package com.sahan.spring;

import com.sahan.spring.service.impl.EmailSenderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.mail.MessagingException;

/**
 * Created by Sahan Nimesha on 2022 - Feb
 * In IntelliJ IDEA
 */
@SpringBootApplication
public class SpringInitializer {
    private final EmailSenderServiceImpl service;

    @Autowired
    public SpringInitializer(EmailSenderServiceImpl service) {
        this.service = service;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringInitializer.class);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void triggerMail() throws MessagingException {
        service.sendEmailWithAttachment("spring.email.to@gmail.com --> courier company email",
                "This is Email Body with Attachment...",
                "This email has attachment",
                "This is an document attachment");

    }
}
