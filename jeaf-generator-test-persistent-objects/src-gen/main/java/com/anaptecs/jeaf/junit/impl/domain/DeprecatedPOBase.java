package com.anaptecs.jeaf.junit.impl.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.anaptecs.jeaf.spi.persistence.ClassID;
import com.anaptecs.jeaf.spi.persistence.PersistentObject;
import com.anaptecs.jeaf.xfun.api.checks.Check;

public abstract class DeprecatedPOBase extends PersistentObject {
  /**
   * The class id is a unique id within the domain model of an application for every business object class.
   */
  public static final ClassID CLASS_ID = ClassID.createClassID(1017, DeprecatedPO.class);

  /**
   * Name of the database table that is used to store the data of objects of this class.
   */
  public static final String TABLE_NAME = "DEPRECATEDPO";

  /**
   * Constant for the name of the row that is used to store the values of attribute "deprecated".
   */
  @Deprecated
  public static final String DEPRECATED_ROW = "DEPRECATED";

  /**
   * Constant for the name of attribute "deprecated".
   */
  @Deprecated
  public static final String DEPRECATED_ATTRIBUTE = "deprecated";

  /**
   * Constant for the name of role "publicClass".
   */
  @Deprecated
  public static final String PUBLICCLASS_ROLE = "publicClass";

  /**
   * Constant for the name of role "baseClasses".
   */
  @Deprecated
  public static final String BASECLASSES_ROLE = "baseClasses";

  @Deprecated
  private int deprecated;

  @Deprecated
  private PublicClassBO publicClass;

  @Deprecated
  private Set<BaseClassBO> baseClasses;

  /**
   * Initialize object. The constructor of the class has visibility protected in order to avoid creating business
   * objects not through JEAFs persistence service provider.
   */
  protected DeprecatedPOBase( ) {
    baseClasses = new HashSet<BaseClassBO>();
  }

  /**
   * Method returns all instance of this class including potential subclasses.
   * 
   * @return {@link List} List with all objects of this class. The method never returns null.
   */
  public static List<DeprecatedPO> findAllDeprecatedPOs( ) {
    return PersistentObject.getPersistenceServiceProvider().findAll(DeprecatedPO.class);
  }

  /**
   * Method returns attribute {@link #deprecated}.<br/>
   * 
   * @return int Value to which {@link #deprecated} is set.
   */
  @Deprecated
  public int getDeprecated( ) {
    return deprecated;
  }

  /**
   * Method sets attribute {@link #deprecated}.<br/>
   * 
   * @param pDeprecated Value to which {@link #deprecated} should be set.
   */
  @Deprecated
  public void setDeprecated( int pDeprecated ) {
    // Assign value to attribute
    deprecated = pDeprecated;
  }

  /**
   * Method returns association {@link #publicClass}.<br/>
   * 
   * @return {@link PublicClassBO} Value to which {@link #publicClass} is set.
   */
  @Deprecated
  public PublicClassBO getPublicClass( ) {
    publicClass = this.unproxy(publicClass);
    return publicClass;
  }

  /**
   * Method sets association {@link #publicClass}.<br/>
   * 
   * @param pPublicClass Value to which {@link #publicClass} should be set.
   */
  @Deprecated
  public void setPublicClass( PublicClassBO pPublicClass ) {
    publicClass = pPublicClass;
  }

  /**
   * Method unsets {@link #publicClass}.
   */
  @Deprecated
  public final void unsetPublicClass( ) {
    publicClass = null;
  }

  /**
   * Method returns association {@link #baseClasses}.<br/>
   * 
   * @return {@link Set<BaseClassBO>} Value to which {@link #baseClasses} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  @Deprecated
  public Set<BaseClassBO> getBaseClasses( ) {
    // Return all BaseClassBO objects as unmodifiable collection.
    return Collections.unmodifiableSet(baseClasses);
  }

  /**
   * Method adds the passed object to {@link #baseClasses}.
   * 
   * @param pBaseClasses Object that should be added to {@link #baseClasses}. The parameter must not be null.
   */
  @Deprecated
  public void addToBaseClasses( BaseClassBO pBaseClasses ) {
    // Check parameter "pBaseClasses" for invalid value null.
    Check.checkInvalidParameterNull(pBaseClasses, "pBaseClasses");
    // Since this is not a many-to-many association the association to which the passed object belongs, has to
    // be released.
    pBaseClasses.unsetDeprecatedPO();
    // Add passed object to collection of associated BaseClassBO objects.
    baseClasses.add(pBaseClasses);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pBaseClasses != null && this.equals(pBaseClasses.getDeprecatedPO()) == false) {
      pBaseClasses.setDeprecatedPO((DeprecatedPO) this);
    }
  }

  /**
   * Method adds all passed objects to the association "baseClasses".
   * 
   * 
   * @param pBaseClasses Collection with all objects that should be added to the association "baseClasses". The
   * parameter must not be null.
   */
  @Deprecated
  public void addToBaseClasses( Collection<BaseClassBO> pBaseClasses ) {
    // Check parameter "pBaseClasses" for invalid value null.
    Check.checkInvalidParameterNull(pBaseClasses, "pBaseClasses");
    // Add all passed objects.
    for (BaseClassBO lNextObject : pBaseClasses) {
      this.addToBaseClasses(lNextObject);
    }
  }

  /**
   * Method removes the passed BaseClassBO object from the association "baseClasses".
   * 
   * 
   * @param pBaseClasses Object that should be removed from the association "baseClasses". The parameter must not be
   * null.
   */
  @Deprecated
  public void removeFromBaseClasses( BaseClassBO pBaseClasses ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pBaseClasses, "pBaseClasses");
    // Remove passed object from collection of associated BaseClassBO objects.
    baseClasses.remove(pBaseClasses);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (this.equals(pBaseClasses.getDeprecatedPO()) == true) {
      pBaseClasses.unsetDeprecatedPO();
    }
  }

  /**
   * Method removes all objects from the association "baseClasses".
   * 
   */
  @Deprecated
  public void clearBaseClasses( ) {
    // Remove all objects from association "baseClasses".
    Collection<BaseClassBO> lBaseClasses = new HashSet<BaseClassBO>(baseClasses);
    Iterator<BaseClassBO> lIterator = lBaseClasses.iterator();
    while (lIterator.hasNext()) {
      // As association is bidirectional we have to clear it in both directions.
      this.removeFromBaseClasses(lIterator.next());
    }
  }

  /**
   */
  @Deprecated
  public abstract void doSomethingDeprecated( );

  /**
   * @param pParam1
   * @param pParam2 <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   * @return {@link String} <br/>
   * <b>Deprecated. </b> <i> (<b>since:</b> , <b>removed with:</b> )
   */
  @Deprecated
  public abstract String doSomething( int pParam1, @Deprecated int pParam2 );

  /**
   * Method returns the class id of this business object class.
   * 
   * @return {@link ClassID} Class ID of this business object. The method never returns null.
   */
  public ClassID getClassID( ) {
    return CLASS_ID;
  }
}
