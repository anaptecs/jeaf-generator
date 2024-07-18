package de.plushnikov.doctorjim;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

import com.github.javaparser.ParseException;

/**
 * Simple testsuit for Importbeautifier tests
 *
 * @author Plushnikov Michail
 */
public class SimpleTest {
  private ImportProcessor mProcessor;

  @Before
  public void setUp( ) {
    mProcessor = new ImportProcessor();
  }

  @Test
  public void testOne( ) throws Exception {
    testBeautifikation("Temp");
  }

  @Test
  public void testTwo( ) throws Exception {
    testBeautifikation("Temp2");
  }

  @Test
  public void testThree( ) throws Exception {
    testBeautifikation("package-info");
  }

  @Test
  public void testSample1( ) throws Exception {
    testBeautifikation("Sample01");
  }

  @Test
  public void testSample2( ) throws Exception {
    testBeautifikation("Sample02");
  }

  @Test
  public void testSample3( ) throws Exception {
    testBeautifikation("Sample03");
  }

  @Test
  public void testSample4( ) throws Exception {
    testBeautifikation("Sample04");
  }

  @Test
  public void testSample5( ) throws Exception {
    testBeautifikation("Sample05");
  }

  @Test
  public void testSample6( ) throws Exception {
    testBeautifikation("Sample06");
  }

  @Test
  public void testSample7( ) throws Exception {
    testBeautifikation("Sample07");
  }

  @Test
  public void testSample8( ) throws Exception {
    testBeautifikation("Sample08");
  }

  @Test
  public void testSample9( ) throws Exception {
    testBeautifikation("Sample09");
  }

  @Test
  public void testSample10( ) throws Exception {
    testBeautifikation("Sample10");
  }

  @Test
  public void testSample11( ) throws Exception {
    testBeautifikation("Sample11");
  }

  @Test
  public void testSample12( ) throws Exception {
    testBeautifikation("Sample12");
  }

  @Test
  public void testSample13( ) throws Exception {
    testBeautifikation("Sample13");
  }

  @Test
  public void testSample14( ) throws Exception {
    testBeautifikation("Sample14");
  }

  @Test
  public void testSample15( ) throws Exception {
    testBeautifikation("Sample15");
  }

  @Test
  public void testSample16( ) throws Exception {
    testBeautifikation("Sample16");
  }

  @Test
  public void testSample17( ) throws Exception {
    mProcessor.setStrict(false);
    testBeautifikation("Sample17");
  }

  @Test
  public void testSample18( ) throws Exception {
    mProcessor.setStrict(false);
    testBeautifikation("Sample18");
  }

  @Test
  public void testSample20( ) throws Exception {
    testBeautifikation("Sample20");
  }

  @Test
  public void testSample21( ) throws Exception {
    testBeautifikation("Sample21");
  }

  @Test
  public void testSample22( ) throws Exception {
    testBeautifikation("Sample22");
  }

  @Test
  public void testSample23( ) throws Exception {
    testBeautifikation("Sample23");
  }

  @Test
  public void testSample24( ) throws Exception {
    testBeautifikation("Sample24");
  }

  @Test
  public void testSample25( ) throws Exception {
    testBeautifikation("Sample25");
  }

  @Test
  public void testSample26( ) throws Exception {
    testBeautifikation("Sample26");
  }

  @Test
  public void testSample27( ) throws Exception {
    testBeautifikation("Sample27");
  }

  @Test
  public void testSample28( ) throws Exception {
    testBeautifikation("Sample28");
  }

  @Test
  public void testSample29( ) throws Exception {
    testBeautifikation("Sample29");
  }

  @Test
  public void testSample30( ) throws Exception {
    testBeautifikation("Sample30");
  }

  @Test
  public void testSample31( ) throws Exception {
    testBeautifikation("Sample31");
  }

  @Test
  public void testSample32( ) throws Exception {
    testBeautifikation("Sample32");
  }

  @Test
  public void testSample33( ) throws Exception {
    testBeautifikation("Sample33");
  }

  @Test
  public void testSample34( ) throws Exception {
    testBeautifikation("Sample34");
  }

  @Test
  public void testSample35( ) throws Exception {
    testBeautifikation("Sample35");
  }

  @Test
  public void testSample36( ) throws Exception {
    testBeautifikation("Sample36");
  }

  @Test
  public void testSample37( ) throws Exception {
    testBeautifikation("Sample37");
  }

  @Test
  public void testSample38( ) throws Exception {
    testBeautifikation("Sample38");
  }

  @Test
  public void testSample39( ) throws Exception {
    testBeautifikation("Sample39");
  }

  @Test
  public void testSample40( ) throws Exception {
    testBeautifikation("Sample40");
  }

  @Test
  public void testAgendarColeta( ) throws Exception {
    testBeautifikation("AgendarColeta");
  }

  @Test
  public void testAgendarColetaController( ) throws Exception {
    testBeautifikation("AgendarColetaController");
  }

  @Test
  public void testManutencaoRelatorio( ) throws Exception {
    testBeautifikation("ManutencaoRelatorio");
  }

  @Test
  public void testDiamondOperator( ) throws Exception {
    testBeautifikation("DiamondOperator");
  }

  /**
   * Execute beautifikation on the given file and compare result
   *
   * @param pFilename filename to be used as input for beautifikation
   * @throws IOException if any errors occured
   * @throws ParseException if any errors occured
   */
  private void testBeautifikation( String pFilename ) throws Exception {
    String lInput = IOUtils.toString(this.getClass().getResourceAsStream(pFilename + ".java_input"));
    String lExpectedOutput = IOUtils.toString(this.getClass().getResourceAsStream(pFilename + ".java_output"));

    String lOutput = mProcessor.organizeImports(lInput, new ArrayList<String>());

    assertEquals(lExpectedOutput.trim(), lOutput.trim());
  }

}
