package org.example.java21;

public class NewStringIndexOfMethodDemo {
    public static void main(String[] args) {
        String message = "one two three four five six";
        int index = message.indexOf("three", 5, 15);
        System.out.println(index); // 8
        int index2 = message.indexOf("one", 5, 15); // -1 ("one" exists in the string, but not between that range)
        System.out.println(index2); // -1
    }
}
