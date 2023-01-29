package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Classement implements Comparable<Classement> { // déclaration d'un comparateur
    private static final String SEPARATEUR = ";";
    private String name;
    private int move;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMove() {
        return move;
    }

    public void setMove(int move) {
        this.move = move;
    }

    /**
     * @author Aya & Florent
     * @return none
     * Enregistre le classement dans le fichier  "classement.csv"
     * @throws IOException
     */
    public void enregistrer() throws IOException {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("classement.csv", true)));
        try {
            pw.println(this.toString());
        } finally {
            pw.close();
        }
    }

    /**
     * @author: Aya et Florent
     * @return liste des classements se trouvant dans le fichier classement.csv
     * La fonction "lister()" retourne une ArrayList de l'objet "Classement"
     * @throws IOException
     */
    public ArrayList<Classement> lister() throws IOException {
        ArrayList<Classement> liste = new ArrayList<Classement>();
        try (BufferedReader pw = new BufferedReader(new FileReader("classement.csv"))) {
            String line;
            while ((line = pw.readLine()) != null) {
                    String[] valeurs = line.split(SEPARATEUR); // Séparer les valeurs de chaque ligne

                    String name = valeurs[0]; // Stocker les valeurs dans les attributs name et move
                    int move = Integer.parseInt(valeurs[1]);
                    Classement score = new Classement();
                    score.setName(name);
                    score.setMove(move);
                    liste.add(score); // Ajouter les données dans topTen

                }
            }
         catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier");
        }
        return liste;
    }

    /**
     * @author: Aya et Florent
     * @throws IOException
     * @return none
     * La fonction "listerTop()" retourne les 10 meilleurs scores
     */
    public void listerTop() throws IOException {
        ArrayList<Classement> topten = lister();
        Collections.sort(topten, compareMove);
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("classement.csv", false)))) {
            for (Classement classement : topten) {
                    pw.println(classement.toString());
                }
        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture du fichier");
        }
        if(topten.size() >= 10)
            topten.subList(10, topten.size()).clear();
        for (Classement classement : topten) {
            System.out.println(classement.getName() + " " + classement.getMove());
        }
    }

    /**
     * @author: Aya et Florent
     * @param joueur : chaine de caractère représentant le nom du joueur gagnant
     * @param move : nombre entier représentant le nombre de coup du joueur gagant 
     * @return none
     * La fonction "ajouterScore()" ajoute le score du joueur dans le fichier "classement.csv"
     */
    public void ajouterScore(String joueur, int move) {
        setName(joueur);
        setMove(move);
        try {
            enregistrer();
        } catch (IOException e) {
            System.out.println("Erreur lors de l'enregistrement");
        }
    }

    public static Comparator<Classement> compareMove = new Comparator<Classement>() {

        @Override
        public int compare(Classement c1, Classement c2) {
            return Integer.compare(c1.getMove(), c2.getMove());
        };

    };

    @Override
    public int compareTo(Classement c) {
        return Integer.compare(this.getMove(), c.getMove());
    };

    @Override
    public String toString() {
        return this.name + ";" + this.move;
    };


// le code ci-dessous est un test de Florent qui n'a pas fonctionné

    // public Classement(String filename) { // Constructeur pour initialiser le nom
    // du fichier CSV

    // this.filename = filename;
    // }
    // public Classement() { // Constructeur par défaut
    // }
    // public void csvToTopTen() throws IOException{ // Méthode pour lire les
    // données d'un fichier CSV et les stocker dans topTen

    // try (BufferedReader pw = new BufferedReader(new FileReader(this.filename))) {
    // String line;
    // while ((line = pw.readLine()) != null) {
    // try {
    // String[] valeurs = line.split(";"); // Séparer les valeurs de chaque ligne

    // String name = valeurs[0]; // Stocker les valeurs dans les attributs name et
    // move
    // int move = Integer.parseInt(valeurs[1]);
    // Classement score = new Classement();
    // score.setName(name);
    // score.setMove(move);
    // topTen.add(score); // Ajouter les données dans topTen

    // } catch (NumberFormatException e) {
    // System.out.println("Erreur lors de la ligne");
    // }
    // }
    // } catch (IOException e) {
    // System.out.println("Erreur lors de la lecture du fichier");
    // }
    // }

    // public void topTenToCsv() { // Méthode pour écrire les données de topTen dans
    // un fichier CSV

    // try (BufferedWriter pw = new BufferedWriter(new FileWriter(this.filename))) {
    // for (Classement score : topTen) {
    // String stringScore = score.toString();
    // pw.write(stringScore);
    // pw.newLine();
    // }
    // } catch (IOException e) {
    // System.out.println("Erreur lors de l'Ã©criture du fichier");
    // }
    // }

    // public void saveClassement(String name, int move) { // Méthode pour
    // sauvegarder les données d'un joueur dans topTen et dans le fichier CSV

    // setName(name);
    // setMove(move);

    // for (Classement score : topTen) { // Ajouter les données dans topTen en
    // respectant l'ordre des scores

    // if (move < score.getMove()) {
    // int index = topTen.indexOf(score);
    // topTen.add(index, this);
    // if (topTen.size() > 10) {
    // topTen.remove(10);
    // }
    // break;
    // }
    // }
    // if(topTen.size()<10){
    // topTen.add(this);
    // }
    // afficherClassement();
    // topTenToCsv();
    // }

    // public String getName() { // Getter pour name

    // return name;
    // }
    // public int getMove() { // Getter pour move

    // return move;
    // }

    // public void setName(String name) { // Setter pour name

    // this.name = name;
    // }

    // public void setMove(int move) { // Setter pour move

    // this.move = move;
    // }

    // public void afficherClassement() { // Méthode pour afficher le classement

    // for (Classement score : topTen) {
    // String scoreString = score.toString();

    // scoreString = scoreString.replace(";", " : ");

    // System.out.println(scoreString);
    // }
    // }

    // @Override // Méthode pour convertir un objet Classement en une chaîne de
    // caractères

    // public String toString() {
    // StringBuilder builder = new StringBuilder();
    // builder.append(this.getName());
    // builder.append(";");
    // builder.append(this.getMove());
    // return builder.toString();
    // }
}