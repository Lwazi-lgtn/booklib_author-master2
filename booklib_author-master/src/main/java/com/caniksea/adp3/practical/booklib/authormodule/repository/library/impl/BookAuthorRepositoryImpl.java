package com.caniksea.adp3.practical.booklib.authormodule.repository.library.impl;

import com.caniksea.adp3.practical.booklib.authormodule.domain.library.Book;
import com.caniksea.adp3.practical.booklib.authormodule.domain.library.BookAuthor;
import com.caniksea.adp3.practical.booklib.authormodule.repository.IRepository;
import com.caniksea.adp3.practical.booklib.authormodule.repository.library.BookAuthorRepository;
import com.sun.org.apache.bcel.internal.generic.ARETURN;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Instructions
 *  > Make sure you have read the instructions on IRepository.java before attempting the tasks below.
 *  > Make sure you have completed the task(s) in BookAuthorRepository.java before attempting the tasks below.
 *  > Note that no Update operation is needed here.
 *
 * Tasks:
 *  > Implement repository using singleton and your chosen Java data structure. (1.5 marks)
 *  > Replace the throw new UnsupportedOperationException() with your implementation of the create methods. (0.25 marks)
 *  > Replace the throw new UnsupportedOperationException() with your implementation of the read methods. (0.5 marks)
 *  > Replace the throw new UnsupportedOperationException() with your implementation of the delete methods. (0.75 marks)
 *  > Write an implementation of the getall method you declared in the interface. (0.25 marks)
 *  > Write an implementation of the method you declared in the interface that returns all
 *      bookauthor entities given bookid. (1.5 marks)
 *  > Write an implementation of the method you declared in the interface that returns all
 *      bookauthor entities given authorid. (1.5 marks)
 *  > Write an implementation of the method you declared to delete all bookauthor entites
 *      given a bookid. (1.5 marks)
 *
 */
public class BookAuthorRepositoryImpl implements BookAuthorRepository {

    private Set<BookAuthor> bookAuthors;
    private static BookAuthorRepository repository = null;

    private BookAuthorRepositoryImpl() { this.bookAuthors = new HashSet<>(); }

    public static BookAuthorRepository getRepository() {
        if (repository ==null) repository = new BookAuthorRepositoryImpl();
            return repository;
    }

    @Override
    public BookAuthor create(BookAuthor bookAuthor) {
        this.bookAuthors.add(bookAuthor);
        return bookAuthor;
    }

    @Override
    public BookAuthor read(String bookId, String authorId) {
        return this.bookAuthors.stream()
                .filter(bookAuthor -> bookAuthor.getAuthorId().trim().equalsIgnoreCase(authorId.trim()))
                .filter(bookAuthor -> bookAuthor.getBookId().trim().equalsIgnoreCase(bookId.trim()))
                .findAny().orElse(null);
    }

    @Override
    public void delete(String bookId, String authorId) {
        BookAuthor bookAuthor = read(bookId, authorId);
        if (bookAuthor != null) this.bookAuthors.remove(bookAuthor);
    }

    @Override
    public Set<BookAuthor> getall() { return this.bookAuthors; }

    @Override
    public Set<BookAuthor> getBookAuthorsForAuthor(String authorId) {
        return this.bookAuthors.stream()
                .filter(bookAuthor -> bookAuthor.getAuthorId().trim().equalsIgnoreCase(authorId.trim()))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<BookAuthor> getBookAuthorsForBook(String bookId) {
        return this.bookAuthors.stream()
                .filter(bookAuthor -> bookAuthor.getBookId().trim().equalsIgnoreCase(bookId.trim()))
                .collect(Collectors.toSet());
    }

    @Override
    public void deleteForBook(String bookId) {
        Set<BookAuthor> bookAuthors = getBookAuthorsForBook(bookId);
        if (!bookAuthors.isEmpty()) this.bookAuthors.removeAll(bookAuthors);
    }
}
