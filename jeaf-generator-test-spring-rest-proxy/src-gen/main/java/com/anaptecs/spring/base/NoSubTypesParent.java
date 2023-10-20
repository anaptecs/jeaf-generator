/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

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
   * Method creates a new builder and initialize it with the data from the passed object.
   *
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new NoSubTypesParent objects. The method never
   * returns null.
   */
  public static Builder builder( NoSubTypesParent pObject ) {
    return new Builder(pObject);
  }

  /**
   * Convenience method to create new instance of class NoSubTypesParent.
   *
   *
   * @return {@link NoSubTypesParent}
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
}
