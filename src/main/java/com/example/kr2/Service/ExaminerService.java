package com.example.kr2.Service;

import com.example.kr2.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
