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

   
    public void enregistrer()throws IOException {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("classement.csv", true)));
        try{
            pw.println(joueur);
        } finally {
            pw.close();
        }
    }


    
}
