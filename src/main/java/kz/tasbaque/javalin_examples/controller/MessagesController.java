package kz.tasbaque.javalin_examples.controller;

import io.javalin.Handler;
import kz.tasbaque.javalin_examples.data.MessagesDao;
import kz.tasbaque.javalin_examples.model.Message;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MessagesController {
    public static Handler index = ctx -> {
        Map<String, Object> map = new HashMap<String, Object>() {
            {
                put("title", "My message desc");
            }
        };
        map.put("messages", MessagesDao.getInstance().getMessages());
        ctx.renderMustache("template/layout.mustache", map);
    };
    public static Handler newMessage = ctx -> {
        Message message = new Message();

        Arrays.stream(ctx.body().split("&"))
        .forEach(keyValue -> {

            String key = keyValue.split("=")[0];
            String value = keyValue.split("=")[1];

            switch (key.toLowerCase()) {
                case "message":
                    message.setMessage(value);
                    break;
                case "author":
                    message.setAuthor(value);
                    break;
            }
        });
        MessagesDao.getInstance().getMessages().add(message);

        System.err.println(message);

        Map<String, Object> map = new HashMap<String, Object>() {
            {
                put("title", "My message desc");
            }
        };
        map.put("messages", MessagesDao.getInstance().getMessages());
        ctx.renderMustache("template/layout.mustache", map);
    };
}
