package kz.tasbaque.javalin_examples;

import io.javalin.Handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MessagesController {
    public static Handler index = ctx -> {
        Map<String, Object> map = new HashMap<String, Object>() {
            {
                put("title", "My message desc");
            }
        };
        map.put("messages", new ArrayList<Message>() {{
            add(new Message("chrome", "Hi there!!"));
            add(new Message("arpanetus", "Hello!!!!!"));
        }});
        ctx.renderMustache("template/layout.mustache", map);
    };
}
