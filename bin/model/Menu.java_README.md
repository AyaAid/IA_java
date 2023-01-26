

# Menu

Menu is a class that allows users to create a menu with options that can be selected by the user. It is written in Java and uses the `java.util.ArrayList` and `java.util.Iterator` classes.

## Usage

To use the Menu class, first create an instance of the class:

```
Menu menu = new Menu();
```

Then, add options to the menu:

```
menu.addOption("Option 1");
menu.addOption("Option 2");
menu.addOption("Option 3");
```

Finally, display the menu and get the user's selection:

```
int selection = menu.displayMenu();
```

## Example

Here is an example of how to use the Menu class:

```
Menu menu = new Menu();
menu.addOption("Option 1");
menu.addOption("Option 2");
menu.addOption("Option 3");
int selection = menu.displayMenu();
```

This code will display a menu with the options "Option 1", "Option 2", and "Option 3". The user can then select one of the options and the selection will be stored in the `selection` variable.




Ce code Java est une classe Menu qui permet de charger un menu. La classe Menu possède plusieurs variables et méthodes qui lui sont associées. 

Variables :
- nbjoueur : un entier qui représente le nombre de joueurs
- couleur : une liste de chaînes de caractères qui représente les couleurs disponibles
- name : une liste de chaînes de caractères qui représente les noms des joueurs
- coul : une chaîne de caractères qui représente la couleur choisie

Méthodes :
- getName() : retourne la liste de chaînes de caractères name
- setName(String nom) : ajoute le nom dans la liste name
- getNbjoueur() : retourne l'entier nbjoueur
- setNbjoueur(int nbjoueur) : définit l'entier nbjoueur
- getCouleur() : retourne la liste de chaînes de caractères couleur
- setCouleur(String coul) : ajoute la couleur choisie dans la liste couleur
- afficherMenu(String choix) : affiche le menu en fonction du choix

Cette classe est utile pour afficher un menu et permettre aux utilisateurs de choisir une option.