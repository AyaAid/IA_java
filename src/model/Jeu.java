package model;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
//on clique sur le menu pour sélectionner le mode

public class Jeu {
    private Grille grid;
    private Joueur joueur1;
    private Joueur joueur2;
    private int nombreJoueur;
    private int move;
    private Joueur currentPlayer;

    private static Scanner _scan = new Scanner(System.in);


    public void Jouer( int nombreJoueur, ArrayList name, ArrayList couleur, ArrayList symbole) {
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
                symbole.add("=");
            } else{
                symbole.add("@");
            }
            joueur2 = new Joueur("IA", (String) couleur.get(1), (String) symbole.get(1));
        }
        currentPlayer = joueur1;
    }

    public void start_game(){
        Grille.afficherGrille();
        System.out.println("C'est au tour de " + currentPlayer.getJoueur() + " de jouer");
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
        System.out.println("Le joueur " + currentPlayer.getJoueur() + " a gagné");
        Classement score = new Classement("IA_java/src/classement.csv");
        try {
            score.saveScore(currentPlayer.getJoueur(), move);
        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture du fichier");
        }
    }

    private void switchPlayer() {
        if (currentPlayer == joueur1) {
            currentPlayer = joueur2;
        } else {
            currentPlayer = joueur1;
        }
    }
    
    public static boolean gagner (int compteurIA, int compteurplayer)
    {
        if (compteurIA == 21)
        {
            return true;
        }
        else
        {
            return false;
        }
    
    }
   
    public static boolean match_nul (int compteurIA, int compteurplayer)
    {
    if (compteurIA == 21 && compteurplayer == 21)
    {
        return true;
    }
    else
    {
        return false;
    }
    }

    public static boolean perdre(int compteurIA, int compteurplayer)
    {
        if (compteurplayer == 21)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    

}


