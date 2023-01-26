
# Grille

Grille is a class that represents a 6x7 grid of strings. It is used to store data in a two-dimensional array.

## Constructor

The constructor initializes the grid with empty strings.

```
public Grille() {
    for (int i = 0; i < rows; i++) {
        grid.add(new ArrayList<String>());
        for (int j = 0; j < columns; j++) {
            grid.get(i).add(" ");
        }
    }
}
```

## getGrid()

The getGrid() method returns the grid as an ArrayList of ArrayLists.

```
public ArrayList<ArrayList<String>> getGrid() {
    return grid;
}
```