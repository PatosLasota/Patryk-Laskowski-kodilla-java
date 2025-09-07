package com.kodilla.stream.forumuser;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        Forum forum = new Forum();

        Map<Integer, ForumUser> resultMap = forum.getUserList().stream()
                .filter(user -> user.getSex() == 'M')
                .filter(user -> Period.between(user.getBirthDate(), LocalDate.now()).getYears() >= 20)
                .filter(user -> user.getPostCount() > 0)
                .collect(Collectors.toMap(ForumUser::getUserId, user -> user));

        resultMap.entrySet().forEach(System.out::println);
    }
}