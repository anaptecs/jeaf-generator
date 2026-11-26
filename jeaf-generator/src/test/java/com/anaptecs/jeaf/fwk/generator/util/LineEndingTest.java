package com.anaptecs.jeaf.fwk.generator.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class LineEndingTest {
  @AfterEach
  void clearProperty( ) {
    System.clearProperty(LineEnding.PROPERTY);
  }

  @Test
  void testNormalizeToLF( ) {
    assertEquals("a\nb\nc\nd\n", LineEnding.LF.normalize("a\r\nb\nc\rd\r\n").toString());
    assertEquals("\n\n", LineEnding.LF.normalize("\r\r\n").toString());
    assertEquals("a\n", LineEnding.LF.normalize("a\r").toString());
  }

  @Test
  void testNormalizeToCRLF( ) {
    assertEquals("a\r\nb\r\nc\r\nd\r\n", LineEnding.CRLF.normalize("a\r\nb\nc\rd\r\n").toString());
    assertEquals("a\r\n", LineEnding.CRLF.normalize("a\n").toString());
  }

  @Test
  void testUnchangedTextIsNotCopied( ) {
    CharSequence lLF = new StringBuilder("a\nb\n");
    assertSame(lLF, LineEnding.LF.normalize(lLF));
    CharSequence lCRLF = new StringBuilder("a\r\nb\r\n");
    assertSame(lCRLF, LineEnding.CRLF.normalize(lCRLF));
    CharSequence lNoLineBreak = "abc";
    assertSame(lNoLineBreak, LineEnding.LF.normalize(lNoLineBreak));
    assertSame(lNoLineBreak, LineEnding.CRLF.normalize(lNoLineBreak));
    assertEquals("", LineEnding.CRLF.normalize("").toString());
    assertNull(LineEnding.LF.normalize(null));
  }

  @Test
  void testAutoUsesLineEndingOfOperatingSystem( ) {
    assertEquals("a" + System.lineSeparator() + "b", LineEnding.AUTO.normalize("a\r\nb").toString());
  }

  @Test
  void testCurrentLineEnding( ) {
    assertEquals(LineEnding.LF, LineEnding.current());
    System.setProperty(LineEnding.PROPERTY, "CRLF");
    assertEquals(LineEnding.CRLF, LineEnding.current());
    System.setProperty(LineEnding.PROPERTY, " auto ");
    assertEquals(LineEnding.AUTO, LineEnding.current());
    System.setProperty(LineEnding.PROPERTY, "unknown");
    assertEquals(LineEnding.LF, LineEnding.current());
  }
}
