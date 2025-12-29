package com.kodilla.spring.portfolio;

import com.kodilla.spring.reader.ReaderConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BoardTestSuite {
    ApplicationContext context =
            new AnnotationConfigApplicationContext(BoardConfig.class);

    Board board = context.getBean(Board.class);

    @Test
    public void testTaskAdd(){
        board.getToDoList().getTasks().add("Zadania do zrobienia");
        board.getInProgressList().getTasks().add("Zadania w trakcie");
        board.getDoneList().getTasks().add("Zadania zrobione");

        assertEquals("Zadania do zrobienia", board.getToDoList().getTasks().get(0));
        assertEquals("Zadania w trakcie", board.getInProgressList().getTasks().get(0));
        assertEquals("Zadania zrobione", board.getDoneList().getTasks().get(0));

        assertEquals(1, board.getToDoList().getTasks().size());
        assertEquals(1, board.getInProgressList().getTasks().size());
        assertEquals(1, board.getDoneList().getTasks().size());

    }
}
