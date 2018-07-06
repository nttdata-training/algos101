package com.nttdata.work;

import java.util.Scanner;
import java.util.Stack;

public class IterativeQuickSort implements  Sortable {
    @Override
    public void sort(int[] array){
        this.quicksort(array, 0, array.length - 1);
    }

    private int partition(int[] array, int low, int high) {
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
        return j;
    }

    private void quicksort(int[] array, int low, int high){
        Stack<Integer> stack = new Stack<>();
        stack.push(low);
        stack.push(high);
        while (!stack.isEmpty()) {
            high = stack.pop();
            low = stack.pop();
            int pivot = partition(array, low, high);
            if (pivot > low) {
                stack.push(low);
                stack.push(pivot);
            }
            if (pivot + 1 < high) {
                stack.push(pivot + 1);
                stack.push(high);
            }
        }
    }

}

class QuickMain2 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scan.nextInt();
        }
        IterativeQuickSort sorter = new IterativeQuickSort();
        sorter.sort(array);
        for (int element : array) {
            System.out.print(element + " ");
        }
    }
}