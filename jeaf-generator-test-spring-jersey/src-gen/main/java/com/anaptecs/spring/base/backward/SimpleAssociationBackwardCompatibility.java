/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base.backward;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonPropertyOrder(value = { "deprecatedLinks", "newLinks", "oldSingleLink", "newSingleLink" })
@JsonDeserialize(builder = SimpleAssociationBackwardCompatibility.Builder.class)
public class SimpleAssociationBackwardCompatibility {
  /**
   * Constant for the name of attribute "deprecatedLinks".
   */
  @Deprecated
  public static final String DEPRECATEDLINKS = "deprecatedLinks";

  /**
   * Constant for the name of attribute "newLinks".
   */
  public static final String NEWLINKS = "newLinks";

  /**
   * Constant for the name of attribute "oldSingleLink".
   */
  @Deprecated
  public static final String OLDSINGLELINK = "oldSingleLink";

  /**
   * Constant for the name of attribute "newSingleLink".
   */
  public static final String NEWSINGLELINK = "newSingleLink";

  @JsonAlias({ "deprecatedLinks" })
  private List<SimpleBackwardCompatibility> newLinks;

  @JsonAlias({ "oldSingleLink" })
  private SimpleBackwardCompatibility newSingleLink;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected SimpleAssociationBackwardCompatibility( Builder pBuilder ) {
    // Read attribute values from builder.
    if (pBuilder.newLinks != null) {
      newLinks = pBuilder.newLinks;
    }
    else {
      newLinks = new ArrayList<>();
    }
    newSingleLink = pBuilder.newSingleLink;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new SimpleAssociationBackwardCompatibility objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Convenience method to create new instance of class SimpleAssociationBackwardCompatibility.
   *
   *
   * @return {@link SimpleAssociationBackwardCompatibility}
   */
  public static SimpleAssociationBackwardCompatibility of( ) {
    var lBuilder = SimpleAssociationBackwardCompatibility.builder();
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>SimpleAssociationBackwardCompatibility</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder {
    @JsonAlias({ "deprecatedLinks" })
    private List<SimpleBackwardCompatibility> newLinks;

    @JsonAlias({ "oldSingleLink" })
    private SimpleBackwardCompatibility newSingleLink;

    /**
     * Use {@link SimpleAssociationBackwardCompatibility#builder()} instead of private constructor to create new
     * builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link SimpleAssociationBackwardCompatibility#builder(SimpleAssociationBackwardCompatibility)} instead of
     * private constructor to create new builder.
     */
    protected Builder( SimpleAssociationBackwardCompatibility pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setNewLinks(pObject.newLinks);
        this.setNewSingleLink(pObject.newSingleLink);
      }
    }

    /**
     * Method sets association {@link #deprecatedLinks}.<br/>
     *
     * @param pDeprecatedLinks Collection to which {@link #deprecatedLinks} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     * @deprecated Wrong type. Switch to <code>newLink</code> instead. (<b>since:</b> 2.0, <b>removed with:</b> 3.0)
     */
    @Deprecated
    public Builder setDeprecatedLinks( List<SimpleBackwardCompatibility> pDeprecatedLinks ) {
      // Delegate call to setNewLinks(...)
      this.setNewLinks(pDeprecatedLinks);
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #deprecatedLinks}.<br/>
     *
     * @param pDeprecatedLinks Array of objects that should be added to {@link #deprecatedLinks}. The parameter may be
     * null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     * @deprecated Wrong type. Switch to <code>newLink</code> instead. (<b>since:</b> 2.0, <b>removed with:</b> 3.0)
     */
    @Deprecated
    public Builder addToDeprecatedLinks( SimpleBackwardCompatibility... pDeprecatedLinks ) {
      // Delegate call to addToNewLinks(...)
      this.addToNewLinks(pDeprecatedLinks);
      return this;
    }

    /**
     * Method sets association {@link #newLinks}.<br/>
     *
     * @param pNewLinks Collection to which {@link #newLinks} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setNewLinks( List<SimpleBackwardCompatibility> pNewLinks ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pNewLinks != null) {
        newLinks = new ArrayList<SimpleBackwardCompatibility>(pNewLinks);
      }
      else {
        newLinks = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #newLinks}.<br/>
     *
     * @param pNewLinks Array of objects that should be added to {@link #newLinks}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToNewLinks( SimpleBackwardCompatibility... pNewLinks ) {
      if (pNewLinks != null) {
        if (newLinks == null) {
          newLinks = new ArrayList<SimpleBackwardCompatibility>();
        }
        newLinks.addAll(Arrays.asList(pNewLinks));
      }
      return this;
    }

    /**
     * Method sets association {@link #oldSingleLink}.<br/>
     *
     * @param pOldSingleLink Value to which {@link #oldSingleLink} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Deprecated
    public Builder setOldSingleLink( SimpleBackwardCompatibility pOldSingleLink ) {
      // Delegate call to setNewSingleLink(...)
      this.setNewSingleLink(pOldSingleLink);
      return this;
    }

    /**
     * Method sets association {@link #newSingleLink}.<br/>
     *
     * @param pNewSingleLink Value to which {@link #newSingleLink} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setNewSingleLink( SimpleBackwardCompatibility pNewSingleLink ) {
      newSingleLink = pNewSingleLink;
      return this;
    }

    /**
     * Method creates a new instance of class SimpleAssociationBackwardCompatibility. The object will be initialized
     * with the values of the builder.
     *
     * @return SimpleAssociationBackwardCompatibility Created object. The method never returns null.
     */
    public SimpleAssociationBackwardCompatibility build( ) {
      return new SimpleAssociationBackwardCompatibility(this);
    }
  }

  /**
   * Method returns association {@link #deprecatedLinks}.<br/>
   *
   * @return {@link List<SimpleBackwardCompatibility>} Value to which {@link #deprecatedLinks} is set. The method never
   * returns null and the returned collection is unmodifiable.
   * @deprecated Wrong type. Switch to <code>newLink</code> instead. (<b>since:</b> 2.0, <b>removed with:</b> 3.0)
   */
  @JsonGetter
  @Deprecated
  public List<SimpleBackwardCompatibility> getDeprecatedLinks( ) {
    // Delegate call to getNewLinks(...)
    return this.getNewLinks();
  }

  /**
   * Method adds the passed object to {@link #deprecatedLinks}.
   *
   * @param pDeprecatedLinks Object that should be added to {@link #deprecatedLinks}. The parameter must not be null.
   * @deprecated Wrong type. Switch to <code>newLink</code> instead. (<b>since:</b> 2.0, <b>removed with:</b> 3.0)
   */
  @Deprecated
  public void addToDeprecatedLinks( SimpleBackwardCompatibility pDeprecatedLinks ) {
    // Delegate call to addToNewLinks(...)
    this.addToNewLinks(pDeprecatedLinks);
  }

  /**
   * Method adds all passed objects to {@link #deprecatedLinks}.
   *
   * @param pDeprecatedLinks Collection with all objects that should be added to {@link #deprecatedLinks}. The parameter
   * must not be null.
   * @deprecated Wrong type. Switch to <code>newLink</code> instead. (<b>since:</b> 2.0, <b>removed with:</b> 3.0)
   */
  @Deprecated
  public void addToDeprecatedLinks( Collection<SimpleBackwardCompatibility> pDeprecatedLinks ) {
    // Add all passed objects.
    for (SimpleBackwardCompatibility lNextObject : pDeprecatedLinks) {
      this.addToDeprecatedLinks(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #deprecatedLinks}.<br/>
   *
   * @param pDeprecatedLinks Object that should be removed from {@link #deprecatedLinks}. The parameter must not be
   * null.
   */
  @Deprecated
  public void removeFromDeprecatedLinks( SimpleBackwardCompatibility pDeprecatedLinks ) {
    // Delegate call to removeFromNewLinks(...)
    this.removeFromNewLinks(pDeprecatedLinks);
  }

  /**
   * Method removes all objects from {@link #deprecatedLinks}.
   */
  @Deprecated
  public void clearDeprecatedLinks( ) {
    // Delegate call to clearNewLinks()
    this.clearNewLinks();
  }

  /**
   * Method returns association {@link #newLinks}.<br/>
   *
   * @return {@link List<SimpleBackwardCompatibility>} Value to which {@link #newLinks} is set. The method never returns
   * null and the returned collection is unmodifiable.
   */
  public List<SimpleBackwardCompatibility> getNewLinks( ) {
    // Return all SimpleBackwardCompatibility objects as unmodifiable collection.
    return Collections.unmodifiableList(newLinks);
  }

  /**
   * Method adds the passed object to {@link #newLinks}.
   *
   * @param pNewLinks Object that should be added to {@link #newLinks}. The parameter must not be null.
   */
  public void addToNewLinks( SimpleBackwardCompatibility pNewLinks ) {
    // Add passed object to collection of associated SimpleBackwardCompatibility objects.
    newLinks.add(pNewLinks);
  }

  /**
   * Method adds all passed objects to {@link #newLinks}.
   *
   * @param pNewLinks Collection with all objects that should be added to {@link #newLinks}. The parameter must not be
   * null.
   */
  public void addToNewLinks( Collection<SimpleBackwardCompatibility> pNewLinks ) {
    // Add all passed objects.
    for (SimpleBackwardCompatibility lNextObject : pNewLinks) {
      this.addToNewLinks(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #newLinks}.<br/>
   *
   * @param pNewLinks Object that should be removed from {@link #newLinks}. The parameter must not be null.
   */
  public void removeFromNewLinks( SimpleBackwardCompatibility pNewLinks ) {
    // Remove passed object from collection of associated SimpleBackwardCompatibility objects.
    newLinks.remove(pNewLinks);
  }

  /**
   * Method removes all objects from {@link #newLinks}.
   */
  public void clearNewLinks( ) {
    // Remove all objects from association "newLinks".
    newLinks.clear();
  }

  /**
   * Method returns association {@link #oldSingleLink}.<br/>
   *
   * @return {@link SimpleBackwardCompatibility} Value to which {@link #oldSingleLink} is set.
   */
  @JsonGetter
  @Deprecated
  public SimpleBackwardCompatibility getOldSingleLink( ) {
    // Delegate call to getNewSingleLink(...)
    return this.getNewSingleLink();
  }

  /**
   * Method sets association {@link #oldSingleLink}.<br/>
   *
   * @param pOldSingleLink Value to which {@link #oldSingleLink} should be set.
   */
  @Deprecated
  public void setOldSingleLink( SimpleBackwardCompatibility pOldSingleLink ) {
    // Delegate call to setNewSingleLink(...)
    this.setNewSingleLink(pOldSingleLink);
  }

  /**
   * Method unsets {@link #oldSingleLink}.
   */
  @Deprecated
  public final void unsetOldSingleLink( ) {
    // Delegate call to unsetNewSingleLink()
    this.unsetNewSingleLink();
  }

  /**
   * Method returns association {@link #newSingleLink}.<br/>
   *
   * @return {@link SimpleBackwardCompatibility} Value to which {@link #newSingleLink} is set.
   */
  public SimpleBackwardCompatibility getNewSingleLink( ) {
    return newSingleLink;
  }

  /**
   * Method sets association {@link #newSingleLink}.<br/>
   *
   * @param pNewSingleLink Value to which {@link #newSingleLink} should be set.
   */
  public void setNewSingleLink( SimpleBackwardCompatibility pNewSingleLink ) {
    newSingleLink = pNewSingleLink;
  }

  /**
   * Method unsets {@link #newSingleLink}.
   */
  public final void unsetNewSingleLink( ) {
    newSingleLink = null;
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
    lBuilder.append("newLinks: ");
    if (newLinks != null) {
      lBuilder.append(newLinks.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (newLinks != null) {
      for (SimpleBackwardCompatibility lNext : newLinks) {
        lBuilder.append(lNext.toStringBuilder(pIndent + "    "));
        lBuilder.append(System.lineSeparator());
      }
    }
    lBuilder.append(pIndent);
    lBuilder.append("newSingleLink: ");
    if (newSingleLink != null) {
      lBuilder.append(System.lineSeparator());
      lBuilder.append(newSingleLink.toStringBuilder(pIndent + "    "));
    }
    else {
      lBuilder.append(" null");
      lBuilder.append(System.lineSeparator());
    }
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
   * @return {@link Builder} New builder that can be used to create new SimpleAssociationBackwardCompatibility objects.
   * The method never returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}