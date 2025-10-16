package com.TechsmartEducationSystem.controller;

import com.TechsmartEducationSystem.model.Discussion;
import com.TechsmartEducationSystem.service.DiscussionService;
import com.TechsmartEducationSystem.util.WebSocketUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/discussions")
@RequiredArgsConstructor
public class DiscussionController {

    private final DiscussionService discussionService;
    private final WebSocketUtil webSocketUtil;

    @GetMapping("/course/{courseId}")
    public List<Discussion> getCourseDiscussions(@PathVariable Long courseId){
        return discussionService.findByCourse(courseId);
    }

    @PostMapping
    public Discussion sendMessage(@RequestBody Discussion discussion){
        Discussion saved = discussionService.save(discussion);
        webSocketUtil.sendMessage("/topic/discussions/"+discussion.getCourse().getId(), saved);
        return saved;
    }
}
