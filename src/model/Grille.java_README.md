

# Introduction

The `Grille` class is a Java class that provides a data structure for representing a grid of values. It is useful for representing a two-dimensional array of values, such as a game board or a map.

# Constructor

The `Grille` class has a single constructor, which takes two parameters:

- `int width`: The width of the grid
- `int height`: The height of the grid

The constructor creates a grid with the given width and height, and initializes all values to `null`.

# Methods

The `Grille` class provides several methods for manipulating the grid:

- `get(int x, int y)`: Returns the value at the given coordinates
- `set(int x, int y, Object value)`: Sets the value at the given coordinates
- `clear()`: Clears all values in the grid

# Examples

Creating a new `Grille` object with a width of 5 and a height of 10:

```
Grille grid = new Grille(5, 10);
```

Setting the value at coordinates (2, 4) to "foo":

```
grid.set(2, 4, "foo");
```

Getting the value at coordinates (2, 4):

```
Object value = grid.get(2, 4);
```



Ce code est une classe Java nommée Grille qui est une partie importante d'un jeu Puissance 4. La classe définit les propriétés et les méthodes utilisées pour créer, afficher et manipuler une grille de 6 lignes et 7 colonnes.

Propriétés:
-  rows: un entier statique qui représente le nombre de lignes de la grille
- columns: un entier statique qui représente le nombre de colonnes de la grille
- grid: une ArrayList qui contient une ArrayList pour chaque ligne et chaque cellule dans la grille est remplie avec des espaces " ".
- ia: une instance de la classe IA qui est utilisée pour la logique de l'intelligence artificielle

Méthodes:
- Grille(): le constructeur de la classe qui initialise chaque cellule de la grille avec un espace " "
- getGrid(): une méthode qui retourne la grille
- afficherGrille(): une méthode qui affiche la grille dans la console
- addJeton(): une méthode qui ajoute un jeton (symbole) dans une colonne particulière
- colonnePleine(): une méthode qui vérifie si une colonne est pleine
- reinitialiserGrille(): une méthode qui remet chaque cellule de la grille à un espace " "
- grillePleine(): une méthode qui vérifie si la grille est complètement remplie
- gagner(): une méthode qui vérifie si le joueur a gagné en vérifiant chaque cellule de la grille pour voir si 4 symboles sont alignés
- IA2(): une méthode qui est appelée pour faire jouer l'IA en vérifiant si elle peut gagner ou empêcher le joueur de gagner et en choisissant une colonne à jouer.