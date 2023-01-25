

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