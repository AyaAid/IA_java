

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