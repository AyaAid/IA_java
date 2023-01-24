package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Classement {

    private String filename;

    public Classement(String filename) {
        this.filename = filename;
    }

    public void saveScore(String name, int move)throws IOException {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(filename, true)));
        try{
            pw.println(name + ";" + move);
        } finally {
            pw.close();
        }
    }

    public void afficherClassement() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("classement.csv"))) {
            int comparescore = 0;
                String comparename = "";
                String line = br.readLine();
                while (line != null) {
                    String[] parts = line.split(";");
                    String name = parts[0];
                    int score = Integer.parseInt(parts[1]);
                    if(score < comparescore){
                        comparescore = score;
                        comparename = name;
                    }
                    line = br.readLine();
                }
                System.out.println("Le meilleur score est de " + comparescore + " par " + comparename);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}