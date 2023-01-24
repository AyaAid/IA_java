
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