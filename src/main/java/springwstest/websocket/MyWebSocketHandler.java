package springwstest.websocket;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class MyWebSocketHandler extends TextWebSocketHandler {

    private static Set<WebSocketSession> clients = Collections.synchronizedSet(new HashSet<WebSocketSession>());

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        clients.add(session);
        System.out.println("Client added");
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);
        if (clients.remove(session)) {
            System.out.println("Client removed successfully");
        } else {
            System.out.println("Client remove failed");
        }
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
        System.out.println("Message came: " + message.getPayload());
        WebSocketMessage response = new TextMessage("Woah! You said " + message.getPayload() + "?");
        try {
            session.sendMessage(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void broadcast(String message) throws IOException {
        System.out.println("Broadcasting on " + clients.size() + " clients. Time = " + System.currentTimeMillis());
        WebSocketMessage response = new TextMessage(message);
        for (WebSocketSession s : clients) {
            s.sendMessage(response);
        }
    }

}

