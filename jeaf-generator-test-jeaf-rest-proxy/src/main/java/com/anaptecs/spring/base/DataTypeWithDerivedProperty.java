
				/*
* anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
* 
* Copyright 2004 - 2019. All rights reserved.
*/
				package com.anaptecs.spring.base;
				  
				


				
    
	    
	
	    
	
	
    

				
				public  class DataTypeWithDerivedProperty extends DataTypeWithDerivedPropertyBase {
					
                    /**
                     * Default serial version UID.
                     */
                    private static final long serialVersionUID = 1L;
					

					/**
					 * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal" object creation builder should be used instead.
					 */
					protected DataTypeWithDerivedProperty( ) {
					}
		
					/**
					 * Initialize object. Nothing special to do.
					 */
					protected DataTypeWithDerivedProperty( DataTypeWithDerivedProperty.BuilderBase pBuilder ) {
					  super(pBuilder);
					}
					  
					
   
    /**
     * Method returns a new builder.
     * 
     * @return {@link Builder} New builder that can be used to create new DataTypeWithDerivedProperty objects.
     */
    public static  Builder builder() {
      return new Builder();
    }

    

   
   /**
    * Method creates a new builder and initializes it with the passed attributes.
    */
    public static  Builder builder( int pProperty) {
      Builder lBuilder = builder();
			lBuilder.setProperty(pProperty);
	  return lBuilder;
    }
    
    
    
    

					
	

					
	/**
	 * Class implements builder to create a new instance of class DataTypeWithDerivedProperty. As the class has readonly attributes
	 * or associations instances can not be created directly. Instead this builder class has to be used.
	 */
	public static class Builder extends DataTypeWithDerivedProperty.BuilderBase {
	  /**
	   * Use {@link DataTypeWithDerivedProperty#builder()} instead of protected constructor to create new builder.
	   */
	  protected Builder( ) {
	  }
	
	  /**
	   * Use {@link DataTypeWithDerivedProperty#builder(DataTypeWithDerivedProperty)} instead of protected constructor to create new builder.
	   */
	  protected Builder( DataTypeWithDerivedProperty pObject ) {
	    super(pObject);
	  }
	
	  
	}

					
					
    
/**
 * Method returns attribute {@link #derivedProperty}.<br/>
 * @return {@link String} Value to which {@link #derivedProperty} is set.
 */

    
    

    @Override
    public String getDerivedProperty() {
        // TODO Implement method for derived property "derivedProperty".
        
        return null;
        
    }

					

				  

				}
			