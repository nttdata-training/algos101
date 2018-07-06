package com.nttdata.work;

import java.util.Scanner;

public class BubbleSort implements Sortable{
    @Override
    public void sort(int array[]) {
        boolean changed = true;
        while (changed) {
            changed = false;
            for (int i = 1; i < array.length; i++) {
                if (array[i - 1] > array[i]) {
                    int a = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = a;
                    changed = true;
                }
            }
        }
    }
}

class BubbleMain {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scan.nextInt();
        }
        BubbleSort sorter = new BubbleSort();
        sorter.sort(array);
        for (int element : array) {
            System.out.print(element + " ");
        }
    }
}