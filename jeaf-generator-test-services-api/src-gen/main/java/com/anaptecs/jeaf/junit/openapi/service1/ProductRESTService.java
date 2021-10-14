/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.service1;

import java.util.List;

import com.anaptecs.jeaf.core.api.Service;
import com.anaptecs.jeaf.junit.openapi.base.Product;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public interface ProductRESTService extends Service {
  /**
   * Operation returns all available product.
   * 
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

  /**
   * 
   * @param pProduct
   * @return {@link Boolean}
   */
  boolean createProduct( Product pProduct );
}
