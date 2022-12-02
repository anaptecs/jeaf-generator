/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class DirectedEdge {
  /**
   * Constant for the name of attribute "start".
   */
  public static final String START = "start";

  /**
   * Constant for the name of attribute "end".
   */
  public static final String END = "end";

  /**
   * Constant for the name of attribute "link".
   */
  public static final String LINK = "link";

  /**
   * The start
   */
  private Stop start;

  /**
   * The end
   */
  private Stop end;

  /**
   * 
   */
  private String link;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected DirectedEdge( ) {
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected DirectedEdge( Builder pBuilder ) {
    // Read attribute values from builder.
    start = pBuilder.start;
    end = pBuilder.end;
    link = pBuilder.link;
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new DirectedEdge objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new DirectedEdge objects. The method never returns
   * null.
   */
  public static Builder builder( DirectedEdge pObject ) {
    return new Builder(pObject);
  }

  /**
   * Method creates a new builder and initializes it with the passed attributes.
   */
  public static Builder builder( Stop pEnd, String pLink ) {
    Builder lBuilder = builder();
    lBuilder.setEnd(pEnd);
    lBuilder.setLink(pLink);
    return lBuilder;
  }

  /**
   * Class implements builder to create a new instance of class DirectedEdge. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * The start
     */
    private Stop start;

    /**
     * The end
     */
    private Stop end;

    /**
     * 
     */
    private String link;

    /**
     * Use {@link DirectedEdge#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link DirectedEdge#builder(DirectedEdge)} instead of private constructor to create new builder.
     */
    protected Builder( DirectedEdge pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        start = pObject.start;
        end = pObject.end;
        link = pObject.link;
      }
    }

    /**
     * Method sets the association "start". The start
     * 
     * @param pStart Stop to which the association "start" should be set.
     */
    public Builder setStart( Stop pStart ) {
      start = pStart;
      return this;
    }

    /**
     * Method sets the association "end". The end
     * 
     * @param pEnd Stop to which the association "end" should be set.
     */
    public Builder setEnd( Stop pEnd ) {
      end = pEnd;
      return this;
    }

    /**
     * Method sets the attribute "link".
     * 
     * @param pLink Value to which the attribute "link" should be set.
     */
    public Builder setLink( String pLink ) {
      // Assign value to attribute
      link = pLink;
      return this;
    }

    /**
     * Method creates a new instance of class DirectedEdge. The object will be initialized with the values of the
     * builder.
     * 
     * @return DirectedEdge Created object. The method never returns null.
     */
    public DirectedEdge build( ) {
      return new DirectedEdge(this);
    }
  }

  /**
   * Method returns the association "start". The start
   *
   * @return Stop Stop to which the association "start" is set.
   */
  public Stop getStart( ) {
    return start;
  }

  /**
   * Method sets the association "start". The start
   * 
   * @param pStart Stop to which the association "start" should be set.
   */
  public void setStart( Stop pStart ) {
    start = pStart;
  }

  /**
   * Method unsets the association "start". The start
   */
  public final void unsetStart( ) {
    start = null;
  }

  /**
   * Method returns the association "end". The end
   *
   * @return Stop Stop to which the association "end" is set.
   */
  public Stop getEnd( ) {
    return end;
  }

  /**
   * Method sets the association "end". The end
   * 
   * @param pEnd Stop to which the association "end" should be set.
   */
  public void setEnd( Stop pEnd ) {
    end = pEnd;
  }

  /**
   * Method unsets the association "end". The end
   */
  public final void unsetEnd( ) {
    end = null;
  }

  /**
   * Method returns the attribute "link".
   * 
   * 
   * @return String Value to which the attribute "link" is set.
   */
  public String getLink( ) {
    return link;
  }

  /**
   * Method sets the attribute "link".
   * 
   * 
   * @param pLink Value to which the attribute "link" should be set.
   */
  public void setLink( String pLink ) {
    // Assign value to attribute
    link = pLink;
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
    lBuilder.append("start: ");
    if (start != null) {
      lBuilder.append(System.lineSeparator());
      lBuilder.append(start.toStringBuilder(pIndent + "    "));
    }
    else {
      lBuilder.append(" null");
      lBuilder.append(System.lineSeparator());
    }
    lBuilder.append(pIndent);
    lBuilder.append("end: ");
    if (end != null) {
      lBuilder.append(System.lineSeparator());
      lBuilder.append(end.toStringBuilder(pIndent + "    "));
    }
    else {
      lBuilder.append(" null");
      lBuilder.append(System.lineSeparator());
    }
    lBuilder.append(pIndent);
    lBuilder.append("link: ");
    lBuilder.append(link);
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
