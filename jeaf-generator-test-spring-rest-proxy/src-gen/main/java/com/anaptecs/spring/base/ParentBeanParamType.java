/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

public class ParentBeanParamType {
  /**
   * Constant for the name of attribute "novaKey".
   */
  public static final String NOVAKEY = "novaKey";

  /**
   * Constant for the name of attribute "tkID".
   */
  public static final String TKID = "tkID";

  /**
   * Constant for the name of attribute "code".
   */
  public static final String CODE = "code";

  /**
   * <br/>
   * <b>Example(s):</b> <br/>
   * <ul>
   * <li><code>4711-0815</code></li>
   * </ul>
   * <p/>
   * <b>Header-Param:</b> <code>novaKey</code>
   */
  private String novaKey;

  private String tkID;

  /**
   * <br/>
   * <b>Example(s):</b> <br/>
   * <ul>
   * <li><code>BOOKING_ID_999</code></li>
   * </ul>
   * <p/>
   * <b>Header-Param:</b> <code>code</code>
   */
  private DoubleCode code;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ParentBeanParamType( Builder pBuilder ) {
    // Read attribute values from builder.
    novaKey = pBuilder.novaKey;
    tkID = pBuilder.tkID;
    code = pBuilder.code;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new ParentBeanParamType objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Convenience method to create new instance of class ParentBeanParamType.
   *
   *
   * @param pNovaKey Value to which {@link #novaKey} should be set.
   *
   * @param pTkID Value to which {@link #tkID} should be set.
   *
   * @param pCode Value to which {@link #code} should be set.
   *
   * @return {@link ParentBeanParamType}
   */
  public static ParentBeanParamType of( String pNovaKey, String pTkID, DoubleCode pCode ) {
    var lBuilder = ParentBeanParamType.builder();
    lBuilder.setNovaKey(pNovaKey);
    lBuilder.setTkID(pTkID);
    lBuilder.setCode(pCode);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>ParentBeanParamType</code>.
   */
  public static class Builder {
    /**
     * <br/>
     * <b>Example(s):</b> <br/>
     * <ul>
     * <li><code>4711-0815</code></li>
     * </ul>
     * <p/>
     * <b>Header-Param:</b> <code>novaKey</code>
     */
    private String novaKey;

    private String tkID;

    /**
     * <br/>
     * <b>Example(s):</b> <br/>
     * <ul>
     * <li><code>BOOKING_ID_999</code></li>
     * </ul>
     * <p/>
     * <b>Header-Param:</b> <code>code</code>
     */
    private DoubleCode code;

    /**
     * Use {@link ParentBeanParamType#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link ParentBeanParamType#builder(ParentBeanParamType)} instead of private constructor to create new
     * builder.
     */
    protected Builder( ParentBeanParamType pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setNovaKey(pObject.novaKey);
        this.setTkID(pObject.tkID);
        this.setCode(pObject.code);
      }
    }

    /**
     * Method sets attribute {@link #novaKey}.<br/>
     *
     * @param pNovaKey Value to which {@link #novaKey} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setNovaKey( String pNovaKey ) {
      // Assign value to attribute
      novaKey = pNovaKey;
      return this;
    }

    /**
     * Method sets attribute {@link #tkID}.<br/>
     *
     * @param pTkID Value to which {@link #tkID} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setTkID( String pTkID ) {
      // Assign value to attribute
      tkID = pTkID;
      return this;
    }

    /**
     * Method sets attribute {@link #code}.<br/>
     *
     * @param pCode Value to which {@link #code} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setCode( DoubleCode pCode ) {
      // Assign value to attribute
      code = pCode;
      return this;
    }

    /**
     * Method creates a new instance of class ParentBeanParamType. The object will be initialized with the values of the
     * builder.
     *
     * @return ParentBeanParamType Created object. The method never returns null.
     */
    public ParentBeanParamType build( ) {
      return new ParentBeanParamType(this);
    }
  }

  /**
   * Method returns attribute {@link #novaKey}.<br/>
   *
   * @return {@link String} Value to which {@link #novaKey} is set.
   */
  public String getNovaKey( ) {
    return novaKey;
  }

  /**
   * Method sets attribute {@link #novaKey}.<br/>
   *
   * @param pNovaKey Value to which {@link #novaKey} should be set.
   */
  public void setNovaKey( String pNovaKey ) {
    // Assign value to attribute
    novaKey = pNovaKey;
  }

  /**
   * Method returns attribute {@link #tkID}.<br/>
   *
   * @return {@link String} Value to which {@link #tkID} is set.
   */
  public String getTkID( ) {
    return tkID;
  }

  /**
   * Method sets attribute {@link #tkID}.<br/>
   *
   * @param pTkID Value to which {@link #tkID} should be set.
   */
  public void setTkID( String pTkID ) {
    // Assign value to attribute
    tkID = pTkID;
  }

  /**
   * Method returns attribute {@link #code}.<br/>
   *
   * @return {@link DoubleCode} Value to which {@link #code} is set.
   */
  public DoubleCode getCode( ) {
    return code;
  }

  /**
   * Method sets attribute {@link #code}.<br/>
   *
   * @param pCode Value to which {@link #code} should be set.
   */
  public void setCode( DoubleCode pCode ) {
    // Assign value to attribute
    code = pCode;
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
    lBuilder.append("novaKey: ");
    lBuilder.append(novaKey);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("tkID: ");
    lBuilder.append(tkID);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("code: ");
    lBuilder.append(code);
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
   * @return {@link Builder} New builder that can be used to create new ParentBeanParamType objects. The method never
   * returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}