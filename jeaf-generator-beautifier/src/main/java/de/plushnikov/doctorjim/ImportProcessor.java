package de.plushnikov.doctorjim;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseException;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ParserConfiguration;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.PackageDeclaration;
import com.github.javaparser.ast.body.TypeDeclaration;
import com.github.javaparser.ast.expr.AnnotationExpr;
import com.github.javaparser.ast.expr.BinaryExpr;
import com.github.javaparser.ast.expr.FieldAccessExpr;
import com.github.javaparser.ast.expr.MemberValuePair;
import com.github.javaparser.ast.expr.ThisExpr;
import com.github.javaparser.ast.nodeTypes.NodeWithRange;
import com.github.javaparser.ast.type.ClassOrInterfaceType;

/**
 * Main class for Importbeautifikation
 *
 * @author Plushnikov Michail
 * @version $Id: $
 */
public class ImportProcessor {
  /**
   * Logger of this class
   */
  private final Log sLogger = LogFactory.getLog(ImportProcessor.class);

  private static final String NEW_LINE = System.lineSeparator();

  private static final String DEFAULT_PACKAGE = "";

  private static final String JAVA_LANG_PACKAGE = "java.lang";

  private static final String IMPORT_STATEMENT = "import ";

  private static final String STAR_IMPORT = ".*";

  /**
   * Import parser behavior for .* imports
   */
  private boolean mStrict;

  /**
   * Encoding to read or write
   */
  private String mEncoding;

  /**
   * Adds some common used types from java.lang package
   *
   * @param pTypes Collection to add types to
   */
  private void initializeJavaLang(Collection<String> pTypes) {
    // add default java lang import
    pTypes.add("java.lang.*");
    pTypes.add("java.lang.Object");
    pTypes.add("java.lang.Short");
    pTypes.add("java.lang.Integer");
    pTypes.add("java.lang.Long");
    pTypes.add("java.lang.Float");
    pTypes.add("java.lang.Double");
    pTypes.add("java.lang.String");
    pTypes.add("java.lang.System");
    pTypes.add("java.lang.Character");
    pTypes.add("java.lang.Boolean");
    pTypes.add("java.lang.Byte");
    pTypes.add("java.lang.Number");
    pTypes.add("java.lang.Exeption");
    pTypes.add("java.lang.StringBuilder");
    pTypes.add("java.lang.StringBuffer");
  }

  /**
   * Apply workaround for import of Map.Entry.
   * 
   * @param pImport2Replace String of import to be replaced
   * @return String of import, which should be replaced
   */
  private String changeReplacementWorkaround(String pImport2Replace) {
    String result = pImport2Replace;
    if (pImport2Replace.equals("java.util.Map.Entry")) {
      result = "java.util.Map";
    }
    return result;
  }

  /**
   * Default constructor
   */
  public ImportProcessor( ) {
    mStrict = true;
    mEncoding = null;
    sLogger.debug("Doctor JIM created");
  }

  /**
   * <p>
   * isStrict
   * </p>
   *
   * @return a boolean.
   */
  public boolean isStrict( ) {
    return mStrict;
  }

  /**
   * <p>
   * setStrict
   * </p>
   *
   * @param pStrict a boolean.
   */
  public void setStrict(boolean pStrict) {
    mStrict = pStrict;
  }

  /**
   * Get encoding used to read/write files
   * 
   * @return encoding
   */
  public String getEncoding( ) {
    return mEncoding;
  }

  /**
   * Sets encoding to use for file reading and writing
   * 
   * @param pEncoding the encoding to use, <code>null</code> means platform default
   */
  public void setEncoding(String pEncoding) {
    mEncoding = pEncoding;
  }

  /**
   * Organized imports from InputFile and writes processed data to OutputFile
   * 
   * @param pInputFile the file to read, must not be <code>null</code>
   * @param pOutputFile the file to write to, must not be <code>null</code>
   * @throws ParseException in case of an parsing errors
   * @throws IOException in case of an I/O error
   * @throws java.io.UnsupportedEncodingException if the encoding is not supported by the VM
   */
  public void organizeImports(File pInputFile, File pOutputFile, List<String> pImportGroups)
    throws ParseException, IOException {
    final String lInput = FileUtils.readFileToString(pInputFile, getEncoding());
    String lOutput = organizeImports(lInput, pImportGroups);
    FileUtils.writeStringToFile(pOutputFile, lOutput, getEncoding());
  }

  /**
   * Organized imports from the given String
   *
   * @param pInput a {@link java.lang.String} object.
   * @return a {@link java.lang.String} object.
   * @throws de.plushnikov.doctorjim.javaparser.ParseException in case of an parsing errors
   */
  public String organizeImports(String pInput, List<String> pImportGroups) throws ParseException {
    sLogger.debug("Started initialization of the parser");
    // create Parser and initialize with input string
    ParserConfiguration lConfiguration = new ParserConfiguration();
    lConfiguration.setTabSize(1);
    JavaParser lParser = new JavaParser(lConfiguration);

    ParseResult<CompilationUnit> lParseResult = lParser.parse(new StringReader(pInput));
    if (lParseResult.isSuccessful()) {
      CompilationUnit lCompilationUnit = lParseResult.getResult().get();
      // parse the string and collect all informations
      sLogger.debug("Parser successfully finished");

      // Main package
      Optional<PackageDeclaration> lPackageDeclaration = lCompilationUnit.getPackageDeclaration();
      final String lMainPackageName;
      final PackageDeclaration lPackage;
      if (lPackageDeclaration.isPresent()) {
        lPackage = lPackageDeclaration.get();
        lMainPackageName = lPackageDeclaration.get().getNameAsString();
      }
      else {
        lPackage = null;
        lMainPackageName = DEFAULT_PACKAGE;
      }

      if (StringUtils.isNotBlank(lMainPackageName)) {
        sLogger.debug("Found package declaration: " + lMainPackageName);
      }
      else {
        sLogger.debug("Found no package declaration");
      }

      // All Imports, which are already defined
      NodeList<ImportDeclaration> lImports = lCompilationUnit.getImports();

      // final Collection<ElementPosition> lImports = lParser.getImports();
      final Collection<String> lOriginalImports = new HashSet<String>(lImports.size());
      // Collect imports
      final Collection<String> lStarImports = new HashSet<String>(lImports.size());
      for (ImportDeclaration lImport : lImports) {
        String lImportValue = lImport.toString();
        if (lImport.isStatic()) {
          lImportValue = "static " + lImport.getNameAsString();
        }
        else {
          lImportValue = lImport.getNameAsString();
        }
        if (lImport.isAsterisk()) {
          lImportValue = lImportValue + ".*";
          lStarImports.add(lImportValue);
        }
        lOriginalImports.add(lImportValue);
      }

      // add some of basic java.lang types
      initializeJavaLang(lOriginalImports);

      // if strict and there are star imports, break and return immediately
      if (isStrict() && !lStarImports.isEmpty()) {
        sLogger.debug("Doctor JIM is in strict modus and file contains star imports -> exiting");
        return pInput;
      }

      // extract head section of the file (everything before first import or just before package end)
      String lHeadSection = extractHeadSection(pInput, lPackage, lImports);
      // extract import section of the file (everything between begin of first import and end of last import)
      final String lImportsSection = extractImportsSection(pInput, lImports);

      // check for safe import section (it means where are no comments between imports)
      final boolean lImportsAreSafe = verifyInputSection(lImportsSection);

      // prepare place for all java parser imports
      final Collection<String> lGeneratedImports = new HashSet<String>();

      // add all local defines Types, because they are already 'imported'
      @SuppressWarnings("rawtypes")
      final Collection<TypeDeclaration> lLocalTypes = lCompilationUnit.findAll(TypeDeclaration.class);

      for (TypeDeclaration<?> localType : lLocalTypes) {
        if (!StringUtils.isBlank(lMainPackageName)) {
          lGeneratedImports.add(lMainPackageName + '.' + localType.getNameAsString());
        }
        else {
          lGeneratedImports.add(localType.getNameAsString());
        }
      }

      String lBody = extractBodySection(pInput, lPackage, lImports);

      List<String> lUsedTypes = new ArrayList<>();
      for (ClassOrInterfaceType lNext : lCompilationUnit.findAll(ClassOrInterfaceType.class)) {
        String lTypeName = lNext.getNameWithScope();
        if (lUsedTypes.contains(lTypeName) == false) {
          lUsedTypes.add(lTypeName);
        }
      }
      
      for (FieldAccessExpr lNext : lCompilationUnit.findAll(FieldAccessExpr.class)) {
        String lTypeName = lNext.toString();
        List<Node> lChildNodes = lNext.getChildNodes();

        // "this" expressions are not relevant to us.
        if (lChildNodes.size() > 0
            && (lChildNodes.get(0) instanceof ThisExpr == false && 
                lChildNodes.get(0) instanceof BinaryExpr == false && 
                lNext.getParentNode().get() instanceof MemberValuePair == false)) {
          lUsedTypes.add(lTypeName);
        }
      }
      for (AnnotationExpr lNext : lCompilationUnit.findAll(AnnotationExpr.class)) {
        String lTypeName = lNext.getChildNodes().get(0).toString();
        if (lUsedTypes.contains(lTypeName) == false) {
          lUsedTypes.add(lTypeName);
        }
      }

      // Prefer entries from java.lang.* over all others.
      List<String> lOrderedTypes =
          lUsedTypes.stream().filter(s -> s.startsWith("java.lang.")).collect(Collectors.toList());
      lUsedTypes.removeAll(lOrderedTypes);
      lOrderedTypes.addAll(lUsedTypes);
      List<String> lTypesToProcess = new ArrayList<>();
      for (String lNext : lOrderedTypes) {
        String[] lParts = lNext.split("\\.");
        if (lParts.length > 1) {
          boolean lFound = false;
          for (String lPart : lParts) {
            if (lPart.matches("\\p{Lu}.*")) {
              lFound = true;
              break;
            }
          }

          if (lFound && lNext.indexOf(".") > -1) {
            if (lTypesToProcess.contains(lNext) == false) {
              lTypesToProcess.add(lNext);
            }
          }
        }
      }

      // Filter out constants and inner classes
      List<String> lFilteredTypes = new ArrayList<>();
      for (String lNext : lTypesToProcess) {
        String[] lParts = lNext.split("\\.");
        int lIndex = 0;
        if (lParts.length > 1) {
          for (int i = lParts.length - 1; i >= 0; i--) {
            String lPart = lParts[i];
            if (lPart.matches("\\p{Lu}.*")) {
              lIndex = i;
            }
            else {
              break;
            }
          }
          StringBuffer lBuffer = new StringBuffer();
          for (int i = 0; i <= lIndex; i++) {
            lBuffer.append(lParts[i]);
            if (i < lIndex) {
              lBuffer.append(".");
            }
          }
          String lType = lBuffer.toString();
          if (lFilteredTypes.contains(lType) == false) {
            lFilteredTypes.add(lType);
          }
        }
      }
      
      Collections.sort(lTypesToProcess);

      for (String lTypeName : lTypesToProcess) {
        final String[] lParts = lTypeName.split("\\.");

        int lCurrentScanToken = lParts.length - 1;
        // search for last (first from the end) type-part, which starts with upper case letter
        while (lCurrentScanToken >= 0 && !lParts[lCurrentScanToken].matches("\\p{Lu}.*")) {
          lCurrentScanToken--;
        }
        // be sure, we have find something
        if (lCurrentScanToken >= 0) {
          // drop everything after last type-part from the previous calculation
          final String lLastTypePart = lParts[lCurrentScanToken];
          String lImport2Replace =
              lTypeName.substring(0, lTypeName.lastIndexOf(lLastTypePart) + lLastTypePart.length());
          // apply workaround for Map.Entry import
          lImport2Replace = changeReplacementWorkaround(lImport2Replace);

          // import should start with lower case and contains '.'
          if (lImport2Replace.matches("[\\p{L}&&[^\\p{Lu}]].*\\..*") &&
              !isConflict(lImport2Replace, lOriginalImports, lGeneratedImports)) {
            final String lImport2ReplaceWith = lImport2Replace.substring(lImport2Replace.lastIndexOf('.') + 1);

            final String lReplaceSource =
                "([^\\w\\p{L}\\.\"])" + lImport2Replace.replaceAll("\\.", "\\\\s*\\.\\\\s*") + "([^\\p{L}\"])";
            final String lReplaceTarget = "$1" + lImport2ReplaceWith + "$2";

            final String lBodyNew = lBody.replaceAll(lReplaceSource, lReplaceTarget);
            final String lHeadSectionNew = lHeadSection.replaceAll(lReplaceSource, lReplaceTarget);

            // add new import only if something has really changed in the output
            if (!lBodyNew.equals(lBody) || !lHeadSectionNew.equals(lHeadSection)) {
              lGeneratedImports.add(lImport2Replace);
              lBody = lBodyNew;
              lHeadSection = lHeadSectionNew;
            }
          }
        }
      }

      // prepare result buffer
      final StringBuilder lBuffer = new StringBuilder(pInput.length());

      // add original head
      if (lHeadSection.length() > 0) {
        lBuffer.append(lHeadSection);
        lBuffer.append(NEW_LINE);
        lBuffer.append(NEW_LINE);
      }

      final Set<String> lAllImports = new TreeSet<String>();
      lAllImports.addAll(lGeneratedImports);

      if (!lImportsAreSafe) {
        if (lImportsSection.length() > 0) {
          lBuffer.append(lImportsSection);
          lBuffer.append(NEW_LINE);
          lBuffer.append(NEW_LINE);
        }
        // remove original imports
        lGeneratedImports.removeAll(lOriginalImports);
      }
      else {
        // add orignal imports
        lAllImports.addAll(lOriginalImports);
      }

      // append new imports
      final String lGeneratedImportsSection =
          generateImportSection(lAllImports, lMainPackageName, lStarImports, pImportGroups);
      if (lGeneratedImportsSection.length() > 0) {
        lBuffer.append(lGeneratedImportsSection);
        lBuffer.append(NEW_LINE);
      }

      // append body of class
      lBuffer.append(lBody);

      return lBuffer.toString();
    }
    else {
      throw new ParseException(lParseResult.getProblems().toString());
    }
  }

  /**
   * <p>
   * extractHeadSection
   * </p>
   *
   * @param pInput a {@link java.lang.String} object.
   * @param pPackage a {@link de.plushnikov.doctorjim.ElementPosition} object.
   * @param pImports a {@link java.util.Collection} object.
   * @return a {@link java.lang.String} object.
   */
  protected String extractHeadSection(String pInput, PackageDeclaration pPackage,
      NodeList<ImportDeclaration> pImports) {
    ImportDeclaration lFirstImport = null;
    if (pImports != null && !pImports.isEmpty()) {
      lFirstImport = pImports.getFirst().get();
    }
    int lInputPosition = 0;
    if (null != pPackage || null != lFirstImport) {
      final int lColumn =
          null == lFirstImport ? pPackage.getEnd().get().column : lFirstImport.getBegin().get().column - 1;
      final int lLine = null == lFirstImport ? pPackage.getEnd().get().line : lFirstImport.getBegin().get().line;

      lInputPosition = locatePosition(pInput, lLine, lColumn + 1);
    }
    if (sLogger.isDebugEnabled()) {
      sLogger.debug("Extract Headsection from positions [0," + lInputPosition + "]");
    }
    return StringUtils.stripToEmpty(pInput.substring(0, lInputPosition));
  }

  /**
   * <p>
   * extractImportsSection
   * </p>
   *
   * @param pInput a {@link java.lang.String} object.
   * @param pImports a {@link java.util.Collection} object.
   * @return a {@link java.lang.String} object.
   */
  protected String extractImportsSection(String pInput, NodeList<ImportDeclaration> pImports) {
    String result = "";
    if (pImports != null && !pImports.isEmpty()) {
      final ImportDeclaration lFirstImport = pImports.getFirst().get();
      final ImportDeclaration lLastImport = pImports.getLast().get();

      int lStart = locatePosition(pInput, lFirstImport.getBegin().get().line, lFirstImport.getBegin().get().column);
      int lEnd = locatePosition(pInput, lLastImport.getEnd().get().line, lLastImport.getEnd().get().column);

      if (sLogger.isDebugEnabled()) {
        sLogger.debug("Extract Importssection from positions [" + lStart + "," + (lEnd + 1) + "]");
      }
      result = StringUtils.stripToEmpty(pInput.substring(lStart, lEnd + 1));
    }
    else {
      sLogger.debug("No Importsection to extract");
    }
    return result;
  }

  /**
   * <p>
   * extractBodySection
   * </p>
   *
   * @param pInput a {@link java.lang.String} object.
   * @param pPackage a {@link de.plushnikov.doctorjim.ElementPosition} object.
   * @param pImports a {@link java.util.Collection} object.
   * @return a {@link java.lang.String} object.
   */
  protected String extractBodySection(String pInput, PackageDeclaration pPackage,
      NodeList<ImportDeclaration> pImports) {
    // determine last element, after which class body declaration starts
    NodeWithRange<?> lClassBodyStartsAfterObject = pPackage;
    if (pImports != null && !pImports.isEmpty()) {
      lClassBodyStartsAfterObject = pImports.getLast().get();
    }
    // calculate start position of class body
    int lClassBodyStartPosition = 0;
    if (null != lClassBodyStartsAfterObject) {
      lClassBodyStartPosition = locatePosition(pInput,
          lClassBodyStartsAfterObject.getEnd().get().line, lClassBodyStartsAfterObject.getEnd().get().column + 1);
    }
    if (sLogger.isDebugEnabled()) {
      sLogger.debug("Extract Bodyssection from positions [" + lClassBodyStartPosition + "," + pInput.length() + "]");
    }
    return StringUtils.stripToEmpty(pInput.substring(lClassBodyStartPosition));
  }

  /**
   * <p>
   * verifyInputSection
   * </p>
   *
   * @param pImportSection a {@link java.lang.String} object.
   * @return a boolean.
   */
  protected boolean verifyInputSection(String pImportSection) {
    return !pImportSection.contains("//") && !pImportSection.contains("/*") && !pImportSection.contains("*/");
  }

  /**
   * <p>
   * isConflict
   * </p>
   *
   * @param type a {@link java.lang.String} object.
   * @param importList a {@link java.util.Collection} object.
   * @param replacedSet a {@link java.util.Collection} object.
   * @return a boolean.
   */
  protected boolean isConflict(String type, Collection<String> importList,
      Collection<String> replacedSet) {
    return !JAVA_LANG_PACKAGE.equals(extractPackage(type)) &&
        (isConflict(type, replacedSet) || isConflict(type, importList));
  }

  /**
   * <p>
   * isConflict
   * </p>
   *
   * @param pType a {@link java.lang.String} object.
   * @param pTestSet a {@link java.util.Collection} object.
   * @return a boolean.
   */
  protected boolean isConflict(String pType, Collection<String> pTestSet) {
    if (pTestSet.contains(pType)) {
      return false;
    }

    for (String importType : pTestSet) {
      if (!importType.endsWith(STAR_IMPORT) && !importType.startsWith("static ")) {
        if (!pType.equals(importType)) {
          String lClassName = importType;
          final int lPosition = importType.lastIndexOf('.');
          if (lPosition > 0) {
            lClassName = importType.substring(lPosition);
          }
          if (pType.endsWith(lClassName)) {
            return true;
          }
        }
      }
    }
    return false;
  }

  /**
   * <p>
   * generateImportSection
   * </p>
   *
   * @param pAllImports a {@link java.util.Set} object.
   * @param pMainPackage a {@link java.lang.String} object.
   * @param pStarImports a {@link java.util.Collection} object.
   * @return a {@link java.lang.String} object.
   */
  protected String generateImportSection(Set<String> pAllImports, String pMainPackage,
      Collection<String> pStarImports, List<String> pImportGroups) {
    StringBuilder lBuffer = new StringBuilder(256);

    List<List<String>> lAllGroupedImports = this.groupImports(pAllImports, pImportGroups, true);
    lAllGroupedImports.addAll(this.groupImports(pAllImports, pImportGroups, false));

    int lLoopCount = 1;
    for (List<String> lNextGroup : lAllGroupedImports) {
      lLoopCount++;
      for (String lImport : lNextGroup) {
        String lImportPackage = extractPackage(lImport);
        // make sure the import is not redundant, because :
        // - it is java.lang import (automatically imported)
        // - it is part of the current package
        // - there is * import from the same package already
        if (!JAVA_LANG_PACKAGE.equals(lImportPackage) &&
            !pMainPackage.equals(lImportPackage) &&
            (lImport.endsWith(STAR_IMPORT) || !pStarImports.contains(lImportPackage + STAR_IMPORT))) {
          lBuffer.append(IMPORT_STATEMENT).append(lImport).append(';').append(NEW_LINE);
        }
      }
      if (lLoopCount < lAllGroupedImports.size()) {
        lBuffer.append(NEW_LINE);
      }
    }

    return lBuffer.toString();
  }

  public List<List<String>> groupImports(Set<String> pAllImports, List<String> pImportGroups, boolean pStatic) {
    // Reduce imports to those that should be processed (static or non-static ones)
    pAllImports = pAllImports.stream().filter(f -> f.startsWith("static ") == pStatic).collect(Collectors.toSet());
    List<List<String>> lGroupedImports = new ArrayList<>();
    List<String> lLeftOvers = new ArrayList<>(pAllImports);
    for (String lNextGroup : pImportGroups) {
      List<String> lImports = pAllImports.stream().filter(e -> e.startsWith(lNextGroup)).collect(Collectors.toList());
      Collections.sort(lImports);
      lGroupedImports.add(lImports);
      lLeftOvers.removeAll(lImports);
    }

    Collections.sort(lLeftOvers);
    lGroupedImports.add(lLeftOvers);
    return lGroupedImports;
  }

  /**
   * <p>
   * Calculates position of a line:column tuple
   * </p>
   *
   * @param pInput original Data-string
   * @param pLine a line in this string
   * @param pColumn a column in this string
   * @return Position of a character in the string
   */
  protected int locatePosition(String pInput, int pLine, int pColumn) {
    int result = pColumn;
    if (pLine > 0) {
      result += StringUtils.ordinalIndexOf(pInput, "\n", pLine - 1);
    }
    return result;
  }

  /**
   * <p>
   * Extracts package name from the type declaration
   * </p>
   *
   * @param pImportType a declaration of some type.
   * @return package name of this type
   */
  protected String extractPackage(String pImportType) {
    final int index = pImportType.lastIndexOf('.');
    String typePackage = "";
    if (-1 < index) {
      typePackage = pImportType.substring(0, index);
    }
    return typePackage;
  }
}
