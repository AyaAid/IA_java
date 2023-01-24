package model;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class Menu {


    public Menu(){
        
    }
    
    private static Scanner _scan;
    
    String choix;

        do {
            afficherMenu();
            choix _scan.nextLine();
            switch (choix) {
                case "1":
                        System.out.println("\nVous avez choisi de jouer en solo\n");
                        Menu.afficher_menuIA();
                    return;
                case "2":
                    System.out.println("\nVous avez choisi de jouer contre l'IA\n");
                        Menu.afficher_menuIA();
                    return;
                case "3":
                        System.out.println("Vous avez choisi de voir le classement");
                        Menu.afficher_menuIA();
                    return;
                case "4":
                        System.out.println("Vous avez choisi de quitter le jeu");
                        Menu.afficher_menuIA();
                    return;
                default:
                        System.out.println("Veuillez choisir une option valide");     
                        Menu.afficher_menuIA();
  
                    break;
            }
        } while (!choix.equals("q"));


    public static void afficherMenu(String choix) {
        ArrayList<String> menus = new ArrayList<>();
        if (choix == "principale"){
            menus.add("          \u001B[4m⥤ MENU ⥢\u001B[0m\n");
            menus.add("\u001B[32m1-   ⌈    Jouer solo !  ⌋\u001B[0m");
            menus.add("\u001B[93m2-   ⌈   Jouer à deux   ⌋\u001B[0m");
            menus.add("\u001B[33m3-   ⌈    Classement    ⌋\u001B[0m");
            menus.add("\u001B[35m4-   ⌈     Quitter      ⌋\u001B[0m\n");
            Iterator<String> iterator = menus.iterator();

            while(iterator.hasNext()) {
                String menu = iterator.next();
                System.out.println(menu);
            }
            System.out.println("Veuillez choisir une option :");
        }
        else if (choix == "couleur"){

        }
        else if (choix == "niveau"){

        }
    }

    public static void afficher_menuIA() {
        ArrayList<String> menus = new ArrayList<>();
        menus.add("          \u001B[4m⥤ Niveau IA ⥢\u001B[0m");
        menus.add("\u001B[32m1-   ⌈    Easy !  ⌋\u001B[0m");
        menus.add("\u001B[93m2-   ⌈   Medium   ⌋\u001B[0m");
        menus.add("\u001B[34m3-   ⌈    Hard    ⌋\u001B[0m");
        menus.add("\u001B[35m4-   ⌈     Impossible      ⌋\u001B[0m");
        menus.add("\u001B[38mq-   ⌈     Quitter      ⌋\u001B[0m");

        Iterator<String> iterator = menus.iterator();

        while(iterator.hasNext()) {
            String menu = iterator.next();
            System.out.println(menu);
        }
        System.out.println("Veuillez choisir une option :");
    }
    
}

