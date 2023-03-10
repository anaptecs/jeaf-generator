/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

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

  private String link;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
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
   * Method returns association {@link #start}.<br/>
   * The start
   * 
   * @return {@link Stop} Value to which {@link #start} is set.
   */
  public Stop getStart( ) {
    return start;
  }

  /**
   * Method sets association {@link #start}.<br/>
   * The start
   * 
   * @param pStart Value to which {@link #start} should be set.
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
   * Method returns association {@link #end}.<br/>
   * The end
   * 
   * @return {@link Stop} Value to which {@link #end} is set.
   */
  public Stop getEnd( ) {
    return end;
  }

  /**
   * Method sets association {@link #end}.<br/>
   * The end
   * 
   * @param pEnd Value to which {@link #end} should be set.
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
   * Method returns attribute {@link #link}.<br/>
   * 
   * @return {@link String} Value to which {@link #link} is set.
   */
  public String getLink( ) {
    return link;
  }

  /**
   * Method sets attribute {@link #link}.<br/>
   * 
   * @param pLink Value to which {@link #link} should be set.
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
