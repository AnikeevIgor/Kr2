package com.example.kr2.Service;

import com.example.kr2.Question;
import com.example.kr2.exception.QuestionIsFullException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService javaQuestionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @BeforeEach
    public void beforeEach(){
        Collection<Question> questions = Stream.of(
                new Question("q","a"),
                new Question("q1","a1"),
                new Question("q2","a2"),
                new Question("q3","a3")
        ).collect(Collectors.toSet());

        when(javaQuestionService.getAll()).thenReturn(questions);
    }
    @Test
    public void getQuestionsExcepton() {
        assertThrows(QuestionIsFullException.class, () -> examinerService.getQuestions(5));
    }
}