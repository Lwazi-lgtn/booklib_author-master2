package com.caniksea.adp3.practical.booklib.authormodule.factory.library;

import com.caniksea.adp3.practical.booklib.authormodule.domain.library.Book;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Instructions:
 *  > Make sure you have completed the task on BookFactory.java.
 *  > Use JUNIT testing framework ONLY.
 *  > Use appropriate assert method(s).
 *
 */
public class BookFactoryTest {

    /**
     * Tasks:
     *  > Replace the throw exception with your implementation of a test case for buildBook. (2 marks)
     */
    @Test
    public void buildBook() {
        Book book = BookFactory.buildBook("Physics for Nerds", 2020);
        assertNotNull(book);
        System.out.println(book);
    }
}