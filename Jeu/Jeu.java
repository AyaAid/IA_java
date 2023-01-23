package Jeu;
import java.util.Random;
import java.util.Scanner;
import javax.swing.SpringLayout;

//on clique sur le menu pour sélectionner le mode

public class Jeu {

    private static Scanner _scan = new Scanner(System.in);
    public int Jouer( Integer compteurIA, Integer compteurplayer, Integer joueur, String mode) {

        joueur = 0;
        compteurIA = 0;
        compteurplayer = 0;
        mode = "";

        String choix;
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
        while ((grille != grillefull )){
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
    public int gagner() {
    
    }
    public int match_nul() {
    
    }
    public int perdre() {
    
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