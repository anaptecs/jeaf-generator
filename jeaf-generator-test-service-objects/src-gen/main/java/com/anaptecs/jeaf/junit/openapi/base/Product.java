/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

import com.anaptecs.jeaf.core.api.AbstractObjectID;
import com.anaptecs.jeaf.core.api.Identifiable;
import com.anaptecs.jeaf.core.api.MessageConstants;
import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.core.api.ServiceObjectID;
import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class Product implements ServiceObject, Identifiable<ServiceObjectID> {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "resellers".
   */
  public static final String RESELLERS = "resellers";

  /**
   * Constant for the name of attribute "image".
   */
  public static final String IMAGE = "image";

  /**
   * Constant for the name of attribute "link".
   */
  public static final String LINK = "link";

  /**
   * Constant for the name of attribute "productID".
   */
  public static final String PRODUCTID = "productID";

  /**
   * Reference to the identifier of this object. The reference may be null since an id is not mandatory.
   */
  private final ServiceObjectID objectID;

  /**
   * 
   */
  private Set<Reseller> resellers = new HashSet<Reseller>();

  /**
   * 
   */
  private byte[] image;

  /**
   * 
   */
  private URL link;

  /**
   * 
   */
  private UUID productID;

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected Product( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read object ID.
    AbstractObjectID<?> lObjectID = pBuilder.objectID;
    if (lObjectID != null) {
      objectID = new ServiceObjectID(pBuilder.objectID);
    }
    else {
      objectID = null;
    }
    // Read attribute values from builder.
    if (pBuilder.resellers != null) {
      resellers.addAll(pBuilder.resellers);
    }
    image = pBuilder.image;
    link = pBuilder.link;
    productID = pBuilder.productID;
  }

  /**
   * Class implements builder to create a new instance of class Product. As the class has readonly attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * Reference to the identifier of this object. The reference may be null since an id is not mandatory.
     */
    private AbstractObjectID<?> objectID;

    /**
     * 
     */
    private Set<Reseller> resellers;

    /**
     * 
     */
    private byte[] image;

    /**
     * 
     */
    private URL link;

    /**
     * 
     */
    private UUID productID;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(Product)} instead of private constructor to create new builder.
     */
    protected Builder( Product pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        objectID = pObject.objectID;
        resellers = pObject.resellers;
        image = pObject.image;
        link = pObject.link;
        productID = pObject.productID;
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
     * @return {@link Builder} New builder that can be used to create new Product objects. The method never returns
     * null.
     */
    public static Builder newBuilder( Product pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the identifier for the object created using the builder. The reference may be null since an id is not
     * mandatory.
     */
    public Builder setID( AbstractObjectID<?> pObjectID ) {
      objectID = pObjectID;
      return this;
    }

    /**
     * Method sets the association "resellers".
     * 
     * @param pResellers Collection with objects to which the association should be set.
     */
    public Builder setResellers( Set<Reseller> pResellers ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pResellers != null) {
        resellers = new HashSet<Reseller>(pResellers);
      }
      else {
        resellers = null;
      }
      return this;
    }

    /**
     * Method sets the attribute "image".
     * 
     * @param pImage Value to which the attribute "image" should be set.
     */
    public Builder setImage( byte[] pImage ) {
      // Assign value to attribute
      if (pImage != null) {
        image = new byte[pImage.length];
        System.arraycopy(pImage, 0, image, 0, pImage.length);
      }
      else {
        image = null;
      }
      return this;
    }

    /**
     * Method sets the attribute "link".
     * 
     * @param pLink Value to which the attribute "link" should be set.
     */
    public Builder setLink( URL pLink ) {
      // Assign value to attribute
      link = pLink;
      return this;
    }

    /**
     * Method sets the attribute "productID".
     * 
     * @param pProductID Value to which the attribute "productID" should be set.
     */
    public Builder setProductID( UUID pProductID ) {
      // Assign value to attribute
      productID = pProductID;
      return this;
    }

    /**
     * Method creates a new instance of class Product. The object will be initialized with the values of the builder.
     * 
     * @return Product Created object. The method never returns null.
     */
    public Product build( ) {
      return new Product(this);
    }

    /**
     * Method creates a new instance of class Product. The object will be initialized with the values of the builder.
     * 
     * @param pValidate Parameter defines if the created POJO should be validated using Java Validation.
     * @return Product Created object. The method never returns null.
     */
    public Product build( boolean pValidate ) {
      Product lPOJO = this.build();
      if (pValidate == true) {
        Tools.getValidationTools().validateObject(lPOJO);
      }
      return lPOJO;
    }
  }

  /**
   * Method returns the id of this object.
   * 
   * @return {@link ServiceObjectID} ID of this object. Since an object must not have an id the method may also return
   * null.
   */
  @Override
  public final ServiceObjectID getID( ) {
    return objectID;
  }

  /**
   * Method returns the unversioned object id of this object.
   * 
   * @return {@link ServiceObjectID} ID of this object. Since an object must not have an id the method may also return
   * null.
   */
  @Override
  public final ServiceObjectID getUnversionedID( ) {
    ServiceObjectID lUnversionedID;
    if (objectID != null) {
      lUnversionedID = objectID.getUnversionedObjectID();
    }
    else {
      lUnversionedID = null;
    }
    return lUnversionedID;
  }

  /**
   * Method returns the association "resellers".
   * 
   *
   * @return Collection All Reseller objects that belong to the association "resellers". The method never returns null
   * and the returned collection is unmodifiable.
   */
  public Set<Reseller> getResellers( ) {
    // Return all Reseller objects as unmodifiable collection.
    return Collections.unmodifiableSet(resellers);
  }

  /**
   * Method sets the association "resellers" to the passed collection. All objects that formerly were part of the
   * association will be removed from it.
   * 
   * 
   * @param pResellers Collection with objects to which the association should be set. The parameter must not be null.
   */
  void setResellers( Set<Reseller> pResellers ) {
    // Check of parameter is not required.
    // Remove all objects from association "resellers".
    this.clearResellers();
    // If the association is null, removing all entries is sufficient.
    if (pResellers != null) {
      resellers = new HashSet<Reseller>(pResellers);
    }
  }

  /**
   * Method adds the passed Reseller object to the association "resellers".
   * 
   * 
   * @param pResellers Object that should be added to the association "resellers". The parameter must not be null.
   */
  public void addToResellers( Reseller pResellers ) {
    // Check parameter "pResellers" for invalid value null.
    Check.checkInvalidParameterNull(pResellers, "pResellers");
    // Add passed object to collection of associated Reseller objects.
    resellers.add(pResellers);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pResellers != null && pResellers.getProducts().contains(this) == false) {
      pResellers.addToProducts((Product) this);
    }
  }

  /**
   * Method adds all passed objects to the association "resellers".
   * 
   * 
   * @param pResellers Collection with all objects that should be added to the association "resellers". The parameter
   * must not be null.
   */
  public void addToResellers( Collection<Reseller> pResellers ) {
    // Check parameter "pResellers" for invalid value null.
    Check.checkInvalidParameterNull(pResellers, "pResellers");
    // Add all passed objects.
    for (Reseller lNextObject : pResellers) {
      this.addToResellers(lNextObject);
    }
  }

  /**
   * Method removes the passed Reseller object from the association "resellers".
   * 
   * 
   * @param pResellers Object that should be removed from the association "resellers". The parameter must not be null.
   */
  public void removeFromResellers( Reseller pResellers ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pResellers, "pResellers");
    // Remove passed object from collection of associated Reseller objects.
    resellers.remove(pResellers);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pResellers.getProducts().contains(this) == true) {
      pResellers.removeFromProducts((Product) this);
    }
  }

  /**
   * Method removes all objects from the association "resellers".
   * 
   */
  public void clearResellers( ) {
    // Remove all objects from association "resellers".
    Collection<Reseller> lResellers = new HashSet<Reseller>(resellers);
    Iterator<Reseller> lIterator = lResellers.iterator();
    while (lIterator.hasNext()) {
      this.removeFromResellers(lIterator.next());
    }
  }

  /**
   * Method returns the attribute "image".
   * 
   * 
   * @return byte Value to which the attribute "image" is set.
   */
  public byte[] getImage( ) {
    byte[] lReturnValue;
    if (image != null) {
      lReturnValue = new byte[image.length];
      System.arraycopy(image, 0, lReturnValue, 0, image.length);
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets the attribute "image".
   * 
   * 
   * @param pImage Value to which the attribute "image" should be set.
   */
  public void setImage( byte[] pImage ) {
    // Assign value to attribute
    if (pImage != null) {
      image = new byte[pImage.length];
      System.arraycopy(pImage, 0, image, 0, pImage.length);
    }
    else {
      image = null;
    }
  }

  /**
   * Method returns the attribute "link".
   * 
   * 
   * @return URL Value to which the attribute "link" is set.
   */
  public URL getLink( ) {
    return link;
  }

  /**
   * Method sets the attribute "link".
   * 
   * 
   * @param pLink Value to which the attribute "link" should be set.
   */
  public void setLink( URL pLink ) {
    // Assign value to attribute
    link = pLink;
  }

  /**
   * Method returns the attribute "productID".
   * 
   * 
   * @return UUID Value to which the attribute "productID" is set.
   */
  public UUID getProductID( ) {
    return productID;
  }

  /**
   * Method sets the attribute "productID".
   * 
   * 
   * @param pProductID Value to which the attribute "productID" should be set.
   */
  public void setProductID( UUID pProductID ) {
    // Assign value to attribute
    productID = pProductID;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. the returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  protected StringBuilder toStringBuilder( ) {
    StringBuilder lBuilder = new StringBuilder(256);
    lBuilder.append(XFun.getMessageRepository().getMessage(MessageConstants.OBJECT_INFO, this.getClass().getName()));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(MessageConstants.OBJECT_ATTRIBUTES_SECTION));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(MessageConstants.OBJECT_ATTRIBUTE, "link", "" + link));
    lBuilder.append('\n');
    lBuilder
        .append(XFun.getMessageRepository().getMessage(MessageConstants.OBJECT_ATTRIBUTE, "productID", "" + productID));
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
