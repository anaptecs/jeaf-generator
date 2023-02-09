package com.anaptecs.jeaf.fwk.generator.util;

public enum ReportFormat {
  MARKDOWN(".md"), HTML(".html"), XML(".xml");

  private final String extension;

  private ReportFormat( String pExtension ) {
    extension = pExtension;
  }

  public String getExtension( ) {
    return extension;
  }
}
