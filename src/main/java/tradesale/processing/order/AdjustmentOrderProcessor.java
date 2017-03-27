package tradesale.processing.order;

import static tradesale.processing.utils.MessageConstants.OPERATION_ADD;
import static tradesale.processing.utils.MessageConstants.OPERATION_MULTIPLY;
import static tradesale.processing.utils.MessageConstants.OPERATION_SUBTRACT;
import static tradesale.processing.utils.MessageConstants.ORDER_TYPE_ADJUSTMENT;

import java.util.List;


/**
 * The Class AdjustmentOrderProcessor to process Adjustment type of order
 */
public class AdjustmentOrderProcessor implements BaseProcessor {


	/**
	 * Instantiates a new adjustment order processor.
	 */
	public AdjustmentOrderProcessor()
	{
	}
	
	/* (non-Javadoc)
	 * @see tradesale.processing.order.BaseProcessor#processOrder(tradesale.processing.order.SalesOrder)
	 */
	public void processOrder(SalesOrder sOrder) {
		SalesOrderCache salesOrderCache = SalesOrderCache.getInstance();
		
		//find all the orders with product of the sales order
		String productName = sOrder.getProduct().getName();
		
		List<SalesOrder> salesOrders = salesOrderCache.getSalesOrders();
		salesOrders.add(sOrder);
		
		//get cache and process the same product order
		//if its add adjustment add the price to all existing product sales orders
		if(sOrder.getOperation().equals(OPERATION_ADD) ) {
			for (SalesOrder order : salesOrders) {
				if (!order.getOrderType().equals(ORDER_TYPE_ADJUSTMENT) && order.getProduct().getName().equals(productName)) {
					double newPrice = order.getProductPrice() + sOrder.getProductPrice();
					order.setProductPrice(newPrice);
					System.out.println(order);
				}
			}		
		//if its subtract adjustment subtract the price from all existing product sales order price
		} else if(sOrder.getOperation().equals(OPERATION_SUBTRACT)) {
			for (SalesOrder order : salesOrders) {
				if (!order.getOrderType().equals(ORDER_TYPE_ADJUSTMENT)&& order.getProduct().getName().equals(productName)) {
					double newPrice = order.getProductPrice() - sOrder.getProductPrice();
					order.setProductPrice(newPrice);
				}
			}		
			//if its multiply adjustment multiply the price of all existing product sales order price
		} else if(sOrder.getOperation().equals(OPERATION_MULTIPLY)) {
			for (SalesOrder order : salesOrders) {
				if (!order.getOrderType().equals(ORDER_TYPE_ADJUSTMENT) && order.getProduct().getName().equals(productName)) {
					double newPrice = order.getProductPrice() * sOrder.getProductPrice();
					order.setProductPrice(newPrice);
				}
			}		
		}
		
	}

}
