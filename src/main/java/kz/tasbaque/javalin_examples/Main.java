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

        app.get("/", ctx -> {
            HashMap<String, Object> map = new HashMap<String, Object>() {
                {
                    put("title", "My message desc");
                }
            };
            map.put("messages", new ArrayList<Message>() {{
                add(new Message("chrome", "Hi there!!"));
                add(new Message("arpanetus", "Hello!!!!!"));
            }});
            ctx.renderMustache("template/layout.mustache", map);
        });
    }
}
