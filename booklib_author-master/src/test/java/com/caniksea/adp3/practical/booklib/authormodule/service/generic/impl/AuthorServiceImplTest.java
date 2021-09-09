package com.caniksea.adp3.practical.booklib.authormodule.service.generic.impl;

import com.caniksea.adp3.practical.booklib.authormodule.domain.generic.Author;
import com.caniksea.adp3.practical.booklib.authormodule.factory.generic.AuthorFactory;
import com.caniksea.adp3.practical.booklib.authormodule.repository.generic.impl.AuthorRepositoryImpl;
import com.caniksea.adp3.practical.booklib.authormodule.service.generic.AuthorService;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;

/**
 * Instructions:
 *  > Make sure you have completed the task(s) in AuthorServiceImpl.java before attempting tasks below.
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
public class AuthorServiceImplTest {

    private static Author author = AuthorFactory.buildAuthor("Paul", "Jideani");
    private AuthorService service = AuthorServiceImpl.getService();

    @Before
    public void setUp() {
        System.out.println("Author: " + author);

    }

    @Test
    public void a_create() {
        Author inserted = service.create(author);
        assertEquals(inserted.getId(), author.getId());
        System.out.println("Inserted: " + inserted);
    }

    @Test
    public void c_update() {
        Author updated = new Author.Builder().copy(author).lastName("Caleb").build();
        updated = service.update(updated);
        assertEquals(updated.getId(), author.getId());
        System.out.println("Updated: " + updated);
    }

    @Test
    public void b_read() {
        Author read = service.read(author.getId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    public void e_delete() {
        service.delete(author.getId());
    }

    @Test
    public void d_getall() {
        Set<Author> authors = service.getall();
        assertEquals(1, authors.size());
        System.out.println("Authors: " + authors);
    }
}