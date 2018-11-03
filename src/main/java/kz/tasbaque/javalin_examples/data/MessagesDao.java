package kz.tasbaque.javalin_examples.data;

import kz.tasbaque.javalin_examples.model.Message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MessagesDao {
    private static MessagesDao ourInstance = new MessagesDao();

    public static MessagesDao getInstance() {
        return ourInstance;
    }

    private List<Message> messages;

    private MessagesDao() {
        messages = new ArrayList<>();
        messages.add(new Message("chrome", "Hi there!!"));
        messages.add(new Message("arpanetus", "Hello!!!!!"));
    }

//    public List<Message> getMessageWithAuthor()

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
