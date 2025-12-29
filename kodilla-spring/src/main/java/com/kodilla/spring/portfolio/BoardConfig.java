package com.kodilla.spring.portfolio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BoardConfig {

    TaskList taskList;

    @Bean
    public TaskList toDoList() {
        return new TaskList();
    }

    @Bean
    public TaskList inProgressList() {
        return new TaskList();
    }

    @Bean
    public TaskList completedList() {
        return new TaskList();
    }

    @Bean
    public Board board() {
        return new Board(toDoList(), inProgressList(), completedList());
    }
}
