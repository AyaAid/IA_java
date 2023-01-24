package model;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class menuIA {
    
    private static Scanner _scan;
    
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
    }
    public static void mainIA(String[] args) throws Exception{
  
        afficher_menuIA();
        switch (_scan.nextLine()) {
            case "1":
                Grille.afficherGrille();
                //variable niv = 1
                break;
            case "2":
                Grille.afficherGrille();
                //variable niv = 2
                break;
            case "3":
                Grille.afficherGrille();
                //variable niv = 3
                break;
            case "4":
                Grille.afficherGrille();
                //variable niv = 4
                break;
            case "q":
                return;
            default:
                System.out.println("Veuillez saisir une des valeurs proposé du menu");
            }
        
    }
}