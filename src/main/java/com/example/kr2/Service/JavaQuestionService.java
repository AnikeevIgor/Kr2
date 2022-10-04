package com.example.kr2.Service;

import com.example.kr2.Question;
import com.example.kr2.exception.QuestionAlreadyExistsException;
import com.example.kr2.exception.QuestionNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final Set<Question> questions;

    public JavaQuestionService() {
        this.questions = new HashSet<>();
    }

    private final Random random = new Random();

    @Override
    public Question add(String question, String answer) {
        Question question1 = new Question(question, answer);
        return add(question1);
    }

    @Override
    public Question add(Question question) {
        if ((!questions.add(question))) {
            throw new QuestionAlreadyExistsException();
        }
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.remove(question)) {
            throw new QuestionNotFoundException();
        }
        return question;
   }

    @Override
    public Collection<Question> getAll() {
        return new HashSet<>(questions);
    }

    @Override
    public Question getRandomQuestion() {
        return new ArrayList<>(questions).get(random.nextInt(questions.size()));
    }


}
