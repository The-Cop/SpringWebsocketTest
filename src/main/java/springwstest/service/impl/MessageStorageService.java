package springwstest.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import springwstest.dto.Message;
import springwstest.service.IMessageStorageService;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Service
@Scope("singleton")
public class MessageStorageService implements IMessageStorageService {

    private static final int maxSize = 10;
    private LinkedList<Message> messages;

    @Override
    public void addMessage(Message message) {
        messages.addFirst(message);
        checkSize();
    }

    @Override
    public List<Message> getMessages() {
        return Collections.unmodifiableList(messages);
    }

    private void checkSize() {
        while (messages.size() > maxSize) {
            messages.removeLast();
        }
    }

}
