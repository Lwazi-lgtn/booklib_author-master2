package com.caniksea.adp3.practical.booklib.authormodule.domain.library;

/**
 * Instructions:
 *  > Do NOT modify class instance variable declaration.
 *
 * Tasks:
 *  > Implement class using Builder Pattern ONLY. (2 marks)
 *
 */
public class BookAuthor {

    private String bookId, authorId; // DO NOT MODIFY THIS LINE.

    private BookAuthor(Builder builder) {
        this.bookId = builder.bookId;
        this.authorId = builder.authorId;
    }

    public String getBookId() {
        return bookId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public static class Builder {
        private String bookId, authorId;

        public Builder BookId(String bookId) {
            this.bookId = bookId;
            return this;
        }

        public Builder authorId(String authorId) {
            this.authorId = authorId;
            return this;
        }

        public Builder copy(BookAuthor bookAuthor) {
            this.bookId = bookAuthor.bookId;
            this.authorId = bookAuthor.authorId;
            return this;
        }

        public BookAuthor build() {
            return new BookAuthor(this);
        }
    }

    @Override
    public String toString() {
        return "BookAuthor{" +
                "bookId='" + bookId + '\'' +
                ", authorId='" + authorId + '\'' +
                '}';
    }
}
