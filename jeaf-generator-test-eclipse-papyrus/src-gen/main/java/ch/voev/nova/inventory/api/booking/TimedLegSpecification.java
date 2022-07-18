/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package ch.voev.nova.inventory.api.booking;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * A minimal timed leg specification.
 * 
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class TimedLegSpecification {
  /**
   * Constant for the name of attribute "start".
   */
  public static final String START = "start";

  /**
   * Constant for the name of attribute "intermediates".
   */
  public static final String INTERMEDIATES = "intermediates";

  /**
   * Constant for the name of attribute "end".
   */
  public static final String END = "end";

  /**
   * Constant for the name of attribute "service".
   */
  public static final String SERVICE = "service";

  /**
   * 
   */
  private BoardSpecification start;

  /**
   * 
   */
  private List<IntermediateSpecification> intermediates = new ArrayList<IntermediateSpecification>();

  /**
   * 
   */
  private AlightSpecification end;

  /**
   * 
   */
  private DatedJourney service;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected TimedLegSpecification( ) {
    // Nothing to do.
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected TimedLegSpecification( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    start = pBuilder.start;
    if (pBuilder.intermediates != null) {
      intermediates.addAll(pBuilder.intermediates);
    }
    end = pBuilder.end;
    service = pBuilder.service;
  }

  /**
   * Class implements builder to create a new instance of class TimedLegSpecification. As the class has read only
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private BoardSpecification start;

    /**
     * 
     */
    private List<IntermediateSpecification> intermediates;

    /**
     * 
     */
    private AlightSpecification end;

    /**
     * 
     */
    private DatedJourney service;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(TimedLegSpecification)} instead of private constructor to create new builder.
     */
    protected Builder( TimedLegSpecification pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        start = pObject.start;
        intermediates = pObject.intermediates;
        end = pObject.end;
        service = pObject.service;
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
     * @return {@link Builder} New builder that can be used to create new TimedLegSpecification objects. The method
     * never returns null.
     */
    public static Builder newBuilder( TimedLegSpecification pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the association "start".
     * 
     * @param pStart BoardSpecification to which the association "start" should be set.
     */
    public Builder setStart( BoardSpecification pStart ) {
      start = pStart;
      return this;
    }

    /**
     * Method sets the association "intermediates".
     * 
     * @param pIntermediates Collection with objects to which the association should be set.
     */
    public Builder setIntermediates( List<IntermediateSpecification> pIntermediates ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pIntermediates != null) {
        intermediates = new ArrayList<IntermediateSpecification>(pIntermediates);
      }
      else {
        intermediates = null;
      }
      return this;
    }

    /**
     * Method sets the association "end".
     * 
     * @param pEnd AlightSpecification to which the association "end" should be set.
     */
    public Builder setEnd( AlightSpecification pEnd ) {
      end = pEnd;
      return this;
    }

    /**
     * Method sets the association "service".
     * 
     * @param pService DatedJourney to which the association "service" should be set.
     */
    public Builder setService( DatedJourney pService ) {
      service = pService;
      return this;
    }

    /**
     * Method creates a new instance of class TimedLegSpecification. The object will be initialized with the values of
     * the builder.
     * 
     * @return TimedLegSpecification Created object. The method never returns null.
     */
    public TimedLegSpecification build( ) {
      return new TimedLegSpecification(this);
    }

    /**
     * Method creates a new validated instance of class TimedLegSpecification. The object will be initialized with the
     * values of the builder and validated afterwards.
     * 
     * @return TimedLegSpecification Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public TimedLegSpecification buildValidated( ) throws ConstraintViolationException {
      TimedLegSpecification lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the association "start".
   * 
   *
   * @return BoardSpecification BoardSpecification to which the association "start" is set.
   */
  public BoardSpecification getStart( ) {
    return start;
  }

  /**
   * Method sets the association "start".
   * 
   * 
   * @param pStart BoardSpecification to which the association "start" should be set.
   */
  public void setStart( BoardSpecification pStart ) {
    start = pStart;
  }

  /**
   * Method unsets the association "start".
   * 
   */
  public final void unsetStart( ) {
    start = null;
  }

  /**
   * Method returns the association "intermediates".
   * 
   *
   * @return Collection All IntermediateSpecification objects that belong to the association "intermediates". The method
   * never returns null and the returned collection is unmodifiable.
   */
  public List<IntermediateSpecification> getIntermediates( ) {
    // Return all IntermediateSpecification objects as unmodifiable collection.
    return Collections.unmodifiableList(intermediates);
  }

  /**
   * Method sets the association "intermediates" to the passed collection. All objects that formerly were part of the
   * association will be removed from it.
   * 
   * 
   * @param pIntermediates Collection with objects to which the association should be set. The parameter must not be
   * null.
   */
  void setIntermediates( List<IntermediateSpecification> pIntermediates ) {
    // Check of parameter is not required.
    // Remove all objects from association "intermediates".
    this.clearIntermediates();
    // If the association is null, removing all entries is sufficient.
    if (pIntermediates != null) {
      intermediates = new ArrayList<IntermediateSpecification>(pIntermediates);
    }
  }

  /**
   * Method adds the passed IntermediateSpecification object to the association "intermediates".
   * 
   * 
   * @param pIntermediates Object that should be added to the association "intermediates". The parameter must not be
   * null.
   */
  public void addToIntermediates( IntermediateSpecification pIntermediates ) {
    // Check parameter "pIntermediates" for invalid value null.
    Check.checkInvalidParameterNull(pIntermediates, "pIntermediates");
    // Add passed object to collection of associated IntermediateSpecification objects.
    intermediates.add(pIntermediates);
  }

  /**
   * Method adds all passed objects to the association "intermediates".
   * 
   * 
   * @param pIntermediates Collection with all objects that should be added to the association "intermediates". The
   * parameter must not be null.
   */
  public void addToIntermediates( Collection<IntermediateSpecification> pIntermediates ) {
    // Check parameter "pIntermediates" for invalid value null.
    Check.checkInvalidParameterNull(pIntermediates, "pIntermediates");
    // Add all passed objects.
    for (IntermediateSpecification lNextObject : pIntermediates) {
      this.addToIntermediates(lNextObject);
    }
  }

  /**
   * Method removes the passed IntermediateSpecification object from the association "intermediates".
   * 
   * 
   * @param pIntermediates Object that should be removed from the association "intermediates". The parameter must not be
   * null.
   */
  public void removeFromIntermediates( IntermediateSpecification pIntermediates ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pIntermediates, "pIntermediates");
    // Remove passed object from collection of associated IntermediateSpecification objects.
    intermediates.remove(pIntermediates);
  }

  /**
   * Method removes all objects from the association "intermediates".
   * 
   */
  public void clearIntermediates( ) {
    // Remove all objects from association "intermediates".
    Collection<IntermediateSpecification> lIntermediates = new HashSet<IntermediateSpecification>(intermediates);
    Iterator<IntermediateSpecification> lIterator = lIntermediates.iterator();
    while (lIterator.hasNext()) {
      this.removeFromIntermediates(lIterator.next());
    }
  }

  /**
   * Method returns the association "end".
   * 
   *
   * @return AlightSpecification AlightSpecification to which the association "end" is set.
   */
  public AlightSpecification getEnd( ) {
    return end;
  }

  /**
   * Method sets the association "end".
   * 
   * 
   * @param pEnd AlightSpecification to which the association "end" should be set.
   */
  public void setEnd( AlightSpecification pEnd ) {
    end = pEnd;
  }

  /**
   * Method unsets the association "end".
   * 
   */
  public final void unsetEnd( ) {
    end = null;
  }

  /**
   * Method returns the association "service".
   * 
   *
   * @return DatedJourney DatedJourney to which the association "service" is set.
   */
  public DatedJourney getService( ) {
    return service;
  }

  /**
   * Method sets the association "service".
   * 
   * 
   * @param pService DatedJourney to which the association "service" should be set.
   */
  public void setService( DatedJourney pService ) {
    service = pService;
  }

  /**
   * Method unsets the association "service".
   * 
   */
  public final void unsetService( ) {
    service = null;
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
