package tradesale.processing.order;

import java.util.ArrayList;


/**
 * The Class SalesOrderCache.
 */
public class SalesOrderCache {
	
	/** The sales orders. */
	private ArrayList<SalesOrder> salesOrders;

	/**
	 * Instantiates a new sales order cache.
	 */
	private SalesOrderCache()
	{
		salesOrders = new ArrayList<SalesOrder>();
	}
	
	/** The instance. */
	private static SalesOrderCache instance;
	
	/**
	 * Gets the single instance of SalesOrderCache.
	 *
	 * @return single instance of SalesOrderCache
	 */
	public static synchronized SalesOrderCache getInstance() {
		if(instance == null) {
			instance = new SalesOrderCache();
		}
		return instance;
	}

	/**
	 * Gets the sales orders.
	 *
	 * @return the sales orders
	 */
	public ArrayList<SalesOrder> getSalesOrders() {
		return salesOrders;
	}
	
	/**
	 * Adds the sales order.
	 *
	 * @param order the order
	 */
	public void addSalesOrder(SalesOrder order) {
		salesOrders.add(order);
	}
	
	/**
	 * Update sales order.
	 *
	 * @param order the order
	 */
	public void updateSalesOrder(SalesOrder order) {
		salesOrders.add(order);
	}
	
}
