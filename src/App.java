
import java.security.Principal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import model.Classement;
import model.Color;
import model.Grille;
import model.Menu;

public class App {
    private static Scanner _scan;
    static Menu menu = new Menu();

    public static void main(String[] args) throws Exception{
        while (true) {
            Menu.afficherMenu("principale");
            switch (_scan.nextLine()) {
                case "1":
                        System.out.println("\nVous avez choisi de jouer en solo\n");
                        menu.setNbjoueur(1);
                        System.out.println("Veuillez entrer le nom du joueur :");
                        String nom = _scan.nextLine();
                        menu.setName(nom);
                        menu.afficherMenu("couleur");
                    break;
                case "2":
                        System.out.println("\nVous avez choisi de jouer à deux\n");
                        menu.setNbjoueur(2);
                        System.out.println("Veuillez entrer le nom du joueur 1 :");
                        String nom1 = _scan.nextLine();
                        menu.setName(nom1);
                        System.out.println("Veuillez entrer le nom du joueur 2 :");
                        String nom2 = _scan.nextLine();
                        menu.setName(nom2);
                    return;
                case "3":
                        System.out.println("Vous avez choisi de voir le classement");
                        Classement score = new Classement("IA_java/src/classement.csv");

                    return;
                case "4":
                        System.out.println("Vous avez choisi de quitter le jeu");
                    return;
                default:
                        System.out.println("Veuillez choisir une option valide");       
                    break;
                }
        }
    }

    static {
        _scan = new Scanner(System.in);
    }

    public App() {
    }
    
   
} 
