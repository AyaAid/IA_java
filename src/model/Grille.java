package model;

import java.util.*;


public class Grille {

    public static void afficherGrille(){
            ArrayList<ArrayList<String>> tableau = new ArrayList<ArrayList<String>>();
            System.out.println("   1     2     3     4     5     6     7");
            for (int y = 0; y < 6; y++) {
                ArrayList<String> collone = new ArrayList<String>();
            for (int x = 0; x < 1; x++) {
                collone.add("| (1) | (2) | (3) | (4) | (5) | (6) | (7) |");
                }
                tableau.add(collone);
            }
    
            for (ArrayList<String> ligne : tableau) {
                for (String caseJeu : ligne) {
                    System.out.print(caseJeu + " ");
                }
                System.out.println();
            }
        }
    

    // public boolean grillePleine() {
    //     for (int i = 0; i < rows; i++) {
    //         for (int j = 0; j < columns; j++) {
    //             if (grid[i][j] == null) {
    //                 return false;
    //             }
    //         }
    //     }
    //     return true;
    // }
}