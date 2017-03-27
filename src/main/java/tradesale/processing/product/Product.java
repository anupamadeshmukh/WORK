package tradesale.processing.product;


/**
 * The Class Product.
 */
public class Product {
	
	/** The name. */
	private String name;
	
	/**
	 * Instantiates a new product.
	 *
	 * @param name the name
	 */
	public Product(String name)
	{
		this.name = name;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return name;
	}
}
