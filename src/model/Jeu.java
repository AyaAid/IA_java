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

}



