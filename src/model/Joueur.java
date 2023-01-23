package model;

public class Joueur {

    private String joueur;
    private String couleur;
    private String symbole;

    public Joueur(String joueur, String couleur) {
        this.joueur = joueur;
        this.couleur = couleur;
    }

    public String getJoueur() {
        return joueur;
    }

    public String getCouleur() {
        return couleur;
    }

    public String getSymbole() {
        return symbole;
    }

    public void setSymbole(String symbole) {
        this.symbole = symbole;
    }
}