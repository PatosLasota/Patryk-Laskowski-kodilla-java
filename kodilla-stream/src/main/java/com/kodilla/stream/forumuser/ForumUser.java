package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public class ForumUser {

    private final int userId;
    private final String Username;
    private final char sex;
    private final LocalDate birthDate;
    private final int postCount;

    public ForumUser(int userId, String username, char sex, LocalDate birthDate, int postCount) {
        this.userId = userId;
        Username = username;
        this.sex = sex;
        this.birthDate = birthDate;
        this.postCount = postCount;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return Username;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getPostCount() {
        return postCount;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "userId=" + userId +
                ", Username='" + Username + '\'' +
                ", sex=" + sex +
                ", birthDate=" + birthDate +
                ", postCount=" + postCount +
                '}';
    }
}

