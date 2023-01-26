import java.util.Objects;
import java.util.Scanner; 
import model.Classement;
import model.Jeu;

import model.Menu;

public class App {

    private static Scanner _scan = new Scanner(System.in);
    public static void main(String[] args) throws Exception {

        Menu menu = new Menu(); // Cette ligne déclare un objet Menu qui sera utilisé pour afficher les menus et récupérer les entrées de l'utilisateur. 

        Jeu jeu = new Jeu(); // Cette ligne déclare un objet Jeu qui sera utilisé pour initialiser le jeu et le lancer. 

        while (true) { // Cette ligne définit une boucle infinie qui s'exécutera tant que l'utilisateur ne quitte pas le jeu. 

            menu.afficherMenu("principale"); // Cette ligne appelle la méthode afficherMenu() sur l'objet Menu pour afficher le menu principal. 

            switch (_scan.nextLine()) { // Cette ligne vérifie quelle option a été choisie par l'utilisateur et exécute le code associé. 

                case "1":
                    System.out.println("\nVous avez choisi de jouer en solo\n");
                    menu.setNbjoueur(1);
                    System.out.println("Veuillez entrer le nom du joueur :");
                    String nom = _scan.nextLine();
                    menu.setName(nom);
                    System.out.println("Choisir une couleur pour le joueur: ");
                    menu.afficherMenu("couleur");
                    String coul = _scan.nextLine();
                    menu.setCouleur(coul);

                    System.out.println("Choisir un niveau de difficulté: ");
                    menu.afficherMenu("niveau");
                    String niv = _scan.nextLine();
                    menu.setNiveau(niv);
                    
                    jeu.Jouer(menu.getNbjoueur(), menu.getName(), menu.getCouleur());
                    jeu.jouerIA();
                    // Cette ligne appelle la méthode Jouer() sur l'objet Jeu pour lancer le jeu. 

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
                    if (Objects.equals(menu.getCouleur().get(0), "🔴")) {
                        menu.setCouleur("2");
                    } else {
                        menu.setCouleur("1");
                    }
                    jeu.Jouer(menu.getNbjoueur(), menu.getName(), menu.getCouleur());
                    jeu.start_game(); // Cette ligne appelle la méthode start_game() sur l'objet Jeu pour lancer le jeu à deux joueurs. 

                    break;
                case "3":
                    System.out.println("Vous avez choisi de voir le classement");
                    Classement score = new Classement("IA_java/src/classement.csv");
                    score = new Classement("IA_java/src/classement.csv");
                    score.afficherClassement(); // Cette ligne instancie un objet Classement qui peut être utilisé pour afficher le classement des joueurs. 

                    // Classement score = new Classement("IA_java/src/classement.csv");
                    // Classement.afficherClassement();
                    return;
                case "4":
                    System.out.println("Vous avez choisi de quitter le jeu\n");
                    return;
                    //Classement score = new Classement();
                    //score.saveClassement("Robert", 10);
                    //break;
                default:
                    System.out.println("Veuillez choisir une option valide\n");
                    break; // Cette ligne termine le programme.
            }
        }
    }
}