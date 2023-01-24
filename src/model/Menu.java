package model;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class Menu {
    private int nbjoueur;
    private ArrayList<String> symbole = new ArrayList<>();
    private ArrayList<String> couleur = new ArrayList<>();
    private static Scanner _scan;

    public Menu(int nbjoueur, ArrayList<String> symbole, ArrayList<String> couleur) {
        this.nbjoueur = nbjoueur;
        this.symbole = symbole;
        this.couleur = couleur;
    }

    public int getNbjoueur() {
        return nbjoueur;
    }

    public void setNbjoueur(int nbjoueur) {
        this.nbjoueur = nbjoueur;
    }

    public ArrayList<String> getSymbole() {
        return symbole;
    }

    public void setSymbole(String symb) {
        symbole.add(symb);
    }

    public ArrayList<String> getCouleur() {
        return couleur;
    }

    public void setCouleur(String coul) {
        couleur.add(coul);
    }
        // do {
        //     afficherMenu(null);
        //     choix _scan.nextLine();
        //     switch (choix) {
        //         case "1":
        //                 System.out.println("\nVous avez choisi de jouer en solo\n");
        //                 Menu.afficher_menuIA();
        //             return;
        //         case "2":
        //             System.out.println("\nVous avez choisi de jouer contre l'IA\n");
        //                 Menu.afficher_menuIA();
        //             return;
        //         case "3":
        //                 System.out.println("Vous avez choisi de voir le classement");
        //                 Menu.afficher_menuIA();
        //             return;
        //         case "4":
        //                 System.out.println("Vous avez choisi de quitter le jeu");
        //                 Menu.afficher_menuIA();
        //             return;
        //         default:
        //                 System.out.println("Veuillez choisir une option valide");     
        //                 Menu.afficher_menuIA();
  
        //             break;
        //     }
        // } while (!choix.equals("q"));


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
                String menus = iterator.next();
                System.out.println(menus);
            }
        }
        else if (choix == "couleur"){
            System.out.println("\nVeuillez choisir une couleur :" + Color.RESET);
            System.out.println (Color.RED + " 1 : Rouge" + Color.RESET);
            System.out.println (Color.GREEN +" 2 : Vert" + Color.RESET);
            System.out.println (Color.PURPLE + " 3 : Violet" + Color.RESET);
        }
        else if (choix == "symbole"){
            System.out.println("\nVeuillez choisir un symbole :");
            System.out.println(" 1 : ✘");
            System.out.println(" 2 : 〇");
        }
        else if (choix == "niveau"){
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
        }
        else{
            System.out.println("Veuillez choisir une option :");
        }
        
    }

}

