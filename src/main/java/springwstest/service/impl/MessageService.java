package springwstest.service.impl;

import org.springframework.stereotype.Service;
import springwstest.dto.Message;
import springwstest.service.IMessageService;

import java.util.Random;

@Service
public class MessageService implements IMessageService {

    private static Random random = new Random();

    @Override
    public Message getRandomMessage() {
        Message m = new Message();
        m.setAuthor("random");
        m.setMessage("Random message, int " + random.nextInt(1000));
        return m;
    }
}
