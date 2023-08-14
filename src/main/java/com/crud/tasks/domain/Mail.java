package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.mail.SimpleMailMessage;

import java.util.Optional;

@Getter
@AllArgsConstructor
public class Mail {
    private final String mailTo;
    private final String subject;
    private final String message;
    private final String toCc;

}