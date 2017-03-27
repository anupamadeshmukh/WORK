package tradesale.processing.msgreceiver;

import static tradesale.processing.utils.MessageConstants.ORDER_TYPE_ADJUSTMENT;
import static tradesale.processing.utils.MessageConstants.ORDER_TYPE_MULTIPLE;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

import tradesale.processing.utils.MessageConstants.MSG_KEY;
import tradesale.processing.utils.MessageValidator;


/**
 * JMS Message receiver receives and uses the ordermanagerService for processing the 
 * message further.
 *
 * @author anupama
 */
public class MsgReceiver implements MessageListener {
	
	/** The service mgr. */
	private OrderManagerServiceImpl serviceMgr;
    
	/**
	 * Gets the service mgr.
	 *
	 * @return the service mgr
	 */
	public OrderManagerServiceImpl getServiceMgr() {
		return serviceMgr;
	}

	/**
	 * Sets the service mgr.
	 *
	 * @param serviceMgr the new service mgr
	 */
	public void setServiceMgr(OrderManagerServiceImpl serviceMgr) {
		this.serviceMgr = serviceMgr;
	}
	

	public void onMessage(final Message message) {
    	try {
	    	if (message instanceof MapMessage) {
	    		MapMessage mapMessage = (MapMessage) message;
	    		//validate if it's supported message type (SINGLE, MULTIPLE, ADJSUTMENT)
	    		if (!MessageValidator.isValidOrderType( (String) mapMessage.getObject(MSG_KEY.ORDERTYPE.name())))
	    		{
	    			System.out.println("Invalid Order Type");
	    			return;
	    		}
	    		else {
	    			// Get order details into transfer object
	    			OrderTO order = new OrderTO();
	    			String orderType = (String) mapMessage.getObject(MSG_KEY.ORDERTYPE.name());
	    			order.setOrderType(orderType);
	    			String productName = (String)mapMessage.getObject(MSG_KEY.PRODUCT.name());
	    			order.setProduct(productName);
	    			order.setProductPrice((Double)mapMessage.getObject(MSG_KEY.PRODUCTPRICE.name()));
	    			order.setProductPriceUnit((String)mapMessage.getObject(MSG_KEY.PRODUCTPRICEUNIT.name()));
	    			String productOperation = (String)mapMessage.getObject(MSG_KEY.PRODUCTOPERATION.name());
	    			order.setProductOperation(productOperation);
		    		System.out.println("Order Details : " + order);
	    			//Check if its valid adjustment (ADD, SUBTRACT, MULTIPLY)
	    			if(orderType.equals(ORDER_TYPE_ADJUSTMENT) && !MessageValidator.isValidProductOperation(productOperation)) {
		    			System.out.println("Invalid Product Operation");
		    			return;
	    			}
	    			//Check if the adjustment is for valid product
	    			if(orderType.equals(ORDER_TYPE_ADJUSTMENT) && !MessageValidator.isValidProduct(productName)) {
	    				System.out.println("Invalid Product Adjustment");
	    				return;
	    			}
	    			//If its a bulk order initialize the unit
	    			if(orderType.equals(ORDER_TYPE_MULTIPLE)) {
	    				order.setProductUnit((Integer)mapMessage.getObject(MSG_KEY.PRODUCTUNITS.name())); 
	    			}
	    			//Execute the order
	    			serviceMgr.executeOrder(order);
	    		}
	    	} else {
	    		System.out.println("Unsupported Message Type");
	    	}
    	}
	    catch (JMSException jmsEx) {
	    	System.out.println("Incorrect MessageFormat.");
	    	jmsEx.printStackTrace();
	    }
    	 catch (Exception e) {
 	    	System.out.println("Exception in processing the order");
 	    	e.printStackTrace();
    	}
    }

}
