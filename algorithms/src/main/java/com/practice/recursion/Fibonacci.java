package com.practice.recursion;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {
    public int fibonacciIterative(int number){
        List<Integer> arr= new ArrayList<>();
        arr.add(0,0);
        arr.add(1,1);
        for(int i=2;i<=number;i++){
            arr.add(i,arr.get(i-1)+arr.get(i-2));
        }
        return arr.get(number);
    }

    public int fibonacciRecursive(int number){
        if(number<2){
            return number;
        }
        else {
            int sum= fibonacciRecursive(number-1)+fibonacciRecursive(number-2);
            return sum;
        }

    }

    public static void main(String[] args) {
        Fibonacci fibonacci= new Fibonacci();
        System.out.println(fibonacci.fibonacciRecursive(5));
        System.out.println(fibonacci.fibonacciIterative(5));
    }

}
