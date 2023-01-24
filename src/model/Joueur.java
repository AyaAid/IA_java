package model;

public class Joueur {

    private static String joueur;
    private String couleur;
    private String symbole;

    public Joueur(String joueur, String couleur, String symbole) {
        this.joueur = joueur;
        this.couleur = couleur;
        this.symbole = symbole;
    }

    public static String getJoueur() {
        return joueur;
    }

    public String getCouleur() {
        return couleur;
    }

    public String getSymbole() {
        return symbole;
    }
}