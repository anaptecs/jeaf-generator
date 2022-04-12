package ch.voev.nova.inventory.api.masterdata;

/**
 * Coarse grained categorization of the product type. Used to determine the type of an Offer (see "OfferPartType").
 */
public enum ProductType {
  /**
   * 
   */
  ADMISSION,
  /**
   * 
   */
  RESERVATION,
  /**
   * 
   */
  ANCILLARY,
  /**
   * 
   */
  FEE;

  /**
   * Initialize object.
   */
  private ProductType( ) {
  }
}