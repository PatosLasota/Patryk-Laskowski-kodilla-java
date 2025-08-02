package com.kodilla.testing.forum;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ForumUser {
    private String name;                                        // [6]
    private String realName;                                    // [7]
    private List<ForumPost> posts = new ArrayList<>();          // [8]
    private List<ForumComment> comments = new LinkedList<>();

    public ForumUser(String name, String realName) {
        this.name = name;
        this.realName = realName;
    }

    public void addPost(String author, String postbody) {
        ForumPost thePost = new ForumPost(author, postbody);
        posts.add(thePost);
    }
    public void addComment(ForumPost thePost, String author, String commentBody) {
        ForumComment theComment = new ForumComment(thePost, author, commentBody);
        comments.add(theComment);
    }
    public int getPostQuantity() {
        return posts.size();
    }
    public int getCommentQuantity() {
        return comments.size();
    }
    public ForumPost getPost(int postNumber){
        if(postNumber >= 0 && postNumber < posts.size()){
            return posts.get(postNumber);
        }
        return null;
    }
    public ForumComment getComment(int commentNumber){
        if(commentNumber >= 0 && commentNumber < comments.size()){
            return comments.get(commentNumber);
        }
        return null;
    }
    public boolean removePost(ForumPost thePost){
        boolean result = false;
        if(posts.contains(thePost)){
            posts.remove(thePost);
            result = true;
        }
        return result;
    }
    public boolean removeComment(ForumComment theComment){
        boolean result = false;
        if(comments.contains(theComment)){
            comments.remove(theComment);
            result = true;
        }
        return result;
    }
    public String getName() {
        return name;
    }

    public String getRealName() {
        return realName;
    }
}
