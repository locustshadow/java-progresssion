package org.example.java14;

public class SwitchExpressionsDemo {
    public static void main(String[] args) {
        String day = "MONDAY";

        switch (day) {
            case "MONDAY", "TUESDAY", "WEDNESDAY" -> System.out.println("m-w");
            default -> System.out.println("r-ss");
        }

        String day2 = "XYZ";
        var result = switch (day2) {
            case "MONDAY", "TUESDAY", "WEDNESDAY" -> "m-w";
            default -> "r-ss";
        };
        System.out.println(result);
    }
}
