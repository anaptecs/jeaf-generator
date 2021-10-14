/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi;

import java.util.List;

import com.anaptecs.jeaf.core.api.Service;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public interface ProductRESTService extends Service {
  /**
   * 
   * @return {@link Product}
   */
  List<Product> getProducts( );

  /**
   * 
   * @param pProductID
   * @return {@link Product}
   */
  Product getProduct( String pProductID );
}
