package tradesale.processing;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// TODO: Auto-generated Javadoc
/**
 * Main class which instantiates the Message Receiver.
 *
 * @author anupama
 */
public class TradeSaleProcessingService {
	   
   	/**
   	 * The main method.
   	 *
   	 * @param args the arguments
   	 */
   	public static void main(String[] args) {
		   ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	   }
}
