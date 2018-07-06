package com.nttdata.work;

import java.util.Scanner;

public class BubbleSort2 implements Sortable{
    @Override
    public void sort(int array[]){
        for (int i = 1; i < array.length; i++) {
            if (i < 1) continue;
            if (array[i - 1] > array[i]) {
                int a = array[i - 1];
                array[i - 1] = array[i];
                array[i] = a;
                i -= 2;
            }
        }
    }
}

class BubbleMain2 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scan.nextInt();
        }
        BubbleSort2 sorter = new BubbleSort2();
        sorter.sort(array);
        for (int element : array) {
            System.out.print(element + " ");
        }
    }
}