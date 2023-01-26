
# Color Class
This class provides a set of constants for printing colored text in the console.

## Usage
To use the Color class, simply call the desired color constant followed by the text you want to print.

Example:
```
System.out.println(Color.RED + "This text is red!");
```

## Constants
The Color class provides the following constants:

- `RESET`: Resets the color of the text to the default.
- `RED`: Prints the text in red.
- `GREEN`: Prints the text in green.
- `YELLOW`: Prints the text in yellow.
- `BLUE`: Prints the text in blue.
- `PURPLE`: Prints the text in purple.
- `CYAN`: Prints the text in cyan.
- `WHITE`: Prints the text in white.

Example:
```
System.out.println(Color.RED + "This text is red!" + Color.RESET + " This text is back to the default color.");
```


Ce code permet de réaliser un affichage en couleur dans un terminal. Il fait partie du package "model". Il définit des constantes qui sont des chaînes de caractères contenant des codes d'échappement ANSI \u001B, suivi de deux caractères de couleurs :
-RESET : \u001B[0m - Permet de réinitialiser la couleur de la console.
-RED : \u001B[31m - Permet d'afficher du texte en rouge.
-GREEN : \u001B[32m - Permet d'afficher du texte en vert.
-YELLOW : \u001B[33m - Permet d'afficher du texte en jaune.
-BLUE : \u001B[34m - Permet d'afficher du texte en bleu.
-PURPLE : \u001B[35m - Permet d'afficher du texte en violet.
-CYAN : \u001B[36m - Permet d'afficher du texte en cyan.
-WHITE : \u001B[37m - Permet d'afficher du texte en blanc.

Pour utiliser ces codes dans un programme, il suffit de les concaténer à la chaîne de caractère à afficher. 
Par exemple, pour afficher du texte en vert, on peut utiliser la fonction "System.out.println" de la manière suivante :
System.out.println(Color.GREEN + "Texte en vert");