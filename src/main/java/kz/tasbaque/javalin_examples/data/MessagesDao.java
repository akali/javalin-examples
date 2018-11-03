package kz.tasbaque.javalin_examples.data;

import kz.tasbaque.javalin_examples.model.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MessagesDao {
    private static MessagesDao ourInstance = new MessagesDao();
    private List<Message> messages;

    private MessagesDao() {
        messages = new ArrayList<>();
        messages.add(new Message("chrome", "Hi there!!"));
        messages.add(new Message("arpanetus", "Hello!!!!!"));
    }

    public static MessagesDao getInstance() {
        return ourInstance;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Message> getMessagesOfAuthor(String author) {
        return
            this.messages.stream()
                .filter(message -> author.equals(message.getAuthor()))
                .collect(Collectors.toList());
    }
}
