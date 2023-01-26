package model;
import java.util.*;

public class Grille {
    private static int rows = 6;
    private static int columns = 7;
    private ArrayList<ArrayList<String>> grid = new ArrayList<ArrayList<String>>();
    private IA ia = new IA();

    public Grille() {
        for (int i = 0; i < rows; i++) {
            grid.add(new ArrayList<String>());
            for (int j = 0; j < columns; j++) {
                grid.get(i).add(" ");
            }
        }
    }

    public ArrayList<ArrayList<String>> getGrid() {
        return grid;
    }

    public void afficherGrille() {

        System.out.println("    0    1    2    3    4    5    6 ");
        for (int c = 1; c <= columns; c++) {
            System.out.print(" "); // ajouté
        }
        System.out.println();
        for (int i = 0; i < rows; i++) {
            System.out.print("  "); // ajouté
            for (int c = 0; c < columns; c++) {
                if (grid.get(i).get(c).equals(" ")) {
                    System.out.print("|   |");
                } else {
                    System.out.print("| " + grid.get(i).get(c) + "|");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public void addJeton(String symbole, int column) {
        if (column >= 0 && column <= columns - 1 && !colonnePleine(column)) {
            for (int i = rows - 1; i >= 0; i--) {
                if (grid.get(i).get(column).equals(" ")) {
                    grid.get(i).set(column, symbole);
                    break;
                }
            }
        } else {
            System.out.println("Vous ne pouvez pas sélectionner cette colonne !");
        }
    }

    public boolean colonnePleine(int column) {
        if (!grid.get(0).get(column).equals(" ")) {
            return true;
        }
        return false;
    }

    public void reinitialiserGrille() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                grid.get(i).set(j, " ");
            }
        }
    }

    public boolean grillePleine() {
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(i).size(); j++) {
                if (grid.get(i).get(j).equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean gagner() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (!grid.get(i).get(j).equals(" ")) {
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

    public int IA2(String symbol) {
        int col = 0;
        boolean jouer = false;
        // test ligne
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns - 3; j++) {
                if (grid.get(i).get(j).equals(symbol) && grid.get(i).get(j + 1).equals(symbol)
                        && grid.get(i).get(j + 2).equals(symbol) && grid.get(i).get(j + 3).equals(" ")) {
                    System.out.println(j + 3 + "ligne");
                    jouer = true;
                    addJeton("⚪️", j + 3);
                    col = j + 3;
                }
            }
        }

        // test colonne
        for (int j = 0; j < columns; j++) {
            for (int i = 5; i >= 0; i--) {
                if (grid.get(i).get(j).equals(symbol) && grid.get(i - 1).get(j).equals(symbol)
                        && grid.get(i - 2).get(j).equals(symbol) && grid.get(i - 3).get(j).equals(" ")) {
                    System.out.println(j + "colonne");
                    jouer = true;
                    addJeton("⚪️", j);
                    col = j;

                }
            }
        }

        for (int i = 0; i < rows - 3; i++) {
            for (int j = 0; j < columns - 3; j++) {
                // test diagonale haut
                if (grid.get(i).get(j).equals(symbol)
                        && grid.get(i + 1).get(j + 1).equals(symbol)
                        && grid.get(i + 2).get(j + 2).equals(symbol)
                        && grid.get(i + 3).get(j + 3).equals(" ")) {
                    System.out.println(j + 3 + " diag haut");
                    addJeton("⚪️", j + 3);
                    col = j + 3;
                }

                // test diagonale bas
                if (grid.get(i).get(j + 3).equals(symbol) && grid.get(i + 1).get(j + 2).equals(symbol)
                        && grid.get(i + 2).get(j + 1).equals(symbol) && grid.get(i + 3).get(j).equals(" ")) {
                    System.out.println(j + " diag bas");
                    // jouer = true;
                    addJeton("⚪️", j + 3);
                    col = j + 3;
                }

                // test diago inversé haut
                if (grid.get(i + 3).get(j).equals(symbol) && grid.get(i + 2).get(j + 1).equals(symbol)
                        && grid.get(i + 1).get(j + 2).equals(symbol) && grid.get(i).get(j + 3).equals(" ")) {
                    System.out.println(j + 3 + " diag inversé haut");
                    jouer = true;
                    addJeton("⚪️", j + 3);
                    col = j + 3;
                }

                // test diago inversé bas
                if (grid.get(i + 3).get(j + 3).equals(symbol) && grid.get(i + 2).get(j + 2).equals(symbol)
                        && grid.get(i + 1).get(j + 1).equals(symbol) && grid.get(i).get(j).equals(" ")) {
                    System.out.println(j - 3 + " diag inversé bas");
                    jouer = true;
                    addJeton("⚪️", j + 3);
                    col = j+3;
                }
            }
        }

        if (!jouer) {
            System.out.println("pif");
            addJeton("⚪️", ia.jouerTour(new Grille(), 1));
            col = ia.jouerTour(new Grille(), 1);
        }

        return col;
    }
}
