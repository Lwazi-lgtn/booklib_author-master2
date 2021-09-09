package com.caniksea.adp3.practical.booklib.authormodule.factory.generic;

import com.caniksea.adp3.practical.booklib.authormodule.domain.generic.Author;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Instructions:
 *  > Make sure you have completed the task on AuthorFactor.java.
 *  > Use JUNIT testing framework ONLY.
 *  > Use appropriate assert method(s).
 *
 */
public class AuthorFactoryTest {

    /**
     * Tasks:
     *  > Replace the throw exception with your implementation of a test case for buildAuthor. (2 marks)
     */
    @Test
    public void buildAuthor() {
        Author author = AuthorFactory.buildAuthor("Arendse", "Jaanties");
        assertNotNull(author);
        System.out.println(author);
        //System.out.println("working");

    }
}