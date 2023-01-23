package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Classement {

    public void enregistrer()throws IOException {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("classement.csv", true)));
        try{
            pw.println("joueur,couleur");
        } finally {
            pw.close();
        }
    }
    
}
