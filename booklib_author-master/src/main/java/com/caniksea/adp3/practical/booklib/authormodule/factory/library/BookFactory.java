package com.caniksea.adp3.practical.booklib.authormodule.factory.library;

import com.caniksea.adp3.practical.booklib.authormodule.domain.library.Book;
import com.caniksea.adp3.practical.booklib.authormodule.helper.GenericHelper;

import java.time.LocalDate;
import java.util.UUID;

public class BookFactory {

    /**
     * Instructions:
     *  > Do NOT modify the method signature.
     *  > year parameter must be 4 digits.
     *  > year parameter must not be older than 1900 and/or in the future.
     *  > title parameter must not be empty, null or "null".
     *
     * Tasks:
     *  > Replace the throw exception (line 22) with your attempt of the factory method. (3 mark)
     *
     * @param title
     * @param year
     * @return
     */
    public static Book buildBook(String title, int year) { // DO NOT MODIFY THIS LINE.
        if (GenericHelper.isNullorEmpty(title))
            return new Book.Builder().build();
        int currentYear = LocalDate.now().getYear();
        if (year < 1900 || year > currentYear) return new Book.Builder().build();
        String id = GenericHelper.generateId();
        return new Book.Builder().id(id).title(title).year(year).build();
    }
}
