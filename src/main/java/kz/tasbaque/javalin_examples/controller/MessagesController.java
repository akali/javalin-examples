package kz.tasbaque.javalin_examples.controller;

import io.javalin.Handler;
import io.netty.handler.codec.http.QueryStringDecoder;
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
        QueryStringDecoder qsd = new QueryStringDecoder("?" + ctx.body());

        Message message = new Message(
            qsd.parameters().get("message").get(0),
            qsd.parameters().get("author").get(0));

        MessagesDao.getInstance().getMessages().add(message);

        Map<String, Object> map = new HashMap<String, Object>() {
            {
                put("title", "My message desc");
            }
        };
        map.put("messages", MessagesDao.getInstance().getMessages());
        ctx.renderMustache("template/layout.mustache", map);
    };
    public static Handler getAuthorPosts = ctx -> {

        Map<String, Object> map = new HashMap<String, Object>() {
            {
                put("title", "My message desc");
            }
        };
        map.put("messages", MessagesDao.getInstance().getMessagesOfAuthor(ctx.param("author")));

        ctx.renderMustache("template/layout.mustache", map);
    };
}
