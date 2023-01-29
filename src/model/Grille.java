package model;
import java.util.*;
import java.util.Random;

public class Grille {
    private static int rows = 6;
    private static int columns = 7;
    private Random rand = new Random(); 

    private ArrayList<ArrayList<String>> grid = new ArrayList<ArrayList<String>>(); 




    /**
     * @author : Aya
     * @return null
     * Ce constructeur est utilisé pour initialiser une nouvelle grille et la remplir avec des espaces vides.
     */
    public Grille() {
        for (int i = 0; i < rows; i++) {
            grid.add(new ArrayList<String>());
            for (int j = 0; j < columns; j++) {
                grid.get(i).add(" ");
            }
        }
    } 


    /**
     * @return ArrayList, retourne la grille 
     */
    public ArrayList<ArrayList<String>> getGrid() {
        return grid;
    }


    /**
     * @author : Aya
     * @return null
     * La fonction "afficherGrille()" affiche la grille dans la console.
     */
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


    /**
     * @author : Aya
     * @param symbole : chaine de caractère représentant la couleur du joueur
     * @param column : nombre entier représentant le numéro de colonne ou le joueur veut poser son jeton
     * @return null
     * La fonction "addJeton()" ajoute un jeton à la grille.
     */
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


    /**
     * @author : Aya
     * @param column : nombre entier représentant le numéro de colonne
     * @return boolean (true si la colonne est pleine, false sinon)
     * La fonction "colonnePleine()" vérifie si une colonne est pleine.
     */
    public boolean colonnePleine(int column) {
        if (!grid.get(0).get(column).equals(" ")) {
            return true;
        }
        return false;
    }


    /**
     * @author : Aya
     * @return null
     * La fonction "reinitialiserGrille()" réinitialise la grille en remplissant toutes les cases avec des espaces vides.
     */
    public void reinitialiserGrille() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                grid.get(i).set(j, " ");
            }
        }
    } 


    /**
     * @author : Aya
     * @return boolean (true si la grille est pleine, false sinon)
     * La fonction "grillePleine()" vérifie si la grille est pleine.
     */
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


    /**
     * @author : Aya
     * @return boolean (true si un joueur a gagné, false sinon)
     * La fonction "gagner()" vérifie si un joueur a gagné.
     */
    public boolean gagner() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (!grid.get(i).get(j).equals(" ")) {
                    if (i + 3 < rows) { // vérifier une victoire en ligne
                        if (grid.get(i).get(j) == grid.get(i + 1).get(j) 
                                && grid.get(i).get(j) == grid.get(i + 2).get(j)
                                && grid.get(i).get(j) == grid.get(i + 3).get(j)) {
                            return true;
                        }
                    }
                    if (j + 3 < columns) { // vérifier une victoire en colonne
                        if (grid.get(i).get(j) == grid.get(i).get(j + 1) 
                                && grid.get(i).get(j) == grid.get(i).get(j + 2)
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

    /**
     * @author : Aya
     * @return nombre entier représentant la colonne choisie par l'IA
     * La fonction "IA1()" permet à l'ordinateur de jouer un coup aléatoire.
     */
    public int IA1(){
        int column = rand.nextInt(6 - 0) + 0;
        while(colonnePleine(column)){
            column = rand.nextInt(6 - 0) + 0;
        }
        return column;
    }


    /**
     * @author : Aya & Romain
     * @param symbol : chaine de caractère représentant la couleur de l'IA
     * @return nombre entier représentant la colonne choisie par l'IA
     * La fonction "IA2()" permet à l'ordinateur de jouer un coup intelligent.
     */
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
                    break;
                }
            }
        } 

        // test colonne
        for (int j = 0; j < columns; j++) {
            for (int i = 5; i >= 0; i--) {
                if (grid.get(i).get(j).equals(symbol) 
                        && grid.get(i - 1).get(j).equals(symbol)
                        && grid.get(i - 2).get(j).equals(symbol) 
                        && grid.get(i - 3).get(j).equals(" ")) {

                    jouer = true;
                    addJeton("⚪️", j);
                    col = j;
                    break;

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
                    jouer = true;
                    addJeton("⚪️", j + 3);
                    col = j + 3;
                    break;
                }

                // test diagonale bas
                if (grid.get(i).get(j + 3).equals(symbol) 
                        && grid.get(i + 1).get(j + 2).equals(symbol)
                        && grid.get(i + 2).get(j + 1).equals(symbol) 
                        && grid.get(i + 3).get(j).equals(" ")) {

                    jouer = true;
                    addJeton("⚪️", j + 3);
                    col = j + 3;
                    break;
                }

                // test diago inversé haut
                if (grid.get(i + 3).get(j).equals(symbol) 
                        && grid.get(i + 2).get(j + 1).equals(symbol)
                        && grid.get(i + 1).get(j + 2).equals(symbol) 
                        && grid.get(i).get(j + 3).equals(" ")) {

                    jouer = true;
                    addJeton("⚪️", j + 3);
                    col = j + 3;
                    break;
                }

                // test diago inversé bas
                if (grid.get(i + 3).get(j + 3).equals(symbol) 
                        && grid.get(i + 2).get(j + 2).equals(symbol)
                        && grid.get(i + 1).get(j + 1).equals(symbol) 
                        && grid.get(i).get(j).equals(" ")) {

                    jouer = true;
                    addJeton("⚪️", j + 3);
                    col = j+3;
                    break;
                }
            }
        }

        if (!jouer) {
            System.out.println("pif");
            addJeton("⚪️", IA1());
            col = IA1();
        }

        return col;
    }



    /**
     * @author : Aya & Romain
     * @param symbol : chaine de caractère représentant la couleur de l'IA
     * @return nombre entier représentant la colonne choisie par l'IA
     * La fonction "IA3()" permet à l'ordinateur de jouer un coup intelligent.
     */
    public int IA3(String symbol){
        int col = 0;
        boolean jouer = false;

        // test ligne
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns - 3; j++) {
                if (grid.get(i).get(j).equals(symbol)
                        && grid.get(i).get(j + 1).equals(symbol)
                        && grid.get(i).get(j + 2).equals(symbol)
                        && grid.get(i).get(j + 3).equals(" ")) {

                    col = j + 3;

                }

                if (grid.get(i).get(j).equals(symbol)
                        && grid.get(i).get(j + 1).equals(symbol)
                        && grid.get(i).get(j + 2).equals(" ")
                        && grid.get(i).get(j + 3).equals(symbol)) {

                    addJeton("⚪️", j + 2);
                    col = j + 2;
                    break;
                }

                if (grid.get(i).get(j).equals(symbol)
                        && grid.get(i).get(j + 1).equals(" ")
                        && grid.get(i).get(j + 2).equals(symbol)
                        && grid.get(i).get(j + 3).equals(symbol)) {

                    addJeton("⚪️", j + 1);
                    col = j + 1;
                    return col;
                } 

            }
        }

        // test colonne
        for (int j = 0; j < columns; j++) {
            for (int i = 5; i > rows-3; i--) {
                if (grid.get(i).get(j).equals(symbol)
                        && grid.get(i - 1).get(j).equals(symbol)
                        && grid.get(i - 2).get(j).equals(symbol)
                        && grid.get(i - 3).get(j).equals(" ")) {

                    jouer = true;
                    addJeton("⚪️", j);
                    col = j;
                    return col;

                }
            }
        }

        for (int i = 0; i < rows - 3; i++) {
            for (int j = 0; j < columns - 3; j++) {
                // test diagonale haut
                if (grid.get(i).get(j).equals(symbol)
                        && grid.get(i + 1).get(j + 1).equals(symbol)
                        && grid.get(i + 2).get(j + 2).equals(symbol)
                        && grid.get(i + 3).get(j + 3).equals(" ")
                        && grid.get(i + 2).get(j + 3).equals(" ")) {

                    col = j + 3;
                }

                // test diagonale bas
                if (grid.get(i).get(j + 3).equals(symbol)
                        && grid.get(i + 1).get(j + 2).equals(symbol)
                        && grid.get(i + 2).get(j + 1).equals(symbol)
                        && grid.get(i + 3).get(j).equals(" ")
                        && grid.get(i + 2).get(j).equals(" ")) {

                    col = j + 3;

                }

                // test diago inversé haut
                if (grid.get(i + 3).get(j).equals(symbol)
                        && grid.get(i + 2).get(j + 1).equals(symbol)
                        && grid.get(i + 1).get(j + 2).equals(symbol)
                        && grid.get(i).get(j + 3).equals(" ")
                        && grid.get(i - 1).get(j + 3).equals(" ")) {

                    // jouer = true;
                    // addJeton("⚪️", j + 3);
                    col = j + 3;

                }

                // test diago inversé bas
                if (grid.get(i + 3).get(j + 3).equals(symbol)
                        && grid.get(i + 2).get(j + 2).equals(symbol)
                        && grid.get(i + 1).get(j + 1).equals(symbol)
                        && grid.get(i).get(j).equals(" ")
                        && grid.get(i - 1).get(j).equals(" ")) {

                    // jouer = true;
                    // addJeton("⚪️", j + 3);
                    col = j + 3;

                }
            }
        }

        if (jouer == false) {
            int random = IA1();

            while (random == col) {
                random = IA1();
            }
            addJeton("⚪️", random);
            col = random;
        }

        return col;
    }

    /**
     * @author Aya & Romain
     * @param symbol : chaine de caractère qui représente la couleur de l'IA
     * @param symbol2 : chaine de caractère qui représente la couleur du joueur adverse
     * @return nombre entier qui représente la colonne où l'IA a joué
     * La fonction IA4 est une IA qui joue en fonction de la position des jetons de l'adversaire
     */
    public int IA4(String symbol, String symbol2) {
        int col = 0;
        boolean jouer = false;
        // test ligne

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns - 3; j++) {
                if (grid.get(i).get(j).equals(symbol)
                        && grid.get(i).get(j + 1).equals(symbol)
                        && grid.get(i).get(j + 2).equals(symbol)
                        && grid.get(i).get(j + 3).equals(" ")) {

                    jouer = true;
                    addJeton(symbol, j + 3);
                    col = j + 3;
                    break;
                }

                if (grid.get(i).get(j).equals(symbol)
                        && grid.get(i).get(j + 1).equals(symbol)
                        && grid.get(i).get(j + 2).equals(" ")
                        && grid.get(i).get(j + 3).equals(symbol)) {

                    System.out.println(symbol);
                    addJeton(symbol, j + 2);
                    col = j + 2;
                    break;
                }

                if (grid.get(i).get(j).equals(symbol)
                        && grid.get(i).get(j + 1).equals(" ")
                        && grid.get(i).get(j + 2).equals(symbol)
                        && grid.get(i).get(j + 3).equals(symbol)) {

                    System.out.println(symbol);
                    addJeton(symbol, j + 1);
                    col = j + 1;
                    return col;
                }
            }
        }

        for (int j = 0; j < columns; j++) {
            for (int i = 5; i >= 0; i--) {
                if (grid.get(i).get(j).equals(symbol)
                        && grid.get(i - 1).get(j).equals(symbol)
                        && grid.get(i - 2).get(j).equals(symbol)
                        && grid.get(i - 3).get(j).equals(" ")) {

                    jouer = true;
                    addJeton(symbol, j);
                    col = j;
                    return col;

                }
            }
        } 

        // test colonne
        for (int j = 0; j < columns; j++) {
            for (int i = 0; i < 0; i++) {
                if (grid.get(i).get(j).equals(symbol) 
                        && grid.get(i + 1).get(j).equals(symbol)
                        && grid.get(i + 2).get(j).equals(symbol) 
                        && grid.get(i + 3).get(j).equals(" ")) {

                    jouer = true;
                    addJeton(symbol, j);
                    col = j;
                    return col;

                }
            }
        }

        for(int i = 0; i < rows - 3; i++){
            for(int j = 0; j < columns - 3; j++){
                // test diagonale haut
                if (grid.get(i).get(j).equals(symbol)
                        && grid.get(i + 1).get(j + 1).equals(symbol)
                        && grid.get(i + 2).get(j + 2).equals(symbol)
                        && grid.get(i + 3).get(j + 3).equals(" ")) {

                    jouer = true;
                    addJeton(symbol, j + 3);
                    col = j + 3;
                    return col;
                }

                // test diagonale bas
                if (grid.get(i).get(j + 3).equals(symbol) 
                        && grid.get(i + 1).get(j + 2).equals(symbol)
                        && grid.get(i + 2).get(j + 1).equals(symbol) 
                        && grid.get(i + 3).get(j).equals(" ")) {

                    jouer = true;
                    addJeton(symbol, j + 3);
                    col = j + 3;
                    return col;
                }

                // test diago inversé haut
                if (grid.get(i + 3).get(j).equals(symbol) 
                        && grid.get(i + 2).get(j + 1).equals(symbol)
                        && grid.get(i + 1).get(j + 2).equals(symbol) 
                        && grid.get(i).get(j + 3).equals(" ")) {

                    jouer = true;
                    addJeton(symbol, j + 3);
                    col = j + 3;
                    return col;
                }

                // test diago inversé bas
                if (grid.get(i + 3).get(j + 3).equals(symbol) 
                        && grid.get(i + 2).get(j + 2).equals(symbol)
                        && grid.get(i + 1).get(j + 1).equals(symbol) 
                        && grid.get(i).get(j).equals(" ")) {

                    jouer = true;
                    addJeton(symbol, j + 3);
                    col = j + 3;
                    return col;
                }
            }
        }

        if (!jouer) {
            System.out.println(symbol2);
            IA3(symbol2);
        }
        return col;
    }
}
// cette fonction est un test d'IA 3 faites par Romain mais qui n'a pas fonctionné

    // public int IA3(String symbol) {
    //     int col = 0;
    //     boolean jouer = false;
    //     // test ligne
    //     for (int i = 0; i < rows; i++) {
    //         for (int j = 0; j < columns - 3; j++) {
    //             if (grid.get(i).get(j).equals(symbol) && grid.get(i).get(j + 1).equals(symbol)
    //                     && grid.get(i).get(j + 2).equals(symbol) && grid.get(i).get(j + 3).equals(" ")) {
    //                 System.out.println(j + 3 + "ligne");
    //                 jouer = true;
    //                 addJeton("⚪️", j + 3);
    //                 col = j + 3;
    //                 break;
    //             }
    //         }
    //     } // Cette ligne déclare une méthode publique qui peut être utilisée pour implémenter l'intelligence artificielle. Elle effectue différents tests pour vérifier si un joueur est sur le point de gagner, et si c'est le cas, elle joue le coup pour l'empêcher de gagner.

    //     // test colonne
    //     for (int j = 0; j < columns; j++) {
    //         for (int i = 5; i >= 0; i--) {
    //             if (grid.get(i).get(j).equals(symbol) && grid.get(i - 1).get(j).equals(symbol)
    //                     && grid.get(i - 2).get(j).equals(symbol) && grid.get(i - 3).get(j).equals(" ")) {
    //                 System.out.println(j + "colonne");
    //                 jouer = true;
    //                 addJeton("⚪️", j);
    //                 col = j;
    //                 break;

    //             }
    //         }
    //     }

    //     for (int i = 5; i < rows - 3; i++) {
    //         for (int j = 0; j < columns - 3; j++) {
    //             // test diagonale haut
    //             if (grid.get(i).get(j).equals(symbol)
    //                     && grid.get(i + 1).get(j + 1).equals(symbol)
    //                     && grid.get(i + 2).get(j + 2).equals(symbol)
    //                     && grid.get(i + 3).get(j + 3).equals(" ")
    //                     && !grid.get(i + 2).get(j + 3).equals(" ")) {
    //                 System.out.println(j + 3 + " diag haut");
    //                 jouer = true;
    //                 addJeton("⚪️", j + 3);
    //                 col = j + 3;
    //                 break;
    //             }

    //             // test diagonale bas
    //             if (grid.get(i).get(j + 3).equals(symbol) && grid.get(i + 1).get(j + 2).equals(symbol)
    //                     && grid.get(i + 2).get(j + 1).equals(symbol) && grid.get(i + 3).get(j).equals(" ")) {
    //                 System.out.println(j + " diag bas");
    //                 jouer = true;
    //                 addJeton("⚪️", j + 3);
    //                 col = j + 3;
    //                 break;
    //             }

    //             // test diago inversé haut
    //             if (grid.get(i + 3).get(j).equals(symbol) && grid.get(i + 2).get(j + 1).equals(symbol)
    //                     && grid.get(i + 1).get(j + 2).equals(symbol) && grid.get(i).get(j + 3).equals(" ")) {
    //                 System.out.println(j + 3 + " diag inversé haut");
    //                 jouer = true;
    //                 addJeton("⚪️", j + 3);
    //                 col = j + 3;
    //                 break;
    //             }

    //             // test diago inversé bas
    //             if (grid.get(i + 3).get(j + 3).equals(symbol) && grid.get(i + 2).get(j + 2).equals(symbol)
    //                     && grid.get(i + 1).get(j + 1).equals(symbol) && grid.get(i).get(j).equals(" ")) {
    //                 System.out.println(j - 3 + " diag inversé bas");
    //                 jouer = true;
    //                 addJeton("⚪️", j + 3);
    //                 col = j+3;
    //                 break;
    //             }
    //         }
    //     }

    //     if (!jouer) {
    //         System.out.println("pif");
    //         addJeton("⚪️", IA1());
    //         col = IA1();
    //     }

    //     return col;
    // }

