package com.kodilla.testing.forum.statistics;

import java.util.List;

public class ForumStatistics {

    private int userCount;
    private int postCount;
    private int commentCount;
    private double averagePostPerUser;
    private double averageCommentPerUser;
    private double averageCommentPerPost;


    public int getUserCount() {
        return userCount;
    }

    public int getPostCount() {
        return postCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public double getAveragePostPerUser() {
        return averagePostPerUser;
    }

    public double getAverageCommentPerUser() {
        return averageCommentPerUser;
    }

    public double getAverageCommentPerPost() {
        return averageCommentPerPost;
    }

    public void calculateAdvStatistics(Statistics statistics) {

        List<String> users = statistics.usersNames();
        userCount = (users != null) ? users.size() : 0;

        postCount = Math.max(0, statistics.postCount());
        commentCount = Math.max(0, statistics.commentCount());

        averagePostPerUser = userCount > 0 ? (double) postCount / userCount : 0;

        if (postCount == 0) {
            averageCommentPerPost = 0;
        } else {
            averageCommentPerUser = userCount > 0 ? (double) commentCount / userCount : 0;
            averageCommentPerPost = (double) commentCount / postCount;
        }

    }

    public void showStatistics() {
        System.out.println("usersNames: " + userCount);
        System.out.println("postsCount: " + postCount);
        System.out.println("commentsCount: " + commentCount);
        System.out.println("averagePostPerUser: " + averagePostPerUser);
        System.out.println("averageCommentPerUser: " + averageCommentPerUser);
        System.out.println("averageCommentPerPost: " + averageCommentPerPost);
    }

}
