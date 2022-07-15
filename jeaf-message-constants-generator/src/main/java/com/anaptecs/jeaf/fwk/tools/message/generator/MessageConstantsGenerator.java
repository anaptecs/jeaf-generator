/*
 * anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 * 
 * Copyright 2004 - 2013 All rights reserved.
 */
package com.anaptecs.jeaf.fwk.tools.message.generator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.anaptecs.jeaf.fwk.tools.message.util.JEAFToolsApplicationException;
import com.anaptecs.jeaf.fwk.tools.message.util.JEAFToolsSystemException;
import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.xfun.annotations.AppInfo;
import com.anaptecs.jeaf.xfun.annotations.StartupInfoConfig;
import com.anaptecs.jeaf.xfun.annotations.TraceConfig;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.anaptecs.jeaf.xfun.api.errorhandling.ApplicationException;
import com.anaptecs.jeaf.xfun.api.errorhandling.ErrorCode;
import com.anaptecs.jeaf.xfun.api.messages.MessageDataDTD;
import com.anaptecs.jeaf.xfun.api.trace.Trace;

/**
 * Class generates a java class out of a XML document containing message information. Therefore the class uses XSLT.
 * 
 * @author JEAF Development Team
 * @version 1.0
 */
@AppInfo(applicationID = "com.anaptecs.jeaf.Generator", applicationName = "JEAF Generator")
@StartupInfoConfig(traceStartupInfo = false)
@TraceConfig(traceMessageFormat = "")
public class MessageConstantsGenerator {
  /**
   * Constant for name of stylesheet that defines the transformation of the xml document.
   */
  public static final String STYLESHEET_NAME = "MessageConstantsGenerator.xslt";

  /**
   * Name of parameter that is used within the XSLT template to access the file name of the message resource. This
   * information has to be passed to the stylesheet.
   */
  public static final String RESOURCE_NAME = "RESOURCE_NAME";

  /**
   * File extension for java class files.
   */
  public static final String FILE_EXTENSION = ".java";

  /**
   * Source object representing the XSLT stylesheet that performs the transformation of the XML document that contains
   * the messages.
   */
  private Source stylesheet;

  /**
   * Main method to run class generator as a command line tool. Usage:
   * com.anaptecs.jeaf.client.tools.MessageConstantsGenerator "message resource(s)" "source dir" [excluded files]
   * 
   * @param pArguments The following parameters must be passed to the main method:
   * <ul>
   * <li>pArguments[0] points to the message resource(s) that should be used. This can either be a single file or a
   * directory. If the parameter points to a directory then all contained XML files are considered to be message
   * resources.</li>
   * <li>pArguments[1] points to the source directory to which the classes should be generated.</li>
   * <li>pArguments[i] (i > 1) Name of the files that should be excluded from the generation.</li>
   * </ul>
   * @throws IOException
   */
  public static void main( String[] pArguments ) {
    Trace lTrace = XFun.getTrace();
    lTrace.info("");
    lTrace.info("Generating message constants classes");

    // Check number of parameters. The message resource and the source directory are required.
    if (pArguments.length >= 2) {
      // Check whether first parameter points to a single file or a directory.
      List<String> lResourceFiles;
      File lMessageResourceLocation = new File(pArguments[0]);

      // Get all XML files from the directory.
      if (lMessageResourceLocation.isDirectory() == true) {
        // Create exclusion list.
        List<String> lExclusionList = new ArrayList<String>(pArguments.length - 2);
        for (int i = 2; i < pArguments.length; i++) {
          lExclusionList.add(pArguments[i]);
        }

        // Create FileFilter and determine resource files that should be used.
        List<String> lExtensions = new ArrayList<String>();
        lExtensions.add(".xml");
        FilenameFilter lFileFilter = Tools.getFileTools().createExtensionFilenameFilter(lExtensions, lExclusionList);
        File[] lFiles = lMessageResourceLocation.listFiles(lFileFilter);

        if (lFiles != null) {
          lResourceFiles = new ArrayList<String>(lFiles.length);

          // Add absolute location of files to Collection with resource files.
          for (int i = 0; i < lFiles.length; i++) {
            lResourceFiles.add(lFiles[i].getAbsolutePath());
          }
        }
        else {
          lResourceFiles = Collections.emptyList();
        }
      }
      // Only single resource file was provided.
      else {
        lResourceFiles = new ArrayList<String>(1);
        lResourceFiles.add(pArguments[0]);
      }

      // Determine output directory and check if it is valid.
      File lOutputDirectory = new File(pArguments[1]);
      if (lOutputDirectory.isDirectory() == true) {
        // Create new generator and start generation
        MessageConstantsGenerator lClassGenerator = new MessageConstantsGenerator();
        // Generate all classes.
        Iterator<String> lIterator = lResourceFiles.iterator();
        while (lIterator.hasNext()) {
          // Get name of next message resource
          String lFileName = lIterator.next();

          try {
            // Print status message
            lFileName = new File(lFileName).getCanonicalPath();
            lTrace.info("Generating class for message resource '" + lFileName + "'.");

            // Try to generate class
            lClassGenerator.generateMessageClass(lFileName, lOutputDirectory.getAbsolutePath());
          }
          // Exception during generation
          catch (IOException e) {
            lTrace.info("Exception during generation.");
            e.printStackTrace(System.out);
          }
          catch (ApplicationException e) {
            lTrace.info("Exception during generation.");
            e.printStackTrace(System.out);
          }
          finally {
            // Insert new line.
            lTrace.info("");
          }
        }
      }
      // Parameter pArguments[1] is no a valid output directory.
      else {
        String lMessage = "'" + pArguments[1] + "' is not a valid output directory.";
        lTrace.info(lMessage);
      }
    }
    // Required parameters were not provided.
    else {
      MessageConstantsGenerator.printUsage();
    }
  }

  /**
   * Method print on system out how to use this class from the command line.
   */
  private static void printUsage( ) {
    String lUsage = "Usage: " + MessageConstantsGenerator.class.getName() + " \"message resources\" \"source dir\"";
    Trace lTrace = XFun.getTrace();
    lTrace.info(lUsage);
    lTrace.info("Usage: " + MessageConstantsGenerator.class.getName()
        + "\"message resource(s)\" \"source dir\" [excluded files]");
    lTrace.info("");
    lTrace.info("The following parameters must be passed to the application:");
    lTrace.info("\"message resource(s)\" points to the message resource(s) that should be used. This can");
    lTrace.info("either be a single file or a directory. If the parameter points to a directory then all");
    lTrace.info("contained XML files are considered to be message resources.");
    lTrace.info("");
    lTrace.info("\"source dir\" points to the source directory to which the classes should be generated.");
    lTrace.info("[excluded files] (optional) Name of the files that should be excluded from the generation.");
  }

  /**
   * Initialize object. Thereby the stylesheet for the XSLT transformation will be loaded.
   */
  public MessageConstantsGenerator( ) {
    // Get URL of stylesheet.
    URL lStylesheetURL = this.getClass().getClassLoader().getResource(STYLESHEET_NAME);
    // If URL is null, the resource could not be located.
    if (lStylesheetURL != null) {
      stylesheet = new StreamSource(lStylesheetURL.toExternalForm());
    }
    // XSLT stylesheet not in class path.
    else {
      ErrorCode lErrorCode = ErrorCodes.STYLESHEET_NOT_AVAILABLE;
      String[] lParams = new String[] { STYLESHEET_NAME };
      throw new JEAFToolsSystemException(lErrorCode, lParams);
    }
  }

  /**
   * Method generates a new java class out of the passed XML file containing message information.
   * 
   * @param pMessageResource URL of the XML file that contains all information that are required to generate the java
   * class. The parameter must not be null.
   * @param pSourceDirectoryName URL of the source directory where class should be generated. The parameter must not be
   * null.
   * @throws ApplicationException if an error occurs during the generation process.
   */
  public void generateMessageClass( String pMessageResource, String pSourceDirectoryName ) throws ApplicationException {
    // Check parameter pMessageResource for null.
    Check.checkInvalidParameterNull(pMessageResource, "pMessageResource");
    Check.checkInvalidParameterNull(pSourceDirectoryName, "pSourceDirectory");

    // Get message resource as DOM document so that the name of the generated file and its location can be determined.
    // All information about the class to generate are contained in the element "CLASS_INFO"
    Document lMessageResource = Tools.getXMLTools().parseFile(pMessageResource, false, MessageDataDTD.SYSTEM_ID);

    // Get DOM element containing class information. If the XML file contains no element CLASS_INFO then no class will
    // be generated.
    Trace lTrace = XFun.getTrace();
    NodeList lNodes = lMessageResource.getElementsByTagName(MessageDataDTD.CLASS_INFO);
    if (lNodes.getLength() == 1) {
      Element lClassInfo = (Element) lNodes.item(0);

      // Create string containing the output directory.
      String lClassName = null;
      try {
        String lPackageName = lClassInfo.getAttribute(MessageDataDTD.PACKAGE);
        File lOutputDirectory =
            new File(pSourceDirectoryName + File.separatorChar + lPackageName.replace('.', File.separatorChar));
        String lOutputDirString = lOutputDirectory.getCanonicalPath();

        // Check if the output directory exists and create it if not.
        if (lOutputDirectory.isDirectory() == false) {
          boolean lSuccesful = lOutputDirectory.mkdirs();
          if (lSuccesful == false) {
            String[] lParams = new String[] { lOutputDirString };
            throw new JEAFToolsApplicationException(ErrorCodes.UNABLE_TO_CREATE_DIR, lParams);
          }
        }
        // Create name of output file of generated class.
        lClassName = lClassInfo.getAttribute(MessageDataDTD.CLASS_NAME);
        String lFileName = lOutputDirString + File.separatorChar + lClassName + FILE_EXTENSION;

        // Print info to console.
        File lSourceDirectory = new File(pSourceDirectoryName);
        lTrace.info("Output directory: " + lSourceDirectory.getCanonicalPath());
        lTrace.info("Class name: " + lPackageName + "." + lClassName);

        // Get transformer factory and create new Transformer object.
        TransformerFactory lFactory = TransformerFactory.newInstance();
        Transformer lTransformer = lFactory.newTransformer(stylesheet);
        String lMessageResourceFileName = new File(pMessageResource).getName();
        lTransformer.setParameter(RESOURCE_NAME, lMessageResourceFileName);

        // Perform transformation.
        InputStream lMessageResourceInputStream = new FileInputStream(pMessageResource);
        Source lSource = new StreamSource(lMessageResourceInputStream, MessageDataDTD.SYSTEM_ID);
        Result lResult = new StreamResult(lFileName);
        lTransformer.transform(lSource, lResult);
      }
      // Message resource file not found.
      catch (IOException e) {
        throw new JEAFToolsApplicationException(ErrorCodes.UNABLE_TO_PERFORM_TRANSFORMATION, e, lClassName,
            pMessageResource);
      }
      // No transformer available
      catch (TransformerConfigurationException e) {
        throw new JEAFToolsApplicationException(ErrorCodes.UNABLE_TO_PERFORM_TRANSFORMATION, e, lClassName,
            pMessageResource);
      }
      // Error while performing transformation.
      catch (TransformerException e) {
        throw new JEAFToolsApplicationException(ErrorCodes.UNABLE_TO_PERFORM_TRANSFORMATION, e, lClassName,
            pMessageResource);
      }
    }
    // Only print message that the resource does not contain the elements that re required to generate a constant class.
    else {
      String lMessage =
          "XML file '" + pMessageResource + "' does not contain elements that are required to generate constants.";
      lTrace.info(lMessage);
    }
  }
}