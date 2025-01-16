/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.io.Serializable;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Hello World!<br/>
 * <img src="https://raw.githubusercontent.com/anaptecs/emoji-images/master/imgs/1f428.png" alt="emoji github:koala"
 * height="20" width="20" align="absmiddle" />
 * </p>
 * <table>
 * <thead>
 * <tr>
 * <th>Syntax</th>
 * <th>Description</th>
 * </tr>
 * </thead> <tbody>
 * <tr>
 * <td>Header</td>
 * <td>Title</td>
 * </tr>
 * <tr>
 * <td>Paragraph</td>
 * <td>Text</td>
 * </tr>
 * </tbody>
 * </table>
 *
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "objectType", visible = true)
public class NoSubTypesParent implements Serializable {
  /**
   * Default serial version UID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected NoSubTypesParent( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected NoSubTypesParent( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new NoSubTypesParent objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Convenience method to create new instance of class NoSubTypesParent.
   *
   *
   * @return {@link com.anaptecs.spring.base.NoSubTypesParent}
   */
  public static NoSubTypesParent of( ) {
    NoSubTypesParent.Builder lBuilder = NoSubTypesParent.builder();
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>NoSubTypesParent</code>.
   */
  public static class Builder {
    /**
     * Use {@link NoSubTypesParent#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link NoSubTypesParent#builder(NoSubTypesParent)} instead of private constructor to create new builder.
     */
    protected Builder( NoSubTypesParent pObject ) {
    }

    /**
     * Method creates a new instance of class NoSubTypesParent. The object will be initialized with the values of the
     * builder.
     *
     * @return NoSubTypesParent Created object. The method never returns null.
     */
    public NoSubTypesParent build( ) {
      return new NoSubTypesParent(this);
    }

    /**
     * Method creates a new validated instance of class NoSubTypesParent. The object will be initialized with the values
     * of the builder and validated afterwards.
     *
     * @return NoSubTypesParent Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public NoSubTypesParent buildValidated( ) throws ConstraintViolationException {
      NoSubTypesParent lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
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
   * @return {@link Builder} New builder that can be used to create new NoSubTypesParent objects. The method never
   * returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}