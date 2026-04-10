package org.example.java16;

public class InstanceOfPatternMatchingDemo {
    public static void main(String[] args) {
        Object x = "hi";
        //  --- OLD WAY ---
        if (x instanceof String) {
            String s = (String) x;   //<---= have to type cast it
            if (s.length() > 1) {
                System.out.println(s.toUpperCase());
            }
        } else if (x instanceof Integer) {
            Integer i = (Integer) x;
            System.out.println(i * i);
        }

        Object y = 6;
        // --- NEW WAY ---
        if (y instanceof String s) {  //<---= put reference here. no more type casting.
            if (s.length() > 1) {
                System.out.println(s.toUpperCase());
            }
        } else if (y instanceof Integer i) {  //<---= put reference here
            System.out.println(i * i);
        }

        System.out.println("done");
    }
}
