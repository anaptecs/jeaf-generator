/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.util.Objects;

import com.anaptecs.annotations.MyNotNullProperty;
import com.anaptecs.jeaf.validation.api.spring.SpringValidationExecutor;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE,
    setterVisibility = JsonAutoDetect.Visibility.NONE,
    creatorVisibility = JsonAutoDetect.Visibility.ANY)
@JsonDeserialize(builder = NoSubTypesChild.NoSubTypesChildBuilderImpl.class)
public class NoSubTypesChild extends NoSubTypesParent {
  /**
   * Constant for the name of attribute "myProperty".
   */
  public static final String MYPROPERTY = "myProperty";

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
   * <p>
   * Let's have an additional discussion about how much sense it makes to add
   * <img src="https://raw.githubusercontent.com/anaptecs/emoji-images/master/imgs/1f428.png" alt="emoji github:koala"
   * height="20" width="20" align="absmiddle" /> to your documentation.<br/>
   * <br/>
   * So far I think it is at least funny.
   */
  private String myProperty;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected NoSubTypesChild( NoSubTypesChildBuilder<?, ?> pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    myProperty = pBuilder.myProperty;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new NoSubTypesChild objects.
   */
  public static NoSubTypesChildBuilder<?, ?> builder( ) {
    return new NoSubTypesChildBuilderImpl();
  }

  /**
   * Convenience method to create new instance of class NoSubTypesChild.
   *
   *
   * @param pMyProperty Value to which {@link #myProperty} should be set.
   *
   * @return {@link NoSubTypesChild}
   */
  public static NoSubTypesChild of( String pMyProperty ) {
    NoSubTypesChildBuilder<?, ?> lBuilder = NoSubTypesChild.builder();
    lBuilder.setMyProperty(pMyProperty);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>NoSubTypesChild</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class NoSubTypesChildBuilder<T extends NoSubTypesChild, B extends NoSubTypesChildBuilder<T, B>>
      extends NoSubTypesParentBuilder<T, B> {
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
     * <p>
     * Let's have an additional discussion about how much sense it makes to add
     * <img src="https://raw.githubusercontent.com/anaptecs/emoji-images/master/imgs/1f428.png" alt="emoji github:koala"
     * height="20" width="20" align="absmiddle" /> to your documentation.<br/>
     * <br/>
     * So far I think it is at least funny.
     */
    private String myProperty;

    /**
     * Use {@link NoSubTypesChildBuilder#builder()} instead of private constructor to create new builder.
     */
    protected NoSubTypesChildBuilder( ) {
      super();
    }

    /**
     * Use {@link NoSubTypesChildBuilder#builder(NoSubTypesChild)} instead of private constructor to create new builder.
     */
    protected NoSubTypesChildBuilder( NoSubTypesChild pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setMyProperty(pObject.myProperty);
      }
    }

    /**
     * Method sets attribute {@link #myProperty}.<br/>
     *
     * @param pMyProperty Value to which {@link #myProperty} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setMyProperty( @MyNotNullProperty String pMyProperty ) {
      // Assign value to attribute
      myProperty = pMyProperty;
      return this.self();
    }

    /**
     * Method creates a new instance of class NoSubTypesChild. The object will be initialized with the values of the
     * builder.
     *
     * @return NoSubTypesChild Created object. The method never returns null.
     */
    public abstract T build( );
  }

  static final class NoSubTypesChildBuilderImpl
      extends NoSubTypesChildBuilder<NoSubTypesChild, NoSubTypesChildBuilderImpl> {
    protected NoSubTypesChildBuilderImpl( ) {
    }

    protected NoSubTypesChildBuilderImpl( NoSubTypesChild pObject ) {
      super(pObject);
    }

    @Override
    protected NoSubTypesChildBuilderImpl self( ) {
      return this;
    }

    @Override
    public NoSubTypesChild build( ) {
      NoSubTypesChild lObject = new NoSubTypesChild(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #myProperty}.<br/>
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
   * <p>
   * Let's have an additional discussion about how much sense it makes to add
   * <img src="https://raw.githubusercontent.com/anaptecs/emoji-images/master/imgs/1f428.png" alt="emoji github:koala"
   * height="20" width="20" align="absmiddle" /> to your documentation.<br/>
   * <br/>
   * So far I think it is at least funny.
   *
   * @return {@link String} Value to which {@link #myProperty} is set.
   */
  @MyNotNullProperty
  public String getMyProperty( ) {
    return myProperty;
  }

  /**
   * Method sets attribute {@link #myProperty}.<br/>
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
   * <p>
   * Let's have an additional discussion about how much sense it makes to add
   * <img src="https://raw.githubusercontent.com/anaptecs/emoji-images/master/imgs/1f428.png" alt="emoji github:koala"
   * height="20" width="20" align="absmiddle" /> to your documentation.<br/>
   * <br/>
   * So far I think it is at least funny.
   *
   * @param pMyProperty Value to which {@link #myProperty} should be set.
   */
  public void setMyProperty( @MyNotNullProperty String pMyProperty ) {
    // Assign value to attribute
    myProperty = pMyProperty;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = super.hashCode();
    lResult = lPrime * lResult + Objects.hashCode(myProperty);
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
    else if (!super.equals(pObject)) {
      lEquals = false;
    }
    else if (this.getClass() != pObject.getClass()) {
      lEquals = false;
    }
    else {
      NoSubTypesChild lOther = (NoSubTypesChild) pObject;
      lEquals = Objects.equals(myProperty, lOther.myProperty);
    }
    return lEquals;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  @Override
  public StringBuilder toStringBuilder( String pIndent ) {
    StringBuilder lBuilder = super.toStringBuilder(pIndent);
    lBuilder.append(pIndent);
    lBuilder.append("myProperty: ");
    lBuilder.append(myProperty);
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
   * @return {@link Builder} New builder that can be used to create new NoSubTypesChild objects. The method never
   * returns null.
   */
  public NoSubTypesChildBuilder<?, ?> toBuilder( ) {
    return new NoSubTypesChildBuilderImpl(this);
  }
}