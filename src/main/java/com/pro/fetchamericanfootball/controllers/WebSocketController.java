package com.pro.fetchamericanfootball.controllers;

import com.pro.fetchamericanfootball.models.Greeting;
import com.pro.fetchamericanfootball.models.HelloMessage;
import com.pro.fetchamericanfootball.services.CustomWebSocketService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class WebSocketController {

    CustomWebSocketService socketService = new CustomWebSocketService();

    @MessageMapping("/fetch")
    @SendTo("/bet/client")
    public Greeting greeting(HelloMessage message) throws Exception {
        socketService.connectTest();
        return new Greeting("This is response from American football, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }
}