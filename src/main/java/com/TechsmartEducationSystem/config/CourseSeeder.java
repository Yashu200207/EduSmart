package com.TechsmartEducationSystem.config;

import com.TechsmartEducationSystem.model.Course;
import com.TechsmartEducationSystem.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CourseSeeder implements CommandLineRunner {

    private final CourseRepository courseRepository;

    @Override
    public void run(String... args) {
        if (courseRepository.count() == 0) {
            System.out.println("🌱 Seeding sample courses into database...");

            Course c1 = new Course();
            c1.setTitle("Full Stack Development");
            c1.setDescription("MERN Stack end-to-end web app building.");
            courseRepository.save(c1);

            Course c2 = new Course();
            c2.setTitle("Data Structures & Algorithms");
            c2.setDescription("Master problem-solving skills.");
            courseRepository.save(c2);

            Course c3 = new Course();
            c3.setTitle("Machine Learning Basics");
            c3.setDescription("Introduction to AI/ML concepts.");
            courseRepository.save(c3);

            System.out.println("✅ Course seeding completed!");
        } else {
            System.out.println("📗 Courses already exist, skipping seeding.");
        }
    }
}
