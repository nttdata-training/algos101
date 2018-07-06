package com.nttdata.work;

import java.io.BufferedReader;
import java.io.File;

public class FileReader {
    public static void main (String args[]){
        File file = new File("fibonacci.txt");
        try {
            BufferedReader buf = new BufferedReader(new java.io.FileReader(file));
            String st;
            int i = 1;
            while ((st = buf.readLine()) != null) {
                System.out.println(i + " = " + st);
                i++;
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
