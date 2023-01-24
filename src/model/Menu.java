package model;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import model.*;

public class Menu {
    private int nbjoueur;
    private ArrayList<String> symbole = new ArrayList<>();
    private ArrayList<String> couleur = new ArrayList<>();
    private ArrayList<String> name = new ArrayList<>();
    private static Scanner _scan;

    public Menu() {
        nbjoueur = getNbjoueur();
        symbole = getSymbole();
        couleur = getCouleur();
    }

    public ArrayList<String> getName() {
        return name;
    }

    public void setName(String nom) {
        name.add(nom);
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


    public void afficherMenu(String choix) {
        ArrayList<String> menus = new ArrayList<>();
        if (choix == "principale"){
            menus.add("          \u001B[4m⥤ MENU ⥢\u001B[0m\n");
            menus.add("\u001B[32m1-   ⌈    Jouer solo !  ⌋\u001B[0m");
            menus.add("\u001B[93m2-   ⌈   Jouer à deux   ⌋\u001B[0m");
            menus.add("\u001B[33m3-   ⌈    Classement    ⌋\u001B[0m");
            menus.add("\u001B[35m4-   ⌈     Quitter      ⌋\u001B[0m\n");

            Iterator<String> iterator = menus.iterator();
            while(iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        }
        else if (choix == "couleur"){

            menus.add (Color.RED + " 1 : Rouge" + Color.RESET);
            menus.add (Color.GREEN +" 2 : Vert" + Color.RESET);
            menus.add (Color.PURPLE + " 3 : Violet" + Color.RESET);

            Iterator<String> iterator = menus.iterator();
            while(iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        }
        else if (choix == "symbole"){

            menus.add(" 1 : ✘");
            menus.add(" 2 : 〇");

            Iterator<String> iterator = menus.iterator();
            while(iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        }
        else if (choix == "niveau"){
            menus.add("          \u001B[4m⥤ Niveau IA ⥢\u001B[0m");
            menus.add("\u001B[32m1-   ⌈       Easy !    ⌋\u001B[0m");
            menus.add("\u001B[93m2-   ⌈      Medium     ⌋\u001B[0m");
            menus.add("\u001B[34m3-   ⌈       Hard      ⌋\u001B[0m");
            menus.add("\u001B[35m4-   ⌈    Impossible   ⌋\u001B[0m");
            menus.add("\u001B[38mq-   ⌈      Quitter    ⌋\u001B[0m");
    
            Iterator<String> iterator = menus.iterator();
            while(iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        }
        else{
            menus.add("Veuillez choisir une option :");
        }
        
    }

}

