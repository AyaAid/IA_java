

# Overview
This code is a Java class called Jeton, which is used to represent a game piece in a board game. It contains three fields: color, row, and column. 

# Constructor
The constructor takes three parameters: a String for the color, and two ints for the row and column. 

```
public Jeton(String color, int row, int column) {
    this.color = color;
    this.row = row;
    this.column = column;
}
```

# Getters
The class also contains three getter methods for each of the fields. 

```
public String getColor() {
    return color;
}

public int getRow() {
    return row;
}

public int getColumn() {
    return column;
}
```





La classe Jeton représente un jeton dans un jeu, qui a une couleur, une ligne et une colonne.
 
Attributs : 
 - color (String) : la couleur du jeton
 - row (int) : le numéro de la ligne du jeton
 - column (int) : le numéro de la colonne du jeton

 Constructeur : 
  Jeton(String color, int row, int column)
   - Prend en paramètres la couleur, la ligne et la colonne du jeton, et les initialise. 
 
 Méthodes : 
 getColor() : retourne la couleur du jeton
 getRow() : retourne la ligne du jeton
 getColumn() : retourne la colonne du jeton
