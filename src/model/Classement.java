package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Classement {

        // Attribut qui contient le nom du fichier CSV
    private String filename;
    
        // Attributs pour stocker les données d'un joueur
    private String name;
    private int move;

        // Attribut pour stocker les scores des 10 meilleurs joueurs
    private ArrayList<Classement> topTen = new ArrayList<Classement>();

        // Constructeur pour initialiser le nom du fichier CSV
    public Classement(String filename) {
        this.filename = filename;
    }

        // Constructeur par défaut
    public Classement() {
    }

        // Méthode pour lire les données d'un fichier CSV et les stocker dans topTen
    public void csvToTopTen() throws IOException{
        try (BufferedReader pw = new BufferedReader(new FileReader(this.filename))) {
            String line;
            while ((line = pw.readLine()) != null) {
                try {
                    // Séparer les valeurs de chaque ligne
                    String[] valeurs = line.split(";");

                    // Stocker les valeurs dans les attributs name et move
                    String name = valeurs[0];
                    int move = Integer.parseInt(valeurs[1]);
                    Classement score = new Classement();
                    score.setName(name);
                    score.setMove(move);

                    // Ajouter les données dans topTen
                    topTen.add(score);
                } catch (NumberFormatException e) {
                    System.out.println("Erreur lors de la ligne");
                }
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier");
        }
    }

    // Méthode pour écrire les données de topTen dans un fichier CSV
    public void topTenToCsv() {

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

    // Méthode pour sauvegarder les données d'un joueur dans topTen et dans le fichier CSV
    public void saveClassement(String name, int move) {
        setName(name);
        setMove(move);

        // Ajouter les données dans topTen en respectant l'ordre des scores
        for (Classement score : topTen) {
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

    // Getter pour name
    public String getName() {
        return name;
    }

    // Getter pour move
    public int getMove() {
        return move;
    }

    // Setter pour name
    public void setName(String name) {
        this.name = name;
    }

    // Setter pour move
    public void setMove(int move) {
        this.move = move;
    }

    // Méthode pour afficher le classement
    public void afficherClassement() {
        for (Classement score : topTen) { 
            String scoreString = score.toString();
    
            scoreString = scoreString.replace(";", " : ");
    
            System.out.println(scoreString);
        }
    }
    
    // Méthode pour convertir un objet Classement en une chaîne de caractères
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.getName());
        builder.append(";");
        builder.append(this.getMove());
        return builder.toString();
    }
}