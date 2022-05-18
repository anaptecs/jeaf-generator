/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.spring.impl;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.springframework.stereotype.Component;

@Component
@WebFilter(asyncSupported = true)
public class ContentTypeFilter implements Filter {

  @Override
  public void doFilter( ServletRequest pRequest, ServletResponse pResponse, FilterChain pChain )
    throws IOException, ServletException {

    ServletRequest lRequest;
    if (pRequest instanceof HttpServletRequest) {
      HttpServletRequest lHttpServletRequest = (HttpServletRequest) pRequest;
      String lContentType = lHttpServletRequest.getContentType();
      if (lContentType == null || lContentType.isEmpty()) {
        lRequest = new ContentTypeEnabledRequest(lHttpServletRequest);
      }
      else {
        lRequest = pRequest;
      }
    }
    else {
      lRequest = pRequest;
    }

    pChain.doFilter(lRequest, pResponse);

  }

  class ContentTypeEnabledRequest extends HttpServletRequestWrapper {
    ContentTypeEnabledRequest( HttpServletRequest pRequest ) {
      super(pRequest);
    }

    @Override
    public String getContentType( ) {
      return "application/json";
    }
  }

}
