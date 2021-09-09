package com.caniksea.adp3.practical.booklib.authormodule.domain.generic;

/**
 * Instructions:
 *  > Do NOT modify class instance variable declaration.
 *
 * Tasks:
 *  > Implement class using Builder Pattern ONLY. (2 marks)
 *
 */
public class Author {

    private String id, firstName, lastName; // DO NOT MODIFY THIS LINE.

    private Author(Builder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public static class Builder {
        private String id, firstName, lastName;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder copy(Author author) {
            this.id = author.id;
            this.firstName = author.firstName;
            this.lastName = author.lastName;
            return this;
        }

        public Author build() {
            return new Author(this);
        }
    }

    @Override
    public String toString() {
        return "Author{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
