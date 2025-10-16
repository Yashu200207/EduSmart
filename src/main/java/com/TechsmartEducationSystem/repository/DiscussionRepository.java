package com.TechsmartEducationSystem.repository;

import com.TechsmartEducationSystem.model.Discussion;
import com.TechsmartEducationSystem.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DiscussionRepository extends JpaRepository<Discussion, Long> {
    List<Discussion> findByCourseIdOrderBySentAtAsc(Long courseId);
}
