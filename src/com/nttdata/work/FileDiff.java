package com.nttdata.work;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;

public class FileDiff {
    public HashSet<String> common = new HashSet<>();
    public HashSet<String> file1 = new HashSet<>();
    public HashSet<String> file2 = new HashSet<>();
    public ArrayList<String> garbage = new ArrayList<>();

    private void addCommon(String element){
        garbage.add(element);
        common.add(element);
    }

    public void compareFiles(ArrayList<String> file1Input, ArrayList<String> file2Input) {
        for (String element : file1Input) {
            file1.add(element);
        }
        for (String element : file2Input) {
            file2.add(element);
        }
        for (String element : file1) {
            if (file2.contains(element)) {
                this.addCommon(element);
            }
        }
        for (String element : garbage) {
            file1.remove(element);
            file2.remove(element);
        }
    }

    public void printSets(){
        System.out.print("Exclusive to file 1: ");
        for (String element : file1) {
            System.out.print(element + " ");
        }
        System.out.print("\nExclusive to file 2: ");
        for (String element : file2) {
            System.out.print(element + " ");
        }
        System.out.print("\nCommon elements: ");
        for (String element : common) {
            System.out.print(element + " ");
        }
    }

    public static void main(String args[]){
        try {
            BufferedReader file1 = new BufferedReader(new FileReader("./Resources/file1.txt"));
            BufferedReader file2 = new BufferedReader(new FileReader("./Resources/file2.txt"));
            String line = null;
            ArrayList<String> file1Array = new ArrayList<>();
            ArrayList<String> file2Array = new ArrayList<>();
            while ((line = file1.readLine()) != null) {
                file1Array.add(line);
            }
            while ((line = file2.readLine()) != null) {
                file2Array.add(line);
            }
            FileDiff diff = new FileDiff();
            diff.compareFiles(file1Array, file2Array);
            diff.printSets();
            file1.close();
            file2.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}