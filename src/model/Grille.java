package model;

import java.util.*;

public class Grille {
    private static int rows = 7;
    private static int columns = 6;
    static ArrayList<ArrayList<String>> grid = new ArrayList<ArrayList<String>>();

    public Grille() {
        for (int i = 0; i < rows; i++) {
            grid.add(new ArrayList<String>());
            for (int j = 0; j < columns; j++) {
                grid.get(i).add(null);
            }
        }
    }

    public void afficherGrille() {
        System.out.println("  1    2    3    4    5    6    7\n");

        for (int i = 0; i < columns; i++) {
            System.out.println("  ");
            for (int c = 0; c < rows; c++) {
                if (grid.get(i).get(c) == null) {
                    System.out.print("|    ");
                } else {
                    System.out.print("| " + grid.get(i).get(c) + " |");
                }
            }
            System.out.println();
        }

    }

    public void addJeton(String symbole, int column) {
        if (column > 0 && column <= columns) {
            for (int i = rows - 1; i >= 0; i--) {
                if (grid.get(i).get(column - 1) == null) {
                    grid.get(i).set(column - 1, symbole);
                    break;
                }
            }
        } else {
            System.out.println("colonne n'existe pas");
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

    public boolean gagner() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid.get(i).get(j) != null) {
                    if (i + 3 < rows) { // vérifier une victoire en ligne
                        if (grid.get(i).get(j) == grid.get(i + 1).get(j) && grid.get(i).get(j) == grid.get(i + 2).get(j)
                                && grid.get(i).get(j) == grid.get(i + 3).get(j)) {
                            return true;
                        }
                    }
                    if (j + 3 < columns) { // vérifier une victoire en colonne
                        if (grid.get(i).get(j) == grid.get(i).get(j + 1) && grid.get(i).get(j) == grid.get(i).get(j + 2)
                                && grid.get(i).get(j) == grid.get(i).get(j + 3)) {
                            return true;
                        }
                    }
                    if (i + 3 < rows && j + 3 < columns) { // Vérifier une victoire en diagonale vers la droite
                        if (grid.get(i).get(j) == grid.get(i + 1).get(j + 1)
                                && grid.get(i).get(j) == grid.get(i + 2).get(j + 2)
                                && grid.get(i).get(j) == grid.get(i + 3).get(j + 3)) {
                            return true;
                        }
                    }
                    if (i + 3 < rows && j - 3 >= 0) { // vérifier une victoire en diagonale vers la gauche
                        if (grid.get(i).get(j) == grid.get(i + 1).get(j - 1)
                                && grid.get(i).get(j) == grid.get(i + 2).get(j - 2)
                                && grid.get(i).get(j) == grid.get(i + 3).get(j - 3)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }


    public boolean IA2(){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid.get(i).get(j) != null) {
                    if(i+2 < rows) { // vérifier si trois pions sont alignés en ligne 
                        if (grid.get(i).get(j) == grid.get(i + 1).get(j) && grid.get(i).get(j) == grid.get(i + 2).get(j)) {
                            if(grid.get(i+3).get(j) == null){
                                grid.get(i+3).set(j, "R");
                                return true;
                            }
                        }
                    }
                    if(j+3 < columns) { // vérifier si trois pions sont alignés en colonne
                        if (grid.get(i).get(j) == grid.get(i).get(j + 1) && grid.get(i).get(j) == grid.get(i).get(j + 2)) {
                            if(grid.get(i).get(j+3) == null){
                                grid.get(i).set(j+3, "R");
                                return true;
                            }
                        }
                    }
                    if(i+3 < rows && j+3 < columns) { // Vérifier si trois pions sont alignés en diagonale vers la droite
                        if (grid.get(i).get(j) == grid.get(i + 1).get(j + 1) && grid.get(i).get(j) == grid.get(i + 2).get(j + 2)) {
                            if(grid.get(i+3).get(j+3) == null){
                                grid.get(i+3).set(j+3, "R");
                                return true;
                            }
                        }
                    }
                    if(i+3 < rows && j-3 >= 0) { // vérifier si trois pions sont alignés en diagonale vers la gauche
                        if (grid.get(i).get(j) == grid.get(i + 1).get(j - 1) && grid.get(i).get(j) == grid.get(i + 2).get(j - 2)) {
                            if(grid.get(i+3).get(j-3) == null){
                                grid.get(i+3).set(j-3, "R");
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}