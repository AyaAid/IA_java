package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Jeu {
    private Grille grid = new Grille();
    private Classement classement = new Classement();
    Joueur joueur1;
    private Joueur joueur2;
    private int move;
    private int moveJoueur1;
    private int moveJoueur2;
    Joueur currentPlayer;
    private Scanner _scan = new Scanner(System.in);
    public static int jetonIA;

    /**
     * @author : Aya
     * @param nombreJoueur : nombre entier egal à 1 ou 2 selon le nombre de joueur
     * @param name         : liste de chaine de caractère contenant les noms des
     *                     joueurs
     * @param couleur      : liste de chaine de caractère contenant les couleurs des
     *                     joueurs
     * @return none
     *         Cette méthode permet de jouer au puissance 4
     */
    public void Jouer(int nombreJoueur, ArrayList<String> name, ArrayList<String> couleur) {
        grid = new Grille();
        joueur1 = new Joueur((String) name.get(name.size() - 1), (String) couleur.get(couleur.size() - 1));
        if (nombreJoueur == 2) {
            joueur2 = new Joueur((String) name.get(name.size() - 2), (String) couleur.get(couleur.size() - 2));
        } else {
            joueur2 = new Joueur("IA", "⚪️");
        }
        currentPlayer = joueur1;
    } // Cette ligne définit une méthode qui prend en entrée le nombre de joueurs,
      // leur nom et leur couleur et initialise les variables (joueur1 et joueur2).

    /**
     * @author : Aya
     * @return none
     *         Cette méthode permet de changer de joueur à chaque tour
     */
    public void start_game() {

        grid.afficherGrille();
        System.out.println("C'est au tour de " + currentPlayer.getJoueur() + " de jouer"); // Cette ligne définit une
                                                                                           // méthode qui change de
                                                                                           // joueur à chaque tour.

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

            if (currentPlayer == joueur1) {
                moveJoueur1++;
            } else {
                moveJoueur2++;
            }
            move++;
            if (!grid.gagner()) {
                switchPlayer();
                System.out.println("C'est au tour de " + currentPlayer.getJoueur() + " de jouer");
                System.out.println(currentPlayer.getCouleur());
                System.out.println("Choisissez une colonne");
                column = _scan.nextInt();
            }
        }
        if (currentPlayer == joueur1) {
            move -= moveJoueur2;
        } else {
            move -= moveJoueur1;
        }
        System.out.println("Le joueur " + currentPlayer.getJoueur() + " a gagné");
        classement.ajouterScore(currentPlayer.getJoueur(), move);
        grid.reinitialiserGrille();
    }

    /**
     * @author : Aya
     * @return none
     *         Cette méthode permet de changer de joueur à chaque tour
     */
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

    /**
     * @author : Aya
     * @return none
     *         Cette méthode permet de joueur avec une IA
     */
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
                if (jetonIA == 1) {
                    grid.IA1();
                }
                if (jetonIA == 2) {
                    grid.IA2(joueur1.getCouleur());
                }
                if (jetonIA == 3) {
                    grid.IA3(joueur1.getCouleur());
                }
                if (jetonIA == 4) {
                    grid.IA4(joueur2.getCouleur(), joueur1.getCouleur());
                }
            } else {
                grid.addJeton(currentPlayer.getCouleur(), column);
            }
            grid.afficherGrille();
            if (!grid.gagner()) {
                switchPlayer();
                move++;
                System.out.println("C'est au tour de " + currentPlayer.getJoueur() + " de jouer");
                System.out.println(currentPlayer.getCouleur());
                if (currentPlayer == joueur1) {
                    System.out.println("Choisissez une colonne");
                    column = _scan.nextInt();
                    while (grid.colonnePleine(column)) {
                        System.out.println("La colonne n'existe pas");
                        System.out.println("Choisissez une colonne");
                        column = _scan.nextInt();
                    }
                }

            }

        }
        System.out.println("Le joueur " + currentPlayer.getJoueur() + " a gagné");
        if (currentPlayer == joueur1) {
            classement.ajouterScore(currentPlayer.getJoueur(), move);
        }
    }
}
