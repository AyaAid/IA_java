package model;

import java.util.Random;
//d

public class IA {
    private Random rand = new Random();
    private int columns = 7;

    public IA() {
    }

    public int jouerTour(Grille grille, int niveau) {
        int column = -1;
        if (niveau == 1) {
            column = rand.nextInt(columns);
        } else if (niveau == 2) {

        } else if (niveau == 3) {

        } else if (niveau == 4) {

        }
        return column;
    }

    public String getJoueur() {
        return null;
    }

    public String getCouleur() {
        return null;
    }

}
