package model;
import java.util.*;
import java.util.Random;

public class Grille {
    private static int rows = 6;
    private static int columns = 7;
    private Random rand = new Random(); // Ces lignes déclarent des variables d'instance qui peuvent être utilisées pour stocker le nombre de lignes et de colonnes dans la grille.

    private ArrayList<ArrayList<String>> grid = new ArrayList<ArrayList<String>>(); // Cette ligne déclare une variable d'instance qui peut être utilisée pour stocker les données de la grille.




    public Grille() {
        for (int i = 0; i < rows; i++) {
            grid.add(new ArrayList<String>());
            for (int j = 0; j < columns; j++) {
                grid.get(i).add(" ");
            }
        }
    } // Cette ligne déclare un constructeur pour la classe Grille. Ce constructeur est utilisé pour initialiser une nouvelle grille et la remplir avec des espaces vides.


    public ArrayList<ArrayList<String>> getGrid() {
        return grid;
    } // Cette ligne déclare une méthode publique qui peut être utilisée pour récupérer les données de la grille.


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
    } // Cette ligne déclare une méthode publique qui peut être utilisée pour afficher la grille dans la console.


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
    } // Cette ligne déclare une méthode publique qui peut être utilisée pour ajouter un jeton à la grille.


    public boolean colonnePleine(int column) {
        if (!grid.get(0).get(column).equals(" ")) {
            return true;
        }
        return false;
    } // Cette ligne déclare une méthode publique qui peut être utilisée pour vérifier si une colonne est pleine.


    public void reinitialiserGrille() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                grid.get(i).set(j, " ");
            }
        }
    } // Cette ligne déclare une méthode publique qui peut être utilisée pour réinitialiser la grille en remplissant toutes les cases avec des espaces vides.


    public boolean grillePleine() {
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(i).size(); j++) {
                if (grid.get(i).get(j).equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    } // Cette ligne déclare une méthode publique qui peut être utilisée pour vérifier si la grille est pleine.


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
    } // Cette ligne déclare une méthode publique qui peut être utilisée pour vérifier si un joueur a gagné.

    public int IA1(){
        int column = rand.nextInt(6 - 0) + 0;
        while(colonnePleine(column)){
            column = rand.nextInt(6 - 0) + 0;
        }
        return column;
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
                    break;
                }
            }
        } // Cette ligne déclare une méthode publique qui peut être utilisée pour implémenter l'intelligence artificielle. Elle effectue différents tests pour vérifier si un joueur est sur le point de gagner, et si c'est le cas, elle joue le coup pour l'empêcher de gagner.

        // test colonne
        for (int j = 0; j < columns; j++) {
            for (int i = 5; i >= 0; i--) {
                if (grid.get(i).get(j).equals(symbol) && grid.get(i - 1).get(j).equals(symbol)
                        && grid.get(i - 2).get(j).equals(symbol) && grid.get(i - 3).get(j).equals(" ")) {
                    System.out.println(j + "colonne");
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
                if (grid.get(i).get(j + 3).equals(symbol) && grid.get(i + 1).get(j + 2).equals(symbol)
                        && grid.get(i + 2).get(j + 1).equals(symbol) && grid.get(i + 3).get(j).equals(" ")) {
                    System.out.println(j + " diag bas");
                    jouer = true;
                    addJeton("⚪️", j + 3);
                    col = j + 3;
                    break;
                }

                // test diago inversé haut
                if (grid.get(i + 3).get(j).equals(symbol) && grid.get(i + 2).get(j + 1).equals(symbol)
                        && grid.get(i + 1).get(j + 2).equals(symbol) && grid.get(i).get(j + 3).equals(" ")) {
                    System.out.println(j + 3 + " diag inversé haut");
                    jouer = true;
                    addJeton("⚪️", j + 3);
                    col = j + 3;
                    break;
                }

                // test diago inversé bas
                if (grid.get(i + 3).get(j + 3).equals(symbol) && grid.get(i + 2).get(j + 2).equals(symbol)
                        && grid.get(i + 1).get(j + 1).equals(symbol) && grid.get(i).get(j).equals(" ")) {
                    System.out.println(j - 3 + " diag inversé bas");
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



    public void IA3(String symbol){
        
        boolean jouer = false;

        // test ligne
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < columns - 3; col++){
                if(grid.get(row).get(col).equals(symbol) 
                        && grid.get(row).get(col+1).equals(symbol)
                        && grid.get(row).get(col+2).equals(symbol) 
                        && grid.get(row).get(col+3).equals(" ")){
                    System.out.println(col + "ligne");
                    jouer = true;
                    addJeton("⚪️", col+3);
                    break;
                }

                if(grid.get(row).get(col).equals(symbol)
                        && grid.get(row).get(col+1).equals(symbol)
                        && grid.get(row).get(col+2).equals(" ")
                        && grid.get(row).get(col+3).equals(symbol)){
                    System.out.println("ligne good");
                    addJeton("⚪️", col+2);
                    jouer = true;
                    break;
               
                }
            }
        }

        // test colonne
        for(int col = 0; col < columns; col++){
            for(int row = 0; row < rows; row++){
                if(grid.get(row).get(col).equals(symbol) 
                        && grid.get(row+1).get(col).equals(symbol)
                        && grid.get(row+2).get(col).equals(symbol) 
                        && grid.get(row+3).get(col).equals(" ")){
                    System.out.println(col + "colonne");
                    jouer = true;
                    addJeton("⚪️", col);
                    break;
                }
            }
        }

        for(int row = 0; row < rows - 3; row++){
            for(int col = 0; col < columns - 3; col++){
                // test diagonale haut
                if(grid.get(row).get(col).equals(symbol)
                        && grid.get(row+1).get(col+1).equals(symbol)
                        && grid.get(row+2).get(col+2).equals(symbol)
                        && grid.get(row+3).get(col+3).equals(" ")){
                    System.out.println(col + 3 + " diag haut");
                   
                    addJeton("⚪️", col+3);
            
                }

                // test diagonale bas
                if(grid.get(row).get(col+3).equals(symbol) 
                        && grid.get(row+1).get(col+2).equals(symbol)
                        && grid.get(row+2).get(col+1).equals(symbol) 
                        && grid.get(row+3).get(col).equals(" ")){
                    System.out.println(col + " diag bas");
                 
                    addJeton("⚪️", col+3);
                  
                }

                // test diago inversé haut
                
                if(grid.get(row).get(col).equals(symbol) 
                        && grid.get(row+1).get(col-1).equals(symbol)
                        && grid.get(row+2).get(col-2).equals(symbol) 
                        && grid.get(row+3).get(col-3).equals(" ")){
                    System.out.println(col - 3 + " diag inversé haut");
               
                    addJeton("⚪️", col-3);
                    
                }

                // test diago inversé bas
                
                if(grid.get(row).get(col-3).equals(symbol) 
                        && grid.get(row+1).get(col-2).equals(symbol)
                        && grid.get(row+2).get(col-1).equals(symbol) 
                        && grid.get(row+3).get(col).equals(" ")){
                    System.out.println(col - 3 + " diag inversé bas");
                
                    addJeton("⚪️", col-3);
                    
                
            }
        }
        if(!jouer){
            int random = rand.nextInt(columns);
            boolean test = true;
            while(test){
                System.out.println(random);
                if(!grid.get(0).get(random).equals(" ")){
                    System.out.println("pif");
                    random = rand.nextInt(columns-1);
                }else{
                    test = false;
                }
            }
            System.out.println("test");
            addJeton("⚪️", random);
            break;
            
        }
    }
}
}
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

