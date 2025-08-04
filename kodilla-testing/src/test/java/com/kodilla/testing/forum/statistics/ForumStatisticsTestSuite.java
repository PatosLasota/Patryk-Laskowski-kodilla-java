package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ForumStatisticsTestSuite {
    private Statistics statisticsMock;

    private ForumStatistics forumStatistics;

    private List<String> generateUserList(int count) {
        List<String> users = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            users.add("User" + i);
        }
        return users;
    }

    @BeforeEach
    public void setup() {
        statisticsMock = mock(Statistics.class);
        forumStatistics = new ForumStatistics();
    }

    @Test
    void testPostsCountIsZero() {
        when(statisticsMock.usersNames()).thenReturn(generateUserList(5));
        when(statisticsMock.postCount()).thenReturn(0);
        when(statisticsMock.commentCount()).thenReturn(0);

        forumStatistics.calculateAdvStatistics(statisticsMock);

        assertEquals(5, forumStatistics.getUserCount());
        assertEquals(0, forumStatistics.getPostCount());
        assertEquals(0, forumStatistics.getCommentCount());

        assertEquals(0.0, forumStatistics.getAveragePostPerUser());
        assertEquals(0.0, forumStatistics.getAverageCommentPerUser());
        assertEquals(0.0, forumStatistics.getAverageCommentPerPost());

        verify(statisticsMock).usersNames();
        verify(statisticsMock).postCount();
        verify(statisticsMock).commentCount();
    }

    @Test
    void testPostsCountIsThousand() {
        when(statisticsMock.usersNames()).thenReturn(generateUserList(10));
        when(statisticsMock.postCount()).thenReturn(1000);
        when(statisticsMock.commentCount()).thenReturn(500);

        forumStatistics.calculateAdvStatistics(statisticsMock);

        assertEquals(10, forumStatistics.getUserCount());
        assertEquals(1000, forumStatistics.getPostCount());
        assertEquals(500, forumStatistics.getCommentCount());

        assertEquals(100.0, forumStatistics.getAveragePostPerUser());
        assertEquals(50.0, forumStatistics.getAverageCommentPerUser());
        assertEquals(0.5, forumStatistics.getAverageCommentPerPost());

        verify(statisticsMock).usersNames();
        verify(statisticsMock).postCount();
        verify(statisticsMock).commentCount();
    }

    @Test
    void testCommentsCountIsZero() {
        when(statisticsMock.usersNames()).thenReturn(generateUserList(5));
        when(statisticsMock.postCount()).thenReturn(20);
        when(statisticsMock.commentCount()).thenReturn(0);

        forumStatistics.calculateAdvStatistics(statisticsMock);

        assertEquals(5, forumStatistics.getUserCount());
        assertEquals(20, forumStatistics.getPostCount());
        assertEquals(0, forumStatistics.getCommentCount());

        assertEquals(4.0, forumStatistics.getAveragePostPerUser());
        assertEquals(0.0, forumStatistics.getAverageCommentPerUser());
        assertEquals(0.0, forumStatistics.getAverageCommentPerPost());

        verify(statisticsMock).usersNames();
        verify(statisticsMock).postCount();
        verify(statisticsMock).commentCount();
    }

    @Test
    void testCommentsLessThanPosts() {
        when(statisticsMock.usersNames()).thenReturn(generateUserList(4));
        when(statisticsMock.postCount()).thenReturn(100);
        when(statisticsMock.commentCount()).thenReturn(50);

        forumStatistics.calculateAdvStatistics(statisticsMock);

        assertEquals(4, forumStatistics.getUserCount());
        assertEquals(100, forumStatistics.getPostCount());
        assertEquals(50, forumStatistics.getCommentCount());

        assertEquals(25.0, forumStatistics.getAveragePostPerUser());
        assertEquals(12.5, forumStatistics.getAverageCommentPerUser());
        assertEquals(0.5, forumStatistics.getAverageCommentPerPost());

        verify(statisticsMock).usersNames();
        verify(statisticsMock).postCount();
        verify(statisticsMock).commentCount();
    }

    @Test
    void testCommentsMoreThanPosts() {
        when(statisticsMock.usersNames()).thenReturn(generateUserList(4));
        when(statisticsMock.postCount()).thenReturn(50);
        when(statisticsMock.commentCount()).thenReturn(200);

        forumStatistics.calculateAdvStatistics(statisticsMock);

        assertEquals(4, forumStatistics.getUserCount());
        assertEquals(50, forumStatistics.getPostCount());
        assertEquals(200, forumStatistics.getCommentCount());

        assertEquals(12.5, forumStatistics.getAveragePostPerUser());
        assertEquals(50.0, forumStatistics.getAverageCommentPerUser());
        assertEquals(4.0, forumStatistics.getAverageCommentPerPost());

        verify(statisticsMock).usersNames();
        verify(statisticsMock).postCount();
        verify(statisticsMock).commentCount();
    }

    @Test
    void testUserCountIsZero() {
        when(statisticsMock.usersNames()).thenReturn(Collections.emptyList());
        when(statisticsMock.postCount()).thenReturn(100);
        when(statisticsMock.commentCount()).thenReturn(200);

        forumStatistics.calculateAdvStatistics(statisticsMock);

        assertEquals(0, forumStatistics.getUserCount());
        assertEquals(100, forumStatistics.getPostCount());
        assertEquals(200, forumStatistics.getCommentCount());

        assertEquals(0.0, forumStatistics.getAveragePostPerUser());
        assertEquals(0.0, forumStatistics.getAverageCommentPerUser());
        assertEquals(2.0, forumStatistics.getAverageCommentPerPost());

        verify(statisticsMock).usersNames();
        verify(statisticsMock).postCount();
        verify(statisticsMock).commentCount();
    }

    @Test
    void testUserCountIsHundred() {
        when(statisticsMock.usersNames()).thenReturn(generateUserList(100));
        when(statisticsMock.postCount()).thenReturn(1000);
        when(statisticsMock.commentCount()).thenReturn(5000);

        forumStatistics.calculateAdvStatistics(statisticsMock);

        assertEquals(100, forumStatistics.getUserCount());
        assertEquals(1000, forumStatistics.getPostCount());
        assertEquals(5000, forumStatistics.getCommentCount());

        assertEquals(10.0, forumStatistics.getAveragePostPerUser());
        assertEquals(50.0, forumStatistics.getAverageCommentPerUser());
        assertEquals(5.0, forumStatistics.getAverageCommentPerPost());

        verify(statisticsMock).usersNames();
        verify(statisticsMock).postCount();
        verify(statisticsMock).commentCount();
    }
}
