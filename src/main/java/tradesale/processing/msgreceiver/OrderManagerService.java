package tradesale.processing.msgreceiver;

import tradesale.processing.report.ReportService;

/**
 * Service for execution of the received order.
 *
 * @author anupama
 */
public interface OrderManagerService {
	
	/**
	 * Execute order.
	 *
	 * @param order to be executed
	 */
	public void executeOrder(OrderTO order);
	
	/**
	 * Gets the report service.
	 *
	 * @return the report service
	 */
	public ReportService getReportService();
	
	/**
	 * Sets the report service.
	 *
	 * @param reportService the new report service
	 */
	public void setReportService(ReportService reportService);
}
