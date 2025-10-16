package com.TechsmartEducationSystem.util;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class WebSocketUtil {

    private final SimpMessagingTemplate messagingTemplate;

    public WebSocketUtil(SimpMessagingTemplate messagingTemplate){
        this.messagingTemplate = messagingTemplate;
    }

    public void sendMessage(String destination, Object payload){
        messagingTemplate.convertAndSend(destination, payload);
    }
}
