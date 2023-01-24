package model;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
//on clique sur le menu pour sélectionner le mode

public class Jeu {
    private static Grille grid;
    static Joueur joueur1;
    private static Joueur joueur2;
    private static int nombreJoueur;
    private static int move;
    static Joueur currentPlayer;

    private static Scanner _scan = new Scanner(System.in);


    public static void Jouer( int nombreJoueur, ArrayList name, ArrayList couleur, ArrayList symbole) {
        System.out.println(nombreJoueur);
        System.out.println(name);
        System.out.println(couleur);
        System.out.println(symbole);
        grid = new Grille();
        joueur1 = new Joueur((String) name.get(0), (String) couleur.get(0), (String) symbole.get(0));
        if(nombreJoueur == 2){
            joueur2 = new Joueur((String) name.get(1), (String) couleur.get(1), (String) couleur.get(1));
        }
        else{
            if(Objects.equals(couleur.get(0), "❌")){
                couleur.add("🟣");
            } else{
                couleur.add("❌");
            }
            if(Objects.equals(symbole.get(0), "@")){
                symbole.add("✘");
            } else{
                symbole.add("〇");
            }
            joueur2 = new Joueur("IA", (String) couleur.get(1), (String) symbole.get(1));
        }
        currentPlayer = joueur1;
    }

    public static void start_game(){
        Grille.afficherGrille();
        System.out.println("C'est au tour de " + Joueur.getJoueur() + " de jouer");
        System.out.println(currentPlayer.getCouleur());
        System.out.println("Choisissez une colonne");
        int column = _scan.nextInt();
        while(!grid.gagner()){
            if(grid.grillePleine()){
                System.out.println("La grille est pleine, match nul");
                break;
            }
            Grille.addJeton(currentPlayer.getCouleur(), column);
            Grille.afficherGrille();
            move++;
            if(!grid.gagner()){
                switchPlayer();
            }
        }
        System.out.println("Le joueur " + Joueur.getJoueur() + " a gagné");
        Classement score = new Classement("IA_java/src/classement.csv");
        try {
            score.saveScore(Joueur.getJoueur(), move);
        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture du fichier");
        }
    }

    private static void switchPlayer() {
        if (currentPlayer == joueur1) {
            currentPlayer = joueur2;
        } else {
            currentPlayer = joueur1;
        }
    }

}


