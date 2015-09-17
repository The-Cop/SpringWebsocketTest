package springwstest.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import springwstest.websocket.MyWebSocketHandler;

import java.io.IOException;

@Component
public class ScheduledBroadcaster {

    @Scheduled(fixedRate = 2000)
    public void scheduledBroadcast() {
        try {
            MyWebSocketHandler.broadcast("This is broadcasted " + System.currentTimeMillis());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
