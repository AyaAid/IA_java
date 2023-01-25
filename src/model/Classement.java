package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Classement {

    private String filename;
    private String name;
    private int move;

    private static ArrayList<Classement> topTen = new ArrayList<Classement>();

    public Classement(String filename) {
        this.filename = filename;
    }

    public Classement() {
    }

    public void csvToTopTen() throws IOException{
        try (BufferedReader pw = new BufferedReader(new FileReader(this.filename))) {
            topTen.clear();

            String line;
            while ((line = pw.readLine()) != null) {
                try {
                    String[] valeurs = line.split(";");

                    String name = valeurs[0];
                    int move = Integer.parseInt(valeurs[1]);

                    //topTen.add(score);
                } catch (NumberFormatException e) {
                    System.out.println("Erreur lors de la ligne");
                }
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier");
        }
    }
    
    public void topTenToCsv() {
        try (BufferedWriter pw = new BufferedWriter(new FileWriter(this.filename))) {
            for (Classement score : topTen) {
                String stringScore = score.toString();
                pw.write(stringScore);
                pw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture du fichier");
        }
    }
    
    public void saveClassement(String name, int move) {
    
        setName(name);
        setMove(move);
    
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
        topTenToCsv();
        afficherClassement();
    }
    
    public String getName() {
        return name;
    }
    
    public int getMove() {
        return move;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setMove(int move) {
        this.move = move;
    }
    
    public void saveScore(String name, int move)throws IOException {
        try {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(filename, true)));
        try{
            pw.write(name + ";" + move + "\n");
        } finally {
            pw.close();
        }
        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture du fichier");
        }
    }
    
    public void afficherClassement() {
    
        for (Classement score : topTen) {
            String scoreString = score.toString();
    
            scoreString = scoreString.replace(";", " : ");
    
            System.out.println(scoreString);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.getName());
        builder.append(";");
        builder.append(this.getMove());
        return builder.toString();
    }
}