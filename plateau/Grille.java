package IA_java.plateau;

import java.util.*;


public class Grille {
        public static void main(String[] args) {
            ArrayList<ArrayList<String>> tableau = new ArrayList<ArrayList<String>>();
            System.out.println("  1    2    3    4    5    6    7");
            for (int y = 0; y < 6; y++) {
                ArrayList<String> collone = new ArrayList<String>();
            for (int x = 0; x < 1; x++) {
                collone.add("|----|----|----|----|----|----|----|");
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
    }