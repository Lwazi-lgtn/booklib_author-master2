package com.caniksea.adp3.practical.booklib.authormodule.helper;

import java.util.UUID;

public class GenericHelper {
    public static String generateId() {
        return UUID.randomUUID().toString();
    }

    public static boolean isNullorEmpty(String str) {
        if (str == null) return true;
        if (str.isEmpty()) return true;
        if (str.equalsIgnoreCase("null")) return true;
        return false;
    }
}
