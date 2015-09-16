package springwstest.service;

import springwstest.dto.Message;

import java.util.List;

public interface IMessageStorageService {

    void addMessage(Message message);

    List<Message> getMessages();
}
