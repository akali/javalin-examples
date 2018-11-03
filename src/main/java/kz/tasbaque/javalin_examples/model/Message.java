package kz.tasbaque.javalin_examples.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message {
    private String author, message;

    @Override
    public String toString() {
        return "Message{" +
            "author='" + author + '\'' +
            ", message='" + message + '\'' +
            ", localDateTime=" + localDateTime +
            '}';
    }

    public Message() {

    }

    public String getLocalDateTime() {
        return localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    private LocalDateTime localDateTime = LocalDateTime.now();

    public Message(String author, String message, LocalDateTime localDateTime) {
        this.author = author;
        this.message = message;
        this.localDateTime = localDateTime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Message(String author, String message) {
        this.author = author;
        this.message = message;
    }
}
