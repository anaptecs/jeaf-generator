/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.io.Serializable;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LinkObject implements Serializable {
  /**
   * Default serial version UID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "href".
   */
  public static final String HREF = "href";

  /**
   * 
   */
  private String href;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected LinkObject( ) {
    // Nothing to do.
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected LinkObject( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    href = pBuilder.href;
  }

  /**
   * Class implements builder to create a new instance of class LinkObject. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private String href;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(LinkObject)} instead of private constructor to create new builder.
     */
    protected Builder( LinkObject pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        href = pObject.href;
      }
    }

    /**
     * Method returns a new builder.
     * 
     * @return {@link Builder} New builder that can be used to create new ImmutablePOJOParent objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     * 
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new LinkObject objects. The method never returns
     * null.
     */
    public static Builder newBuilder( LinkObject pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the attribute "href".
     * 
     * @param pHref Value to which the attribute "href" should be set.
     */
    public Builder setHref( String pHref ) {
      // Assign value to attribute
      href = pHref;
      return this;
    }

    /**
     * Method creates a new instance of class LinkObject. The object will be initialized with the values of the builder.
     * 
     * @return LinkObject Created object. The method never returns null.
     */
    public LinkObject build( ) {
      return new LinkObject(this);
    }

    /**
     * Method creates a new validated instance of class LinkObject. The object will be initialized with the values of
     * the builder and validated afterwards.
     * 
     * @return LinkObject Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public LinkObject buildValidated( ) throws ConstraintViolationException {
      LinkObject lPOJO = this.build();
      Tools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "href".
   * 
   * 
   * @return String Value to which the attribute "href" is set.
   */
  public String getHref( ) {
    return href;
  }

  /**
   * Method sets the attribute "href".
   * 
   * 
   * @param pHref Value to which the attribute "href" should be set.
   */
  public void setHref( String pHref ) {
    // Assign value to attribute
    href = pHref;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. the returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  protected StringBuilder toStringBuilder( ) {
    StringBuilder lBuilder = new StringBuilder();
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_INFO, this.getClass().getName()));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTES_SECTION));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "href", "" + href));
    lBuilder.append('\n');
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
    return this.toStringBuilder().toString();
  }
}