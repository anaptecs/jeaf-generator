package com.anaptecs.jeaf.fwk.tools.message.generator.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Locale;

import com.anaptecs.jeaf.fwk.tools.message.generator.ConversionResult;
import com.anaptecs.jeaf.fwk.tools.message.generator.ExcelToMessageResourceConverter;
import com.anaptecs.jeaf.generator.ErrorCodes;
import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.tools.api.xml.XMLTools;
import com.anaptecs.jeaf.xfun.api.checks.VerificationResult;
import com.anaptecs.jeaf.xfun.api.errorhandling.FailureMessage;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.xmlunit.builder.DiffBuilder;
import org.xmlunit.diff.Diff;
import org.xmlunit.diff.Difference;

/**
 * Copyright 2004 - 2020 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ExcelTransformationTest {
  private static final String BROKEN_TEST_MESSAGES = "./src/test/resources/broken-test-messages.xlsx";;

  private static final String TEST_MESSAGES = "./src/test/resources/test-messages.xlsx";

  private static final String NO_MESSAGES = "./src/test/resources/no-messages.xlsx";

  private static final String CLASS_INFO_MISSING = "./src/test/resources/class-info-missing.xlsx";

  private static final String EXPECTED_XML = "./src/test/resources/ExpectedXMLFile.xml";

  @Test
  @Order(10)
  public void testExcelTransformation( ) throws Exception {
    // Run Excel transformation
    ExcelToMessageResourceConverter lConverter = new ExcelToMessageResourceConverter();
    ConversionResult lConversionResult = lConverter.generateMessageResource(TEST_MESSAGES);

    // Ensure that transformation was done without any errors or warnings.
    VerificationResult lVerificationResult = lConversionResult.getVerificationResult();
    assertFalse(lVerificationResult.containsErrors());
    assertFalse(lVerificationResult.containsWarnings());

    // Check for expected errors

    // Compare expected result and actual one. Here we do not check that results are byte by byte identical but that
    // they are the same from an XML perspective.
    XMLTools lXMLTools = Tools.getXMLTools();

    String lGeneratedXML = lXMLTools.toString(lConversionResult.getDocument());
    System.out.println(lGeneratedXML);
    String lExpectedXML = lXMLTools.toString(lXMLTools.parseFile(EXPECTED_XML, false));
    Diff lDiff = DiffBuilder.compare(lExpectedXML).withTest(lGeneratedXML).normalizeWhitespace().build();
    if (lDiff.hasDifferences()) {
      for (Difference lNextDiff : lDiff.getDifferences()) {
        System.out.println(lNextDiff.toString());
      }
    }
    assertFalse(lDiff.hasDifferences(), "Differences between expected and actual XML file found: " + lDiff.toString());
  }

  @Test
  @Order(20)
  public void testExcelTransformationErrorDetection( ) {
    // Run Excel transformation
    ExcelToMessageResourceConverter lConverter = new ExcelToMessageResourceConverter();
    ConversionResult lConversionResult = lConverter.generateMessageResource(BROKEN_TEST_MESSAGES);

    // Ensure that transformation was done without any errors or warnings.
    VerificationResult lVerificationResult = lConversionResult.getVerificationResult();
    System.out.println(lVerificationResult.getMessage());
    assertTrue(lVerificationResult.containsErrors());
    assertTrue(lVerificationResult.containsWarnings());

    // Check for expected errors
    List<FailureMessage> lErrors = lVerificationResult.getErrors();
    assertEquals(11, lErrors.size());

    FailureMessage lFailureMessage = lErrors.get(0);
    assertEquals(ErrorCodes.INVALID_CLASS_INFO, lFailureMessage.getMessageID());
    assertEquals(
        "Unable to convert Excel workbook to message resource file. Class-Information is incomplete or invalid. Affected field 'Package' in file './src/test/resources/broken-test-messages.xlsx'.",
        lFailureMessage.toString(Locale.ENGLISH));

    lFailureMessage = lErrors.get(1);
    assertEquals(ErrorCodes.INVALID_CLASS_INFO, lFailureMessage.getMessageID());
    assertEquals(
        "Unable to convert Excel workbook to message resource file. Class-Information is incomplete or invalid. Affected field 'Class-Name' in file './src/test/resources/broken-test-messages.xlsx'.",
        lFailureMessage.toString(Locale.ENGLISH));

    lFailureMessage = lErrors.get(2);
    assertEquals(ErrorCodes.MESSAGE_ID_NOT_UNIQUE, lFailureMessage.getMessageID());
    assertEquals(
        "Message-ID '20000' is not unique. Excel sheet 'Test-Message 02' contains this message ID even though it was already used before. Please ensure that every message ID is globally only used once.",
        lFailureMessage.toString(Locale.ENGLISH));

    lFailureMessage = lErrors.get(3);
    assertEquals(ErrorCodes.MESSAGE_NAME_NOT_UNIQUE, lFailureMessage.getMessageID());
    assertEquals(
        "Message-Name 'BANK_BALANCE_NOT_SUFFICIENT' is not unique. Excel sheet 'Test-Message 02' contains this name even though it was already used before. Please ensure that every message name is only used once per Excel file.",
        lFailureMessage.toString(Locale.ENGLISH));

    lFailureMessage = lErrors.get(4);
    assertEquals(ErrorCodes.INVALID_MESSAGE_DATA, lFailureMessage.getMessageID());
    assertEquals(
        "Excel sheet 'Invalid Sheet' does not contain required column with name 'Message-ID'. Please ensure that you use the right Excel template for message resources.",
        lFailureMessage.toString(Locale.ENGLISH));

    lFailureMessage = lErrors.get(5);
    assertEquals(ErrorCodes.INVALID_MESSAGE_DATA, lFailureMessage.getMessageID());
    assertEquals(
        "Excel sheet 'Invalid Sheet' does not contain required column with name 'Name'. Please ensure that you use the right Excel template for message resources.",
        lFailureMessage.toString(Locale.ENGLISH));

    lFailureMessage = lErrors.get(6);
    assertEquals(ErrorCodes.INVALID_MESSAGE_DATA, lFailureMessage.getMessageID());
    assertEquals(
        "Excel sheet 'Invalid Sheet' does not contain required column with name 'Message-Type'. Please ensure that you use the right Excel template for message resources.",
        lFailureMessage.toString(Locale.ENGLISH));

    lFailureMessage = lErrors.get(7);
    assertEquals(ErrorCodes.INVALID_MESSAGE_DATA, lFailureMessage.getMessageID());
    assertEquals(
        "Excel sheet 'Invalid Sheet' does not contain required column with name 'Trace-Level'. Please ensure that you use the right Excel template for message resources.",
        lFailureMessage.toString(Locale.ENGLISH));

    lFailureMessage = lErrors.get(8);
    assertEquals(ErrorCodes.INVALID_MESSAGE_DATA, lFailureMessage.getMessageID());
    assertEquals(
        "Excel sheet 'Invalid Sheet' does not contain required column with name 'Deprecated'. Please ensure that you use the right Excel template for message resources.",
        lFailureMessage.toString(Locale.ENGLISH));

    lFailureMessage = lErrors.get(9);
    assertEquals(ErrorCodes.INVALID_MESSAGE_DATA, lFailureMessage.getMessageID());
    assertEquals(
        "Excel sheet 'Invalid Sheet' does not contain required column with name 'Description'. Please ensure that you use the right Excel template for message resources.",
        lFailureMessage.toString(Locale.ENGLISH));

    lFailureMessage = lErrors.get(10);
    assertEquals(ErrorCodes.INVALID_MESSAGE_DATA, lFailureMessage.getMessageID());
    assertEquals(
        "Excel sheet 'Invalid Sheet' does not contain required column with name 'Default-Text'. Please ensure that you use the right Excel template for message resources.",
        lFailureMessage.toString(Locale.ENGLISH));

    // Check expected warnings
    List<FailureMessage> lWarnings = lVerificationResult.getWarnings();
    assertEquals(8, lWarnings.size());

    lFailureMessage = lWarnings.get(0);
    assertEquals(ErrorCodes.IGNORING_ROW, lFailureMessage.getMessageID());
    assertEquals(
        "Ignoring row '4' in Excel sheet 'Test-Message 01' as it does not contain values for all required columns. The following fields are missing: Message-ID, Message-Type, Trace-Level, Default-Text",
        lFailureMessage.toString(Locale.ENGLISH));

    lFailureMessage = lWarnings.get(1);
    assertEquals(ErrorCodes.IGNORING_ROW, lFailureMessage.getMessageID());
    assertEquals(
        "Ignoring row '3' in Excel sheet 'Test-Message 02' as it does not contain values for all required columns. The following fields are missing: Message-Type, Trace-Level, Default-Text",
        lFailureMessage.toString(Locale.ENGLISH));

    lFailureMessage = lWarnings.get(2);
    assertEquals(ErrorCodes.IGNORING_ROW, lFailureMessage.getMessageID());
    assertEquals(
        "Ignoring row '4' in Excel sheet 'Test-Message 02' as it does not contain values for all required columns. The following fields are missing: Message-ID, Message-Type, Trace-Level, Default-Text",
        lFailureMessage.toString(Locale.ENGLISH));

    lFailureMessage = lWarnings.get(3);
    assertEquals(ErrorCodes.IGNORING_ROW, lFailureMessage.getMessageID());
    assertEquals(
        "Ignoring row '5' in Excel sheet 'Test-Message 02' as it does not contain values for all required columns. The following fields are missing: Trace-Level, Default-Text",
        lFailureMessage.toString(Locale.ENGLISH));

    lFailureMessage = lWarnings.get(4);
    assertEquals(ErrorCodes.IGNORING_ROW, lFailureMessage.getMessageID());
    assertEquals(
        "Ignoring row '6' in Excel sheet 'Test-Message 02' as it does not contain values for all required columns. The following fields are missing: Message-Type, Default-Text",
        lFailureMessage.toString(Locale.ENGLISH));

    lFailureMessage = lWarnings.get(5);
    assertEquals(ErrorCodes.IGNORING_ROW, lFailureMessage.getMessageID());
    assertEquals(
        "Ignoring row '7' in Excel sheet 'Test-Message 02' as it does not contain values for all required columns. The following fields are missing: Message-Type, Trace-Level, Default-Text",
        lFailureMessage.toString(Locale.ENGLISH));

    lFailureMessage = lWarnings.get(6);
    assertEquals(ErrorCodes.IGNORING_ROW, lFailureMessage.getMessageID());
    assertEquals(
        "Ignoring row '8' in Excel sheet 'Test-Message 02' as it does not contain values for all required columns. The following fields are missing: Message-Type, Trace-Level, Default-Text",
        lFailureMessage.toString(Locale.ENGLISH));

    lFailureMessage = lWarnings.get(7);
    assertEquals(ErrorCodes.IGNORING_EMPTY_SHEET, lFailureMessage.getMessageID());
    assertEquals("Ignoring empty sheet 'Empty Sheet' within Excel workbook.", lFailureMessage.toString(Locale.ENGLISH));

    // Test Excel file without messages.
    lConversionResult = lConverter.generateMessageResource(NO_MESSAGES);
    lVerificationResult = lConversionResult.getVerificationResult();
    System.out.println(lVerificationResult.getMessage());
    assertEquals(1, lVerificationResult.getErrors().size());
    assertFalse(lVerificationResult.containsWarnings());

    // Test Excel file with no class info.
    lConversionResult = lConverter.generateMessageResource(CLASS_INFO_MISSING);
    lVerificationResult = lConversionResult.getVerificationResult();
    System.out.println(lVerificationResult.getMessage());
    assertEquals(1, lVerificationResult.getErrors().size());
    assertFalse(lVerificationResult.containsWarnings());
  }
}
