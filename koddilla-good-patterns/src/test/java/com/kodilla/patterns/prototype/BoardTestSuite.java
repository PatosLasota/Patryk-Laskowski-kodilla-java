package com.kodilla.patterns.prototype;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BoardTestSuite {
    @Test
    void testToString() {
        TaskList listToDo = new TaskList("To Do Task");
        IntStream.iterate(1,n -> n + 1)
                .limit(10)
                .forEach(n -> listToDo.getTasks().add(new Task("To Do Task number" + n)));

        TaskList listInProgress = new TaskList("In Progress Task");
        IntStream.iterate(1,n -> n + 1)
                .limit(10)
                .forEach(n -> listInProgress.getTasks().add(new Task("In Progress Task number" + n)));
        TaskList listDone = new TaskList("Done Task");
        IntStream.iterate(1,n -> n + 1)
                .limit(10)
                .forEach(n -> listDone.getTasks().add(new Task("Done Task number" + n)));

        Board board = new Board("Project number 1");
        board.getLists().add(listToDo);
        board.getLists().add(listInProgress);
        board.getLists().add(listDone);
        System.out.println(board);

        Board cloneBoard = null;
        try {
            cloneBoard = board.shallowCopy();
            cloneBoard.setName("Project number 2");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        Board deepClonedBoard = null;
        try {
            deepClonedBoard = board.deepCopy();
            deepClonedBoard.setName("Project number 3");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }



        board.getLists().remove(listToDo);

        System.out.println(board);
        System.out.println(cloneBoard);
        System.out.println(deepClonedBoard);


        assertEquals(2, board.getLists().size());
        assertEquals(2, cloneBoard.getLists().size());
        assertEquals(3, deepClonedBoard.getLists().size());
        assertEquals(cloneBoard.getLists(), board.getLists());
        assertNotEquals(deepClonedBoard.getLists(), board.getLists());
    }


}
