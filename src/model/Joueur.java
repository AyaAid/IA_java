package model;

public class Joueur {

    private String joueur;
    private String couleur;

    public Joueur(String joueur, String couleur) { // Cette ligne déclare un constructeur qui prend en paramètre le nom du joueur et la couleur et les stocke dans les variables déclarées précédemment.

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