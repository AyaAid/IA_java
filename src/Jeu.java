import javax.swing.SpringLayout;

public class Jeu {
 
    public void Jouer( Integer compteurIA, Integer compteurplayer, Integer joueur) {

        joueur = 0;
        compteurIA = 0;
        compteurplayer = 0;

        //tant que la grille n'est pas complete
        while (grille != arraydegrille){
            compteurIA = compteurIA + 1;
            compteurplayer = compteurplayer + 1;
            joueur = joueur + 1;
            //si c'est au joueur de jouer
            if (joueur % 2 == 0) {
                compteurIA = compteurIA + 1;
                System.out.println("Le compteur de l'IA est à :" + compteurIA);
                } 
                //si c'est à l'ia de jouer        
                else {
                    compteurplayer = compteurplayer + 1;
                    System.out.println("Ton compteur est à :" + compteurplayer);
              }
            

        }

    }
}
