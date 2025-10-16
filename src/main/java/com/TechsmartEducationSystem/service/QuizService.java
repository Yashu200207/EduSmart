package com.TechsmartEducationSystem.service;

import com.TechsmartEducationSystem.model.Quiz;
import com.TechsmartEducationSystem.repository.QuizRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class QuizService {
    private final QuizRepository repo;
    public QuizService(QuizRepository repo){ this.repo = repo; }

    public List<Quiz> getByCourse(Long courseId){ return repo.findByCourseId(courseId); }

    public int grade(Long courseId, java.util.Map<Long,String> answers){
        int correct=0;
        for(var q : repo.findByCourseId(courseId)){
            String ans = answers.get(q.getId());
            if (ans!=null && ans.equalsIgnoreCase(q.getCorrectAnswer())) correct++;
        }
        return correct;
    }
}
