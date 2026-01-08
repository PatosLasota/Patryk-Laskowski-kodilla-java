package com.kodilla.patterns.prototype.library;

public class Book {
    final private String title;
    final private String author;
    final private String publicationDate;

    public Book(String title, String author, String publicationDate) {
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
    }

    public String getTitle() {
        return title;
    }

    public final String getAuthor() {
        return author;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    @Override
    public String toString() {
        return "Book{ title=" + title
                + ", author=" + author
                + ", publicationDate=" + publicationDate + "}";
    }
}
