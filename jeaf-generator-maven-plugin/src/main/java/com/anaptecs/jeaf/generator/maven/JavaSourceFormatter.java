/**
 * Copyright 2004 - 2026 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.generator.maven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.logging.Log;

import com.anaptecs.jeaf.fwk.generator.util.LineEnding;

/**
 * Formats Java files with the Java formatter of the formatter-maven-plugin. In contrast to the plugin, files can be
 * formatted in parallel.
 * <p>
 * The formatter classes are loaded from the class loader of the plugin, as the plugin requires other versions of the
 * Eclipse libraries than the generator. Formatting is done the same way as by the plugin with its default settings:
 * line ending of the platform and removal of trailing whitespace.
 */
final class JavaSourceFormatter {
  /**
   * Result of formatting a single file.
   */
  enum Result {
    FORMATTED, UNCHANGED, FAILED
  }

  private static final String FORMATTER_PACKAGE = "net.revelc.code.formatter.";

  /**
   * Same pattern as used by the formatter-maven-plugin to remove trailing whitespace.
   */
  private static final Pattern REMOVE_TRAILING_PATTERN = Pattern.compile("\\p{Blank}+$", Pattern.MULTILINE);

  private final ClassLoader formatterClassLoader;

  private final Map<String, String> options;

  private final Charset encoding;

  private final Log log;

  private final Object lineEnding;

  private final Method formatFileMethod;

  /**
   * Formatter instances are not thread-safe, so every thread uses its own one.
   */
  private final ThreadLocal<Object> formatters;

  /**
   * @param pFormatterClassLoader Class loader of the formatter-maven-plugin. The parameter must not be null.
   * @param pConfigFile Formatter configuration as file (absolute or relative to the base directory) or as resource of
   * the plugin's class loader. The parameter must not be null.
   * @param pBaseDirectory Base directory of the project. The parameter must not be null.
   * @param pEncoding Encoding of the Java files. The parameter must not be null.
   * @param pLineEnding Line ending of the formatted files. The parameter must not be null.
   * @param pLog Log that is used by the formatter. The parameter must not be null.
   */
  JavaSourceFormatter( ClassLoader pFormatterClassLoader, String pConfigFile, File pBaseDirectory, Charset pEncoding,
      LineEnding pLineEnding, Log pLog ) throws MojoExecutionException {
    formatterClassLoader = pFormatterClassLoader;
    encoding = pEncoding;
    log = pLog;
    try {
      options = this.readOptions(pConfigFile, pBaseDirectory);
      Class<?> lLineEndingClass = this.loadFormatterClass("LineEnding");
      // formatter-maven-plugin uses the same names (LF, CRLF, AUTO).
      lineEnding = this.enumValue(lLineEndingClass, pLineEnding.name());
      formatFileMethod = this.loadFormatterClass("java.JavaFormatter").getMethod("formatFile", Path.class,
          String.class, lLineEndingClass);
    }
    catch (ReflectiveOperationException e) {
      throw new MojoExecutionException("Unable to load Java formatter of formatter-maven-plugin.", e);
    }
    formatters = ThreadLocal.withInitial(this::createFormatter);
  }

  /**
   * Method formats the passed Java file. The file is only written if formatting changed it.
   *
   * @param pFile Java file that should be formatted. The parameter must not be null.
   * @return {@link Result} Result of the formatting. The method never returns null.
   */
  Result format( Path pFile ) throws IOException {
    // Like the plugin, invalid characters are replaced instead of causing an exception.
    String lOriginalCode = new String(Files.readAllBytes(pFile), encoding);
    String lFormattedCode;
    Thread lThread = Thread.currentThread();
    ClassLoader lContextClassLoader = lThread.getContextClassLoader();
    try {
      // The formatter is executed with the same context class loader as by Maven.
      lThread.setContextClassLoader(formatterClassLoader);
      lFormattedCode = (String) formatFileMethod.invoke(formatters.get(), pFile, lOriginalCode, lineEnding);
    }
    catch (IllegalAccessException e) {
      throw new IllegalStateException(e);
    }
    catch (InvocationTargetException e) {
      if (e.getCause() instanceof RuntimeException) {
        throw (RuntimeException) e.getCause();
      }
      throw new IllegalStateException(e.getCause());
    }
    finally {
      lThread.setContextClassLoader(lContextClassLoader);
    }

    Result lResult;
    if (lFormattedCode == null) {
      lResult = Result.FAILED;
    }
    else {
      lFormattedCode = REMOVE_TRAILING_PATTERN.matcher(lFormattedCode).replaceAll("");
      if (lOriginalCode.equals(lFormattedCode)) {
        lResult = Result.UNCHANGED;
      }
      else {
        Files.writeString(pFile, lFormattedCode, encoding);
        lResult = Result.FORMATTED;
      }
    }
    return lResult;
  }

  private Object createFormatter( ) {
    try {
      Class<?> lConfigurationSourceClass = this.loadFormatterClass("ConfigurationSource");
      Object lConfigurationSource = Proxy.newProxyInstance(formatterClassLoader,
          new Class<?>[] { lConfigurationSourceClass }, ( pProxy, pMethod, pArgs ) -> {
            switch (pMethod.getName()) {
              case "getLog":
                return log;
              case "getEncoding":
                return encoding;
              default:
                // Compiler settings and target directory are not used for formatting with a configuration file.
                return null;
            }
          });
      Class<?> lFormatterClass = this.loadFormatterClass("java.JavaFormatter");
      Object lFormatter = lFormatterClass.getDeclaredConstructor().newInstance();
      lFormatterClass.getMethod("init", Map.class, lConfigurationSourceClass).invoke(lFormatter, options,
          lConfigurationSource);
      return lFormatter;
    }
    catch (ReflectiveOperationException e) {
      throw new IllegalStateException("Unable to create Java formatter of formatter-maven-plugin.", e);
    }
  }

  /**
   * Reads the formatter options in the same order as the formatter-maven-plugin resolves its configuration file.
   */
  @SuppressWarnings("unchecked")
  private Map<String, String> readOptions( String pConfigFile, File pBaseDirectory )
    throws MojoExecutionException, ReflectiveOperationException {
    try (InputStream lConfig = this.openConfigFile(pConfigFile, pBaseDirectory)) {
      if (lConfig == null) {
        throw new MojoExecutionException("Cannot find formatter config file [" + pConfigFile + "]");
      }
      Class<?> lConfigReaderClass = this.loadFormatterClass("model.ConfigReader");
      Object lConfigReader = lConfigReaderClass.getDeclaredConstructor().newInstance();
      return (Map<String, String>) lConfigReaderClass.getMethod("read", InputStream.class).invoke(lConfigReader,
          lConfig);
    }
    catch (IOException e) {
      throw new MojoExecutionException("Cannot read formatter config file [" + pConfigFile + "]", e);
    }
    catch (InvocationTargetException e) {
      throw new MojoExecutionException("Cannot parse formatter config file [" + pConfigFile + "]", e.getCause());
    }
  }

  private InputStream openConfigFile( String pConfigFile, File pBaseDirectory ) throws IOException {
    InputStream lConfig;
    File lFile = new File(pConfigFile);
    File lRelativeFile = new File(pBaseDirectory, pConfigFile);
    if (lFile.isAbsolute() && lFile.isFile()) {
      lConfig = new FileInputStream(lFile);
    }
    else if (lRelativeFile.isFile()) {
      lConfig = new FileInputStream(lRelativeFile);
    }
    else {
      String lResourceName = pConfigFile.startsWith("/") ? pConfigFile.substring(1) : pConfigFile;
      lConfig = formatterClassLoader.getResourceAsStream(lResourceName);
      if (lConfig == null) {
        try {
          lConfig = new URL(pConfigFile).openStream();
        }
        catch (MalformedURLException e) {
          lConfig = null;
        }
      }
    }
    return lConfig;
  }

  private Class<?> loadFormatterClass( String pName ) throws ClassNotFoundException {
    return formatterClassLoader.loadClass(FORMATTER_PACKAGE + pName);
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  private Object enumValue( Class<?> pEnumClass, String pName ) {
    return Enum.valueOf((Class<Enum>) pEnumClass, pName);
  }
}
