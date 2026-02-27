package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TaskListDaoTestSuite {

    private String DESCRIPTION = "Test: Learn Hibernate";

    @Autowired
    private TaskListDao taskListDao;

    @Test
    void findByListName() {
        //Given
        TaskList taskList = new TaskList("Name", DESCRIPTION);
        taskListDao.save(taskList);

        //When
        List<TaskList> taskLists = taskListDao.findByListName("Name");
        //Then

        assertEquals(1, taskLists.size());

        //CleanUp
        taskListDao.deleteAll(taskLists);
    }
}
