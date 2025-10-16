package com.TechsmartEducationSystem.repository;

import com.TechsmartEducationSystem.model.Enrollment;
import com.TechsmartEducationSystem.model.User;
import com.TechsmartEducationSystem.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    List<Enrollment> findByUser(User user);
    Optional<Enrollment> findByUserIdAndCourseId(Long userId, Long courseId);
}
