/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.validationgroups;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.anaptecs.jeaf.junit.validationgroups.validationgroups.V4;
import com.anaptecs.jeaf.junit.validationgroups.validationgroups.V5;
import com.anaptecs.jeaf.junit.validationgroups.validationgroups.V6;
import com.anaptecs.jeaf.junit.validationgroups.validationgroups.V7;
import com.anaptecs.jeaf.validation.api.TypeRestriction;
import com.anaptecs.jeaf.validation.api.spring.SpringValidationExecutor;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import tools.jackson.databind.annotation.JsonDeserialize;
import tools.jackson.databind.annotation.JsonPOJOBuilder;

@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE,
    setterVisibility = JsonAutoDetect.Visibility.NONE,
    creatorVisibility = JsonAutoDetect.Visibility.ANY)
@JsonDeserialize(builder = Zoo.Builder.class)
public class Zoo {
  /**
   * Constant for the name of attribute "allAnimals".
   */
  public static final String ALLANIMALS = "allAnimals";

  /**
   * Constant for the name of attribute "endangeredSpecies".
   */
  public static final String ENDANGEREDSPECIES = "endangeredSpecies";

  @TypeRestriction(allowSubtypes = false, allowedTypes = { Cat.class, Dog.class }, groups = { V7.class })
  @TypeRestriction(
      allowSubtypes = true,
      notAllowedTypes = { Elephant.class },
      groups = { V4.class, V5.class, V6.class })
  private Set<Animal> allAnimals;

  @TypeRestriction(allowSubtypes = true, allowedTypes = { Animal.class })
  private Set<Animal> endangeredSpecies;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected Zoo( Builder pBuilder ) {
    // Read attribute values from builder.
    allAnimals = (pBuilder.allAnimals == null) ? new HashSet<>() : pBuilder.allAnimals;
    endangeredSpecies = (pBuilder.endangeredSpecies == null) ? new HashSet<>() : pBuilder.endangeredSpecies;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new Zoo objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Convenience method to create new instance of class Zoo.
   *
   *
   * @return {@link Zoo}
   */
  public static Zoo of( ) {
    var lBuilder = Zoo.builder();
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>Zoo</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder {
    private Set<Animal> allAnimals;

    private Set<Animal> endangeredSpecies;

    /**
     * Use {@link Zoo#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link Zoo#builder(Zoo)} instead of private constructor to create new builder.
     */
    protected Builder( Zoo pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setAllAnimals(pObject.allAnimals);
        this.setEndangeredSpecies(pObject.endangeredSpecies);
      }
    }

    /**
     * Method returns a new builder.
     *
     * @return {@link Builder} New builder that can be used to create new Zoo objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     *
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new Zoo objects. The method never returns null.
     */
    public static Builder newBuilder( Zoo pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets association {@link #allAnimals}.<br/>
     *
     * @param pAllAnimals Collection to which {@link #allAnimals} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP, contentNulls = Nulls.SKIP)
    public Builder setAllAnimals( Set<Animal> pAllAnimals ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pAllAnimals != null) {
        allAnimals = new HashSet<Animal>(pAllAnimals);
      }
      else {
        allAnimals = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #allAnimals}.<br/>
     *
     * @param pAllAnimals Array of objects that should be added to {@link #allAnimals}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToAllAnimals( Animal... pAllAnimals ) {
      if (pAllAnimals != null) {
        if (allAnimals == null) {
          allAnimals = new HashSet<Animal>();
        }
        allAnimals.addAll(Arrays.asList(pAllAnimals));
      }
      return this;
    }

    /**
     * Method sets association {@link #endangeredSpecies}.<br/>
     *
     * @param pEndangeredSpecies Collection to which {@link #endangeredSpecies} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP, contentNulls = Nulls.SKIP)
    public Builder setEndangeredSpecies( Set<Animal> pEndangeredSpecies ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pEndangeredSpecies != null) {
        endangeredSpecies = new HashSet<Animal>(pEndangeredSpecies);
      }
      else {
        endangeredSpecies = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #endangeredSpecies}.<br/>
     *
     * @param pEndangeredSpecies Array of objects that should be added to {@link #endangeredSpecies}. The parameter may
     * be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToEndangeredSpecies( Animal... pEndangeredSpecies ) {
      if (pEndangeredSpecies != null) {
        if (endangeredSpecies == null) {
          endangeredSpecies = new HashSet<Animal>();
        }
        endangeredSpecies.addAll(Arrays.asList(pEndangeredSpecies));
      }
      return this;
    }

    /**
     * Method creates a new instance of class Zoo. The object will be initialized with the values of the builder.
     *
     * @return Zoo Created object. The method never returns null.
     */
    public Zoo build( ) {
      Zoo lObject = new Zoo(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  /**
   * Method returns association {@link #allAnimals}.<br/>
   *
   * @return {@link Set<Animal>} Value to which {@link #allAnimals} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  public Set<Animal> getAllAnimals( ) {
    // Return all Animal objects as unmodifiable collection.
    return Collections.unmodifiableSet(allAnimals);
  }

  /**
   * Method adds the passed object to {@link #allAnimals}.
   *
   * @param pAllAnimals Object that should be added to {@link #allAnimals}. The parameter must not be null.
   */
  public void addToAllAnimals( Animal pAllAnimals ) {
    // Add passed object to collection of associated Animal objects.
    allAnimals.add(pAllAnimals);
  }

  /**
   * Method adds all passed objects to {@link #allAnimals}.
   *
   * @param pAllAnimals Collection with all objects that should be added to {@link #allAnimals}. The parameter must not
   * be null.
   */
  public void addToAllAnimals( Collection<Animal> pAllAnimals ) {
    // Add all passed objects.
    for (Animal lNextObject : pAllAnimals) {
      this.addToAllAnimals(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #allAnimals}.<br/>
   *
   * @param pAllAnimals Object that should be removed from {@link #allAnimals}. The parameter must not be null.
   */
  public void removeFromAllAnimals( Animal pAllAnimals ) {
    // Remove passed object from collection of associated Animal objects.
    allAnimals.remove(pAllAnimals);
  }

  /**
   * Method removes all objects from {@link #allAnimals}.
   */
  public void clearAllAnimals( ) {
    // Remove all objects from association "allAnimals".
    allAnimals.clear();
  }

  /**
   * Method returns association {@link #endangeredSpecies}.<br/>
   *
   * @return {@link Set<Animal>} Value to which {@link #endangeredSpecies} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  public Set<Animal> getEndangeredSpecies( ) {
    // Return all Animal objects as unmodifiable collection.
    return Collections.unmodifiableSet(endangeredSpecies);
  }

  /**
   * Method adds the passed object to {@link #endangeredSpecies}.
   *
   * @param pEndangeredSpecies Object that should be added to {@link #endangeredSpecies}. The parameter must not be
   * null.
   */
  public void addToEndangeredSpecies( Animal pEndangeredSpecies ) {
    // Add passed object to collection of associated Animal objects.
    endangeredSpecies.add(pEndangeredSpecies);
  }

  /**
   * Method adds all passed objects to {@link #endangeredSpecies}.
   *
   * @param pEndangeredSpecies Collection with all objects that should be added to {@link #endangeredSpecies}. The
   * parameter must not be null.
   */
  public void addToEndangeredSpecies( Collection<Animal> pEndangeredSpecies ) {
    // Add all passed objects.
    for (Animal lNextObject : pEndangeredSpecies) {
      this.addToEndangeredSpecies(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #endangeredSpecies}.<br/>
   *
   * @param pEndangeredSpecies Object that should be removed from {@link #endangeredSpecies}. The parameter must not be
   * null.
   */
  public void removeFromEndangeredSpecies( Animal pEndangeredSpecies ) {
    // Remove passed object from collection of associated Animal objects.
    endangeredSpecies.remove(pEndangeredSpecies);
  }

  /**
   * Method removes all objects from {@link #endangeredSpecies}.
   */
  public void clearEndangeredSpecies( ) {
    // Remove all objects from association "endangeredSpecies".
    endangeredSpecies.clear();
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(allAnimals);
    lResult = lPrime * lResult + Objects.hashCode(endangeredSpecies);
    return lResult;
  }

  @Override
  public boolean equals( Object pObject ) {
    boolean lEquals;
    if (this == pObject) {
      lEquals = true;
    }
    else if (pObject == null) {
      lEquals = false;
    }
    else if (this.getClass() != pObject.getClass()) {
      lEquals = false;
    }
    else {
      Zoo lOther = (Zoo) pObject;
      lEquals =
          Objects.equals(allAnimals, lOther.allAnimals) && Objects.equals(endangeredSpecies, lOther.endangeredSpecies);
    }
    return lEquals;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  public StringBuilder toStringBuilder( String pIndent ) {
    StringBuilder lBuilder = new StringBuilder();
    lBuilder.append(pIndent);
    lBuilder.append(this.getClass().getName());
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("allAnimals: ");
    if (allAnimals != null) {
      lBuilder.append(allAnimals.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (allAnimals != null) {
      for (Animal lNext : allAnimals) {
        lBuilder.append(lNext.toStringBuilder(pIndent + "    "));
        lBuilder.append(System.lineSeparator());
      }
    }
    lBuilder.append(pIndent);
    lBuilder.append("endangeredSpecies: ");
    if (endangeredSpecies != null) {
      lBuilder.append(endangeredSpecies.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (endangeredSpecies != null) {
      for (Animal lNext : endangeredSpecies) {
        lBuilder.append(lNext.toStringBuilder(pIndent + "    "));
        lBuilder.append(System.lineSeparator());
      }
    }
    return lBuilder;
  }

  /**
   * Method creates a new String with the values of all attributes of this class. All references to other objects will
   * be ignored.
   *
   * @return {@link String} String representation of this object. The method never returns null.
   */
  @Override
  public String toString( ) {
    return this.toStringBuilder("").toString();
  }

  /**
   * Method creates a new builder and initializes it with the data of this object.
   *
   * @return {@link Builder} New builder that can be used to create new Zoo objects. The method never returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}