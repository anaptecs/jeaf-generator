package com.anaptecs.jeaf.fwk.generator.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.anaptecs.jeaf.tools.api.file.FileTools;
import org.apache.poi.ooxml.POIXMLProperties;
import org.apache.poi.ooxml.POIXMLProperties.CoreProperties;
import org.apache.poi.ooxml.POIXMLProperties.ExtendedProperties;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelper {
  private static final List<List<String>> rowEntryCollector = new ArrayList<List<String>>();

  public static void addRow(List<String> pRowEntries) {
    rowEntryCollector.add(pRowEntries);
  }

  public static void clearRowCollector( ) {
    rowEntryCollector.clear();
  }

  public static void writeRowsToExcelTemplate(String pTemplateName, String pOutputFile) {
    try (InputStream lTemplateAsStream = FileTools.getFileTools().getResourceAsStream(pTemplateName)) {
      XSSFWorkbook lWorkbook = new XSSFWorkbook(lTemplateAsStream);
      // Workbook lWorkbook = WorkbookFactory.create(lTemplateAsStream, null);
      CoreProperties lProperties = lWorkbook.getProperties().getCoreProperties();
      String FIXED_DATE = "2020-01-01T00:00:00Z";
      lProperties.setCreator("JEAF Generator");
      lProperties.setLastModifiedByUser("JEAF Generator");
      lProperties.setCreated(FIXED_DATE);
      lProperties.setModified(FIXED_DATE);

      ExtendedProperties lExtendedProperties = lWorkbook.getProperties().getExtendedProperties();
      lExtendedProperties.setApplication("JEAF Generator");
      lExtendedProperties.setAppVersion("1.0");

      XSSFSheet lSheet = lWorkbook.getSheetAt(0);

      int lRowIndex = 1;
      for (List<String> lNextRow : rowEntryCollector) {
        Row lExcelRow = lSheet.createRow(lRowIndex++);
        int lCellIndex = 0;
        for (String lCellValue : lNextRow) {
          lExcelRow.createCell(lCellIndex++).setCellValue(lCellValue);
        }
      }

      File lFile = new File(pOutputFile);
      FileOutputStream lOutputStream = new FileOutputStream(lFile);
      lWorkbook.write(lOutputStream);
      lOutputStream.close();
      lWorkbook.close();
    }
    catch (IOException | InvalidFormatException e) {
      e.printStackTrace();
      throw new RuntimeException("Unable to create Excel file ' " + pOutputFile + ".", e);
    }
  }
}
