package ci.univ;

public class ValidationResult {

    private final PasswordStrength strength;
    private final String crackTime;

    public ValidationResult(
            PasswordStrength strength,
            String crackTime) {

        this.strength = strength;
        this.crackTime = crackTime;
    }

    public PasswordStrength getStrength() {
        return strength;
    }

    public String getCrackTime() {
        return crackTime;
    }
}