package kz.tasbaque.javalin_examples;

import io.javalin.Javalin;

public class Main {
    public static void main(String[] args) {
        Javalin app = Javalin
            .create()
            .port(3000)
            .start();

        app.get("/", ctx -> {
            ctx.html("yaaay");
        });
    }
}
