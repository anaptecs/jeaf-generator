/**
 * Copyright 2004 - 2020 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.fwk.tools.message.generator;

import org.w3c.dom.Document;

import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.anaptecs.jeaf.xfun.api.checks.VerificationResult;

public class ConversionResult {
  private final Document document;

  private final VerificationResult verificationResult;

  public ConversionResult( Document pDocument, VerificationResult pVerificationResult ) {
    // Check parameters.
    Check.checkInvalidParameterNull(pVerificationResult, "pVerificationResult");

    document = pDocument;
    verificationResult = pVerificationResult;
  }

  public Document getDocument( ) {
    return document;
  }

  public VerificationResult getVerificationResult( ) {
    return verificationResult;
  }

}
