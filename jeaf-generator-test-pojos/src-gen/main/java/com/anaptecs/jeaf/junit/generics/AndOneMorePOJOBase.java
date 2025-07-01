/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.generics;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;
import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

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

  private GenericResponsePOJO<MyBusinessObject> genericProperty;

  private Set<GenericResponsePOJO<MyBusinessObject>> genericResponses;

  private MultiTemplateClass<Message, TemplateEnumTest> multiTemplateClassImpl;

  private Set<MultiTemplateClass<Message, TemplateEnumTest>> many;

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
    if (pBuilder.genericResponses != null) {
      genericResponses = pBuilder.genericResponses;
    }
    else {
      genericResponses = new HashSet<>();
    }
    multiTemplateClassImpl = pBuilder.multiTemplateClassImpl;
    if (pBuilder.many != null) {
      many = pBuilder.many;
    }
    else {
      many = new HashSet<>();
    }
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
   * Method sets attribute {@link #genericProperty}.<br/>
   *
   * @param pGenericProperty Value to which {@link #genericProperty} should be set.
   */
  public void setGenericProperty( GenericResponsePOJO<MyBusinessObject> pGenericProperty ) {
    // Assign value to attribute
    genericProperty = pGenericProperty;
  }

  /**
   * Method returns association {@link #genericResponses}.<br/>
   *
   * @return {@link Set<GenericResponsePOJO<MyBusinessObject>>} Value to which {@link #genericResponses} is set. The
   * method never returns null and the returned collection is unmodifiable.
   */
  public Set<GenericResponsePOJO<MyBusinessObject>> getGenericResponses( ) {
    // Return all DoSomethingResponse objects as unmodifiable collection.
    return Collections.unmodifiableSet(genericResponses);
  }

  /**
   * Method adds the passed object to {@link #genericResponses}.
   *
   * @param pGenericResponses Object that should be added to {@link #genericResponses}. The parameter must not be null.
   */
  public void addToGenericResponses( GenericResponsePOJO<MyBusinessObject> pGenericResponses ) {
    // Check parameter "pGenericResponses" for invalid value null.
    Check.checkInvalidParameterNull(pGenericResponses, "pGenericResponses");
    // Add passed object to collection of associated DoSomethingResponse objects.
    genericResponses.add(pGenericResponses);
  }

  /**
   * Method adds all passed objects to {@link #genericResponses}.
   *
   * @param pGenericResponses Collection with all objects that should be added to {@link #genericResponses}. The
   * parameter must not be null.
   */
  public void addToGenericResponses( Collection<GenericResponsePOJO<MyBusinessObject>> pGenericResponses ) {
    // Check parameter "pGenericResponses" for invalid value null.
    Check.checkInvalidParameterNull(pGenericResponses, "pGenericResponses");
    // Add all passed objects.
    for (GenericResponsePOJO<MyBusinessObject> lNextObject : pGenericResponses) {
      this.addToGenericResponses(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #genericResponses}.<br/>
   *
   * @param pGenericResponses Object that should be removed from {@link #genericResponses}. The parameter must not be
   * null.
   */
  public void removeFromGenericResponses( GenericResponsePOJO<MyBusinessObject> pGenericResponses ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pGenericResponses, "pGenericResponses");
    // Remove passed object from collection of associated DoSomethingResponse objects.
    genericResponses.remove(pGenericResponses);
  }

  /**
   * Method removes all objects from {@link #genericResponses}.
   */
  public void clearGenericResponses( ) {
    // Remove all objects from association "genericResponses".
    genericResponses.clear();
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
   * Method sets association {@link #multiTemplateClassImpl}.<br/>
   *
   * @param pMultiTemplateClassImpl Value to which {@link #multiTemplateClassImpl} should be set.
   */
  public void setMultiTemplateClassImpl( MultiTemplateClass<Message, TemplateEnumTest> pMultiTemplateClassImpl ) {
    multiTemplateClassImpl = pMultiTemplateClassImpl;
  }

  /**
   * Method unsets {@link #multiTemplateClassImpl}.
   */
  public final void unsetMultiTemplateClassImpl( ) {
    multiTemplateClassImpl = null;
  }

  /**
   * Method returns association {@link #many}.<br/>
   *
   * @return {@link Set<MultiTemplateClass<Message, TemplateEnumTest>>} Value to which {@link #many} is set. The method
   * never returns null and the returned collection is unmodifiable.
   */
  public Set<MultiTemplateClass<Message, TemplateEnumTest>> getMany( ) {
    // Return all MultiTemplateClassImpl objects as unmodifiable collection.
    return Collections.unmodifiableSet(many);
  }

  /**
   * Method adds the passed object to {@link #many}.
   *
   * @param pMany Object that should be added to {@link #many}. The parameter must not be null.
   */
  public void addToMany( MultiTemplateClass<Message, TemplateEnumTest> pMany ) {
    // Check parameter "pMany" for invalid value null.
    Check.checkInvalidParameterNull(pMany, "pMany");
    // Add passed object to collection of associated MultiTemplateClassImpl objects.
    many.add(pMany);
  }

  /**
   * Method adds all passed objects to {@link #many}.
   *
   * @param pMany Collection with all objects that should be added to {@link #many}. The parameter must not be null.
   */
  public void addToMany( Collection<MultiTemplateClass<Message, TemplateEnumTest>> pMany ) {
    // Check parameter "pMany" for invalid value null.
    Check.checkInvalidParameterNull(pMany, "pMany");
    // Add all passed objects.
    for (MultiTemplateClass<Message, TemplateEnumTest> lNextObject : pMany) {
      this.addToMany(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #many}.<br/>
   *
   * @param pMany Object that should be removed from {@link #many}. The parameter must not be null.
   */
  public void removeFromMany( MultiTemplateClass<Message, TemplateEnumTest> pMany ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pMany, "pMany");
    // Remove passed object from collection of associated MultiTemplateClassImpl objects.
    many.remove(pMany);
  }

  /**
   * Method removes all objects from {@link #many}.
   */
  public void clearMany( ) {
    // Remove all objects from association "many".
    many.clear();
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