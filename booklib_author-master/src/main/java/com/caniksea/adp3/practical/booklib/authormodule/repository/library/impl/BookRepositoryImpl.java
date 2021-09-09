package com.caniksea.adp3.practical.booklib.authormodule.repository.library.impl;

import com.caniksea.adp3.practical.booklib.authormodule.domain.library.Book;
import com.caniksea.adp3.practical.booklib.authormodule.repository.library.BookRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Instructions
 *  > Make sure you have read the instructions on IRepository.java before attempting the tasks below.
 *  > Make sure you have completed the task(s) in BookRepository.java before attempting the tasks below.
 *
 * Tasks:
 *  > Implement repository using singleton and your chosen Java data structure. (1.5 marks)
 *  > Replace the throw new UnsupportedOperationException() with your implementation of the create methods. (0.25 marks)
 *  > Replace the throw new UnsupportedOperationException() with your implementation of the read methods. (0.5 marks)
 *  > Replace the throw new UnsupportedOperationException() with your implementation of the update methods. (0.75 marks)
 *  > Replace the throw new UnsupportedOperationException() with your implementation of the delete methods. (0.75 marks)
 *  > Write an implementation of the getall method you declared in the interface. (0.25 marks)
 *
 */
public class BookRepositoryImpl implements BookRepository {

    private Set<Book> books;
    private static BookRepository repository = null;

    private BookRepositoryImpl() {this.books = new HashSet<>(); }


    public static BookRepository getRepository() {
        if (repository == null) repository = new BookRepositoryImpl();
        return repository;
    }

    @Override
    public Book create(Book book) {
        this.books.add(book);
        return book;
    }

    @Override
    public Book update(Book book) {
        Book read = read(book.getId());
        if (read != null) {
            this.books.remove(read);
            this.books.add(book);
            return book;
        }
        return null;
    }

    @Override
    public Book read(String s) {
        return this.books.stream()
                .filter(book -> book.getId().trim().equalsIgnoreCase(s.trim()))
                .findAny().orElseGet(null);
    }

    @Override
    public void delete(String s) {
        Book book = read(s);
        if (book != null) this.books.remove(book);
    }

    @Override
    public Set<Book> getall() {
        return this.books;
    }
}
