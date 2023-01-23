package model;

public class Pions {
    private String color;
    private int row;
    private int column;

    public Pions(String color, int row, int column) {
        this.color = color;
        this.row = row;
        this.column = column;
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