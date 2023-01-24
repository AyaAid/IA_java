
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;

import model.Color;
import model.Grille;
import model.Menu;

public class App {
    private static Scanner _scan;

    public static void main(String[] args) throws Exception{
        while (true) {
            afficherMenu();
            switch (_scan.nextLine()) {
                case "1":
                        System.out.println("\nVous avez choisi de jouer en solo\n");
                        SelectionCouleur();
                        SelectionSymbole();
                        NomduJoueurSolo();
                    return;
                case "2":
                        SelectionCouleur();
                        SelectionSymbole();
                        NomduJoueur();
                    return;
                case "3":
                        System.out.println("Vous avez choisi de voir le classement");
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
    
    public static void afficherMenu() {
        ArrayList<String> menus = new ArrayList<>();
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
} 
