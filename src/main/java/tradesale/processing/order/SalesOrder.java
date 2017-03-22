package tradesale.processing.order;

import java.util.concurrent.atomic.AtomicInteger;

import tradesale.processing.product.Product;

/**
 * The Class SalesOrder.
 */
public class SalesOrder {
	
	/** The Constant soCount. */
	private static final AtomicInteger soCount = new AtomicInteger(0); 
	
	/** The order number. */
	private int orderNumber;
	
	/** The order type. */
	private String orderType;
	
	/** The product. */
	private Product product;
	
	/** The product price. */
	private double productPrice;
	
	/** The product price unit. */
	private String productPriceUnit; 
	
	/** The product unit. */
	private int productUnit;
	
	/** The operation. */
	private String operation;
	
	/**
	 * Instantiates a new sales order.
	 */
	public SalesOrder()
	{
		orderNumber = soCount.incrementAndGet(); 
	}
	
	/**
	 * Gets the order number.
	 *
	 * @return the order number
	 */
	public int getOrderNumber() {
		return orderNumber;
	}
	
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
	public Product getProduct() {
		return product;
	}
	
	/**
	 * Gets the product name.
	 *
	 * @return the product name
	 */
	public String getProductName() {
		return product.getName();
	}

	/**
	 * Sets the product.
	 *
	 * @param product the new product
	 */
	public void setProduct(Product product) {
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
	public void setProductPrice(double productPrice) {
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
	public int getProductUnit() {
		return productUnit;
	}
	
	/**
	 * Sets the product unit.
	 *
	 * @param productUnit the new product unit
	 */
	public void setProductUnit(int productUnit) {
		this.productUnit = productUnit;
	}
	
	/**
	 * Gets the operation.
	 *
	 * @return the operation
	 */
	public String getOperation() {
		return operation;
	}
	
	/**
	 * Sets the operation.
	 *
	 * @param operation the new operation
	 */
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		return orderNumber + "\t" + orderType + "\t" + product.getName() + "\t" + productPrice + "\t" 
				+ productPriceUnit + "\t" + productUnit + "\t" + (operation != null ? operation :"");
	}

}
