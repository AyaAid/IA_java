
import java.util.Scanner;

import model.Classement;

import model.Jeu;
import model.Menu;

public class App {
    private static Scanner _scan = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        
        Menu menu = new Menu();
        Jeu jeu = new Jeu();
        while (true) {
            menu.afficherMenu("principale");
            switch (_scan.nextLine()) {
                case "1":
                    System.out.println("\nVous avez choisi de jouer en solo\n");
                    menu.setNbjoueur(1);
                    System.out.println("Veuillez entrer le nom du joueur :");
                    String nom = _scan.nextLine();
                    menu.setName(nom);
                    menu.afficherMenu("couleur");
                    String coul = _scan.nextLine();
                    menu.setName(coul);
                    menu.afficherMenu("symbole");
                    String symb = _scan.nextLine();
                    menu.setName(symb);
                    jeu.Jouer(menu.getNbjoueur(), menu.getName(), menu.getCouleur(), menu.getSymbole());
                    jeu.start_game();
                    // menu.afficherMenu("niveau");
                    // String symb = _scan.nextLine();
                    // menu.setName(symb);
                    break;
                case "2":
                    System.out.println("\nVous avez choisi de jouer à deux\n");
                    menu.setNbjoueur(2);
                    System.out.println("Veuillez entrer le nom du joueur 1 :\n");
                    String nom1 = _scan.nextLine();
                    menu.setName(nom1);
                    System.out.println("Veuillez entrer le nom du joueur 2 :\n");
                    String nom2 = _scan.nextLine();
                    menu.setName(nom2);
                    System.out.println("Choisir une couleur pour le joueur 1:\n");
                    menu.afficherMenu("couleur");
                    String coul0 = _scan.nextLine();
                    menu.setCouleur(coul0);
                    System.out.println("Choisir une couleur pour le joueur 2:\n");
                    menu.afficherMenu("couleur");
                    String coul1 = _scan.nextLine();
                    menu.setCouleur(coul1);
                    System.out.println("Choisir un symbole pour le joueur 1:\n");
                    menu.afficherMenu("symbole");
                    String symb0 = _scan.nextLine();
                    menu.setSymbole(symb0);
                    System.out.println("Choisir un symbole pour le joueur 2:\n");
                    menu.afficherMenu("symbole");
                    String symb1 = _scan.nextLine();
                    menu.setSymbole(symb1);
                    jeu.Jouer(menu.getNbjoueur(), menu.getName(), menu.getCouleur(), menu.getSymbole());
                    jeu.start_game();
                    break;
                case "3":
                    System.out.println("Vous avez choisi de voir le classement\n");
                    Classement score = new Classement("IA_java/src/classement.csv\n");
                    score.afficherClassement();
                    return;
                case "4":
                    System.out.println("Vous avez choisi de quitter le jeu\n");
                    return;
                default:
                    System.out.println("Veuillez choisir une option valide\n");
                    break;
            }
        }
    }
}