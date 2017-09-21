package JMS;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.core.MessageCreator;

import spittr.Spittle;

public class AlertServiceImpl implements AlertService {

	
	private JmsOperations jms;
	
	@Autowired
	public AlertServiceImpl(JmsOperations jmsOperations) {
		// TODO Auto-generated constructor stub
		this.jms=jmsOperations;
	}
	
	
	@Override
	public void sendSpittleAlert(final Spittle spittle) {
		// TODO Auto-generated method stub
		jms.send("spittle.alert.queue", new MessageCreator() {
			
			@Override
			public Message createMessage(Session arg0) throws JMSException {
				// TODO Auto-generated method stub                                    
				return arg0.createObjectMessage(spittle);
			}
		});
		                                          
		jms.receive();
		
		
	}

}
