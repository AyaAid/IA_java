
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