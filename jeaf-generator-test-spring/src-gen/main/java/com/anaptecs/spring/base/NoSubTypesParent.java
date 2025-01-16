/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import com.anaptecs.jeaf.validation.api.spring.SpringValidationExecutor;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
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
@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE,
    setterVisibility = JsonAutoDetect.Visibility.NONE)
public class NoSubTypesParent {
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
     * Method returns a new builder.
     *
     * @return {@link Builder} New builder that can be used to create new NoSubTypesParent objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     *
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new NoSubTypesParent objects. The method never
     * returns null.
     */
    public static Builder newBuilder( NoSubTypesParent pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method creates a new instance of class NoSubTypesParent. The object will be initialized with the values of the
     * builder.
     *
     * @return NoSubTypesParent Created object. The method never returns null.
     */
    public NoSubTypesParent build( ) {
      NoSubTypesParent lObject = new NoSubTypesParent(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  @Override
  public int hashCode( ) {
    return 1;
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
      lEquals = true;
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