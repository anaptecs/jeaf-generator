package com.anaptecs.jeaf.fwk.generator.util;

/**
 * Line ending of generated files.
 */
public enum LineEnding {
  LF("\n"), CRLF("\r\n"), AUTO(System.lineSeparator());

  /**
   * System property that passes the line ending configured in the Maven plugin to the generator.
   */
  public static final String PROPERTY = "jeaf.generator.lineEnding";

  private final String separator;

  private LineEnding( String pSeparator ) {
    separator = pSeparator;
  }

  public String getSeparator( ) {
    return separator;
  }

  /**
   * @return {@link LineEnding} Line ending of the current generator run. If none or an unknown one is configured then
   * {@link #LF} is used.
   */
  public static LineEnding current( ) {
    String lValue = System.getProperty(PROPERTY);
    LineEnding lLineEnding = LF;
    if (lValue != null) {
      try {
        lLineEnding = LineEnding.valueOf(lValue.trim().toUpperCase());
      }
      catch (IllegalArgumentException e) {
        lLineEnding = LF;
      }
    }
    return lLineEnding;
  }

  /**
   * Converts all line breaks (CRLF, LF or single CR) to this line ending.
   *
   * @param pText Text that should be converted. The parameter may be null.
   * @return {@link CharSequence} Converted text. If nothing has to be changed then the passed object is returned.
   */
  public CharSequence normalize( CharSequence pText ) {
    CharSequence lResult = pText;
    if (pText != null && this.needsConversion(pText)) {
      int lLength = pText.length();
      StringBuilder lBuilder = new StringBuilder(lLength + lLength / 20);
      for (int i = 0; i < lLength; i++) {
        char lChar = pText.charAt(i);
        if (lChar == '\r') {
          if (i + 1 < lLength && pText.charAt(i + 1) == '\n') {
            i++;
          }
          lBuilder.append(separator);
        }
        else if (lChar == '\n') {
          lBuilder.append(separator);
        }
        else {
          lBuilder.append(lChar);
        }
      }
      lResult = lBuilder;
    }
    return lResult;
  }

  /**
   * Checks if the text contains a line break that differs from this line ending. Most texts don't, so they don't have
   * to be copied.
   */
  private boolean needsConversion( CharSequence pText ) {
    boolean lNeedsConversion = false;
    int lLength = pText.length();
    for (int i = 0; i < lLength && lNeedsConversion == false; i++) {
      char lChar = pText.charAt(i);
      if (lChar == '\r') {
        // CRLF only fits if the line ending is CRLF, a single CR never fits.
        boolean lIsCRLF = i + 1 < lLength && pText.charAt(i + 1) == '\n';
        lNeedsConversion = lIsCRLF == false || separator.equals("\r\n") == false;
        i++;
      }
      else if (lChar == '\n') {
        lNeedsConversion = separator.equals("\n") == false;
      }
    }
    return lNeedsConversion;
  }
}
