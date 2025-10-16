package com.TechsmartEducationSystem.controller;

import com.TechsmartEducationSystem.model.Discussion;
import com.TechsmartEducationSystem.service.NotificationService;
import com.TechsmartEducationSystem.util.WebSocketUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;
    private final WebSocketUtil webSocketUtil;

    @GetMapping("/course/{courseId}")
    public List<Discussion> getNotifications(@PathVariable Long courseId){
        // Returns the recent notifications/messages for a course
        return notificationService.getAllByCourse(courseId);
    }

    @PostMapping
    public Discussion sendNotification(@RequestBody Discussion discussion){
        Discussion saved = notificationService.saveMessage(discussion);
        // Broadcast via WebSocket to subscribed clients
        webSocketUtil.sendMessage("/topic/notifications/" + discussion.getCourse().getId(), saved);
        return saved;
    }
}
