package com.caniksea.adp3.practical.booklib.authormodule.domain.library;

import com.caniksea.adp3.practical.booklib.authormodule.domain.generic.Author;

/**
 * Instructions:
 *  > Do NOT modify class instance variable declaration.
 *
 * Tasks:
 *  > Implement class using Builder Pattern ONLY. (2 marks)
 *
 */
public class Book {

    private String id, title; // DO NOT MODIFY THIS LINE.
    private int year; // DO NOT MODIFY THIS LINE


    private Book (Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.year = builder.year;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public static class Builder {
        private String id, title;
        private int year;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder year(int year) {
            this.year = year;
            return this;
        }

        public Builder copy(Book book) {
            this.id = book.id;
            this.title = book.title;
            this.year = book.year;
            return this;
        }

        public Book build() {
            return new Book(this);
        }

    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", year=" + year +
                '}';
    }
}
