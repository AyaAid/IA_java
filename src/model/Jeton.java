package model;

public class Jeton {
    private String color;
    private int row;
    private int column;

    public Jeton(String color, int row, int column) {
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