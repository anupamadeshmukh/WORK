package tradesale.processing.msgsender;

import java.util.Map;

import org.springframework.jms.core.JmsTemplate;


/**
 * The Class MsgSender is used to send messages.
 */
public class MsgSender {

    /** The jms template. */
    private JmsTemplate jmsTemplate;

    /**
     * Sets the jms template.
     *
     * @param jmsTemplate the new jms template
     */
    public void setJmsTemplate(JmsTemplate jmsTemplate) {
     this.jmsTemplate = jmsTemplate;
    }

    /**
     * Gets the jms template.
     *
     * @return the jms template
     */
    public JmsTemplate getJmsTemplate() {
        return this.jmsTemplate;
    }

    /**
     * Send the message by converting to proper format.
     *
     * @param object the object
     */
    public void send(final Map object) {
    	jmsTemplate.convertAndSend(object);
    }

}
