package com.TechsmartEducationSystem.controller;

import com.TechsmartEducationSystem.model.Enrollment;
import com.TechsmartEducationSystem.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dashboard")
@RequiredArgsConstructor
public class DashBoardController {

    private final EnrollmentService enrollmentService;

    // Get all enrollments for a user
    @GetMapping("/enrollments/{username}")
    public List<Enrollment> getEnrollments(@PathVariable String username) {
        return enrollmentService.getEnrollmentsByUsername(username);
    }

    // Enroll user in a course
    @PostMapping("/enroll/{username}/{courseId}")
    public Enrollment enrollCourse(@PathVariable String username, @PathVariable Long courseId) {
        return enrollmentService.enroll(username, courseId);
    }

    // Update progress for a course
    @PostMapping("/progress/{username}/{courseId}")
    public Enrollment updateProgress(@PathVariable String username,
                                     @PathVariable Long courseId,
                                     @RequestBody ProgressRequest req) {
        return enrollmentService.updateProgress(username, courseId, req.progress());
    }

    // Inner record class to deserialize progress JSON
    public record ProgressRequest(int progress) {}
}
