package tradesale.processing.order;
import static tradesale.processing.utils.MessageConstants.ORDER_TYPE_ADJUSTMENT;
import static tradesale.processing.utils.MessageConstants.ORDER_TYPE_MULTIPLE;
import static tradesale.processing.utils.MessageConstants.ORDER_TYPE_SINGLE;


/**
 * A factory for creating Processor objects.
 */
public class ProcessorFactory {
	
	/**
	 * Gets the order processor.
	 *
	 * @param orderType the order type
	 * @return the order processor
	 */
	public static BaseProcessor getOrderProcessor(String orderType)
	{
		BaseProcessor processor = null;
		if(orderType.equals(ORDER_TYPE_SINGLE)) {
			processor = new SingleOrderProcessor();
		}
		else if(orderType.equals(ORDER_TYPE_MULTIPLE)) {
			processor = new MultipleOrderProcessor();
		}
		else if(orderType.equals(ORDER_TYPE_ADJUSTMENT)) {
			processor = new AdjustmentOrderProcessor();
		}
		return processor;
	}
}
