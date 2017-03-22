package tradesale.processing.product;

import java.util.HashMap;
import java.util.Set;

/**
 * The Class ProductPool.
 */
public class ProductPool {
	
	/** The pool. */
	private HashMap<String, Product> pool = new HashMap<String, Product>();
	
	/** The pool instance. */
	private static ProductPool poolInstance;
	
	static {
		poolInstance = new ProductPool();
	}
	
	/**
	 * Instantiates a new product pool.
	 */
	private ProductPool() {
	}
	
	/**
	 * Gets the single instance of ProductPool.
	 *
	 * @return single instance of ProductPool
	 */
	public static synchronized ProductPool getInstance() {
		return poolInstance;
	}
	
	/**
	 * Gets the product if already existing else create a new and returns
	 *
	 * @param productName the product name
	 * @return the product
	 */
	public Product getProduct(String productName) {
		Product product = (Product) pool.get(productName);
		if(product == null){
			product = new Product(productName);
			pool.put(productName, product);
		}
		return product;
	}
	
	/**
	 * Checks if is existing product.
	 *
	 * @param productName the product name
	 * @return true, if is existing product
	 */
	public boolean isExistingProduct(String productName) {
		Product product = (Product) pool.get(productName);
		if(product == null){
			return false;
		}
		return true;
	}
	
	/**
	 * Gets the set of products.
	 *
	 * @return the products
	 */
	public Set<String> getProducts() {
		return pool.keySet();
	}
	
}
