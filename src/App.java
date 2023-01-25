import java.util.Objects;
import java.util.Scanner;

import model.Classement;

import model.Jeu;
import model.Menu;

public class App {
    private static Scanner _scan = new Scanner(System.in);
    
    public static void main(String[] args) throws Exception {
        
        Menu menu = new Menu();
        Jeu jeu = new Jeu();
        Classement classement;
        while (true) {
            menu.afficherMenu("principale");
            switch (_scan.nextLine()) {
                case "1":
                    System.out.println("\nVous avez choisi de jouer en solo\n");
                    menu.setNbjoueur(1);
                    System.out.println("Veuillez entrer le nom du joueur :");
                    String nom = _scan.nextLine();
                    menu.setName(nom);
                    System.out.println("Choisir une couleur pour le joueur: ");
                    menu.afficherMenu("couleur");
                    String coul = _scan.nextLine();
                    menu.setName(coul);
                    jeu.Jouer(menu.getNbjoueur(), menu.getName(), menu.getCouleur());
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
                    if(Objects.equals(menu.getCouleur().get(0), "🔴")){
                        menu.setCouleur("2");
                    } else{
                        menu.setCouleur("1");
                    }
                    jeu.Jouer(menu.getNbjoueur(), menu.getName(), menu.getCouleur());
                    jeu.start_game();
                    break;
                case "3":
                    System.out.println("Vous avez choisi de voir le classement");
                    Classement score = new Classement("IA_java/src/classement.csv");
                    classement = new Classement("IA_java/src/classement.csv");
                    classement.afficherClassement();
                    return;
                case "4":
                    System.out.println("Vous avez choisi de quitter le jeu\n");
                    return;
                    //Classement score = new Classement();
                    //score.saveClassement("Robert", 10);
                    //break;
                default:
                    System.out.println("Veuillez choisir une option valide\n");
                    break;
            }
        }
    }
}