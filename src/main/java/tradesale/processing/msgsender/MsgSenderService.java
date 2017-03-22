package tradesale.processing.msgsender;

import static tradesale.processing.utils.MessageConstants.OPERATION_ADD;
import static tradesale.processing.utils.MessageConstants.OPERATION_MULTIPLY;
import static tradesale.processing.utils.MessageConstants.OPERATION_SUBTRACT;
import static tradesale.processing.utils.MessageConstants.ORDER_TYPE_ADJUSTMENT;
import static tradesale.processing.utils.MessageConstants.ORDER_TYPE_MULTIPLE;
import static tradesale.processing.utils.MessageConstants.ORDER_TYPE_SINGLE;
import static tradesale.processing.utils.MessageConstants.PRODUCT_PRICE_UNIT_PAISA;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import tradesale.processing.utils.MessageConstants.MSG_KEY;


/**
 * The Class MsgSenderService.
 */
public class MsgSenderService {
	   
   	/**
   	 * The main method.
   	 *
   	 * @param args the arguments
   	 */
   	public static void main(String[] args) {
		   ApplicationContext context = new ClassPathXmlApplicationContext("mockApplicationContext.xml");
		   MsgSender sender = (MsgSender) context.getBean("messageSender");
		   
		   //Send First Type of Message
		   for(int i = 0; i< 5 ; i++) {
			   Map<String, Object> map1 = new HashMap <String, Object>();
			   map1.put(MSG_KEY.ORDERTYPE.name(), ORDER_TYPE_SINGLE);
			   map1.put(MSG_KEY.PRODUCT.name(), "Apple");
			   map1.put(MSG_KEY.PRODUCTPRICE.name(), 20.0+i);
			   map1.put(MSG_KEY.PRODUCTPRICEUNIT.name(), PRODUCT_PRICE_UNIT_PAISA);
			   map1.put(MSG_KEY.PRODUCTUNITS.name(), i);	
			   sender.send(map1);
		   }

		   for(int i = 0; i< 5 ; i++) {
			   Map<String, Object> map1 = new HashMap <String, Object>();
			   map1.put(MSG_KEY.ORDERTYPE.name(), ORDER_TYPE_SINGLE);
			   map1.put(MSG_KEY.PRODUCT.name(), "Banana");
			   map1.put(MSG_KEY.PRODUCTPRICE.name(), 90.0+i);
			   map1.put(MSG_KEY.PRODUCTPRICEUNIT.name(), PRODUCT_PRICE_UNIT_PAISA);
			   map1.put(MSG_KEY.PRODUCTUNITS.name(), i);	
			   sender.send(map1);
		   }
		   
		   //Send Second Type of Message
		   for(int i = 0; i< 10 ; i++) {
			   Map<String, Object> map2 = new HashMap<String, Object>();
			   map2.put(MSG_KEY.ORDERTYPE.name(), ORDER_TYPE_MULTIPLE);
			   map2.put(MSG_KEY.PRODUCT.name(), "Mango");
			   map2.put(MSG_KEY.PRODUCTPRICE.name(), 40.0 + i);
			   map2.put(MSG_KEY.PRODUCTPRICEUNIT.name(), PRODUCT_PRICE_UNIT_PAISA);
			   map2.put(MSG_KEY.PRODUCTUNITS.name(), new Integer(2) + i);
			   sender.send(map2);
			}
		   
		   
		   	//Send Add Adjustments
			for(int i = 0; i< 10 ; i++) {
			   Map<String, Object> map3 = new HashMap<String, Object>();
			   map3.put(MSG_KEY.ORDERTYPE.name(), ORDER_TYPE_ADJUSTMENT);
			   map3.put(MSG_KEY.PRODUCT.name(), "Apple");
			   map3.put(MSG_KEY.PRODUCTPRICE.name(), new Double(i));
			   map3.put(MSG_KEY.PRODUCTPRICEUNIT.name(), PRODUCT_PRICE_UNIT_PAISA);
			   map3.put(MSG_KEY.PRODUCTOPERATION.name(), OPERATION_ADD);
			   sender.send(map3);
			}
			
			
			//Send Subtract Adjustments
			for(int i = 1; i<= 5 ; i++) {
			   Map<String, Object> map3 = new HashMap<String, Object>();
			   map3.put(MSG_KEY.ORDERTYPE.name(), ORDER_TYPE_ADJUSTMENT);
			   map3.put(MSG_KEY.PRODUCT.name(), "Banana");
			   map3.put(MSG_KEY.PRODUCTPRICE.name(), new Double(i));
			   map3.put(MSG_KEY.PRODUCTPRICEUNIT.name(), PRODUCT_PRICE_UNIT_PAISA);
			   map3.put(MSG_KEY.PRODUCTOPERATION.name(), OPERATION_SUBTRACT);
			   sender.send(map3);
			}

			//Send Multiply Adjustments
			Map<String, Object> map3 = new HashMap<String, Object>();
			map3.put(MSG_KEY.ORDERTYPE.name(), ORDER_TYPE_ADJUSTMENT);
			map3.put(MSG_KEY.PRODUCT.name(), "Mango");
			map3.put(MSG_KEY.PRODUCTPRICE.name(), 2.0);
			map3.put(MSG_KEY.PRODUCTPRICEUNIT.name(), PRODUCT_PRICE_UNIT_PAISA);
			map3.put(MSG_KEY.PRODUCTOPERATION.name(), OPERATION_MULTIPLY);
			sender.send(map3);
			   
			//Send Invalid Adjustment
			Map<String, Object> map4 = new HashMap<String, Object>();
			map4.put(MSG_KEY.ORDERTYPE.name(), ORDER_TYPE_ADJUSTMENT);
			map4.put(MSG_KEY.PRODUCT.name(), "Cherry");
			map4.put(MSG_KEY.PRODUCTPRICE.name(), 0.1);
			map4.put(MSG_KEY.PRODUCTPRICEUNIT.name(), PRODUCT_PRICE_UNIT_PAISA);
			map4.put(MSG_KEY.PRODUCTOPERATION.name(), OPERATION_SUBTRACT);
			sender.send(map4);


			
			
		   for(int i = 1; i<= 20 ; i++) {
			   Map<String, Object> map5 = new HashMap <String, Object>();
			   map5.put(MSG_KEY.ORDERTYPE.name(), ORDER_TYPE_SINGLE);
			   map5.put(MSG_KEY.PRODUCT.name(), "Pineapple");
			   map5.put(MSG_KEY.PRODUCTPRICE.name(), 20.0+i);
			   map5.put(MSG_KEY.PRODUCTPRICEUNIT.name(), PRODUCT_PRICE_UNIT_PAISA);
			   map5.put(MSG_KEY.PRODUCTUNITS.name(), i);	
			   sender.send(map5);
		   }
		
			
	   }
}
