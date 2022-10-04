package com.example.kr2.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus()
public class QuestionIsFullException extends RuntimeException{
}
