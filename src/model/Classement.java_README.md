

# Introduction
This code is a Java program that allows to manage a ranking system. It is composed of the class Classement which contains the methods to read and write a ranking file.

# Methods

## readRanking
This method allows to read a ranking file and store the data in an array of strings.

```
public static String[] readRanking(String fileName) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(fileName));
    String[] ranking = new String[10];
    for (int i = 0; i < 10; i++) {
        ranking[i] = br.readLine();
    }
    br.close();
    return ranking;
}
```

## writeRanking
This method allows to write a ranking file from an array of strings.

```
public static void writeRanking(String fileName, String[] ranking) throws IOException {
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
    for (int i = 0; i < 10; i++) {
        pw.println(ranking[i]);
    }
    pw.close();
}
```


Ce code fait partie d'un projet de jeu de Puissance 4. Il représente une classe nommée Classement qui sert à stocker et gérer les meilleurs scores enregistrés dans le jeu.

Constructeur Classement(String filename):
Ce constructeur prend un nom de fichier en paramètre et l'utilise pour stocker et récupérer le classement des meilleurs scores.

Constructeur Classement():
Ce constructeur est le constructeur par défaut et n'accepte aucun paramètre.

Méthode csvToTopTen():
Cette méthode lit le fichier passé en paramètre lors de la création de l'instance de la classe et stocke les meilleurs scores lus dans une liste.

Méthode topTenToCsv():
Cette méthode prend la liste des scores et les enregistre dans le fichier passé en paramètre lors de la création de l'instance de la classe.

Méthode saveClassement(String name, int move):
Cette méthode prend le nom et le nombre de mouvements du joueur et les enregistre dans une liste. Elle vérifie le nombre de mouvements et ajoute le nouvel enregistrement à la liste en fonction de sa position. Elle affiche ensuite le classement et enregistre le tout dans le fichier.

Getter et setter:
Il y a deux getter et deux setter pour récupérer et enregistrer le nom et le nombre de mouvements du joueur.

Méthode afficherClassement():
Cette méthode affiche tous les scores enregistrés dans la liste.

Méthode toString():
Cette méthode renvoie le nom et le nombre de mouvements de l'instance de la classe sous forme de chaîne de caractères.