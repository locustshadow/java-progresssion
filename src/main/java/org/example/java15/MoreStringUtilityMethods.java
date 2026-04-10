package org.example.java15;

public class MoreStringUtilityMethods {
    public static void main(String[] args) {
        var userId = 111;
        var username = "kevin";

        // %d for numbers, %s for strings, %f for floating point numbers

        // -- format() -- OLD
        String message = String.format("%d - %s", userId, username);
        System.out.println(message);

        // -- formatted() -- NEW
        String message2 = "%d - %s".formatted(userId, username);
        System.out.println(message2);

        // -- translate escapes --
        var s = "kevin\s\b\\\n\'j\'\s\\\n\bmurphy";
        System.out.println(s);
        System.out.println(s.translateEscapes());
    }
}
