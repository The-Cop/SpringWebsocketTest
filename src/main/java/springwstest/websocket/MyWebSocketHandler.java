package springwstest.websocket;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

public class MyWebSocketHandler extends TextWebSocketHandler {

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
        System.out.println("Message came: " + message.getPayload());
        WebSocketMessage response = new TextMessage("Woah! You said " + message.getPayload()+"?");
        try {
            session.sendMessage(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

