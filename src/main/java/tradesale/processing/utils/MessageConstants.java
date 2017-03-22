package tradesale.processing.utils;


/**
 * The Interface MessageConstants.
 *
 * @author anupama
 */
public interface MessageConstants {
	/*
	 * Product Sales Order types
	 */
	
	/** The Constant ORDER_TYPE_SINGLE. */
	public static final String ORDER_TYPE_SINGLE = "SINGLE";
	
	/** The Constant ORDER_TYPE_MULTIPLE. */
	public static final String ORDER_TYPE_MULTIPLE = "MULTIPLE";
	
	/** The Constant ORDER_TYPE_ADJUSTMENT. */
	public static final String ORDER_TYPE_ADJUSTMENT = "ADJUSTMENT";
	
	/** The Constant OPERATION_ADD. */
	public static final String OPERATION_ADD = "ADD"; 
	
	/** The Constant OPERATION_SUBTRACT. */
	public static final String OPERATION_SUBTRACT = "SUBTRACT";
	
	/** The Constant OPERATION_MULTIPLY. */
	public static final String OPERATION_MULTIPLY = "MULTIPLY";
		
	/** The Constant PRODUCT_PRICE_UNIT_PAISA. */
	public static final String PRODUCT_PRICE_UNIT_PAISA = "PAISA";
	
	/**
	 * The Enum MSG_KEY.
	 */
	/*
	 * Keys of the incoming message
	 */
	public enum MSG_KEY {
			/** The ordertype. */
			ORDERTYPE, 
			 /** The product. */
			 PRODUCT, 
			 /** The productprice. */
			 PRODUCTPRICE, 
			 /** The productpriceunit. */
			 PRODUCTPRICEUNIT, 
			 /** The productunits. */
			 PRODUCTUNITS, 
			 /** The productoperation. */
			 PRODUCTOPERATION };
	   	
}
