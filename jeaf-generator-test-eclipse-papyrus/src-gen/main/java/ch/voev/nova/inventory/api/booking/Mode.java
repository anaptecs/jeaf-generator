/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package ch.voev.nova.inventory.api.booking;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * A method of transportation such as bus, rail, etc. Provided by OJP.
 * 
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class Mode {
  /**
   * Constant for the name of attribute "name".
   */
  public static final String NAME = "name";

  /**
   * Constant for the name of attribute "shortName".
   */
  public static final String SHORTNAME = "shortName";

  /**
   * Constant for the name of attribute "description".
   */
  public static final String DESCRIPTION = "description";

  /**
   * Constant for the name of attribute "ptMode".
   */
  public static final String PTMODE = "ptMode";

  /**
   * Name of the mode <br/>
   * <b>Example:</b> <code>rail</code>
   */
  private String name;

  /**
   * Short name or acronym of the mode <br/>
   * <b>Example:</b> <code>S</code>
   */
  private String shortName;

  /**
   * Additional text that further describes the mode
   */
  private String description;

  /**
   * 
   */
  private PTMode ptMode;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected Mode( ) {
    // Nothing to do.
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected Mode( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    name = pBuilder.name;
    shortName = pBuilder.shortName;
    description = pBuilder.description;
    ptMode = pBuilder.ptMode;
  }

  /**
   * Class implements builder to create a new instance of class Mode. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * Name of the mode
     */
    private String name;

    /**
     * Short name or acronym of the mode
     */
    private String shortName;

    /**
     * Additional text that further describes the mode
     */
    private String description;

    /**
     * 
     */
    private PTMode ptMode;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(Mode)} instead of private constructor to create new builder.
     */
    protected Builder( Mode pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        name = pObject.name;
        shortName = pObject.shortName;
        description = pObject.description;
        ptMode = pObject.ptMode;
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
     * @return {@link Builder} New builder that can be used to create new Mode objects. The method never returns null.
     */
    public static Builder newBuilder( Mode pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the attribute "name". Name of the mode
     * 
     * @param pName Value to which the attribute "name" should be set.
     */
    public Builder setName( String pName ) {
      // Assign value to attribute
      name = pName;
      return this;
    }

    /**
     * Method sets the attribute "shortName". Short name or acronym of the mode
     * 
     * @param pShortName Value to which the attribute "shortName" should be set.
     */
    public Builder setShortName( String pShortName ) {
      // Assign value to attribute
      shortName = pShortName;
      return this;
    }

    /**
     * Method sets the attribute "description". Additional text that further describes the mode
     * 
     * @param pDescription Value to which the attribute "description" should be set.
     */
    public Builder setDescription( String pDescription ) {
      // Assign value to attribute
      description = pDescription;
      return this;
    }

    /**
     * Method sets the association "ptMode".
     * 
     * @param pPtMode PTMode to which the association "ptMode" should be set.
     */
    public Builder setPtMode( PTMode pPtMode ) {
      ptMode = pPtMode;
      return this;
    }

    /**
     * Method creates a new instance of class Mode. The object will be initialized with the values of the builder.
     * 
     * @return Mode Created object. The method never returns null.
     */
    public Mode build( ) {
      return new Mode(this);
    }

    /**
     * Method creates a new validated instance of class Mode. The object will be initialized with the values of the
     * builder and validated afterwards.
     * 
     * @return Mode Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public Mode buildValidated( ) throws ConstraintViolationException {
      Mode lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "name". Name of the mode
   * 
   * @return String Value to which the attribute "name" is set.
   */
  public String getName( ) {
    return name;
  }

  /**
   * Method sets the attribute "name". Name of the mode
   * 
   * @param pName Value to which the attribute "name" should be set.
   */
  public void setName( String pName ) {
    // Assign value to attribute
    name = pName;
  }

  /**
   * Method returns the attribute "shortName". Short name or acronym of the mode
   * 
   * @return String Value to which the attribute "shortName" is set.
   */
  public String getShortName( ) {
    return shortName;
  }

  /**
   * Method sets the attribute "shortName". Short name or acronym of the mode
   * 
   * @param pShortName Value to which the attribute "shortName" should be set.
   */
  public void setShortName( String pShortName ) {
    // Assign value to attribute
    shortName = pShortName;
  }

  /**
   * Method returns the attribute "description". Additional text that further describes the mode
   * 
   * @return String Value to which the attribute "description" is set.
   */
  public String getDescription( ) {
    return description;
  }

  /**
   * Method sets the attribute "description". Additional text that further describes the mode
   * 
   * @param pDescription Value to which the attribute "description" should be set.
   */
  public void setDescription( String pDescription ) {
    // Assign value to attribute
    description = pDescription;
  }

  /**
   * Method returns the association "ptMode".
   * 
   *
   * @return PTMode PTMode to which the association "ptMode" is set.
   */
  public PTMode getPtMode( ) {
    return ptMode;
  }

  /**
   * Method sets the association "ptMode".
   * 
   * 
   * @param pPtMode PTMode to which the association "ptMode" should be set.
   */
  public void setPtMode( PTMode pPtMode ) {
    ptMode = pPtMode;
  }

  /**
   * Method unsets the association "ptMode".
   * 
   */
  public final void unsetPtMode( ) {
    ptMode = null;
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
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "name", "" + name));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "shortName", "" + shortName));
    lBuilder.append('\n');
    lBuilder
        .append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "description", "" + description));
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
