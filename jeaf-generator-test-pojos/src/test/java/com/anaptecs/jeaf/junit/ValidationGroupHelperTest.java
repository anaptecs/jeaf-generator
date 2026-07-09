package com.anaptecs.jeaf.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.anaptecs.jeaf.junit.validationgroups.validationgroups.V4;
import com.anaptecs.jeaf.junit.validationgroups.validationgroups.V6;
import com.anaptecs.jeaf.junit.validationgroups.validationgroups.ValidationGroupHelper;
import org.junit.jupiter.api.Test;

public class ValidationGroupHelperTest {

  @Test
  void testValidationGroupResolution( ) {
    assertEquals(V4.class, ValidationGroupHelper.findMatchingValidationGroup("4.1.2").get().validationGroupClass());
    assertEquals(V6.class,
        ValidationGroupHelper.findMatchingValidationGroup("6.0.0-RC13").get().validationGroupClass());
    assertTrue(ValidationGroupHelper.findMatchingValidationGroup("3.4.2").isEmpty());
  }
}
