package tradesale.processing.utils;

import static tradesale.processing.utils.MessageConstants.OPERATION_ADD;
import static tradesale.processing.utils.MessageConstants.OPERATION_MULTIPLY;
import static tradesale.processing.utils.MessageConstants.OPERATION_SUBTRACT;
import static tradesale.processing.utils.MessageConstants.ORDER_TYPE_ADJUSTMENT;
import static tradesale.processing.utils.MessageConstants.ORDER_TYPE_MULTIPLE;
import static tradesale.processing.utils.MessageConstants.ORDER_TYPE_SINGLE;
import tradesale.processing.product.ProductPool;

/**
 * The Class MessageValidator.
 */
public class MessageValidator {
	
	/**
	 * Checks if is valid order type.
	 *
	 * @param orderType the order type
	 * @return true, if is valid order type
	 */
	public static boolean isValidOrderType(String orderType) {
		if(orderType == null) {
			return false;
		}	else if(orderType.equals(ORDER_TYPE_SINGLE) ||
						orderType.equals(ORDER_TYPE_MULTIPLE) ||
								orderType.equals(ORDER_TYPE_ADJUSTMENT)) {
				return true;
		}	else {
			return false;
		}
	}
	
	/**
	 * Checks if is valid product operation.
	 *
	 * @param productOperation the product operation
	 * @return true, if is valid product operation
	 */
	public static boolean isValidProductOperation(String productOperation) {
		if(productOperation == null) {
			return false;
		} else if(productOperation.equals(OPERATION_ADD) || 
					productOperation.equals(OPERATION_SUBTRACT) ||
						productOperation.equals(OPERATION_MULTIPLY)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Checks if is valid product.
	 *
	 * @param productName the product name
	 * @return true, if is valid product
	 */
	public static boolean isValidProduct(String productName) {
		return ProductPool.getInstance().isExistingProduct(productName);
	}	

}
