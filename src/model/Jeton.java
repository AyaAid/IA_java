package model;


public class Jeton {
    private String color;
    private int row;
    private int column;

    public Jeton(String color, int row, int column) {
        this.color = color; // Cette ligne affecte à la variable membre color la valeur de l'argument color passé au constructeur.
        this.row = row; // Cette ligne affecte à la variable membre row la valeur de l'argument row passé au constructeur.
        this.column = column; // Cette ligne affecte à la variable membre column la valeur de l'argument column passé au constructeur.
    }

    public String getColor() { 
        return color;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    } 
}