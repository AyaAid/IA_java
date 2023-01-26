package model;
// Cette ligne définit le package auquel appartient la classe Jeton. 


public class Jeton {
    // Cette ligne définit une nouvelle classe appelée Jeton.
    private String color;
    // Cette ligne déclare une variable de type chaîne appelée color qui sera accessible uniquement au sein de la classe Jeton.
    private int row;
    // Cette ligne déclare une variable entière appelée row qui sera accessible uniquement au sein de la classe Jeton.

    private int column;
    // Cette ligne déclare une variable entière appelée column qui sera accessible uniquement au sein de la classe Jeton.


    public Jeton(String color, int row, int column) {
        // Cette ligne déclare un constructeur pour la classe Jeton qui prend trois arguments, une chaîne de caractères appelée color, un entier appelé row et un entier appelé column.

        this.color = color;
        // Cette ligne affecte à la variable membre color la valeur de l'argument color passé au constructeur.

        this.row = row;
        // Cette ligne affecte à la variable membre row la valeur de l'argument row passé au constructeur.

        this.column = column;
        // Cette ligne affecte à la variable membre column la valeur de l'argument column passé au constructeur.

    }

    public String getColor() {
        // Cette ligne déclare une méthode publique appelée getColor qui retourne une chaîne.

        return color;
        // Cette ligne retourne la valeur de la variable membre color.

    }

    public int getRow() {
        // Cette ligne déclare une méthode publique appelée getRow qui retourne un entier.

        return row;
        // Cette ligne retourne la valeur de la variable membre row.

    }

    public int getColumn() {
        // Cette ligne déclare une méthode publique appelée getColumn qui retourne un entier.

        return column;
        // Cette ligne retourne la valeur de la variable membre column.
    } 
}