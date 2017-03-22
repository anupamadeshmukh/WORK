package tradesale.processing.msgreceiver;

/**
 * The Class OrderTO.
 */
public class OrderTO {
	
	/** The order type. */
	private String orderType;
	
	/** The product. */
	private String product;
	
	/** The product price. */
	private Double productPrice;
	
	/** The product price unit. */
	private String productPriceUnit; 
	
	/** The product unit. */
	private Integer productUnit;
	
	/** The product operation. */
	private String productOperation;
	
	/**
	 * Instantiates a new order TO.
	 */
	public OrderTO() {}
	
	/**
	 * Gets the order type.
	 *
	 * @return the order type
	 */
	public String getOrderType() {
		return orderType;
	}
	
	/**
	 * Sets the order type.
	 *
	 * @param orderType the new order type
	 */
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	
	/**
	 * Gets the product.
	 *
	 * @return the product
	 */
	public String getProduct() {
		return product;
	}
	
	/**
	 * Sets the product.
	 *
	 * @param product the new product
	 */
	public void setProduct(String product) {
		this.product = product;
	}
	
	/**
	 * Gets the product price.
	 *
	 * @return the product price
	 */
	public double getProductPrice() {
		return productPrice;
	}
	
	/**
	 * Sets the product price.
	 *
	 * @param productPrice the new product price
	 */
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	
	/**
	 * Gets the product price unit.
	 *
	 * @return the product price unit
	 */
	public String getProductPriceUnit() {
		return productPriceUnit;
	}
	
	/**
	 * Sets the product price unit.
	 *
	 * @param productPriceUnit the new product price unit
	 */
	public void setProductPriceUnit(String productPriceUnit) {
		this.productPriceUnit = productPriceUnit;
	}
	
	/**
	 * Gets the product unit.
	 *
	 * @return the product unit
	 */
	public Integer getProductUnit() {
		return productUnit;
	}
	
	/**
	 * Sets the product unit.
	 *
	 * @param productUnit the new product unit
	 */
	public void setProductUnit(Integer productUnit) {
		this.productUnit = productUnit;
	}
	
	/**
	 * Gets the product operation.
	 *
	 * @return the product operation
	 */
	public String getProductOperation() {
		return productOperation;
	}
	
	/**
	 * Sets the product operation.
	 *
	 * @param productOperation the new product operation
	 */
	public void setProductOperation(String productOperation) {
		this.productOperation = productOperation;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Order Type:" + orderType + " Product:" + product + " Price:" + productPrice 
				+ " Currency:" + productPriceUnit + " Unit:" + productUnit + " Adjustment Type:" + productOperation;
	}
}
