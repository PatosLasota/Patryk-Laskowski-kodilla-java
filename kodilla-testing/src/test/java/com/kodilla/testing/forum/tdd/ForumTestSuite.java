package com.kodilla.testing.forum.tdd;

import com.kodilla.testing.forum.ForumComment;
import com.kodilla.testing.forum.ForumPost;
import com.kodilla.testing.forum.ForumUser;
import org.junit.jupiter.api.*;

@DisplayName("TDD: Forum Test Suite \uD83D\uDE31")
public class ForumTestSuite {
    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTest() {
        System.out.println("This is the beginning of test.");
    }
    @AfterAll
    public static void afterAllTest() {
        System.out.println("All tests are finished.");
    }
    @BeforeEach
    public void beforeEveryTest() {
        System.out.println("Preparing to execute test#" + testCounter);
    }
    @Nested
    @DisplayName("Tests for posts")
    class ThePosts{
        @Test
        void testAddPost(){
            //Given
            ForumUser forumUser = new ForumUser("mrsmith","John Smith");
            //When
            forumUser.addPost("mrsmith","Hellow everyone, this is my first contribution here!");
            //Then
            Assertions.assertEquals(1, forumUser.getPostQuantity());
        }
        @Test
        void testGetPosts(){
            //Given
            ForumUser forumUser = new ForumUser("mrsmith","John Smith");
            ForumPost thePost = new ForumPost("mrsmith", "Hello everyone,"+
                    "this is my first contribution here!");
            forumUser.addPost(thePost.getAuthor(), thePost.getPostBody());
            //When
            ForumPost retrivePost;
            retrivePost = forumUser.getPost(0);
            //Then
            Assertions.assertEquals(thePost,retrivePost);
        }
        @Test
        void testRemovePostNoExisting(){
            //Given
            ForumUser forumUser = new ForumUser("mrsmith","John Smith");
            ForumPost thePost = new ForumPost("mrsmith", "Hello everyone,"+
                    "this is my first contribution here!");
            //when
            boolean result = forumUser.removePost(thePost);
            //Then
            Assertions.assertFalse(result);
        }
        @Test
        void testRemovePost(){
            //Given
            ForumUser forumUser = new ForumUser("mrsmith","John Smith");
            ForumPost thePost = new ForumPost("mrsmith", "Hello everyone,"+
                    "this is my first contribution here!");
            forumUser.addPost(thePost.getAuthor(), thePost.getPostBody());
            //When
            boolean result = forumUser.removePost(thePost);
            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0,forumUser.getPostQuantity());
        }
    }
    @Nested
    @DisplayName("Tests for Comments")
    class TheComments{
        @Test
        void testAddComment(){
            //Given
            ForumUser forumUser = new ForumUser("mrsmith","John Smith");
            ForumPost thePost = new ForumPost("mrsmith", "Hello everyone,"+
                    "this is my first contribution here!");
            //When
            forumUser.addComment(thePost,"mrspith","Thank you for all good words!");
            //Then
            Assertions.assertEquals(1, forumUser.getCommentQuantity());
        }

        @Test
        void testGetComments(){
            //Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost thePost = new ForumPost("mrsmith", "Hello everyone,"+
                    "this is my first contribution here!");
            ForumComment theComment = new ForumComment(thePost, "mrsmith",
                    "Thank you for all good words!");
            forumUser.addComment(thePost, theComment.getAuthor(),
                    theComment.getCommentBody());

            //When
            ForumComment retrievedComment = forumUser.getComment(0);

            //Then
            Assertions.assertEquals(theComment, retrievedComment);
        }

        @Test
        void testRemoveCommentNoExisting(){
            //Given
            ForumUser forumUser = new ForumUser("mrsmith","John Smith");
            ForumPost thePost = new ForumPost("mrsmith", "Hello everyone,"+
                    "this is my first contribution here!");
            ForumComment theComment = new ForumComment(thePost, "mrsmith", "Thank you for all good words!");
            //when
            boolean result = forumUser.removeComment(theComment);
            //Then
            Assertions.assertFalse(result);
        }

        @Test
        void testRemoveComment(){
            //Given
            ForumUser forumUser = new ForumUser("mrsmith","John Smith");
            ForumPost thePost = new ForumPost("mrsmith", "Hello everyone,"+
                    "this is my first contribution here!");
            ForumComment theComment = new ForumComment(thePost, "mrsmith","Thank you for all good words!");
            forumUser.addComment(thePost,theComment.getAuthor(),theComment.getCommentBody());
            //When
            boolean result = forumUser.removeComment(theComment);
            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0,forumUser.getCommentQuantity());
        }
    }


}

