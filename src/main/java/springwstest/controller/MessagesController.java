package springwstest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import springwstest.dto.Message;
import springwstest.service.IMessageService;

@Controller
public class MessagesController {

    @Autowired
    IMessageService messageService;

    @MessageMapping("/random")
    @SendTo("/topic/random")
    public Message randomMessage() throws InterruptedException {
        System.out.println("randomMessage called");
        Thread.sleep(1000);
        return messageService.getRandomMessage();
    }

}
