package tradesale.processing.order;


/**
 * The Class SingleOrderProcessor to process single order type.
 */
public class SingleOrderProcessor implements BaseProcessor {

	/**
	 * Instantiates a new single order processor.
	 */
	public SingleOrderProcessor()
	{
	}
	
	/* (non-Javadoc)
	 * @see tradesale.processing.order.BaseProcessor#processOrder(tradesale.processing.order.SalesOrder)
	 */
	public void processOrder(SalesOrder order) {
		SalesOrderCache salesOrderCache = SalesOrderCache.getInstance();
		order.setProductUnit(1);
		salesOrderCache.addSalesOrder(order);
	}

}
