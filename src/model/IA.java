import java.util.Random;

public class Joueur {
    private Player joueur2;
    private PlayerModel playerModel;
    private Minimax minimax;
    private Random rand;

    public Joueur(String string, String string2) {
        joueur2 = new Player();
        playerModel = new PlayerModel();
        minimax = new Minimax();
        rand = new Random();
    }

    public int jouerTour(Grille grille, int niveau) {
        int column = -1;
        if (niveau == 1) {
            column = rand.nextInt(grille.getColonnes());
        } else if (niveau == 2) {
            for (int c = 0; c < grille.getColonnes(); c++) {
                if (grille.isAligned(c, joueur2.getCouleur())) {
                    column = c;
                    break;
                }
            }
            if (column == -1) {
                column = rand.nextInt(grille.getColonnes());
            } else {
                column = column + 1;
            }
        } else if (niveau == 3) {
            column = playerModel.predictNextMove(grille.getPreviousMoves());
            column = (column + 1) % grille.getColonnes();
        } else if (niveau == 4) {
            column = minimax.findBestMove(grille, joueur2.getCouleur());
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
