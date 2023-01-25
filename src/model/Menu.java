package model;
import java.lang.foreign.SymbolLookup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class Menu {
    private int nbjoueur;
    private ArrayList<String> couleur = new ArrayList<>();
    private ArrayList<String> name = new ArrayList<>();

    public Menu() {
        nbjoueur = getNbjoueur();
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
        return getSymbole();
    }

    public void setSymbole(String symb) {
        getCouleur();
        SymbolLookup.add(symb);
    }

    public ArrayList<String> getCouleur() {
        return couleur;
    }

    public void setCouleur(String coul) {
        if(coul.equals("1")){
            couleur.add("🔴");
        }
        else if(coul.equals("2")){
            couleur.add("🟡");
        }
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

            menus.add (Color.RED + " 1 : 🔴" + Color.RESET);
            menus.add (Color.YELLOW +" 2 : 🟡" + Color.RESET);

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