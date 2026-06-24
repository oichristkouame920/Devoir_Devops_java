package main.java.ci.univ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PasswordValidator {

    public ValidationResult validate(String password) {

        try {

            ProcessBuilder pb = new ProcessBuilder(
                    "docker",
                    "exec",
                    "password-validator",
                    "node",
                    "/app/validator.js",
                    password
            );

            Process process = pb.start();

            BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(
                                    process.getInputStream()
                            )
                    );

            String result = reader.readLine();

            process.waitFor();

            // Ici normalement on analyserait le JSON
            // retourné par validator.js

            return new ValidationResult(
                    PasswordStrength.STRONG,
                    result
            );

        } catch (Exception e) {

            return new ValidationResult(
                    PasswordStrength.VERY_WEAK,
                    "Docker non disponible"
            );
        }
    }
}