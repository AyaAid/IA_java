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
        BufferedReader br = new BufferedReader(new FileReader("classement.csv"));
        try{
            String line = br.readLine();
            while(line != null){
                System.out.println(line);
                line = br.readLine();
            }
        } finally {
            br.close();
        }
    }
}