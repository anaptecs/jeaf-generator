/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.validationgroups.validationgroups;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import com.anaptecs.annotations.MyNotNullProperty;

/**
 * Type can be used to resolve validation groups by an identifier etc.
 */
public class ValidationGroupHelper {
  /**
   * List contains all validation groups that are defined in the UML model.
   */
  public static final List<ValidationGroup> ALL_VALIDATION_GROUPS = List.of(
      new ValidationGroup(V4.class, V4.IDENTIFIER_PATTERN), new ValidationGroup(V5.class, V5.IDENTIFIER_PATTERN),
      new ValidationGroup(V6.class, V6.IDENTIFIER_PATTERN), new ValidationGroup(V7.class, V7.IDENTIFIER_PATTERN));

  /**
   * Record aggregates information about a validation group.
   */
  public static record ValidationGroup( Class<?> validationGroupClass, String identifierPattern ) {
  }

  /**
   * Operation returns the first validation group that matches to the passed version name.
   *
   * @param pVersionName Name version that should be used to identify a validation group.
   * @return {@link Optional<ValidationGroup>} First validation group that matches if any does.
   */
  public static Optional<ValidationGroup> findMatchingValidationGroup( @MyNotNullProperty String pVersionName ) {
    Predicate<ValidationGroup> lPredicate = s -> pVersionName.matches(s.identifierPattern);
    return findMatchingValidationGroup(lPredicate);
  }

  /**
   * Operation returns the first validation group that matches to the passed predicate.
   *
   * @param pPredicate Predicate that should be used to identify a validation group.
   * @return {@link Optional<ValidationGroup>} First validation group that matches if any does.
   */
  public static Optional<ValidationGroup> findMatchingValidationGroup(
      @MyNotNullProperty Predicate<ValidationGroup> pPredicate ) {
    return ALL_VALIDATION_GROUPS.stream().filter(pPredicate).findFirst();
  }
}