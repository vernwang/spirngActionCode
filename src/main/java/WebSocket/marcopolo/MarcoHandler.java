package WebSocket.marcopolo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

public class MarcoHandler extends AbstractWebSocketHandler{

	private static final Logger LOGGER=LoggerFactory.getLogger(MarcoHandler.class);
	
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		
		LOGGER.info("receive"+message.getPayload());
		
		Thread.sleep(2000);
		
		session.sendMessage(new TextMessage("Polo!"));
	}


    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {

        LOGGER.info("123");

    }
}
