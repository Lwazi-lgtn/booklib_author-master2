package com.caniksea.adp3.practical.booklib.authormodule.repository.generic.impl;

import com.caniksea.adp3.practical.booklib.authormodule.domain.generic.Author;
import com.caniksea.adp3.practical.booklib.authormodule.factory.generic.AuthorFactory;
import com.caniksea.adp3.practical.booklib.authormodule.repository.generic.AuthorRepository;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;

/**
 * Instructions:
 *  > Make sure you have completed the task(s) in AuthorRepositoryImpl.java before attempting tasks below.
 *  > Use JUNIT testing framework ONLY.
 *  > Use appropriate assert method(s).
 *
 * Tasks:
 *  > Replace the throw exception with test cases the create methods. (0.25 marks)
 *  > Replace the throw exception with test cases the read methods. (0.5 marks)
 *  > Replace the throw exception with test cases the update methods. (0.75 marks)
 *  > Replace the throw exception with test cases the delete methods. (0.75 marks)
 *  > Write a test case for the getall method. (0.25 marks)
 *  > Ensure your tests run in a right order (Hint: method name ascending). (0.125 marks)
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AuthorRepositoryImplTest {

    private static Author author = AuthorFactory.buildAuthor("Paul", "Jideani");
    private AuthorRepository repository = AuthorRepositoryImpl.getRepository();

    @Before
    public void setUp() {
        System.out.println("Author: " + author);

    }

    @Test
    public void a_create() {
        Author inserted = repository.create(author);
        assertEquals(inserted.getId(), author.getId());
        System.out.println("Inserted: " + inserted);
    }

    @Test
    public void c_update() {
        Author updated = new Author.Builder().copy(author).lastName("Caleb").build();
        updated = repository.update(updated);
        assertEquals(updated.getId(), author.getId());
        System.out.println("Updated: " + updated);
    }

    @Test
    public void b_read() {
        Author read = repository.read(author.getId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    public void e_delete() {
        repository.delete(author.getId());
    }

    @Test
    public void d_getall() {
        Set<Author> authors = repository.getall();
        assertEquals(1, authors.size());
        System.out.println("Authors: " + authors);
    }
}