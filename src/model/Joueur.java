package model;

public class Joueur {

    /**
     *@autor : Aya et Romain
     * @return
     * Cette classe permet de définir les joueurs et leurs couleurs.
     */
    private String joueur;
    private String couleur;

    /**
     * @param joueur
     * @param couleur
     * @return 
     * Cette méthode permet de définir les joueurs et leurs couleurs.
     */
    public Joueur(String joueur, String couleur) { // Cette ligne déclare un constructeur qui prend en paramètre le nom du joueur et la couleur et les stocke dans les variables déclarées précédemment.

        this.joueur = joueur;
        this.couleur = couleur;
    }

    /**
     * @return
     * Cette méthode permet de récupérer le nom du joueur.
     */
    public String getJoueur() {
        return joueur;
    }

    /**
     * @return
     * Cette méthode permet de récupérer la couleur du joueur.
     */
    public String getCouleur() {
        return couleur;
        
    }
}