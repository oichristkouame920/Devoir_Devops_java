package ci.univ;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("GENERATEUR DE MOTS DE PASSE");
        System.out.println("=================================");

        System.out.print("Longueur du mot de passe : ");
        int length = scanner.nextInt();

        System.out.print("Inclure les majuscules ? (o/n) : ");
        boolean upper = scanner.next().equalsIgnoreCase("o");

        System.out.print("Inclure les minuscules ? (o/n) : ");
        boolean lower = scanner.next().equalsIgnoreCase("o");

        System.out.print("Inclure les chiffres ? (o/n) : ");
        boolean digits = scanner.next().equalsIgnoreCase("o");

        System.out.print("Inclure les symboles ? (o/n) : ");
        boolean symbols = scanner.next().equalsIgnoreCase("o");

        System.out.print("Nombre de mots de passe à générer : ");
        int count = scanner.nextInt();

        PasswordGenerator generator = new PasswordGenerator();
        PasswordValidator validator = new PasswordValidator();

        System.out.println();

        for (int i = 1; i <= count; i++) {

            String password = generator.generate(
                    length,
                    upper,
                    lower,
                    digits,
                    symbols
            );

            ValidationResult result =
                    validator.validate(password);

            System.out.println("Mot de passe " + i + " :");
            System.out.println(password);

            System.out.println("Force : "
                    + result.getStrength().getLabel());

            System.out.println("Temps estimé : "
                    + result.getCrackTime());

            System.out.println("---------------------------------");
        }

        scanner.close();
    }
}