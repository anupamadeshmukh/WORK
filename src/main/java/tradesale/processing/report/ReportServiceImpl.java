package tradesale.processing.report;

import static tradesale.processing.utils.MessageConstants.ORDER_TYPE_ADJUSTMENT;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import tradesale.processing.order.SalesOrder;
import tradesale.processing.order.SalesOrderCache;
import tradesale.processing.product.ProductPool;
import tradesale.processing.report.model.ProductReportPojo;



/**
 * The Class ReportServiceImpl.
 */
public class ReportServiceImpl implements ReportService{
	
	/* (non-Javadoc)
	 * @see tradesale.processing.report.ReportService#generateOrderReport()
	 */
	public void generateOrderReport() {
		SalesOrderCache salesOrderCache = SalesOrderCache.getInstance();
		List<SalesOrder> orders = salesOrderCache.getSalesOrders();
		List<ProductReportPojo> reportOrders = new ArrayList<ProductReportPojo>();
		//if there are no orders into the memory then do not generate the report
		if(orders.size() == 0) {
			System.out.println("No orders to Report");
		} else {

			//find total sales orders and total price for product
			Set<String> products = ProductPool.getInstance().getProducts();
			for(String name : products){
				List<SalesOrder> filteredOrders = orders.stream()
				        .filter(o -> o.getProductName().equals(name))
				        .collect(Collectors.toList());
				
				//total units
				int sumUnits = filteredOrders.stream().collect(Collectors.summingInt(
																	o -> o.getProductUnit() ));
				//total product price
				double sumPrice = filteredOrders.stream().collect(Collectors.summingDouble(
																	o -> (o.getProductUnit() * o.getProductPrice()) ));
				String currency = filteredOrders.get(0).getProductPriceUnit();
				reportOrders.add(new ProductReportPojo(name, sumPrice, currency, sumUnits));
			}
	        
			System.out.println("=============================================================================");
			System.out.println("Product Sales Order Report");
			System.out.println("=============================================================================");
			System.out.println("Product \t Price \t Currency \t Unit");
			System.out.println("-----------------------------------------------------------------------------");
			for(int i=0; i < reportOrders.size();i++) {
				ProductReportPojo rOrder = (ProductReportPojo)(reportOrders.get(i));
				System.out.println(rOrder.getName() + " \t " + rOrder.getPrice() + " \t " 
						+ rOrder.getCurrency() + " \t " + rOrder.getUnit());
			}
			System.out.println("-----------------------------------------------------------------------------");
			System.out.println("Total Orders : " + orders.size());
			System.out.println("-----------------------------------------------------------------------------");
		}
	}
	
	
	/* (non-Javadoc)
	 * @see tradesale.processing.report.ReportService#generateAdjustmentReport()
	 */
	public void generateAdjustmentReport()  {
		SalesOrderCache salesOrderCache = SalesOrderCache.getInstance();
		List<SalesOrder> sOrders = salesOrderCache.getSalesOrders();
		//filter adjustments only
		List<SalesOrder> filteredAdjustment = sOrders.stream()
		        .filter(f -> f.getOrderType().equals(ORDER_TYPE_ADJUSTMENT))
		        .collect(Collectors.toList());
		//if there are no adjustments into the memory then do not generate the report
		if(sOrders.size() == 0) {
			System.out.println("No Adjustments to Report");
			return;
		}
		
		System.out.println("=============================================================================");
		System.out.println("Adjustment Sales Order Report");
		System.out.println("=============================================================================");
		System.out.println("Product \t Price \t Adjustment");
		System.out.println("-----------------------------------------------------------------------------");
		for(int i=0; i < filteredAdjustment.size();i++) {
			SalesOrder sOrder = (SalesOrder)filteredAdjustment.get(i);
			System.out.println(sOrder.getProduct() + " \t " + sOrder.getProductPrice() + " \t " 
						+ sOrder.getOperation());
		}
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Total Adjustment : " + filteredAdjustment.size());
		System.out.println("-----------------------------------------------------------------------------");
	}
}
