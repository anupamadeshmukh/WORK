package tradesale.processing.order;



/**
 * The Interface BaseProcessor.
 */
public interface BaseProcessor {

	/**
	 * Process order.
	 *
	 * @param order the order
	 */
	public void processOrder(SalesOrder order);
}
