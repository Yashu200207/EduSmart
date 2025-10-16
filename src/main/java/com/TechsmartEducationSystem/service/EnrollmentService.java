package com.TechsmartEducationSystem.service;

import com.TechsmartEducationSystem.model.Enrollment;
import com.TechsmartEducationSystem.model.User;
import com.TechsmartEducationSystem.repository.EnrollmentRepository;
import com.TechsmartEducationSystem.repository.CourseRepository;
import com.TechsmartEducationSystem.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepo;
    private final UserRepository userRepo;
    private final CourseRepository courseRepo;

    public EnrollmentService(EnrollmentRepository enrollmentRepo, UserRepository userRepo, CourseRepository courseRepo){
        this.enrollmentRepo = enrollmentRepo;
        this.userRepo = userRepo;
        this.courseRepo = courseRepo;
    }

    public List<Enrollment> getEnrollmentsByUsername(String username){
        User u = userRepo.findByUsername(username).orElseThrow();
        return enrollmentRepo.findByUser(u);
    }

    public Enrollment enroll(String username, Long courseId){
        User u = userRepo.findByUsername(username).orElseThrow();
        var course = courseRepo.findById(courseId).orElseThrow();
        Enrollment e = new Enrollment();
        e.setUser(u); e.setCourse(course); e.setProgress(0);
        return enrollmentRepo.save(e);
    }

    public Enrollment updateProgress(String username, Long courseId, int progress){
        var opt = enrollmentRepo.findByUserIdAndCourseId(userRepo.findByUsername(username).get().getId(), courseId);
        var en = opt.orElseThrow();
        en.setProgress(progress);
        return enrollmentRepo.save(en);
    }
}
