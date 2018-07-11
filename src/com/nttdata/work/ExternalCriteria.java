package com.nttdata.work;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExternalCriteria {
    List<Integer> priority = new ArrayList<>();

    ExternalCriteria(List<Integer> list){
        for (int elem : list) {
            priority.add(elem);
        }
    }

    private List<Integer> sort(List<Integer> list){
        Collections.sort(list);
        if (priority.isEmpty()) {
            //sort normally
            return list;
        }
        int index = 0;
        for (int num : priority) {
            for (int i = index; i < list.size(); i++) {
                int elem = list.get(i);
                if (elem == num) {
                    list.remove(i);
                    list.add(index, elem);
                    index++;
                }
            }
        }
        return list;
    }

    public static void main(String args[]) {
        FileReader file = new FileReader();
        List<Integer> pList = file.read("priority");
        ExternalCriteria sorter = new ExternalCriteria(pList);
        List<Integer> toSort = file.read("sort");
        List<Integer> sorted = sorter.sort(toSort);
        System.out.println(sorted);
    }
}

class FileReader {
    public List<Integer> read(String file){
        try {
            BufferedReader openFile = new BufferedReader(new java.io.FileReader("./Resources/" + file + ".txt"));
            String number;
            List<Integer> list = new ArrayList<>();
            while ((number = openFile.readLine()) != null) {
                list.add(Integer.parseInt(number));
            }
            openFile.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
