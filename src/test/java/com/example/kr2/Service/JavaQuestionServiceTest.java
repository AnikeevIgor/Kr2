package com.example.kr2.Service;

import com.example.kr2.Question;
import com.example.kr2.exception.QuestionAlreadyExistsException;
import com.example.kr2.exception.QuestionNotFoundException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class JavaQuestionServiceTest {
    private final QuestionService questionService = new JavaQuestionService();

    @Test
    void addT() {
        Question question = new Question("q", "a");
        questionService.add(question);
        assertThat(questionService.getAll().contains(question));

    }

    @Test
    void testAddT() {
        Question question1 = new Question("q1", "a1");
        questionService.add(question1);
        assertThrows(QuestionAlreadyExistsException.class, () -> questionService.add(question1));
    }

    @Test
    void removeT() {
        Question question2 = new Question("q2", "a2");
        questionService.add(question2);
        questionService.remove(question2);
        assertThat(questionService.getAll().isEmpty());
        assertThrows(QuestionNotFoundException.class, () -> questionService.remove(question2));
    }

    @Test
    void getRandomQuestionT() {
        Question question10 = new Question("q10", "a10");
        Question question11 = new Question("q11", "a11");
        Question question12 = new Question("q12", "a12");
        Question question13 = new Question("q13", "a13");
        questionService.add(question10);
        questionService.add(question11);
        questionService.add(question12);
        questionService.add(question13);
        assertThat(questionService.getRandomQuestion()).isIn(questionService.getAll());
    }
}