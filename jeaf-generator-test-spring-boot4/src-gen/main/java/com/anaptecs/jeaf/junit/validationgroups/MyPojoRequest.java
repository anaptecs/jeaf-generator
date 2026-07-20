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

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.anaptecs.annotations.MyNotEmptyProperty;
import com.anaptecs.annotations.MyNotNullProperty;
import com.anaptecs.jeaf.junit.validationgroups.validationgroups.V4;
import com.anaptecs.jeaf.junit.validationgroups.validationgroups.V5;
import com.anaptecs.jeaf.junit.validationgroups.validationgroups.V6;
import com.anaptecs.jeaf.junit.validationgroups.validationgroups.V7;
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
@JsonDeserialize(builder = MyPojoRequest.Builder.class)
public class MyPojoRequest {
  /**
   * Constant for the name of attribute "upcomingMandatoryProperty".
   */
  public static final String UPCOMINGMANDATORYPROPERTY = "upcomingMandatoryProperty";

  /**
   * Constant for the name of attribute "propertyWithNewConstraints".
   */
  public static final String PROPERTYWITHNEWCONSTRAINTS = "propertyWithNewConstraints";

  /**
   * Constant for the name of attribute "formerMandatoryRequestProperty".
   */
  @Deprecated
  public static final String FORMERMANDATORYREQUESTPROPERTY = "formerMandatoryRequestProperty";

  /**
   * Constant for the name of attribute "untouchedProperty".
   */
  public static final String UNTOUCHEDPROPERTY = "untouchedProperty";

  /**
   * Constant for the name of attribute "constraintChangingProperty".
   */
  public static final String CONSTRAINTCHANGINGPROPERTY = "constraintChangingProperty";

  /**
   * Constant for the name of attribute "otherPojos".
   */
  public static final String OTHERPOJOS = "otherPojos";

  /**
   * Constant for the name of attribute "thePojo".
   */
  public static final String THEPOJO = "thePojo";

  /**
   * <p/>
   * <b>Breaking Change with :</b>
   */
  @NotNull(groups = { V7.class })
  private String upcomingMandatoryProperty;

  /**
   * <p/>
   * <b>Breaking Change with :</b>
   */
  @NotNull
  private String propertyWithNewConstraints;

  @Deprecated
  @NotNull(groups = { V4.class, V5.class, V6.class })
  private String formerMandatoryRequestProperty;

  @NotNull
  private String untouchedProperty;

  @Size(min = 10, max = 20, groups = { V7.class })
  @Size(min = 5, max = 500, groups = { V4.class, V5.class, V6.class })
  @NotNull(groups = { V7.class })
  private String constraintChangingProperty;

  @Size(min = 1, groups = { V7.class })
  @NotNull(groups = { V7.class })
  private Set<OtherPojo> otherPojos;

  @Valid
  @NotNull(groups = { V7.class })
  private OtherPojo thePojo;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected MyPojoRequest( Builder pBuilder ) {
    // Read attribute values from builder.
    upcomingMandatoryProperty = pBuilder.upcomingMandatoryProperty;
    propertyWithNewConstraints = pBuilder.propertyWithNewConstraints;
    formerMandatoryRequestProperty = pBuilder.formerMandatoryRequestProperty;
    untouchedProperty = pBuilder.untouchedProperty;
    constraintChangingProperty = pBuilder.constraintChangingProperty;
    otherPojos = (pBuilder.otherPojos == null) ? new HashSet<>() : pBuilder.otherPojos;
    thePojo = pBuilder.thePojo;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new MyPojoRequest objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Convenience method to create new instance of class MyPojoRequest.
   *
   *
   * @param pUpcomingMandatoryProperty Value to which {@link #upcomingMandatoryProperty} should be set.
   *
   * @param pPropertyWithNewConstraints Value to which {@link #propertyWithNewConstraints} should be set.
   *
   * @param pUntouchedProperty Value to which {@link #untouchedProperty} should be set.
   *
   * @param pConstraintChangingProperty Value to which {@link #constraintChangingProperty} should be set.
   *
   * @param pOtherPojos Value to which {@link #otherPojos} should be set.
   *
   * @param pThePojo Value to which {@link #thePojo} should be set.
   *
   * @return {@link MyPojoRequest}
   */
  public static MyPojoRequest of( String pUpcomingMandatoryProperty, String pPropertyWithNewConstraints,
      String pUntouchedProperty, String pConstraintChangingProperty, Set<OtherPojo> pOtherPojos, OtherPojo pThePojo ) {
    var lBuilder = MyPojoRequest.builder();
    lBuilder.setUpcomingMandatoryProperty(pUpcomingMandatoryProperty);
    lBuilder.setPropertyWithNewConstraints(pPropertyWithNewConstraints);
    lBuilder.setUntouchedProperty(pUntouchedProperty);
    lBuilder.setConstraintChangingProperty(pConstraintChangingProperty);
    lBuilder.setOtherPojos(pOtherPojos);
    lBuilder.setThePojo(pThePojo);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>MyPojoRequest</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder {
    /**
     * <p/>
     * <b>Breaking Change with :</b>
     */
    private String upcomingMandatoryProperty;

    /**
     * <p/>
     * <b>Breaking Change with :</b>
     */
    private String propertyWithNewConstraints;

    @Deprecated
    private String formerMandatoryRequestProperty;

    private String untouchedProperty;

    private String constraintChangingProperty;

    private Set<OtherPojo> otherPojos;

    private OtherPojo thePojo;

    /**
     * Use {@link MyPojoRequest#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link MyPojoRequest#builder(MyPojoRequest)} instead of private constructor to create new builder.
     */
    protected Builder( MyPojoRequest pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setUpcomingMandatoryProperty(pObject.upcomingMandatoryProperty);
        this.setPropertyWithNewConstraints(pObject.propertyWithNewConstraints);
        this.setFormerMandatoryRequestProperty(pObject.formerMandatoryRequestProperty);
        this.setUntouchedProperty(pObject.untouchedProperty);
        this.setConstraintChangingProperty(pObject.constraintChangingProperty);
        this.setOtherPojos(pObject.otherPojos);
        this.setThePojo(pObject.thePojo);
      }
    }

    /**
     * Method returns a new builder.
     *
     * @return {@link Builder} New builder that can be used to create new MyPojoRequest objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     *
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new MyPojoRequest objects. The method never
     * returns null.
     */
    public static Builder newBuilder( MyPojoRequest pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets attribute {@link #upcomingMandatoryProperty}.<br/>
     * <p/>
     * <b>Breaking Change with :</b>
     *
     * @param pUpcomingMandatoryProperty Value to which {@link #upcomingMandatoryProperty} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public Builder setUpcomingMandatoryProperty( @MyNotNullProperty String pUpcomingMandatoryProperty ) {
      // Assign value to attribute
      upcomingMandatoryProperty = pUpcomingMandatoryProperty;
      return this;
    }

    /**
     * Method sets attribute {@link #propertyWithNewConstraints}.<br/>
     * <p/>
     * <b>Breaking Change with :</b>
     *
     * @param pPropertyWithNewConstraints Value to which {@link #propertyWithNewConstraints} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public Builder setPropertyWithNewConstraints( @MyNotNullProperty String pPropertyWithNewConstraints ) {
      // Assign value to attribute
      propertyWithNewConstraints = pPropertyWithNewConstraints;
      return this;
    }

    /**
     * Method sets attribute {@link #formerMandatoryRequestProperty}.<br/>
     *
     * @param pFormerMandatoryRequestProperty Value to which {@link #formerMandatoryRequestProperty} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Deprecated
    @JsonSetter(nulls = Nulls.SKIP)
    public Builder setFormerMandatoryRequestProperty( String pFormerMandatoryRequestProperty ) {
      // Assign value to attribute
      formerMandatoryRequestProperty = pFormerMandatoryRequestProperty;
      return this;
    }

    /**
     * Method sets attribute {@link #untouchedProperty}.<br/>
     *
     * @param pUntouchedProperty Value to which {@link #untouchedProperty} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public Builder setUntouchedProperty( @MyNotNullProperty String pUntouchedProperty ) {
      // Assign value to attribute
      untouchedProperty = pUntouchedProperty;
      return this;
    }

    /**
     * Method sets attribute {@link #constraintChangingProperty}.<br/>
     *
     * @param pConstraintChangingProperty Value to which {@link #constraintChangingProperty} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public Builder setConstraintChangingProperty( @MyNotNullProperty String pConstraintChangingProperty ) {
      // Assign value to attribute
      constraintChangingProperty = pConstraintChangingProperty;
      return this;
    }

    /**
     * Method sets association {@link #otherPojos}.<br/>
     *
     * @param pOtherPojos Collection to which {@link #otherPojos} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP, contentNulls = Nulls.SKIP)
    public Builder setOtherPojos( @MyNotEmptyProperty Set<OtherPojo> pOtherPojos ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pOtherPojos != null) {
        otherPojos = new HashSet<OtherPojo>(pOtherPojos);
      }
      else {
        otherPojos = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #otherPojos}.<br/>
     *
     * @param pOtherPojos Array of objects that should be added to {@link #otherPojos}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToOtherPojos( @MyNotEmptyProperty OtherPojo... pOtherPojos ) {
      if (pOtherPojos != null) {
        if (otherPojos == null) {
          otherPojos = new HashSet<OtherPojo>();
        }
        otherPojos.addAll(Arrays.asList(pOtherPojos));
      }
      return this;
    }

    /**
     * Method sets association {@link #thePojo}.<br/>
     *
     * @param pThePojo Value to which {@link #thePojo} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public Builder setThePojo( @MyNotNullProperty OtherPojo pThePojo ) {
      thePojo = pThePojo;
      return this;
    }

    /**
     * Method creates a new instance of class MyPojoRequest. The object will be initialized with the values of the
     * builder.
     *
     * @return MyPojoRequest Created object. The method never returns null.
     */
    public MyPojoRequest build( ) {
      MyPojoRequest lObject = new MyPojoRequest(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #upcomingMandatoryProperty}.<br/>
   * <p/>
   * <b>Breaking Change with :</b>
   *
   * @return {@link String} Value to which {@link #upcomingMandatoryProperty} is set.
   */
  @MyNotNullProperty
  public String getUpcomingMandatoryProperty( ) {
    return upcomingMandatoryProperty;
  }

  /**
   * Method sets attribute {@link #upcomingMandatoryProperty}.<br/>
   * <p/>
   * <b>Breaking Change with :</b>
   *
   * @param pUpcomingMandatoryProperty Value to which {@link #upcomingMandatoryProperty} should be set.
   */
  public void setUpcomingMandatoryProperty( @MyNotNullProperty String pUpcomingMandatoryProperty ) {
    // Assign value to attribute
    upcomingMandatoryProperty = pUpcomingMandatoryProperty;
  }

  /**
   * Method returns attribute {@link #propertyWithNewConstraints}.<br/>
   * <p/>
   * <b>Breaking Change with :</b>
   *
   * @return {@link String} Value to which {@link #propertyWithNewConstraints} is set.
   */
  @MyNotNullProperty
  public String getPropertyWithNewConstraints( ) {
    return propertyWithNewConstraints;
  }

  /**
   * Method sets attribute {@link #propertyWithNewConstraints}.<br/>
   * <p/>
   * <b>Breaking Change with :</b>
   *
   * @param pPropertyWithNewConstraints Value to which {@link #propertyWithNewConstraints} should be set.
   */
  public void setPropertyWithNewConstraints( @MyNotNullProperty String pPropertyWithNewConstraints ) {
    // Assign value to attribute
    propertyWithNewConstraints = pPropertyWithNewConstraints;
  }

  /**
   * Method returns attribute {@link #formerMandatoryRequestProperty}.<br/>
   *
   * @return {@link String} Value to which {@link #formerMandatoryRequestProperty} is set.
   */
  @Deprecated
  public String getFormerMandatoryRequestProperty( ) {
    return formerMandatoryRequestProperty;
  }

  /**
   * Method sets attribute {@link #formerMandatoryRequestProperty}.<br/>
   *
   * @param pFormerMandatoryRequestProperty Value to which {@link #formerMandatoryRequestProperty} should be set.
   */
  @Deprecated
  public void setFormerMandatoryRequestProperty( String pFormerMandatoryRequestProperty ) {
    // Assign value to attribute
    formerMandatoryRequestProperty = pFormerMandatoryRequestProperty;
  }

  /**
   * Method returns attribute {@link #untouchedProperty}.<br/>
   *
   * @return {@link String} Value to which {@link #untouchedProperty} is set.
   */
  @MyNotNullProperty
  public String getUntouchedProperty( ) {
    return untouchedProperty;
  }

  /**
   * Method sets attribute {@link #untouchedProperty}.<br/>
   *
   * @param pUntouchedProperty Value to which {@link #untouchedProperty} should be set.
   */
  public void setUntouchedProperty( @MyNotNullProperty String pUntouchedProperty ) {
    // Assign value to attribute
    untouchedProperty = pUntouchedProperty;
  }

  /**
   * Method returns attribute {@link #constraintChangingProperty}.<br/>
   *
   * @return {@link String} Value to which {@link #constraintChangingProperty} is set.
   */
  @MyNotNullProperty
  public String getConstraintChangingProperty( ) {
    return constraintChangingProperty;
  }

  /**
   * Method sets attribute {@link #constraintChangingProperty}.<br/>
   *
   * @param pConstraintChangingProperty Value to which {@link #constraintChangingProperty} should be set.
   */
  public void setConstraintChangingProperty( @MyNotNullProperty String pConstraintChangingProperty ) {
    // Assign value to attribute
    constraintChangingProperty = pConstraintChangingProperty;
  }

  /**
   * Method returns association {@link #otherPojos}.<br/>
   *
   * @return {@link Set<OtherPojo>} Value to which {@link #otherPojos} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  @MyNotEmptyProperty
  public Set<OtherPojo> getOtherPojos( ) {
    // Return all OtherPojo objects as unmodifiable collection.
    return Collections.unmodifiableSet(otherPojos);
  }

  /**
   * Method adds the passed object to {@link #otherPojos}.
   *
   * @param pOtherPojos Object that should be added to {@link #otherPojos}. The parameter must not be null.
   */
  public void addToOtherPojos( OtherPojo pOtherPojos ) {
    // Add passed object to collection of associated OtherPojo objects.
    otherPojos.add(pOtherPojos);
  }

  /**
   * Method adds all passed objects to {@link #otherPojos}.
   *
   * @param pOtherPojos Collection with all objects that should be added to {@link #otherPojos}. The parameter must not
   * be null.
   */
  public void addToOtherPojos( Collection<OtherPojo> pOtherPojos ) {
    // Add all passed objects.
    for (OtherPojo lNextObject : pOtherPojos) {
      this.addToOtherPojos(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #otherPojos}.<br/>
   *
   * @param pOtherPojos Object that should be removed from {@link #otherPojos}. The parameter must not be null.
   */
  public void removeFromOtherPojos( OtherPojo pOtherPojos ) {
    // Remove passed object from collection of associated OtherPojo objects.
    otherPojos.remove(pOtherPojos);
  }

  /**
   * Method removes all objects from {@link #otherPojos}.
   */
  public void clearOtherPojos( ) {
    // Remove all objects from association "otherPojos".
    otherPojos.clear();
  }

  /**
   * Method returns association {@link #thePojo}.<br/>
   *
   * @return {@link OtherPojo} Value to which {@link #thePojo} is set.
   */
  @MyNotNullProperty
  public OtherPojo getThePojo( ) {
    return thePojo;
  }

  /**
   * Method sets association {@link #thePojo}.<br/>
   *
   * @param pThePojo Value to which {@link #thePojo} should be set.
   */
  public void setThePojo( @MyNotNullProperty OtherPojo pThePojo ) {
    thePojo = pThePojo;
  }

  /**
   * Method unsets {@link #thePojo}.
   */
  public final void unsetThePojo( ) {
    thePojo = null;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(upcomingMandatoryProperty);
    lResult = lPrime * lResult + Objects.hashCode(propertyWithNewConstraints);
    lResult = lPrime * lResult + Objects.hashCode(formerMandatoryRequestProperty);
    lResult = lPrime * lResult + Objects.hashCode(untouchedProperty);
    lResult = lPrime * lResult + Objects.hashCode(constraintChangingProperty);
    lResult = lPrime * lResult + Objects.hashCode(otherPojos);
    lResult = lPrime * lResult + Objects.hashCode(thePojo);
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
      MyPojoRequest lOther = (MyPojoRequest) pObject;
      lEquals = Objects.equals(upcomingMandatoryProperty, lOther.upcomingMandatoryProperty)
          && Objects.equals(propertyWithNewConstraints, lOther.propertyWithNewConstraints)
          && Objects.equals(formerMandatoryRequestProperty, lOther.formerMandatoryRequestProperty)
          && Objects.equals(untouchedProperty, lOther.untouchedProperty)
          && Objects.equals(constraintChangingProperty, lOther.constraintChangingProperty)
          && Objects.equals(otherPojos, lOther.otherPojos) && Objects.equals(thePojo, lOther.thePojo);
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
    lBuilder.append("upcomingMandatoryProperty: ");
    lBuilder.append(upcomingMandatoryProperty);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("propertyWithNewConstraints: ");
    lBuilder.append(propertyWithNewConstraints);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("formerMandatoryRequestProperty: ");
    lBuilder.append(formerMandatoryRequestProperty);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("untouchedProperty: ");
    lBuilder.append(untouchedProperty);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("constraintChangingProperty: ");
    lBuilder.append(constraintChangingProperty);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("otherPojos: ");
    if (otherPojos != null) {
      lBuilder.append(otherPojos.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (otherPojos != null) {
      for (OtherPojo lNext : otherPojos) {
        lBuilder.append(lNext.toStringBuilder(pIndent + "    "));
        lBuilder.append(System.lineSeparator());
      }
    }
    lBuilder.append(pIndent);
    lBuilder.append("thePojo: ");
    if (thePojo != null) {
      lBuilder.append(System.lineSeparator());
      lBuilder.append(thePojo.toStringBuilder(pIndent + "    "));
    }
    else {
      lBuilder.append(" null");
      lBuilder.append(System.lineSeparator());
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
   * @return {@link Builder} New builder that can be used to create new MyPojoRequest objects. The method never returns
   * null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}