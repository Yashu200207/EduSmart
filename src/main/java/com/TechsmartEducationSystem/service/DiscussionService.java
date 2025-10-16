package com.TechsmartEducationSystem.service;

import com.TechsmartEducationSystem.model.Discussion;
import com.TechsmartEducationSystem.repository.DiscussionRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DiscussionService {
    private final DiscussionRepository repo;
    public DiscussionService(DiscussionRepository repo){ this.repo = repo; }

    public Discussion save(Discussion d){ return repo.save(d); }
    public List<Discussion> findByCourse(Long courseId){ return repo.findByCourseIdOrderBySentAtAsc(courseId); }
}
