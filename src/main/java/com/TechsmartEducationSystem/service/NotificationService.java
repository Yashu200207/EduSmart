package com.TechsmartEducationSystem.service;

import com.TechsmartEducationSystem.model.Discussion;
import com.TechsmartEducationSystem.repository.DiscussionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final DiscussionRepository discussionRepository;

    public Discussion saveMessage(Discussion discussion) {
        return discussionRepository.save(discussion);
    }
}
