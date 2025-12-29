package com.kodilla.spring.library;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

@SpringBootTest
public class LibraryTestSuite {

    @Autowired
    private Library library;

    @Test
    public void testLoadFromDb(){

        library.loadFromDb();

    }

    @Test
    public void testSavetoDb(){

        library.saveToDb();

    }
    @Test
    void testContext(){
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");

        System.out.println("===== Beans List: ===== >>");
        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);
        System.out.println("<< ===== Beans List: =====");
    }
}
