package tradesale.processing.order;


/**
 * The Class MultipleOrderProcessor will process AULTIPLE type of Sales orders
 */
public class MultipleOrderProcessor implements BaseProcessor  {
	
	/**
	 * Instantiates a new multiple order processor.
	 */
	public MultipleOrderProcessor()
	{
	}
	
	/* (non-Javadoc)
	 * @see tradesale.processing.order.BaseProcessor#processOrder(tradesale.processing.order.SalesOrder)
	 */
	public void processOrder(SalesOrder order) {
		SalesOrderCache salesOrderCache = SalesOrderCache.getInstance();		
		salesOrderCache.addSalesOrder(order);
	}

	
}
