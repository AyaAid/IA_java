
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;

import model.Color;
import model.Grille;


public class App {
    private static Scanner _scan;

    public static void main(String[] args) throws Exception{
        while (true) {
            Menu.afficherMenu("principale");
            switch (_scan.nextLine()) {
                case "1":
                        System.out.println("\nVous avez choisi de jouer en solo\n");
                        Menu.afficherMenu("couleur");
                    break;
                case "2":
                        Menu.afficherMenu("symbole");
                    break;
                case "3":
                        Menu.afficherMenu("niveau");
                        System.out.println("Vous avez choisi de voir le classement");
                    break;
                case "4":
                        System.out.println("Vous avez choisi de quitter le jeu");
                    return;
                default:
                        System.out.println("Veuillez choisir une option valide");       
                        System.out.println("Veuillez choisir une option valide");       
                    break;
                }
    }
}
    }
}

    public static void NomduJoueurSolo() {
        System.out.println("\nVeuillez entrer votre nom :");
        String nom = _scan.nextLine();
        Grille.afficherGrille();
        System.out.println( "\n"+ nom +" VS IA");
    }

    public static void NomduJoueur() {
        System.out.println("\nVeuillez entrer le nom du joueur 1 :");
        String nom1 = _scan.nextLine();
        System.out.println("\nVeuillez entrer le nom du joueur 2 :");
        String nom2 = _scan.nextLine();
        Grille.afficherGrille();
        System.out.println( "\n"+ nom1 +" VS " + nom2);
    }

    public static void ChoixdeCouleur() {
        System.out.println("\nVeuillez choisir une couleur :" + Color.RESET);
        System.out.println (Color.RED + " 1 : Rouge" + Color.RESET);
        System.out.println (Color.GREEN +" 2 : Vert" + Color.RESET);
        System.out.println (Color.PURPLE + " 3 : Violet" + Color.RESET);
    }

    public static void ChoixdeSymbole() {
        System.out.println("\nVeuillez choisir un symbole :");
        System.out.println(" 1 : ✘");
        System.out.println(" 2 : 〇");
        
    }

    public static void SelectionSymbole() {
        while (true) {
            ChoixdeSymbole();
            String symbole = _scan.nextLine();
            switch (symbole) {
                case "1":
                    System.out.println("Vous avez choisi le symbole @");
                    return;
                case "2":
                    System.out.println("Vous avez choisi le symbole =");
                    return;
                default:
                    System.out.println("Veuillez choisir une option valide");
                    break;
            }
        }
    }

    public static void SelectionCouleur() {
        while (true) {
            ChoixdeCouleur();
            String couleur = _scan.nextLine();
            switch (couleur) {
                case "1":
                    System.out.println(Color.RED + "Vous avez choisi la couleur Rouge" + Color.RESET);
                    return;
                case "2":
                    System.out.println(Color.GREEN + "Vous avez choisi la couleur Vert" + Color.RESET);
                    return;
                case "3":
                    System.out.println(Color.PURPLE + "Vous avez choisi la couleur Violet" + Color.RESET);
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