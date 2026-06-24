package ci.univ;

import java.security.SecureRandom;

public class PasswordGenerator {

    private static final String UPPER =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
 
    private static final String LOWER =
            "abcdefghijklmnopqrstuvwxyz";

    private static final String DIGITS =
            "0123456789";

    private static final String SYMBOLS =
            "!@#$%^&*()-_=+[]{};:,.<>?";

    private final SecureRandom random =
            new SecureRandom();

    public String generate(
            int length,
            boolean upper,
            boolean lower,
            boolean digits,
            boolean symbols) {

        StringBuilder characters =
                new StringBuilder();

        if (upper) characters.append(UPPER);
        if (lower) characters.append(LOWER);
        if (digits) characters.append(DIGITS);
        if (symbols) characters.append(SYMBOLS);

        if (characters.isEmpty()) {
            characters.append(LOWER);
        }

        StringBuilder password =
                new StringBuilder();

        for (int i = 0; i < length; i++) {

            int index =
                    random.nextInt(characters.length());

            password.append(
                    characters.charAt(index)
            );
        }

        return password.toString();
    }
}