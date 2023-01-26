
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choisissez le mode de jeu :");
        System.out.println("1. Mode solo");
        System.out.println("2. Mode multijoueur");
        int choix = sc.nextInt();
        switch (choix) {
            case 1:
                System.out.println("Vous avez choisi le mode solo");
                break;
            case 2:
                System.out.println("Vous avez choisi le mode multijoueur");
                break;
            default:
                System.out.println("Veuillez choisir un mode valide");
        }
    }
}

# Jeu
This code is a game with two modes: solo and multiplayer.

## Mode Solo
In solo mode, the user can play the game alone.

Example:
```
Choisissez le mode de jeu :
1. Mode solo
2. Mode multijoueur
1
Vous avez choisi le mode solo
```

## Mode Multijoueur
In multiplayer mode, the user can play the game with other players.

Example:
```
Choisissez le mode de jeu :
1. Mode solo
2. Mode multijoueur
2
Vous avez choisi le mode multijoueur
```



Ce code est une classe Java qui définit une classe Jeu. La classe Jeu est utilisée pour créer un jeu d'alignement 4. Il initialise le jeu avec des paramètres spécifiés tels que le nombre de joueurs, leurs noms et couleurs. La méthode start_game() démarre le jeu. Elle affiche la grille de jeu et demande au joueur de choisir une colonne, et elle vérifie si le joueur a gagné. Si le joueur n'a pas gagné, elle switchPlayer et demande au joueur suivant de choisir une colonne. La méthode jouerIA() est similaire à la méthode start_game(), mais elle contient une fonctionnalité supplémentaire pour l'IA qui lui permet de jouer. La méthode switchPlayer() est utilisée pour changer de joueur. Elle vérifie si le joueur actuel est le joueur1 et change le joueur actuel si ce n'est pas le cas. La méthode getCurrentPlayer() est utilisée pour obtenir le joueur actuel. La méthode getMove() est utilisée pour obtenir le nombre de mouvements effectués. La méthode Jouer() initialise le jeu avec des paramètres spécifiés. Il initialise le jeu avec des paramètres spécifiés tels que le nombre de joueurs, leurs noms et couleurs. La méthode saveClassement() est utilisée pour sauvegarder le nom du joueur actuel et le nombre de mouvements effectués dans un fichier CSV.