package tradesale.processing.msgreceiver;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.jms.listener.SimpleMessageListenerContainer;

import tradesale.processing.order.BaseProcessor;
import tradesale.processing.order.ProcessorFactory;
import tradesale.processing.order.SalesOrder;
import tradesale.processing.product.ProductPool;
import tradesale.processing.report.ReportService;



/**
 * The Class OrderManagerServiceImpl.
 */
public class OrderManagerServiceImpl implements OrderManagerService {
	
	/** The simple message listener container. */
	private SimpleMessageListenerContainer simpleMessageListenerContainer;
	
	/** The report service. */
	private ReportService reportService;
	 
	/**
	 * Gets the simple message listener container.
	 *
	 * @return the simple message listener container
	 */
	public SimpleMessageListenerContainer getSimpleMessageListenerContainer() {
		return simpleMessageListenerContainer;
	}
	
	/**
	 * Sets the simple message listener container.
	 *
	 * @param simpleMessageListenerContainer the new simple message listener container
	 */
	public void setSimpleMessageListenerContainer(
			SimpleMessageListenerContainer simpleMessageListenerContainer) {
		this.simpleMessageListenerContainer = simpleMessageListenerContainer;
	}
	
	/** The Constant msgCount. */
	private static final AtomicInteger msgCount = new AtomicInteger(0); 
	
	/**
	 * Instantiates a new order manager service impl.
	 */
	public OrderManagerServiceImpl() {
	}
	
	/* (non-Javadoc)
	 * @see tradesale.processing.msgreceiver.OrderManagerService#executeOrder(tradesale.processing.msgreceiver.OrderTO)
	 */
	public void executeOrder(OrderTO order) {
		int currentMsgCount = msgCount.incrementAndGet();
		System.out.println("Current Message Count : " + currentMsgCount);

		//Get processor based on the order type
		BaseProcessor processor = ProcessorFactory.getOrderProcessor(order.getOrderType());
		
		//create and process Sales Order
		SalesOrder sOrder = new SalesOrder();
		sOrder.setOrderType(order.getOrderType());
		sOrder.setProduct(ProductPool.getInstance().getProduct(order.getProduct()));
		sOrder.setProductPrice(order.getProductPrice());
		sOrder.setProductPriceUnit(order.getProductPriceUnit());
		
		if(order.getProductUnit() != null)
			sOrder.setProductUnit(order.getProductUnit());
		if(order.getProductOperation() != null)
		sOrder.setOperation(order.getProductOperation());
		
		processor.processOrder(sOrder);
		
		//after every 10th message report the products and their total Sales
		if(currentMsgCount%10 == 0) {
			System.out.println("Generating the Order Report - Start");
			reportService.generateOrderReport();
			System.out.println("Generating the Order Report - End");
		}
		if(currentMsgCount == 50) { 
		
			//After 50 messages your application should log that it is pausing, stop accepting new
			//messages and log a report of the adjustments that have been made to each sale type while
			//the application was running
			simpleMessageListenerContainer.stop();
			System.out.println("Generating the Adjustment Report - Start");
			reportService.generateAdjustmentReport();
			System.out.println("Generating the Adjustment Report - End");
		}
	}
	
	/* (non-Javadoc)
	 * @see tradesale.processing.msgreceiver.OrderManagerService#getReportService()
	 */
	public ReportService getReportService() {
		return reportService;
	}
	
	/* (non-Javadoc)
	 * @see tradesale.processing.msgreceiver.OrderManagerService#setReportService(tradesale.processing.report.ReportService)
	 */
	public void setReportService(ReportService reportService) {
		this.reportService = reportService;
	}
	
}
