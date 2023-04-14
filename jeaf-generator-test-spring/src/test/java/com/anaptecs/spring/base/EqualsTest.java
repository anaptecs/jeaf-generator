package com.anaptecs.spring.base;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class EqualsTest {
  @Test
  void testEqualsForPOJO( ) {
    EqualsVerifier.simple().forPackage(BeanParameter.class.getPackageName())
        .except(c -> c.getSimpleName().endsWith("Builder") || c.getSimpleName().endsWith("BuilderBase"))
        .except(BidirectA.class, BidirectB.class, Channel.class, Product.class, Reseller.class, ResellerBase.class,
            Sortiment.class)
        .suppress(Warning.BIGDECIMAL_EQUALITY).verify();
  }
}
