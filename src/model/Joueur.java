package model;
// Ce code commence par un package model, ce qui indique que les classes contenues à l'intérieur de ce répertoire sont des classes destinées à être utilisées pour construire des modèles.


public class Joueur {
    // Cette ligne déclare une classe publique appelée Joueur qui est utilisée pour stocker des informations sur un joueur d'un jeu.


    private String joueur;
    private String couleur;
    // Ces lignes déclarent deux variables privées qui sont utilisées pour stocker le nom du joueur et la couleur du joueur.



    public Joueur(String joueur, String couleur) {
        // Cette ligne déclare un constructeur qui prend en paramètre le nom du joueur et la couleur et les stocke dans les variables déclarées précédemment.

        this.joueur = joueur;
        this.couleur = couleur;
    }

    public String getJoueur() {
        // Cette ligne déclare une méthode publique qui retourne le nom du joueur.

        return joueur;
    }

    public String getCouleur() {
        // Cette ligne déclare une méthode publique qui retourne la couleur du joueur.
        return couleur;
        
    }
}