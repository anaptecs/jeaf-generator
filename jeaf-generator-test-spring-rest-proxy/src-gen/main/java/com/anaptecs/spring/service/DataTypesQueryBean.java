/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.anaptecs.spring.base.BookingID;
import com.anaptecs.spring.base.DoubleCode;
import com.anaptecs.spring.base.IntegerCodeType;
import com.anaptecs.spring.base.LongCode;

public class DataTypesQueryBean {
  /**
   * Constant for the name of attribute "longCodes".
   */
  public static final String LONGCODES = "longCodes";

  /**
   * Constant for the name of attribute "codes".
   */
  public static final String CODES = "codes";

  /**
   * Constant for the name of attribute "doubleCodes".
   */
  public static final String DOUBLECODES = "doubleCodes";

  /**
   * Constant for the name of attribute "bookingIDs".
   */
  public static final String BOOKINGIDS = "bookingIDs";

  /**
   * Constant for the name of attribute "bookingIDsArray".
   */
  public static final String BOOKINGIDSARRAY = "bookingIDsArray";

  /**
   * Constant for the name of attribute "offsetDateTime".
   */
  public static final String OFFSETDATETIME = "offsetDateTime";

  /**
   * Constant for the name of attribute "offsetTime".
   */
  public static final String OFFSETTIME = "offsetTime";

  /**
   * Constant for the name of attribute "localDateTime".
   */
  public static final String LOCALDATETIME = "localDateTime";

  /**
   * Constant for the name of attribute "localTime".
   */
  public static final String LOCALTIME = "localTime";

  /**
   * Constant for the name of attribute "timestamps".
   */
  public static final String TIMESTAMPS = "timestamps";

  /**
   * Constant for the name of attribute "times".
   */
  public static final String TIMES = "times";

  /**
   * Constant for the name of attribute "startTimestamps".
   */
  public static final String STARTTIMESTAMPS = "startTimestamps";

  private LongCode[] longCodes;

  private IntegerCodeType[] codes;

  private Set<DoubleCode> doubleCodes;

  private Set<BookingID> bookingIDs;

  private BookingID[] bookingIDsArray;

  private OffsetDateTime offsetDateTime;

  private OffsetTime offsetTime;

  private LocalDateTime localDateTime;

  private LocalTime localTime;

  private List<LocalDateTime> timestamps;

  private Set<OffsetTime> times;

  private OffsetDateTime[] startTimestamps;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  public DataTypesQueryBean( ) {
    doubleCodes = new HashSet<DoubleCode>();
    bookingIDs = new HashSet<BookingID>();
    timestamps = new ArrayList<LocalDateTime>();
    times = new HashSet<OffsetTime>();
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected DataTypesQueryBean( Builder pBuilder ) {
    // Read attribute values from builder.
    longCodes = pBuilder.longCodes;
    codes = pBuilder.codes;
    if (pBuilder.doubleCodes != null) {
      doubleCodes = pBuilder.doubleCodes;
    }
    else {
      doubleCodes = new HashSet<DoubleCode>();
    }
    if (pBuilder.bookingIDs != null) {
      bookingIDs = pBuilder.bookingIDs;
    }
    else {
      bookingIDs = new HashSet<BookingID>();
    }
    bookingIDsArray = pBuilder.bookingIDsArray;
    offsetDateTime = pBuilder.offsetDateTime;
    offsetTime = pBuilder.offsetTime;
    localDateTime = pBuilder.localDateTime;
    localTime = pBuilder.localTime;
    if (pBuilder.timestamps != null) {
      timestamps = pBuilder.timestamps;
    }
    else {
      timestamps = new ArrayList<LocalDateTime>();
    }
    if (pBuilder.times != null) {
      times = pBuilder.times;
    }
    else {
      times = new HashSet<OffsetTime>();
    }
    startTimestamps = pBuilder.startTimestamps;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new DataTypesQueryBean objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   *
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new DataTypesQueryBean objects. The method never
   * returns null.
   */
  public static Builder builder( DataTypesQueryBean pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class <code>DataTypesQueryBean</code>.
   */
  public static class Builder {
    private LongCode[] longCodes;

    private IntegerCodeType[] codes;

    private Set<DoubleCode> doubleCodes;

    private Set<BookingID> bookingIDs;

    private BookingID[] bookingIDsArray;

    private OffsetDateTime offsetDateTime;

    private OffsetTime offsetTime;

    private LocalDateTime localDateTime;

    private LocalTime localTime;

    private List<LocalDateTime> timestamps;

    private Set<OffsetTime> times;

    private OffsetDateTime[] startTimestamps;

    /**
     * Use {@link DataTypesQueryBean#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link DataTypesQueryBean#builder(DataTypesQueryBean)} instead of private constructor to create new builder.
     */
    protected Builder( DataTypesQueryBean pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        longCodes = pObject.longCodes;
        codes = pObject.codes;
        doubleCodes = pObject.doubleCodes;
        bookingIDs = pObject.bookingIDs;
        bookingIDsArray = pObject.bookingIDsArray;
        offsetDateTime = pObject.offsetDateTime;
        offsetTime = pObject.offsetTime;
        localDateTime = pObject.localDateTime;
        localTime = pObject.localTime;
        timestamps = pObject.timestamps;
        times = pObject.times;
        startTimestamps = pObject.startTimestamps;
      }
    }

    /**
     * Method sets attribute {@link #longCodes}.<br/>
     *
     * @param pLongCodes Collection to which {@link #longCodes} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setLongCodes( LongCode[] pLongCodes ) {
      // Assign value to attribute
      if (pLongCodes != null) {
        longCodes = new LongCode[pLongCodes.length];
        System.arraycopy(pLongCodes, 0, longCodes, 0, pLongCodes.length);
      }
      else {
        longCodes = null;
      }
      return this;
    }

    /**
     * Method sets attribute {@link #codes}.<br/>
     *
     * @param pCodes Collection to which {@link #codes} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setCodes( IntegerCodeType[] pCodes ) {
      // Assign value to attribute
      if (pCodes != null) {
        codes = new IntegerCodeType[pCodes.length];
        System.arraycopy(pCodes, 0, codes, 0, pCodes.length);
      }
      else {
        codes = null;
      }
      return this;
    }

    /**
     * Method sets association {@link #doubleCodes}.<br/>
     *
     * @param pDoubleCodes Collection to which {@link #doubleCodes} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setDoubleCodes( Set<DoubleCode> pDoubleCodes ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pDoubleCodes != null) {
        doubleCodes = new HashSet<DoubleCode>(pDoubleCodes);
      }
      else {
        doubleCodes = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #doubleCodes}.<br/>
     *
     * @param pDoubleCodes Array of objects that should be added to {@link #doubleCodes}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToDoubleCodes( DoubleCode... pDoubleCodes ) {
      if (pDoubleCodes != null) {
        if (doubleCodes == null) {
          doubleCodes = new HashSet<DoubleCode>();
        }
        doubleCodes.addAll(Arrays.asList(pDoubleCodes));
      }
      return this;
    }

    /**
     * Method sets association {@link #bookingIDs}.<br/>
     *
     * @param pBookingIDs Collection to which {@link #bookingIDs} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setBookingIDs( Set<BookingID> pBookingIDs ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pBookingIDs != null) {
        bookingIDs = new HashSet<BookingID>(pBookingIDs);
      }
      else {
        bookingIDs = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #bookingIDs}.<br/>
     *
     * @param pBookingIDs Array of objects that should be added to {@link #bookingIDs}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToBookingIDs( BookingID... pBookingIDs ) {
      if (pBookingIDs != null) {
        if (bookingIDs == null) {
          bookingIDs = new HashSet<BookingID>();
        }
        bookingIDs.addAll(Arrays.asList(pBookingIDs));
      }
      return this;
    }

    /**
     * Method sets attribute {@link #bookingIDsArray}.<br/>
     *
     * @param pBookingIDsArray Collection to which {@link #bookingIDsArray} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setBookingIDsArray( BookingID[] pBookingIDsArray ) {
      // Assign value to attribute
      if (pBookingIDsArray != null) {
        bookingIDsArray = new BookingID[pBookingIDsArray.length];
        System.arraycopy(pBookingIDsArray, 0, bookingIDsArray, 0, pBookingIDsArray.length);
      }
      else {
        bookingIDsArray = null;
      }
      return this;
    }

    /**
     * Method sets attribute {@link #offsetDateTime}.<br/>
     *
     * @param pOffsetDateTime Value to which {@link #offsetDateTime} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setOffsetDateTime( OffsetDateTime pOffsetDateTime ) {
      // Assign value to attribute
      offsetDateTime = pOffsetDateTime;
      return this;
    }

    /**
     * Method sets association {@link #offsetTime}.<br/>
     *
     * @param pOffsetTime Value to which {@link #offsetTime} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setOffsetTime( OffsetTime pOffsetTime ) {
      offsetTime = pOffsetTime;
      return this;
    }

    /**
     * Method sets attribute {@link #localDateTime}.<br/>
     *
     * @param pLocalDateTime Value to which {@link #localDateTime} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setLocalDateTime( LocalDateTime pLocalDateTime ) {
      // Assign value to attribute
      localDateTime = pLocalDateTime;
      return this;
    }

    /**
     * Method sets attribute {@link #localTime}.<br/>
     *
     * @param pLocalTime Value to which {@link #localTime} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setLocalTime( LocalTime pLocalTime ) {
      // Assign value to attribute
      localTime = pLocalTime;
      return this;
    }

    /**
     * Method sets association {@link #timestamps}.<br/>
     *
     * @param pTimestamps Collection to which {@link #timestamps} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setTimestamps( List<LocalDateTime> pTimestamps ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pTimestamps != null) {
        timestamps = new ArrayList<LocalDateTime>(pTimestamps);
      }
      else {
        timestamps = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #timestamps}.<br/>
     *
     * @param pTimestamps Array of objects that should be added to {@link #timestamps}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToTimestamps( LocalDateTime... pTimestamps ) {
      if (pTimestamps != null) {
        if (timestamps == null) {
          timestamps = new ArrayList<LocalDateTime>();
        }
        timestamps.addAll(Arrays.asList(pTimestamps));
      }
      return this;
    }

    /**
     * Method sets association {@link #times}.<br/>
     *
     * @param pTimes Collection to which {@link #times} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setTimes( Set<OffsetTime> pTimes ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pTimes != null) {
        times = new HashSet<OffsetTime>(pTimes);
      }
      else {
        times = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #times}.<br/>
     *
     * @param pTimes Array of objects that should be added to {@link #times}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToTimes( OffsetTime... pTimes ) {
      if (pTimes != null) {
        if (times == null) {
          times = new HashSet<OffsetTime>();
        }
        times.addAll(Arrays.asList(pTimes));
      }
      return this;
    }

    /**
     * Method sets attribute {@link #startTimestamps}.<br/>
     *
     * @param pStartTimestamps Collection to which {@link #startTimestamps} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setStartTimestamps( OffsetDateTime[] pStartTimestamps ) {
      // Assign value to attribute
      if (pStartTimestamps != null) {
        startTimestamps = new OffsetDateTime[pStartTimestamps.length];
        System.arraycopy(pStartTimestamps, 0, startTimestamps, 0, pStartTimestamps.length);
      }
      else {
        startTimestamps = null;
      }
      return this;
    }

    /**
     * Method creates a new instance of class DataTypesQueryBean. The object will be initialized with the values of the
     * builder.
     *
     * @return DataTypesQueryBean Created object. The method never returns null.
     */
    public DataTypesQueryBean build( ) {
      return new DataTypesQueryBean(this);
    }
  }

  /**
   * Method returns attribute {@link #longCodes}.<br/>
   *
   * @return {@link LongCode} Value to which {@link #longCodes} is set.
   */
  public LongCode[] getLongCodes( ) {
    LongCode[] lReturnValue;
    if (longCodes != null) {
      lReturnValue = new LongCode[longCodes.length];
      System.arraycopy(longCodes, 0, lReturnValue, 0, longCodes.length);
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets attribute {@link #longCodes}.<br/>
   *
   * @param pLongCodes Value to which {@link #longCodes} should be set.
   */
  public void setLongCodes( LongCode[] pLongCodes ) {
    // Assign value to attribute
    if (pLongCodes != null) {
      longCodes = new LongCode[pLongCodes.length];
      System.arraycopy(pLongCodes, 0, longCodes, 0, pLongCodes.length);
    }
    else {
      longCodes = null;
    }
  }

  /**
   * Method returns attribute {@link #codes}.<br/>
   *
   * @return {@link IntegerCodeType} Value to which {@link #codes} is set.
   */
  public IntegerCodeType[] getCodes( ) {
    IntegerCodeType[] lReturnValue;
    if (codes != null) {
      lReturnValue = new IntegerCodeType[codes.length];
      System.arraycopy(codes, 0, lReturnValue, 0, codes.length);
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets attribute {@link #codes}.<br/>
   *
   * @param pCodes Value to which {@link #codes} should be set.
   */
  public void setCodes( IntegerCodeType[] pCodes ) {
    // Assign value to attribute
    if (pCodes != null) {
      codes = new IntegerCodeType[pCodes.length];
      System.arraycopy(pCodes, 0, codes, 0, pCodes.length);
    }
    else {
      codes = null;
    }
  }

  /**
   * Method returns association {@link #doubleCodes}.<br/>
   *
   * @return {@link Set<DoubleCode>} Value to which {@link #doubleCodes} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  public Set<DoubleCode> getDoubleCodes( ) {
    // Return all DoubleCode objects as unmodifiable collection.
    return Collections.unmodifiableSet(doubleCodes);
  }

  /**
   * Method adds the passed object to {@link #doubleCodes}.
   *
   * @param pDoubleCodes Object that should be added to {@link #doubleCodes}. The parameter must not be null.
   */
  public void addToDoubleCodes( DoubleCode pDoubleCodes ) {
    // Add passed object to collection of associated DoubleCode objects.
    doubleCodes.add(pDoubleCodes);
  }

  /**
   * Method adds all passed objects to {@link #doubleCodes}.
   *
   * @param pDoubleCodes Collection with all objects that should be added to {@link #doubleCodes}. The parameter must
   * not be null.
   */
  public void addToDoubleCodes( Collection<DoubleCode> pDoubleCodes ) {
    // Add all passed objects.
    for (DoubleCode lNextObject : pDoubleCodes) {
      this.addToDoubleCodes(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #doubleCodes}.<br/>
   *
   * @param pDoubleCodes Object that should be removed from {@link #doubleCodes}. The parameter must not be null.
   */
  public void removeFromDoubleCodes( DoubleCode pDoubleCodes ) {
    // Remove passed object from collection of associated DoubleCode objects.
    doubleCodes.remove(pDoubleCodes);
  }

  /**
   * Method removes all objects from {@link #doubleCodes}.
   */
  public void clearDoubleCodes( ) {
    // Remove all objects from association "doubleCodes".
    doubleCodes.clear();
  }

  /**
   * Method returns association {@link #bookingIDs}.<br/>
   *
   * @return {@link Set<BookingID>} Value to which {@link #bookingIDs} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  public Set<BookingID> getBookingIDs( ) {
    // Return all BookingID objects as unmodifiable collection.
    return Collections.unmodifiableSet(bookingIDs);
  }

  /**
   * Method adds the passed object to {@link #bookingIDs}.
   *
   * @param pBookingIDs Object that should be added to {@link #bookingIDs}. The parameter must not be null.
   */
  public void addToBookingIDs( BookingID pBookingIDs ) {
    // Add passed object to collection of associated BookingID objects.
    bookingIDs.add(pBookingIDs);
  }

  /**
   * Method adds all passed objects to {@link #bookingIDs}.
   *
   * @param pBookingIDs Collection with all objects that should be added to {@link #bookingIDs}. The parameter must not
   * be null.
   */
  public void addToBookingIDs( Collection<BookingID> pBookingIDs ) {
    // Add all passed objects.
    for (BookingID lNextObject : pBookingIDs) {
      this.addToBookingIDs(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #bookingIDs}.<br/>
   *
   * @param pBookingIDs Object that should be removed from {@link #bookingIDs}. The parameter must not be null.
   */
  public void removeFromBookingIDs( BookingID pBookingIDs ) {
    // Remove passed object from collection of associated BookingID objects.
    bookingIDs.remove(pBookingIDs);
  }

  /**
   * Method removes all objects from {@link #bookingIDs}.
   */
  public void clearBookingIDs( ) {
    // Remove all objects from association "bookingIDs".
    bookingIDs.clear();
  }

  /**
   * Method returns attribute {@link #bookingIDsArray}.<br/>
   *
   * @return {@link BookingID} Value to which {@link #bookingIDsArray} is set.
   */
  public BookingID[] getBookingIDsArray( ) {
    BookingID[] lReturnValue;
    if (bookingIDsArray != null) {
      lReturnValue = new BookingID[bookingIDsArray.length];
      System.arraycopy(bookingIDsArray, 0, lReturnValue, 0, bookingIDsArray.length);
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets attribute {@link #bookingIDsArray}.<br/>
   *
   * @param pBookingIDsArray Value to which {@link #bookingIDsArray} should be set.
   */
  public void setBookingIDsArray( BookingID[] pBookingIDsArray ) {
    // Assign value to attribute
    if (pBookingIDsArray != null) {
      bookingIDsArray = new BookingID[pBookingIDsArray.length];
      System.arraycopy(pBookingIDsArray, 0, bookingIDsArray, 0, pBookingIDsArray.length);
    }
    else {
      bookingIDsArray = null;
    }
  }

  /**
   * Method returns attribute {@link #offsetDateTime}.<br/>
   *
   * @return {@link OffsetDateTime} Value to which {@link #offsetDateTime} is set.
   */
  public OffsetDateTime getOffsetDateTime( ) {
    return offsetDateTime;
  }

  /**
   * Method sets attribute {@link #offsetDateTime}.<br/>
   *
   * @param pOffsetDateTime Value to which {@link #offsetDateTime} should be set.
   */
  public void setOffsetDateTime( OffsetDateTime pOffsetDateTime ) {
    // Assign value to attribute
    offsetDateTime = pOffsetDateTime;
  }

  /**
   * Method returns association {@link #offsetTime}.<br/>
   *
   * @return {@link OffsetTime} Value to which {@link #offsetTime} is set.
   */
  public OffsetTime getOffsetTime( ) {
    return offsetTime;
  }

  /**
   * Method sets association {@link #offsetTime}.<br/>
   *
   * @param pOffsetTime Value to which {@link #offsetTime} should be set.
   */
  public void setOffsetTime( OffsetTime pOffsetTime ) {
    offsetTime = pOffsetTime;
  }

  /**
   * Method unsets {@link #offsetTime}.
   */
  public final void unsetOffsetTime( ) {
    offsetTime = null;
  }

  /**
   * Method returns attribute {@link #localDateTime}.<br/>
   *
   * @return {@link LocalDateTime} Value to which {@link #localDateTime} is set.
   */
  public LocalDateTime getLocalDateTime( ) {
    return localDateTime;
  }

  /**
   * Method sets attribute {@link #localDateTime}.<br/>
   *
   * @param pLocalDateTime Value to which {@link #localDateTime} should be set.
   */
  public void setLocalDateTime( LocalDateTime pLocalDateTime ) {
    // Assign value to attribute
    localDateTime = pLocalDateTime;
  }

  /**
   * Method returns attribute {@link #localTime}.<br/>
   *
   * @return {@link LocalTime} Value to which {@link #localTime} is set.
   */
  public LocalTime getLocalTime( ) {
    return localTime;
  }

  /**
   * Method sets attribute {@link #localTime}.<br/>
   *
   * @param pLocalTime Value to which {@link #localTime} should be set.
   */
  public void setLocalTime( LocalTime pLocalTime ) {
    // Assign value to attribute
    localTime = pLocalTime;
  }

  /**
   * Method returns association {@link #timestamps}.<br/>
   *
   * @return {@link List<LocalDateTime>} Value to which {@link #timestamps} is set. The method never returns null and
   * the returned collection is unmodifiable.
   */
  public List<LocalDateTime> getTimestamps( ) {
    // Return all LocalDateTime objects as unmodifiable collection.
    return Collections.unmodifiableList(timestamps);
  }

  /**
   * Method adds the passed object to {@link #timestamps}.
   *
   * @param pTimestamps Object that should be added to {@link #timestamps}. The parameter must not be null.
   */
  public void addToTimestamps( LocalDateTime pTimestamps ) {
    // Add passed object to collection of associated LocalDateTime objects.
    timestamps.add(pTimestamps);
  }

  /**
   * Method adds all passed objects to {@link #timestamps}.
   *
   * @param pTimestamps Collection with all objects that should be added to {@link #timestamps}. The parameter must not
   * be null.
   */
  public void addToTimestamps( Collection<LocalDateTime> pTimestamps ) {
    // Add all passed objects.
    for (LocalDateTime lNextObject : pTimestamps) {
      this.addToTimestamps(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #timestamps}.<br/>
   *
   * @param pTimestamps Object that should be removed from {@link #timestamps}. The parameter must not be null.
   */
  public void removeFromTimestamps( LocalDateTime pTimestamps ) {
    // Remove passed object from collection of associated LocalDateTime objects.
    timestamps.remove(pTimestamps);
  }

  /**
   * Method removes all objects from {@link #timestamps}.
   */
  public void clearTimestamps( ) {
    // Remove all objects from association "timestamps".
    timestamps.clear();
  }

  /**
   * Method returns association {@link #times}.<br/>
   *
   * @return {@link Set<OffsetTime>} Value to which {@link #times} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  public Set<OffsetTime> getTimes( ) {
    // Return all OffsetTime objects as unmodifiable collection.
    return Collections.unmodifiableSet(times);
  }

  /**
   * Method adds the passed object to {@link #times}.
   *
   * @param pTimes Object that should be added to {@link #times}. The parameter must not be null.
   */
  public void addToTimes( OffsetTime pTimes ) {
    // Add passed object to collection of associated OffsetTime objects.
    times.add(pTimes);
  }

  /**
   * Method adds all passed objects to {@link #times}.
   *
   * @param pTimes Collection with all objects that should be added to {@link #times}. The parameter must not be null.
   */
  public void addToTimes( Collection<OffsetTime> pTimes ) {
    // Add all passed objects.
    for (OffsetTime lNextObject : pTimes) {
      this.addToTimes(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #times}.<br/>
   *
   * @param pTimes Object that should be removed from {@link #times}. The parameter must not be null.
   */
  public void removeFromTimes( OffsetTime pTimes ) {
    // Remove passed object from collection of associated OffsetTime objects.
    times.remove(pTimes);
  }

  /**
   * Method removes all objects from {@link #times}.
   */
  public void clearTimes( ) {
    // Remove all objects from association "times".
    times.clear();
  }

  /**
   * Method returns attribute {@link #startTimestamps}.<br/>
   *
   * @return {@link OffsetDateTime} Value to which {@link #startTimestamps} is set.
   */
  public OffsetDateTime[] getStartTimestamps( ) {
    OffsetDateTime[] lReturnValue;
    if (startTimestamps != null) {
      lReturnValue = new OffsetDateTime[startTimestamps.length];
      System.arraycopy(startTimestamps, 0, lReturnValue, 0, startTimestamps.length);
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets attribute {@link #startTimestamps}.<br/>
   *
   * @param pStartTimestamps Value to which {@link #startTimestamps} should be set.
   */
  public void setStartTimestamps( OffsetDateTime[] pStartTimestamps ) {
    // Assign value to attribute
    if (pStartTimestamps != null) {
      startTimestamps = new OffsetDateTime[pStartTimestamps.length];
      System.arraycopy(pStartTimestamps, 0, startTimestamps, 0, pStartTimestamps.length);
    }
    else {
      startTimestamps = null;
    }
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
    lBuilder.append("longCodes: ");
    if (longCodes != null) {
      lBuilder.append(Arrays.toString(longCodes));
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("codes: ");
    if (codes != null) {
      lBuilder.append(Arrays.toString(codes));
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("doubleCodes: ");
    if (doubleCodes != null) {
      lBuilder.append(doubleCodes.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (doubleCodes != null) {
      for (DoubleCode lNext : doubleCodes) {
        lBuilder.append(lNext.toStringBuilder(pIndent + "    "));
        lBuilder.append(System.lineSeparator());
      }
    }
    lBuilder.append(pIndent);
    lBuilder.append("bookingIDs: ");
    if (bookingIDs != null) {
      lBuilder.append(bookingIDs.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (bookingIDs != null) {
      for (BookingID lNext : bookingIDs) {
        lBuilder.append(lNext.toStringBuilder(pIndent + "    "));
        lBuilder.append(System.lineSeparator());
      }
    }
    lBuilder.append(pIndent);
    lBuilder.append("bookingIDsArray: ");
    if (bookingIDsArray != null) {
      lBuilder.append(Arrays.toString(bookingIDsArray));
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("offsetDateTime: ");
    lBuilder.append(offsetDateTime);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("offsetTime: ");
    lBuilder.append(offsetTime);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("localDateTime: ");
    lBuilder.append(localDateTime);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("localTime: ");
    lBuilder.append(localTime);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("timestamps: ");
    if (timestamps != null) {
      lBuilder.append(timestamps.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (timestamps != null) {
      for (LocalDateTime lNext : timestamps) {
        lBuilder.append(pIndent + "    ");
        lBuilder.append(lNext.toString());
        lBuilder.append(System.lineSeparator());
      }
    }
    lBuilder.append(pIndent);
    lBuilder.append("times: ");
    if (times != null) {
      lBuilder.append(times.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (times != null) {
      for (OffsetTime lNext : times) {
        lBuilder.append(pIndent + "    ");
        lBuilder.append(lNext.toString());
        lBuilder.append(System.lineSeparator());
      }
    }
    lBuilder.append(pIndent);
    lBuilder.append("startTimestamps: ");
    if (startTimestamps != null) {
      lBuilder.append(Arrays.toString(startTimestamps));
    }
    else {
      lBuilder.append(" null");
    }
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
