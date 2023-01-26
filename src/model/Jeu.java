package model;
import java.util.ArrayList;
import java.util.Scanner;
public class Jeu {
    private Grille grid = new Grille();
    Joueur joueur1; //Cette ligne déclare une nouvelle instance de Joueur et la stocke dans la variable joueur1.

    private Joueur joueur2; //Cette ligne déclare une nouvelle instance de Joueur et la stocke dans la variable joueur2.
    private int move; //Cette ligne déclare une variable de type entier (move) qui compte le nombre de mouvements effectués.
    Joueur currentPlayer; //Cette ligne déclare une variable de type Joueur qui stocke le joueur actuel.

    private int rows = 6;
    private int columns = 7; //Cette ligne déclare deux variables de type entier qui définissent le nombre de lignes et de colonnes de la grille.

    private IA ia = new IA(); //Cette ligne déclare une nouvelle instance de l'IA et la stocke dans la variable ia.


    private Scanner _scan = new Scanner(System.in); //Cette ligne déclare une nouvelle instance de Scanner et la stocke dans la variable _scan.


    public void Jouer(int nombreJoueur, ArrayList<String> name, ArrayList<String> couleur) {
        grid = new Grille();
        joueur1 = new Joueur((String) name.get(0), (String) couleur.get(0));
        if (nombreJoueur == 2) {
            joueur2 = new Joueur((String) name.get(1), (String) couleur.get(1));
        } else {
            couleur.add("⚪️");
            joueur2 = new Joueur("IA", (String) couleur.get(1));
        }
        currentPlayer = joueur1;
    } //Cette ligne définit une méthode qui prend en entrée le nombre de joueurs, leur nom et leur couleur et initialise les variables (joueur1 et joueur2).


    public void start_game() {

        grid.afficherGrille();
        System.out.println("C'est au tour de " + currentPlayer.getJoueur() + " de jouer"); //Cette ligne définit une méthode qui change de joueur à chaque tour.

        System.out.println(currentPlayer.getCouleur());
        System.out.println("Choisissez une colonne");
        int column = _scan.nextInt();
        while (!grid.gagner()) {
            if (grid.grillePleine()) {
                System.out.println("La grille est pleine, match nul");
                break;
            }
            grid.addJeton(currentPlayer.getCouleur(), column);
            grid.afficherGrille();
            move++;
            if (!grid.gagner()) {
                switchPlayer();
                System.out.println("C'est au tour de " + currentPlayer.getJoueur() + " de jouer");
                System.out.println(currentPlayer.getCouleur());
                System.out.println("Choisissez une colonne");
                column = _scan.nextInt();
            }
        }
        System.out.println("Le joueur " + currentPlayer.getJoueur() + " a gagné");
        grid.reinitialiserGrille();
        Classement score = new Classement("IA_java/src/classement.csv");
        score.saveClassement(getCurrentPlayer().getJoueur(), getMove());
        // Classement score = new Classement("IA_java/src/classement.csv");
        // try {
        // score.saveScore(currentPlayer.getJoueur(), move);
        // } catch (IOException e) {
        // System.out.println("Erreur lors de l'écriture du fichier");
        // }
    }

    private void switchPlayer() {
        if (currentPlayer == joueur1) {
            currentPlayer = joueur2;
        } else {
            currentPlayer = joueur1;
        }
    }

    public Joueur getCurrentPlayer() {
        return currentPlayer;
    }

    public int getMove() {
        return move;
    }

    public void jouerIA() {

        grid.afficherGrille();
        System.out.println("C'est au tour de " + currentPlayer.getJoueur() + " de jouer");
        System.out.println(currentPlayer.getCouleur());
        System.out.println("Choisissez une colonne");
        int column = _scan.nextInt();
        while (!grid.gagner()) {
            if (grid.grillePleine()) {
                System.out.println("La grille est pleine, match nul");
                break;
            }
            if (currentPlayer.getCouleur().equals("⚪️")) {
                grid.IA2(joueur1.getCouleur());
            } else {
                grid.addJeton(currentPlayer.getCouleur(), column);
            }
            grid.afficherGrille();
            move++;
            if (!grid.gagner()) {
                switchPlayer();
                System.out.println("C'est au tour de " + currentPlayer.getJoueur() + " de jouer");
                System.out.println(currentPlayer.getCouleur());
                if (currentPlayer == joueur1) {
                    System.out.println("Choisissez une colonne");
                    column = _scan.nextInt();
                }

            }

        }
        System.out.println("Le joueur " + currentPlayer.getJoueur() + " a gagné");
    }

    // Classement score = new Classement("IA_java/src/classement.csv");
    // score.saveClassement(getCurrentPlayer(), getMove());
        }
