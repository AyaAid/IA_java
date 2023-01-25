

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