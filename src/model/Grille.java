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
}