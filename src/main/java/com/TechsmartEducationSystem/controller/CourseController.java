package com.TechsmartEducationSystem.controller;

import com.TechsmartEducationSystem.model.Course;
import com.TechsmartEducationSystem.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.listAll();
    }

    @GetMapping("/{id}")
    public Course getCourse(@PathVariable Long id) {
        return courseService.getById(id);
    }

    @PostMapping
    public Course addCourse(@RequestBody Course c){
        return courseService.addCourse(c);
    }

    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course c){
        c.setId(id);
        return courseService.save(c);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id){
        // Optional: Implement soft delete or real delete
    }
}
