package com.practice.recursion;

public class Factorial {

    int factorial(int number){
        if(number<2)
            return 1;
        else
            return number*factorial(number-1);
    }

    int factorialIterative(int number){
        int fact=1;
        for(int i=2;i<=number;i++){
            fact*=i;
        }
        return fact;
    }
    public static void main(String[] args) {
        Factorial factorial= new Factorial();
        System.out.println(factorial.factorial(5));
        System.out.println(factorial.factorial(0));
        System.out.println("Factorial Iterative:"+factorial.factorialIterative(5));
    }
}
