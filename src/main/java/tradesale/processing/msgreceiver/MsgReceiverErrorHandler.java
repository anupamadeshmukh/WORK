package tradesale.processing.msgreceiver;

import org.springframework.util.ErrorHandler;

/**
 * Message Error handler.
 *
 * @author anupama
 */
public class MsgReceiverErrorHandler implements ErrorHandler {

    /* (non-Javadoc)
     * @see org.springframework.util.ErrorHandler#handleError(java.lang.Throwable)
     */
    @Override
    public void handleError(Throwable t) {
        System.out.println("Error in listener :" + t.getMessage());
    }
    
}
