package com.mechanic_advisor.utils;

public class Utils {

    /**
     * Gets a random number within the specified range.
     *
     * @return {@code int}
     */
    public static int getRandomNumber() {
        return (1000 + (int) (Math.random() * ((9999) + 1)));
    }
}
