package model;
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
<<<<<<< HEAD
    /**
     * @param compteurIA
     * @param compteurplayer
     * @param joueur
     * @param mode
     * @return
     */
    private int rows;
    private int columns;
    private Object grid;
    public int Jouer( Integer compteurIA, Integer compteurplayer, Integer joueur, String mode) {
=======
>>>>>>> 824b57bba40564e2d3d6cf6f7aaf1296eae771bc

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
        grid.afficherGrille();
        System.out.println("C'est au tour de " + currentPlayer.getJoueur() + " de jouer");
        System.out.println(currentPlayer.getCouleur());
        System.out.println("Choisissez une colonne");
        int column = _scan.nextInt();
        while(!grid.gagner()){
            if(grid.grillePleine()){
                System.out.println("La grille est pleine, match nul");
                break;
            }
            grid.addJeton(currentPlayer.getCouleur(), column)
            grid.afficherGrille();
            move++;
            if(!grid.gagner()){
                switchPlayer();
            }
        }
        System.out.println("Le joueur " + currentPlayer.getJoueur() + " a gagné");
    }

    private void switchPlayer() {
        if (currentPlayer == joueur1) {
            currentPlayer = joueur2;
        } else {
            currentPlayer = joueur1;
        }
    }
<<<<<<< HEAD
    
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
    
    public boolean gagner() {

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (( grid).get(i).get(j) != 0) {
                    if(i+3 < rows) { // vérifier une victoire en ligne
                        if (grid.get(i).get(j) == grid.get(i + 1).get(j) && grid.get(i).get(j) == grid.get(i + 2).get(j) && grid.get(i).get(j) == grid.get(i + 3).get(j)) {
                            return true;
                        }
                    }
                    if(j+3 < columns) { // vérifier une victoire en colonne 
                        if (grid.get(i).get(j) == grid.get(i).get(j + 1) && grid.get(i).get(j) == grid.get(i).get(j + 2) && grid.get(i).get(j) == grid.get(i).get(j + 3)) {
                            return true;
                        }
                    }
                    if(i+3 < rows && j+3 < columns) { // Vérifier une victoire en diagonale vers la droite
                        if (grid.get(i).get(j) == grid.get(i + 1).get(j + 1) && grid.get(i).get(j) == grid.get(i + 2).get(j + 2) && grid.get(i).get(j) == grid.get(i + 3).get(j + 3)) {
                            return true;
                        }
                    }
                    if(i+3 < rows && j-3 >= 0) { // vérifier une victoire en diagonale vers la gauche
                        if (grid.get(i).get(j) == grid.get(i + 1).get(j - 1) && grid.get(i).get(j) == grid.get(i + 2).get(j - 2) && grid.get(i).get(j) == grid.get(i + 3).get(j - 3)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}

    // private void nextPlayer() {
    //     if (currentPlayer == player1) {
    //         currentPlayer = player2;
    //     } else {
    //         currentPlayer = player1;
    //     }
    // }}
=======

}



>>>>>>> 824b57bba40564e2d3d6cf6f7aaf1296eae771bc
