/**
 * Copyright 2004 - 2020 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.fwk.tools.message.generator;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringJoiner;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.tools.api.xml.XMLTools;
import com.anaptecs.jeaf.xfun.api.checks.Assert;
import com.anaptecs.jeaf.xfun.api.checks.VerificationResult;
import com.anaptecs.jeaf.xfun.api.errorhandling.JEAFSystemException;
import com.anaptecs.jeaf.xfun.api.messages.MessageDataDTD;

/**
 * Class implements a converter that transform message data that is defined inside Excel into an XML file that contains
 * the data as message resources.
 * 
 * @author JEAF Development Team
 * @version JEAf Release 1.5.x
 */
public class ExcelToMessageResourceConverter {
  private static final String CLASS_INFO_SHEET = "Class-Info";

  private static final String CLASS_INFO_PACKAGE = "Package";

  private static final String CLASS_INFO_CLASS = "Class-Name";

  private static final String CLASS_INFO_DESCRIPTION = "Description";

  private static final String CLASS_INFO_AUTHOR = "Author";

  private static final String CLASS_INFO_VERSION = "Version";

  private static final String MESSAGE_FOLDER_TEMPLATE_SHEET = "Message-Data-Template";

  private static final String MESSAGE_FOLDER = "MessageFolder";

  private static final String MESSAGE_ID = "Message-ID";

  private static final String NAME = "Name";

  private static final String MESSAGE_TYPE = "Message-Type";

  private static final String TRACE_LEVEL = "Trace-Level";

  private static final String DEPRECATED = "Deprecated";

  private static final String DESCRIPTION = "Description";

  private static final String DEFAULT_TEXT = "Default-Text";

  private static final String PREDEFINED_VALUES_SHEET = "Predefined-Values";

  /**
   * Method converts the Excel file with the passed name into a JEAf X-Fun Message Resource.
   * 
   * @param pExcelSource Excel file that should be transformed into a message resource.
   * @return {@link ConversionResult} Result of the transformation. This contains the DOM representation of the
   * generated message resource as well as information about errors and / or warnings that occurred during the
   * transformation. The method never returns null.
   */
  public ConversionResult generateMessageResource( String pExcelSource ) {
    VerificationResult lVerificationResult = new VerificationResult();
    Document lDocument = null;
    Workbook lWorkbook = null;

    try {
      // Open Excel sheet
      lWorkbook = WorkbookFactory.create(new File(pExcelSource), null, true);
      Set<Integer> lUsedMessageIDs = new HashSet<>();
      Set<String> lUsedNames = new HashSet<>();

      // Create document and root element.
      XMLTools lXMLTools = Tools.getXMLTools();
      lDocument = lXMLTools.createDocument();
      Element lRootElement = lDocument.createElement("Root");
      lDocument.appendChild(lRootElement);

      // At first we have to resolve the sheet that contains the class info.
      Sheet lClassInfoSheet = lWorkbook.getSheet(CLASS_INFO_SHEET);
      if (lClassInfoSheet != null) {
        // Try to create class info as XML.
        Element lClassInfoElement = this.createClassInfo(lDocument, lClassInfoSheet, pExcelSource, lVerificationResult);
        if (lClassInfoElement != null) {
          lRootElement.appendChild(lClassInfoElement);
        }

        // Handle all sheets that contain message resource data
        boolean lMessageFolderFound = false;
        for (int i = 0; i < lWorkbook.getNumberOfSheets(); i++) {
          String lSheetName = lWorkbook.getSheetName(i);

          // Sheet with real message data found.
          if (CLASS_INFO_SHEET.equals(lSheetName) == false && MESSAGE_FOLDER_TEMPLATE_SHEET.equals(lSheetName) == false
              && PREDEFINED_VALUES_SHEET.equals(lSheetName) == false) {

            // Process sheet and convert it into XML representation.
            lMessageFolderFound = true;
            Sheet lSheet = lWorkbook.getSheetAt(i);
            Element lMessageFolder = this.createMessageFolder(lDocument, lSheet, lSheetName, lVerificationResult,
                lUsedMessageIDs, lUsedNames);
            if (lMessageFolder != null) {
              lRootElement.appendChild(lMessageFolder);
            }
          }
          // Sheets CLASS_INFO_SHEET, MESSAGE_FOLDER_TEMPLATE_SHEET and PREDEFINED_VALUES_SHEET will be ignored
          else {
            // Nothing to do.
          }
        }

        // All sheets of the workbook are processed, now we have to ensure that at least one sheet with message data is
        // inside the provided Excel workbook.
        if (lMessageFolderFound == true) {
          // Nothing special to do.
        }
        // No message data inside the provided Excel workbook
        else {
          lVerificationResult.addError(ErrorCodes.NO_MESSAGE_DATA_IN_WORKBOOK, pExcelSource);
        }
      }
      // Sheet "Class-Info" is missing in the provided workbook.
      else {
        lVerificationResult.addError(ErrorCodes.CLASS_INFO_SHEET_MISSING, CLASS_INFO_SHEET, pExcelSource);
      }
    }
    // Unable to open Excel sheet
    catch (IOException e) {
      lVerificationResult.addError(ErrorCodes.UNABLE_TO_OPEN_EXCEL_WORKBOOK, e, pExcelSource, e.getMessage());
    }
    catch (ParserConfigurationException e) {
      lVerificationResult.addError(ErrorCodes.UNABLE_TO_CREATE_XML_DOCUMENT);
    }
    // No matter what happens at the end we should close the Excel workbook again.
    finally {
      if (lWorkbook != null) {
        try {
          lWorkbook.close();
        }
        catch (IOException e) {
          throw new JEAFSystemException(ErrorCodes.UNABLE_TO_OPEN_EXCEL_WORKBOOK, e, pExcelSource, e.getMessage());
        }
      }
    }
    // Return result of conversion
    return new ConversionResult(lDocument, lVerificationResult);
  }

  /**
   * Method creates a ClassInfo element from the passed excel sheet.
   * 
   * @param pDocument XML document that contains the created element. The parameter must not be null.
   * @param pSheet Object representing the sheet of the Excel file that contains the class information. The parameter
   * must not be null.
   * @param pSheetName Name of the sheet. The parameter must not be null. Attribute is "only" needed to provide
   * understandable error messages.
   * @param pVerificationResult Verification result to which may be found problems should be added. The parameter must
   * not be null.
   * @return {@link Element} XML element that was created. In case of errors the method will return null.
   */
  private Element createClassInfo( Document pDocument, Sheet pSheet, String pSheetName,
      VerificationResult pVerificationResult ) {
    Element lElement = pDocument.createElement(MessageDataDTD.CLASS_INFO);

    // Expecting that in column A Name of the field is defined and in column B its value
    int lFirstRowNum = pSheet.getFirstRowNum();
    int lLastRowNum = pSheet.getLastRowNum();

    // Collect data from all rows
    Map<String, String> lValues = new HashMap<>();
    for (int i = lFirstRowNum; i <= lLastRowNum; i++) {
      Row lNextRow = pSheet.getRow(i);
      Cell lKeyCell = lNextRow.getCell(0);
      if (lKeyCell != null) {
        String lKey = getStringValueFromCell(lKeyCell);

        Cell lValueCell = lNextRow.getCell(1);
        if (lValueCell != null) {
          String lValue = getStringValueFromCell(lValueCell);
          lValues.put(lKey, lValue);
        }
      }
    }

    //
    boolean lIncomplete = false;
    String lPackage = lValues.get(CLASS_INFO_PACKAGE);
    if (lPackage != null) {
      lElement.setAttribute(MessageDataDTD.PACKAGE, lPackage);
    }
    else {
      lIncomplete = true;
      pVerificationResult.addError(ErrorCodes.INVALID_CLASS_INFO, CLASS_INFO_PACKAGE, pSheetName);
    }
    String lClass = lValues.get(CLASS_INFO_CLASS);
    if (lClass != null) {
      lElement.setAttribute(MessageDataDTD.CLASS_NAME, lClass);
    }
    else {
      lIncomplete = true;
      pVerificationResult.addError(ErrorCodes.INVALID_CLASS_INFO, CLASS_INFO_CLASS, pSheetName);
    }
    String lDescription = lValues.get(CLASS_INFO_DESCRIPTION);
    if (lDescription != null) {
      lElement.setAttribute(MessageDataDTD.CLASS_DESCRIPTION, lDescription);
    }
    String lAuthor = lValues.get(CLASS_INFO_AUTHOR);
    if (lAuthor != null) {
      lElement.setAttribute(MessageDataDTD.AUTHOR, lAuthor);
    }

    String lVersion = lValues.get(CLASS_INFO_VERSION);
    if (lVersion != null) {
      lElement.setAttribute(MessageDataDTD.VERSION, lVersion);
    }

    if (lIncomplete == false) {
      return lElement;
    }
    else {
      return null;
    }
  }

  private Element createMessageFolder( Document pDocument, Sheet pSheet, String pSheetName,
      VerificationResult pVerificationResult, Set<Integer> pUsedMessageIDs, Set<String> pUsedNames ) {

    int lFirstRowNum = pSheet.getFirstRowNum();
    Row lHeaders = pSheet.getRow(lFirstRowNum);

    // Excel sheet contains at least some data.
    Element lMessageFolder;
    if (lHeaders != null) {

      Map<String, Integer> lAllColumns = new HashMap<>();
      Map<String, Integer> lDefaultColumns = new HashMap<>();

      for (int i = lHeaders.getFirstCellNum(); i <= lHeaders.getLastCellNum(); i++) {
        Cell lNextCell = lHeaders.getCell(i);
        if (lNextCell != null) {
          String lHeaderName = this.getStringValueFromCell(lNextCell);
          lAllColumns.put(lHeaderName, i);
        }
      }

      // Ensure that all required columns are present.
      boolean lIncomplete = false;
      if (lAllColumns.containsKey(MESSAGE_ID) == false) {
        pVerificationResult.addError(ErrorCodes.INVALID_MESSAGE_DATA, pSheetName, MESSAGE_ID);
        lIncomplete = true;
      }
      if (lAllColumns.containsKey(NAME) == false) {
        pVerificationResult.addError(ErrorCodes.INVALID_MESSAGE_DATA, pSheetName, NAME);
        lIncomplete = true;
      }
      if (lAllColumns.containsKey(MESSAGE_TYPE) == false) {
        pVerificationResult.addError(ErrorCodes.INVALID_MESSAGE_DATA, pSheetName, MESSAGE_TYPE);
        lIncomplete = true;
      }
      if (lAllColumns.containsKey(TRACE_LEVEL) == false) {
        pVerificationResult.addError(ErrorCodes.INVALID_MESSAGE_DATA, pSheetName, TRACE_LEVEL);
        lIncomplete = true;
      }
      if (lAllColumns.containsKey(DEPRECATED) == false) {
        pVerificationResult.addError(ErrorCodes.INVALID_MESSAGE_DATA, pSheetName, DEPRECATED);
        lIncomplete = true;
      }
      if (lAllColumns.containsKey(DESCRIPTION) == false) {
        pVerificationResult.addError(ErrorCodes.INVALID_MESSAGE_DATA, pSheetName, DESCRIPTION);
        lIncomplete = true;
      }
      if (lAllColumns.containsKey(DEFAULT_TEXT) == false) {
        pVerificationResult.addError(ErrorCodes.INVALID_MESSAGE_DATA, pSheetName, DEFAULT_TEXT);
        lIncomplete = true;
      }

      // Structure of passed Excel sheet in general is fine.
      if (lIncomplete == false) {
        // Create message folder element to which all messages of this sheet will be added to.
        lMessageFolder = pDocument.createElement(MESSAGE_FOLDER);
        lMessageFolder.setAttribute("name", pSheetName);

        // Separate between required and optional columns.
        lDefaultColumns.put(MESSAGE_ID, lAllColumns.remove(MESSAGE_ID));
        lDefaultColumns.put(NAME, lAllColumns.remove(NAME));
        lDefaultColumns.put(MESSAGE_TYPE, lAllColumns.remove(MESSAGE_TYPE));
        lDefaultColumns.put(TRACE_LEVEL, lAllColumns.remove(TRACE_LEVEL));
        lDefaultColumns.put(DEPRECATED, lAllColumns.remove(DEPRECATED));
        lDefaultColumns.put(DESCRIPTION, lAllColumns.remove(DESCRIPTION));
        lDefaultColumns.put(DEFAULT_TEXT, lAllColumns.remove(DEFAULT_TEXT));

        Map<String, Integer> lLocalizedColumns = lAllColumns;

        // Process all rows.
        for (int i = lFirstRowNum + 1; i <= pSheet.getLastRowNum(); i++) {
          // Resolve next row.
          Row lNextRow = pSheet.getRow(i);
          if (lNextRow != null) {
            StringJoiner lMissingFields = new StringJoiner(", ");

            boolean lIgnoreCell = false;
            // Get values for default columns
            // Message-ID
            Cell lMessageIDCell = lNextRow.getCell(lDefaultColumns.get(MESSAGE_ID));
            if (lMessageIDCell == null) {
              lIgnoreCell = true;
              lMissingFields.add(MESSAGE_ID);
            }
            // Message-Name
            Cell lNameCell = lNextRow.getCell(lDefaultColumns.get(NAME));
            if (lNameCell == null) {
              lIgnoreCell = true;
              lMissingFields.add(NAME);
            }
            // Message-Type
            Cell lMessageTypeCell = lNextRow.getCell(lDefaultColumns.get(MESSAGE_TYPE));
            if (lMessageTypeCell == null) {
              lIgnoreCell = true;
              lMissingFields.add(MESSAGE_TYPE);
            }
            // Trace-Level
            Cell lTracelLevelCell = lNextRow.getCell(lDefaultColumns.get(TRACE_LEVEL));
            if (lTracelLevelCell == null) {
              lIgnoreCell = true;
              lMissingFields.add(TRACE_LEVEL);
            }
            // Optional deprecated and description cells
            Cell lDeprecatedCell = lNextRow.getCell(lDefaultColumns.get(DEPRECATED));
            Cell lDescriptionCell = lNextRow.getCell(lDefaultColumns.get(DESCRIPTION));

            // Default-Text
            Cell lDefaultTextCell = lNextRow.getCell(lDefaultColumns.get(DEFAULT_TEXT));
            if (lDefaultTextCell == null) {
              lIgnoreCell = true;
              lMissingFields.add(DEFAULT_TEXT);
            }

            // Minimum data is present in current row
            if (lIgnoreCell == false) {
              Element lMessageElement = pDocument.createElement("Message");
              int lMessageID = (int) lMessageIDCell.getNumericCellValue();
              lMessageElement.setAttribute("messageID", Integer.toString(lMessageID));

              if (pUsedMessageIDs.contains(lMessageID)) {
                pVerificationResult.addError(ErrorCodes.MESSAGE_ID_NOT_UNIQUE, Integer.toString(lMessageID),
                    pSheetName);
              }
              else {
                pUsedMessageIDs.add(lMessageID);
              }

              String lMessageName = lNameCell.getStringCellValue();
              lMessageElement.setAttribute("name", lMessageName);

              if (pUsedNames.contains(lMessageName)) {
                pVerificationResult.addError(ErrorCodes.MESSAGE_NAME_NOT_UNIQUE, lMessageName, pSheetName);
              }
              else {
                pUsedNames.add(lMessageName);
              }
              lMessageElement.setAttribute("type", lMessageTypeCell.getStringCellValue());
              lMessageElement.setAttribute("traceLevel", lTracelLevelCell.getStringCellValue());
              if (lDeprecatedCell != null) {
                String lValue = lDeprecatedCell.getStringCellValue();
                if (Tools.getStringTools().isRealString(lValue)) {
                  lMessageElement.setAttribute("deprecated", lValue);
                }
              }
              lMessageElement.setAttribute("defaultText", lDefaultTextCell.getStringCellValue());
              if (lDescriptionCell != null) {
                lMessageElement.setAttribute("description", lDescriptionCell.getStringCellValue());
              }
              lMessageFolder.appendChild(lMessageElement);

              // Process all localizations of the message.
              for (Entry<String, Integer> lNextEntry : lLocalizedColumns.entrySet()) {
                Locale lLocale = Tools.getLocaleTools().createLocale(lNextEntry.getKey());
                Cell lNextCell = lNextRow.getCell(lNextEntry.getValue());

                if (lNextCell != null) {
                  Element lLocalizedMessageElement = pDocument.createElement("LocalizedMessage");
                  lLocalizedMessageElement.setAttribute("language", lLocale.getLanguage());
                  lLocalizedMessageElement.setAttribute("country", lLocale.getCountry());
                  lLocalizedMessageElement.setAttribute("variant", lLocale.getVariant());
                  lLocalizedMessageElement.setAttribute("localizedText", lNextCell.getStringCellValue());
                  lMessageElement.appendChild(lLocalizedMessageElement);
                }
              }
            }
            // We have to ignore the row as not all required information are present.
            else {
              String lRow = Integer.toString(i + 1);

              // If all fields are missing except for the message id then we do not genrate a warning.
              String lMissingFieldsDetails = lMissingFields.toString();
              if (lMissingFieldsDetails.equals("Name, Message-Type, Trace-Level, Default-Text") == false) {
                pVerificationResult.addWarning(ErrorCodes.IGNORING_ROW, pSheetName, lRow, lMissingFieldsDetails);
              }
            }
          }
        }
      }
      // Excel sheet is invalid, so we do not return anything.
      else {
        lMessageFolder = null;
      }
    }
    // Excel sheet is empty
    else {
      pVerificationResult.addWarning(ErrorCodes.IGNORING_EMPTY_SHEET, pSheetName);
      lMessageFolder = null;
    }

    return lMessageFolder;
  }

  private String getStringValueFromCell( Cell pCell ) {
    // Check parameter.
    Assert.assertNotNull(pCell, "pCell");
    if (pCell.getCellType() == CellType.STRING) {
      return pCell.getStringCellValue();
    }
    else {
      int lRowIndex = pCell.getRowIndex();
      int lColumnIndex = pCell.getColumnIndex();
      throw new IllegalArgumentException(
          "Cell [" + lRowIndex + ", " + lColumnIndex + "] does not contain alpha-numeric value.");
    }
  }

}
