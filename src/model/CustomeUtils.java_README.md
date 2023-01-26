

# CustomeUtils

CustomeUtils is a Java package that provides a method to get user input from the console.

## getUserInput()

`getUserInput()` is a method that takes user input from the console and returns it as a `String`.

### Example

```
String userInput = CustomeUtils.getUserInput();
System.out.println("You entered: " + userInput);
```

This code will prompt the user to enter a string, and then print it out.



Cette classe représente un utilitaire personnalisé qui permet à l'utilisateur d'entrer une chaîne de caractères. 

Il contient une méthode statique appelée "getUserInput" qui est utilisée pour récupérer la chaîne de caractères saisie par l'utilisateur.

La méthode getUserInput est déclarée en tant que méthode statique, ce qui signifie qu'elle peut être appelée directement à partir de la classe sans avoir à créer une instance de l'objet. 

La méthode getUserInput commence par créer une instance de la classe Scanner et la stocker dans une variable scanner. Cela permet à la méthode de lire les entrées de l'utilisateur à partir de l'entrée standard.

Ensuite, la méthode appelle la méthode Scanner.nextLine () pour lire la chaîne de caractères entrée par l'utilisateur. La chaîne est stockée dans une variable appelée userInput.

Enfin, la méthode renvoie la chaîne de caractères stockée dans la variable userInput.