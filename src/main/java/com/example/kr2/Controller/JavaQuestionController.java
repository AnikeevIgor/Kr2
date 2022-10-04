package com.example.kr2.Controller;

import com.example.kr2.Question;
import com.example.kr2.Service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/add")
    public Question addQ(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping("/add1")
    public Question addQ1(@RequestParam("question") Question question) {
        return questionService.add(question);
    }

    @GetMapping("/remove")
    public Question removeQ(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        return questionService.remove(new Question(question,answer));
    }

    @GetMapping("")
    public Collection<Question> getAll() {
        return questionService.getAll();
    }
}
