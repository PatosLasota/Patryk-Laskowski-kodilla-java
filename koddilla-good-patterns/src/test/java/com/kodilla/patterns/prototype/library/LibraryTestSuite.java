package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LibraryTestSuite {

    @Test
    public void testGetBooks() {
        try {
            Library library = new Library("Library");
            Book book1 = new Book("Book 1", "Author 1", "2001");
            Book book2 = new Book("Book 2", "Author 2", "2002");
            Book book3 = new Book("Book 3", "Author 3", "2003");

            library.getBooks().add(book1);
            library.getBooks().add(book2);
            library.getBooks().add(book3);

            Library shallowCoppiedLibrary = library.shallowClone();
            Library deepCoppiedLibarry = library.deepClone();

            Book book4 = new Book("Book 4", "Author 4", "2004");
            library.getBooks().add(book4);

            System.out.println("===Results===");
            System.out.println("   Original Liblary" + library);
            System.out.println("   Books count: " + library.getBooks().size());

            System.out.println("   Shallow coppied" + shallowCoppiedLibrary);
            System.out.println("   Shallow coppied books count: " + shallowCoppiedLibrary.getBooks().size());

            System.out.println("   Deep cooppied" + deepCoppiedLibarry);
            System.out.println("   Deep coppied books count: " + deepCoppiedLibarry.getBooks().size());


            assertEquals(4, library.getBooks().size());
            assertEquals(4, shallowCoppiedLibrary.getBooks().size());
            assertEquals(3, deepCoppiedLibarry.getBooks().size());

            assertNotEquals(library.getBooks(), deepCoppiedLibarry.getBooks());
            assertEquals(library.getBooks(), shallowCoppiedLibrary.getBooks());
        }catch (CloneNotSupportedException e) {
            System.out.println("Clone not supported: " + e.getMessage());
        }
        }
}
