package com.TechsmartEducationSystem.service;

import com.TechsmartEducationSystem.model.Course;
import com.TechsmartEducationSystem.repository.CourseRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private final CourseRepository repo;

    public CourseService(CourseRepository repo) {
        this.repo = repo;
    }

    @Cacheable("courses")
    public List<Course> listAll() {
        return repo.findAll();
    }

    @Cacheable("courses")
    public List<Course> getAllCourses() {
        return repo.findAll();
    }

    public Course save(Course c) {
        return repo.save(c);
    }

    public Course addCourse(Course c) {
        return repo.save(c);
    }

    public Course getById(Long id) {
        return repo.findById(id).orElse(null);
    }
}
