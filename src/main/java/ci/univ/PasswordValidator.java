package ci.univ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PasswordValidator {

    public ValidationResult validate(String password) {

        try {

            ProcessBuilder processBuilder = new ProcessBuilder(
                    "docker",
                    "exec",
                    "password-validator",
                    "node",
                    "/app/validator.js",
                    password
            );

            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream())
            );

            String result = reader.readLine();

            process.waitFor();

            PasswordStrength strength;
            String crackTime;

            if (result != null && result.contains("\"score\":4")) {

                strength = PasswordStrength.VERY_STRONG;
                crackTime = "Des milliers d'années";

            } else if (result != null && result.contains("\"score\":3")) {

                strength = PasswordStrength.STRONG;
                crackTime = "Plusieurs années";

            } else if (result != null && result.contains("\"score\":2")) {

                strength = PasswordStrength.MEDIUM;
                crackTime = "Quelques heures";

            } else if (result != null && result.contains("\"score\":1")) {

                strength = PasswordStrength.WEAK;
                crackTime = "Quelques minutes";

            } else {

                strength = PasswordStrength.VERY_WEAK;
                crackTime = "Quelques secondes";
            }

            return new ValidationResult(
                    strength,
                    crackTime
            );

        } catch (Exception e) {

            // Si Docker n'est pas disponible,
            // le programme continue de fonctionner.

            return new ValidationResult(
                    PasswordStrength.VERY_WEAK,
                    "Docker non disponible"
            );
        }
    }
}