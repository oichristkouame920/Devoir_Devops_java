package ci.univ;

public class PasswordValidator {

    public ValidationResult validate(String password) {

        int score = 0;

        if (password.length() >= 8) score++;
        if (password.length() >= 12) score++;

        if (password.matches(".*[A-Z].*")) score++;
        if (password.matches(".*[a-z].*")) score++;
        if (password.matches(".*\\d.*")) score++;
        if (password.matches(".*[^a-zA-Z0-9].*")) score++;

        PasswordStrength strength;
        String crackTime;

        if (score <= 2) {
            strength = PasswordStrength.VERY_WEAK;
            crackTime = "Quelques secondes";
        }
        else if (score <= 3) {
            strength = PasswordStrength.WEAK;
            crackTime = "Quelques minutes";
        }
        else if (score <= 4) {
            strength = PasswordStrength.MEDIUM;
            crackTime = "Quelques heures";
        }
        else if (score <= 5) {
            strength = PasswordStrength.STRONG;
            crackTime = "Plusieurs années";
        }
        else {
            strength = PasswordStrength.VERY_STRONG;
            crackTime = "Des milliers d'années";
        }

        return new ValidationResult(
                strength,
                crackTime
        );
    }
}