
import java.security.Principal;
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
            Menu.afficherMenu("principale");
            switch (_scan.nextLine()) {
                case "1":
                        System.out.println("\nVous avez choisi de jouer en solo\n");
                    return;
                case "2":
                        System.out.println("\nVous avez choisi de jouer contre l'IA\n");
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
    
   
} 
