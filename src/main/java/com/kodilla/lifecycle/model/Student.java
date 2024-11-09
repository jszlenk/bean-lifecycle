package com.kodilla.lifecycle.model;

import java.util.Random;

public class Student {
    private static final Random random = new Random();

    private String indexNumber;

    public Student(int z) {
        this.indexNumber = generateRandomString(z);
    }

    private String generateRandomString(int length) {
        int leftLimit = 48;
        int rightLimit = 122;
        StringBuilder buffer = new StringBuilder(length);

        while (buffer.length() < length) {
            int randomCodePoint = random.nextInt(rightLimit - leftLimit + 1) + leftLimit;
            if (Character.isLetterOrDigit(randomCodePoint)) {
                buffer.append((char) randomCodePoint);
            }
        }
        return buffer.toString();
    }
}
