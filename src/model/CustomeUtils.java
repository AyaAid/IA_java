package model;

import java.util.Scanner;

public class CustomeUtils {
    /**
     * Récupère la chaine de caractères saisie par l'utilisateur
     *
     * @return La chaine de caractères saisie par l'utilisateur
     */
    public static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        return userInput;
    }
}