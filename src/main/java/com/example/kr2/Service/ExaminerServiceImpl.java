package com.example.kr2.Service;


import com.example.kr2.Question;
import com.example.kr2.exception.QuestionIsFullException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount>questionService.getAll().size()){
            throw new QuestionIsFullException();
        }
        Set<Question> question =new HashSet<>();
        while (question.size()<amount){
            question.add(questionService.getRandomQuestion());
        }
        return question;
    }
}
