package model;
import java.util.Random;
import java.util.Scanner;
import javax.swing.SpringLayout;

//on clique sur le menu pour sélectionner le mode

public class Jeu {

    private static Scanner _scan = new Scanner(System.in);
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

        joueur = 0;
        compteurIA = 0;
        compteurplayer = 0;
        mode = "";

        String choix;
        Object grille;
        Object grillefull;
        do {
            App.afficherMenu();
            choix = _scan.nextLine();
            switch (choix) {
                case "1":
                    mode = "solo";
                    System.out.println("yo");
                    break;
                case "2":
                    mode = "duo";
                    break;
                default:
                    System.out.println("Choix incorrect!");
                    break;
            }
        }

        //tant que la grille n'est pas complete("grille" = le structure du plateau   ==   "grillefull" = plateau complet)
        while (grille != grillefull ){
            // if (mode == "solo"){
                
            // }
            // else if (mode == "duo"){

            // }
            // else{
            //     System.out.println("Tu dois écrire soit 'solo' soit 'duo' !");
            // }
            compteurIA = compteurIA + 1;
            compteurplayer = compteurplayer + 1;
            joueur = 0;
            System.out.println("Start:");
            //si c'est au joueur de jouer
            if (joueur % 2 == 0) {
                compteurIA = compteurIA + 1;
                System.out.println("Le compteur de l'IA est à :" + compteurIA);
            } 
                //si c'est à l'ia de jouer        
            else {
                compteurplayer = compteurplayer + 1;
                System.out.println("Ton compteur est à :" + compteurplayer);
            }
            
            joueur = joueur + 1;
        }
    
        return Math.max(compteurIA, compteurplayer);
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