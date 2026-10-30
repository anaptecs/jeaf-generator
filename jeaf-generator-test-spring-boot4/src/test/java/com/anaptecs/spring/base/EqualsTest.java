package com.anaptecs.spring.base;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.ScanOption;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled
public class EqualsTest {
  @Test
  void testEqualsForPOJO( ) {
    EqualsVerifier.simple()
        .forPackage(
            BeanParameter.class.getPackageName(),
            ScanOption.except(
                BidirectA.class,
                BidirectB.class,
                Channel.class,
                Product.class,
                Reseller.class,
                ResellerBase.class,
                Sortiment.class))
        .suppress(
            Warning.BIGDECIMAL_EQUALITY,
            Warning.INHERITED_DIRECTLY_FROM_OBJECT)
        .verify();
  }
}
