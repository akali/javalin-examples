package kz.tasbaque.javalin_examples;

import io.javalin.Javalin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Javalin app = Javalin
            .create()
            .port(3000)
            .start();

        app.get("/", MessagesController.index);
    }
}
