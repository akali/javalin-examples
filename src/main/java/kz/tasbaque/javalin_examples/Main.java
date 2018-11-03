package kz.tasbaque.javalin_examples;

import io.javalin.Javalin;
import kz.tasbaque.javalin_examples.controller.MessagesController;

public class Main {
    public static void main(String[] args) {
        Javalin app = Javalin
            .create()
            .port(3000)
            .start();

        app.get("/", MessagesController.index);
        app.post("/", MessagesController.newMessage);

        app.get("/:author", MessagesController.getAuthorPosts);
    }
}
