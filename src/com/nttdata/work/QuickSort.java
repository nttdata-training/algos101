package com.nttdata.work;

import java.util.Scanner;

public class QuickSort implements Sortable {
    @Override
    public void sort(int[] array){
        this.quicksort(array, 0, array.length - 1);
    }

    private void quicksort(int[] array, int low, int high){
        int pivot = array[low];
        int i = low - 1;
        int j = high + 1;
        while (i < j) {
            for (i++; array[i] < pivot; i++);
            for (j--; array[j] > pivot; j--);
            if (i < j) {
                int a = array[i];
                array[i] = array[j];
                array[j] = a;
            }
        }
        if (low < j) quicksort(array, low, j);
        if (j + 1 < high) quicksort(array, j + 1, high);
    }
}

class QuickMain {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scan.nextInt();
        }
        QuickSort sorter = new QuickSort();
        sorter.sort(array);
        for (int element : array) {
            System.out.print(element + " ");
        }
    }
}