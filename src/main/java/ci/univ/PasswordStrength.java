package main.java.ci.univ;

public enum PasswordStrength {

    VERY_WEAK("Très faible"),
    WEAK("Faible"),
    MEDIUM("Moyen"),
    STRONG("Fort"),
    VERY_STRONG("Très fort");

    private final String label;

    PasswordStrength(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}