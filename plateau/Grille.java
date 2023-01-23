package IA_java.plateau;

import java.util.*;


public class Grille {

    private String[][] grille = new String[6][7];

    public void afficherGrille() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(grille[i][j]);
            }
            System.out.println();
        }
    }

    }