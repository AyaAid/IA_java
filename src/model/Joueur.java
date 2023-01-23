package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Joueur {

    private String joueur;
    private String couleur;

    public void joueur(String joueur, String couleur) {
        this.joueur = joueur;
        this.couleur = couleur;
    }

    public String getJoueur() {
        return joueur;
    }

    public String getCouleur() {
        return couleur;
    }

   



    
}
