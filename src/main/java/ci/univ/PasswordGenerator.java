package main.java.ci.univ;

import java.security.SecureRandom;

public class PasswordGenerator {

    private static final String LOWER =
            "abcdefghijklmnopqrstuvwxyz";

    private static final String UPPER =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static final String DIGITS =
            "0123456789";

    private static final String SYMBOLS =
            "!@#$%^&*()-_=+[]{}<>?";

    private final SecureRandom random =
            new SecureRandom();

    public String generate(
            int length,
            boolean upper,
            boolean lower,
            boolean digits,
            boolean symbols) {

        StringBuilder pool = new StringBuilder();

        if (upper) pool.append(UPPER);
        if (lower) pool.append(LOWER);
        if (digits) pool.append(DIGITS);
        if (symbols) pool.append(SYMBOLS);

        if (pool.isEmpty()) {
            throw new IllegalArgumentException(
                    "Aucun type de caractère sélectionné.");
        }

        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {

            int index = random.nextInt(pool.length());

            password.append(pool.charAt(index));
        }

        return password.toString();
    }
}