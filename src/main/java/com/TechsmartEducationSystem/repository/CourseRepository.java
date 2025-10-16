package com.TechsmartEducationSystem.repository;

import com.TechsmartEducationSystem.model.Course;
import com.TechsmartEducationSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> { }