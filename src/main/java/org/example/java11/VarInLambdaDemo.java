package org.example.java11;

import java.util.function.Predicate;


public class VarInLambdaDemo {
    public static void main(String[] args) {
        // in Java 11, you can use `var` in Lambda expressions
        Predicate<Integer> isEven = (var num) -> num % 2 == 0;
        System.out.println(isEven.test(10));
    }
}
