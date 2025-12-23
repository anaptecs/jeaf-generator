/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo.softlink;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonGetter;

public class SoftLinkPartner extends SoftLinkPartnerBase {
  /**
   * Initialize object. Nothing special to do.
   */
  protected SoftLinkPartner( SoftLinkPartner.BuilderBase pBuilder ) {
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new SoftLinkPartner objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Class implements builder to create a new instance of class SoftLinkPartner. As the class has readonly attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends SoftLinkPartner.BuilderBase {
    /**
     * Use {@link SoftLinkPartner#builder()} instead of protected constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link SoftLinkPartner#builder(SoftLinkPartner)} instead of protected constructor to create new builder.
     */
    protected Builder( SoftLinkPartner pObject ) {
      super(pObject);
    }
  }

  /**
   * Method returns association {@link #derivedSoftLink}.<br/>
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #derivedSoftLink} is
   * <code>com.anaptecs.jeaf.junit.pojo.softlink.SoftLinkParent</code><br/>
   *
   * @return {@link String} Value to which {@link #derivedSoftLink} is set.
   */
  @JsonGetter
  @Override
  public String getDerivedSoftLinkID( ) {
    // TODO Implement method for derived property "derivedSoftLink".
    return null;
  }

  /**
   * Method returns association {@link #theDerivedSoftLinks}.<br/>
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by {@link #theDerivedSoftLinks}
   * is <code>com.anaptecs.jeaf.junit.pojo.softlink.SoftLinkParent</code><br/>
   *
   * @return {@link List<SoftLinkID>} Value to which {@link #theDerivedSoftLinks} is set. The method never returns null
   * and the returned collection is unmodifiable.
   */
  @JsonGetter
  @Override
  public List<SoftLinkID> getTheDerivedSoftLinkIDs( ) {
    // TODO Implement method for derived property "theDerivedSoftLinks".
    return null;
  }

  /**
   * Method returns association {@link #javaOnlyDerivedSoftLink}.<br/>
   * <p/>
   * This class uses so called soft links for decoupling. The actual type that is hidden by
   * {@link #javaOnlyDerivedSoftLink} is <code>com.anaptecs.jeaf.junit.pojo.softlink.SoftLinkChildA</code><br/>
   *
   * @return {@link SoftLinkID} Value to which {@link #javaOnlyDerivedSoftLink} is set.
   */
  @Override
  public SoftLinkID getJavaOnlyDerivedSoftLinkID( ) {
    // TODO Implement method for derived property "javaOnlyDerivedSoftLink".
    return null;
  }
}