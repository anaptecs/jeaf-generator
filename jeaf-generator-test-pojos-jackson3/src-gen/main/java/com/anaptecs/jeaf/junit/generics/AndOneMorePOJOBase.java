/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.generics;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;
import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import tools.jackson.databind.annotation.JsonDeserialize;
import tools.jackson.databind.annotation.JsonPOJOBuilder;

@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
@JsonDeserialize(builder = AndOneMorePOJO.Builder.class)
public abstract class AndOneMorePOJOBase {
  /**
   * Constant for the name of attribute "genericProperty".
   */
  public static final String GENERICPROPERTY = "genericProperty";

  /**
   * Constant for the name of attribute "genericResponses".
   */
  public static final String GENERICRESPONSES = "genericResponses";

  /**
   * Constant for the name of attribute "multiTemplateClassImpl".
   */
  public static final String MULTITEMPLATECLASSIMPL = "multiTemplateClassImpl";

  /**
   * Constant for the name of attribute "many".
   */
  public static final String MANY = "many";

  private final GenericResponsePOJO<MyBusinessObject> genericProperty;

  private final Set<GenericResponsePOJO<MyBusinessObject>> genericResponses;

  private final MultiTemplateClass<Message, TemplateEnumTest> multiTemplateClassImpl;

  private final Set<MultiTemplateClass<Message, TemplateEnumTest>> many;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected AndOneMorePOJOBase( BuilderBase pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    genericProperty = pBuilder.genericProperty;
    genericResponses = (pBuilder.genericResponses == null) ? Set.of() : Set.copyOf(pBuilder.genericResponses);
    multiTemplateClassImpl = pBuilder.multiTemplateClassImpl;
    many = (pBuilder.many == null) ? Set.of() : Set.copyOf(pBuilder.many);
  }

  /**
   * Class implements builder to create a new instance of class AndOneMorePOJO. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class BuilderBase {
    private GenericResponsePOJO<MyBusinessObject> genericProperty;

    private Set<GenericResponsePOJO<MyBusinessObject>> genericResponses;

    private MultiTemplateClass<Message, TemplateEnumTest> multiTemplateClassImpl;

    private Set<MultiTemplateClass<Message, TemplateEnumTest>> many;

    /**
     * Use {@link AndOneMorePOJO.builder()} instead of protected constructor to create new builder.
     */
    protected BuilderBase( ) {
    }

    /**
     * Use {@link AndOneMorePOJO.builder(AndOneMorePOJO)} instead of protected constructor to create new builder.
     */
    protected BuilderBase( AndOneMorePOJOBase pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setGenericProperty(pObject.genericProperty);
        this.setGenericResponses(pObject.genericResponses);
        this.setMultiTemplateClassImpl(pObject.multiTemplateClassImpl);
        this.setMany(pObject.many);
      }
    }

    /**
     * Method sets attribute {@link #genericProperty}.<br/>
     *
     * @param pGenericProperty Value to which {@link #genericProperty} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setGenericProperty( GenericResponsePOJO<MyBusinessObject> pGenericProperty ) {
      // Assign value to attribute
      genericProperty = pGenericProperty;
      return this;
    }

    /**
     * Method sets association {@link #genericResponses}.<br/>
     *
     * @param pGenericResponses Collection to which {@link #genericResponses} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setGenericResponses( Set<GenericResponsePOJO<MyBusinessObject>> pGenericResponses ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pGenericResponses != null) {
        genericResponses = new HashSet<GenericResponsePOJO<MyBusinessObject>>(pGenericResponses);
      }
      else {
        genericResponses = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #genericResponses}.<br/>
     *
     * @param pGenericResponses Array of objects that should be added to {@link #genericResponses}. The parameter may be
     * null.
     * @return {@link BuilderBase} Instance of this builder to support chaining. Method never returns null.
     */
    public BuilderBase addToGenericResponses( GenericResponsePOJO<MyBusinessObject>... pGenericResponses ) {
      if (pGenericResponses != null) {
        if (genericResponses == null) {
          genericResponses = new HashSet<GenericResponsePOJO<MyBusinessObject>>();
        }
        genericResponses.addAll(Arrays.asList(pGenericResponses));
      }
      return this;
    }

    /**
     * Method sets association {@link #multiTemplateClassImpl}.<br/>
     *
     * @param pMultiTemplateClassImpl Value to which {@link #multiTemplateClassImpl} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setMultiTemplateClassImpl(
        MultiTemplateClass<Message, TemplateEnumTest> pMultiTemplateClassImpl ) {
      multiTemplateClassImpl = pMultiTemplateClassImpl;
      return this;
    }

    /**
     * Method sets association {@link #many}.<br/>
     *
     * @param pMany Collection to which {@link #many} should be set.
     * @return {@link BuilderBase} Instance of this builder to support chaining setters. Method never returns null.
     */
    public BuilderBase setMany( Set<MultiTemplateClass<Message, TemplateEnumTest>> pMany ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pMany != null) {
        many = new HashSet<MultiTemplateClass<Message, TemplateEnumTest>>(pMany);
      }
      else {
        many = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #many}.<br/>
     *
     * @param pMany Array of objects that should be added to {@link #many}. The parameter may be null.
     * @return {@link BuilderBase} Instance of this builder to support chaining. Method never returns null.
     */
    public BuilderBase addToMany( MultiTemplateClass<Message, TemplateEnumTest>... pMany ) {
      if (pMany != null) {
        if (many == null) {
          many = new HashSet<MultiTemplateClass<Message, TemplateEnumTest>>();
        }
        many.addAll(Arrays.asList(pMany));
      }
      return this;
    }

    /**
     * Method creates a new instance of class AndOneMorePOJO. The object will be initialized with the values of the
     * builder.
     *
     * @return AndOneMorePOJO Created object. The method never returns null.
     */
    public AndOneMorePOJO build( ) {
      return new AndOneMorePOJO(this);
    }

    /**
     * Method creates a new validated instance of class AndOneMorePOJO. The object will be initialized with the values
     * of the builder and validated afterwards.
     *
     * @return AndOneMorePOJO Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public AndOneMorePOJO buildValidated( ) throws ConstraintViolationException {
      AndOneMorePOJO lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns attribute {@link #genericProperty}.<br/>
   *
   * @return {@link GenericResponsePOJO<MyBusinessObject>} Value to which {@link #genericProperty} is set.
   */
  public GenericResponsePOJO<MyBusinessObject> getGenericProperty( ) {
    return genericProperty;
  }

  /**
   * Method returns association {@link #genericResponses}.<br/>
   *
   * @return {@link Set<GenericResponsePOJO<MyBusinessObject>>} Value to which {@link #genericResponses} is set. The
   * method never returns null and the returned collection is unmodifiable.
   */
  public Set<GenericResponsePOJO<MyBusinessObject>> getGenericResponses( ) {
    return genericResponses;
  }

  /**
   * Method returns association {@link #multiTemplateClassImpl}.<br/>
   *
   * @return {@link MultiTemplateClass<Message, TemplateEnumTest>} Value to which {@link #multiTemplateClassImpl} is
   * set.
   */
  public MultiTemplateClass<Message, TemplateEnumTest> getMultiTemplateClassImpl( ) {
    return multiTemplateClassImpl;
  }

  /**
   * Method returns association {@link #many}.<br/>
   *
   * @return {@link Set<MultiTemplateClass<Message, TemplateEnumTest>>} Value to which {@link #many} is set. The method
   * never returns null and the returned collection is unmodifiable.
   */
  public Set<MultiTemplateClass<Message, TemplateEnumTest>> getMany( ) {
    return many;
  }

  /**
   * Convenience method to create new instance of class AndOneMorePOJO.
   *
   *
   * @param pGenericProperty Value to which {@link #genericProperty} should be set.
   *
   * @param pMultiTemplateClassImpl Value to which {@link #multiTemplateClassImpl} should be set.
   *
   * @return {@link AndOneMorePOJO}
   */
  public static AndOneMorePOJO of( GenericResponsePOJO<MyBusinessObject> pGenericProperty,
      MultiTemplateClass<Message, TemplateEnumTest> pMultiTemplateClassImpl ) {
    var lBuilder = AndOneMorePOJO.builder();
    lBuilder.setGenericProperty(pGenericProperty);
    lBuilder.setMultiTemplateClassImpl(pMultiTemplateClassImpl);
    return lBuilder.build();
  }

  /**
   * @return {@link GenericResponsePOJO<TemplateEnumTest>}
   */
  public abstract GenericResponsePOJO<TemplateEnumTest> getEnumTemplate( );

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(genericProperty);
    lResult = lPrime * lResult + Objects.hashCode(genericResponses);
    lResult = lPrime * lResult + Objects.hashCode(multiTemplateClassImpl);
    lResult = lPrime * lResult + Objects.hashCode(many);
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
      AndOneMorePOJOBase lOther = (AndOneMorePOJOBase) pObject;
      lEquals = Objects.equals(genericProperty, lOther.genericProperty)
          && Objects.equals(genericResponses, lOther.genericResponses)
          && Objects.equals(multiTemplateClassImpl, lOther.multiTemplateClassImpl) && Objects.equals(many, lOther.many);
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
    lBuilder.append("genericProperty: ");
    lBuilder.append(genericProperty);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("genericResponses: ");
    if (genericResponses != null) {
      lBuilder.append(genericResponses.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (genericResponses != null) {
      for (GenericResponsePOJO<MyBusinessObject> lNext : genericResponses) {
        lBuilder.append(pIndent + "    ");
        lBuilder.append(lNext.toString());
        lBuilder.append(System.lineSeparator());
      }
    }
    lBuilder.append(pIndent);
    lBuilder.append("multiTemplateClassImpl: ");
    lBuilder.append(multiTemplateClassImpl);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("many: ");
    if (many != null) {
      lBuilder.append(many.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (many != null) {
      for (MultiTemplateClass<Message, TemplateEnumTest> lNext : many) {
        lBuilder.append(pIndent + "    ");
        lBuilder.append(lNext.toString());
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
   * @return {@link Builder} New builder that can be used to create new AndOneMorePOJO objects. The method never returns
   * null.
   */
  public AndOneMorePOJO.Builder toBuilder( ) {
    return new AndOneMorePOJO.Builder((AndOneMorePOJO) this);
  }
}