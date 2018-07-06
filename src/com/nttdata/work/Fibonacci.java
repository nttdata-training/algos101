package com.nttdata.work;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class Fibonacci {
    public BigInteger fibonacciIt(int n){
        BigInteger fibonacciPrev = new BigInteger("0");
        BigInteger fibonacciNow = new BigInteger("1");
        BigInteger value = new BigInteger("1");
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("fibonacci.txt");
            //writer.println("0");
            writer.println("1");
        } catch (Exception e) {
            System.err.println(e);
        }
        if (n == 0) return BigInteger.ZERO;
        if (n == 1) return BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            value = fibonacciPrev.add(fibonacciNow);
            fibonacciPrev = fibonacciNow;
            fibonacciNow = value;
            if (writer != null) {
                writer.println(value);
            }
        }
        if (writer != null) {
            writer.close();
        }
        return value;
    }

    public long fibonacciRec(int n){
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacciRec(n - 1) + fibonacciRec(n - 2);
    }

    public BigInteger fibonacciSmart(int n){
        BigInteger[] array = new BigInteger[100];
        array[0] = BigInteger.ZERO;
        array[1] = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            if(i%100==0)
            {
              //
                BigInteger[] replace = new BigInteger[100];
                replace[0] = array[98];
                replace[1] = array[99];
            }

            //dict lru
            array[(i % 100)] = array[(i % 100 )-1].add(array[(i % 100) - 2]);
        }
        return array[n];
    }
}

class FibMain {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        //int n = scan.nextInt();
        Fibonacci counter = new Fibonacci();
        //TODO output execution time for both functions and make it work for very large values. :)
        //System.out.println(counter.fibonacciIt(Integer.MAX_VALUE));
        System.out.println(counter.fibonacciIt(
                1000000));

    }
}