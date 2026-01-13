package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskFactoryTestSuite {

    @Test
    void testFactoryDrivingTask() {
        TaskFactory taskFactory = new TaskFactory();

        Task task = TaskFactory.makeTask(TaskFactory.DRIVING);

        assertNotNull(task);
        assertEquals("Trip to work",task.getTaskName());
        assertFalse(task.isTaskExecuted());

        task.executetask();
        assertTrue(task.isTaskExecuted());
    }

    @Test
    void testFactoryShorTask() {
        TaskFactory taskFactory = new TaskFactory();
        Task task = taskFactory.makeTask(TaskFactory.SHOPPING);

        assertNotNull(task);
        assertEquals("Weekly shopping",task.getTaskName());
        assertFalse(task.isTaskExecuted());

        task.executetask();
        assertTrue(task.isTaskExecuted());

    }

    @Test
    void testFactoryParkingTask() {
        TaskFactory taskFactory = new TaskFactory();
        Task task = taskFactory.makeTask(TaskFactory.PAINTING);

        assertNotNull(task);
        assertEquals("Room painting",task.getTaskName());
        assertFalse(task.isTaskExecuted());

        task.executetask();
        assertTrue(task.isTaskExecuted());
    }
    @Test
    void testFactoryUnknownTask() {
        TaskFactory taskFactory = new TaskFactory();
        Task task = taskFactory.makeTask("UNKNOWN");

        assertNull(task);
    }
}
