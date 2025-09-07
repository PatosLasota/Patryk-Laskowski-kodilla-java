package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Forum {
    private final List<ForumUser> userList = new ArrayList<>();

    public Forum() {
        userList.add(new ForumUser(1, "AdamK", 'M', LocalDate.of(1995, 5, 12), 10));
        userList.add(new ForumUser(2, "KasiaM", 'F', LocalDate.of(1998, 8, 21), 5));
        userList.add(new ForumUser(3, "MarekP", 'M', LocalDate.of(2007, 1, 3), 2));
        userList.add(new ForumUser(4, "OlaZ", 'F', LocalDate.of(1990, 12, 30), 0));
        userList.add(new ForumUser(5, "TomekL", 'M', LocalDate.of(1985, 3, 17), 15));
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(userList);
    }
}
