package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Classement {

    private String filename;
    private String name;
    private int move; 
    private ArrayList<Classement> topTen = new ArrayList<Classement>(); // Attribut pour stocker les scores des 10 meilleurs joueurs


    public Classement(String filename) { // Constructeur pour initialiser le nom du fichier CSV

        this.filename = filename;
    }
    public Classement() { // Constructeur par défaut
    }
    public void csvToTopTen() throws IOException{ // Méthode pour lire les données d'un fichier CSV et les stocker dans topTen

        try (BufferedReader pw = new BufferedReader(new FileReader(this.filename))) {
            String line;
            while ((line = pw.readLine()) != null) {
                try {
                    String[] valeurs = line.split(";"); // Séparer les valeurs de chaque ligne

                    String name = valeurs[0]; // Stocker les valeurs dans les attributs name et move
                    int move = Integer.parseInt(valeurs[1]);
                    Classement score = new Classement();
                    score.setName(name);
                    score.setMove(move);
                    topTen.add(score); // Ajouter les données dans topTen

                } catch (NumberFormatException e) {
                    System.out.println("Erreur lors de la ligne");
                }
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier");
        }
    }

    public void topTenToCsv() { // Méthode pour écrire les données de topTen dans un fichier CSV


        try (BufferedWriter pw = new BufferedWriter(new FileWriter(this.filename))) {
            for (Classement score : topTen) {
                String stringScore = score.toString();
                pw.write(stringScore);
                pw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de l'Ã©criture du fichier");
        }
    }

    public void saveClassement(String name, int move) { // Méthode pour sauvegarder les données d'un joueur dans topTen et dans le fichier CSV

        setName(name);
        setMove(move);

        for (Classement score : topTen) { // Ajouter les données dans topTen en respectant l'ordre des scores

            if (move < score.getMove()) {
                int index = topTen.indexOf(score);
                topTen.add(index, this);
                if (topTen.size() > 10) {
                    topTen.remove(10);
                }
                break;
            }
        }
        if(topTen.size()<10){
            topTen.add(this);
        }
        afficherClassement(); 
        topTenToCsv();
    }

    public String getName() { // Getter pour name

        return name;
    }
    public int getMove() { // Getter pour move

        return move;
    }

    public void setName(String name) { // Setter pour name

        this.name = name;
    }

    public void setMove(int move) { // Setter pour move

        this.move = move;
    }

    public void afficherClassement() { // Méthode pour afficher le classement

        for (Classement score : topTen) { 
            String scoreString = score.toString();
    
            scoreString = scoreString.replace(";", " : ");
    
            System.out.println(scoreString);
        }
    }
    
    @Override // Méthode pour convertir un objet Classement en une chaîne de caractères

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.getName());
        builder.append(";");
        builder.append(this.getMove());
        return builder.toString();
    }
}