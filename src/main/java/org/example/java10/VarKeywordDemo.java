package org.example.java10;

import java.util.ArrayList;

public class VarKeywordDemo {
    public static void main(String[] args) {
        // -- old way --
        int a = 10;
        String b = "hi";
        // -- var keyword --
        var c = 20;     //infer type
        var d = "hello";//infer type
        var list = new ArrayList<>();

        var widget = new Widget("test");

        // NOTE: below is not possible in Java 10.  `var` in lambda is ok in Java 11.
        //Predicate<Integer> isEven = (var num) -> num % 2 == 0;
        //System.out.println(isEven.test(10));
    }
}

class Widget {
    private String name;

    Widget(String name) {
        this.name = name;
    }
}