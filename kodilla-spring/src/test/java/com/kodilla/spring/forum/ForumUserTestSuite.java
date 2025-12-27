package com.kodilla.spring.forum;

import org.junit.jupiter.api.Test;
import com.kodilla.spring.forum.ForumUser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import static org.junit.jupiter.api.Assertions.*;

public class ForumUserTestSuite {

    @Test
    public void testGetUsername() {
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");

        ForumUser forumUser = context.getBean(ForumUser.class);

        String name = forumUser.getUsername();

        assertEquals("John Smith", name);

    }
    @Test
    void contextLoads() {
    }
}
