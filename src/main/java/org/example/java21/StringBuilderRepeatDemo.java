package org.example.java21;

public class StringBuilderRepeatDemo {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("kevin");
        sb.repeat('-', 4); // can take a single char
        sb.repeat("abc", 2); // or string
        System.out.println(sb);
        // kevin----abcabc
    }
}
