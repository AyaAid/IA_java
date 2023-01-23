package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Classement {

    public void saveScore(String name, int move)throws IOException {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("classement.csv", true)));
        try{
            pw.println(name + ";" + move);
        } finally {
            pw.close();
        }
    }
}
