package model;

import java.util.*;


public class Grille {
    private static int rows = 7;
    private static int columns = 6;
    static ArrayList<ArrayList<String>> grid = new ArrayList<ArrayList<String>>();


    public static void afficherGrille(){
        for (int i = 0; i < rows; i++) {
            grid.add(new ArrayList<String>(columns));
            }
        System.out.println("   1     2     3     4     5     6     7");
        System.out.println();
        for(int c = 1; c <= columns; c++){
            System.out.println("  ");
            for(int i= 0; i < rows; i++){

                    System.out.print("|----|");
                
            }
            System.out.println();
        }
        System.out.println();

    }

    public static void addJeton(String color, int column){
        if(column > 1 || column > columns){
            System.out.println("La colonne n'existe pas");
        }
        else{
            for(int i = rows - 1; i >= 0; i--){
                if(grid.get(i).get(column-1) == null){
                    grid.get(i).set(column-1, color);
                    break;
                }
            }
        }
    }

    public boolean colonnePleine(int column) {
        if (grid.get(0).get(column) != null) {
            return true;
        }
        return false;
    }
    
    public boolean grillePleine() {
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(i).size(); j++) {
                if (grid.get(i).get(j) == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean gagner(){
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                if(grid.get(i).get(j) != null){
                    if(grid.get(i).get(j) == grid.get(i).get(j+1) && grid.get(i).get(j) == grid.get(i).get(j+2) && grid.get(i).get(j) == grid.get(i).get(j+3)){
                        return true;
                    }
                    if(grid.get(i).get(j) == grid.get(i+1).get(j) && grid.get(i).get(j) == grid.get(i+2).get(j) && grid.get(i).get(j) == grid.get(i+3).get(j)){
                        return true;
                    }
                    if(grid.get(i).get(j) == grid.get(i+1).get(j+1) && grid.get(i).get(j) == grid.get(i+2).get(j+2) && grid.get(i).get(j) == grid.get(i+3).get(j+3)){
                        return true;
                    }
                    if(grid.get(i).get(j) == grid.get(i+1).get(j-1) && grid.get(i).get(j) == grid.get(i+2).get(j-2) && grid.get(i).get(j) == grid.get(i+3).get(j-3)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}