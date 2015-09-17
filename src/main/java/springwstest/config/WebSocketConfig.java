package springwstest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.HandshakeInterceptor;
import springwstest.websocket.MyHandshakeInterceptor;
import springwstest.websocket.MyWebSocketHandler;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    // http://docs.spring.io/spring-framework/docs/current/spring-framework-reference/html/websocket.html
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(myHandler(), "/myHandler")
                .addInterceptors(myHandshakeInterceptor());
    }

    @Bean
    public WebSocketHandler myHandler() {
        return new MyWebSocketHandler();
    }

    @Bean
    public HandshakeInterceptor myHandshakeInterceptor(){
        return new MyHandshakeInterceptor();
    }
}
