package org.example.java12;

public class MoreStringUtilsDemo {
    public static void main(String[] args) {
        // -- indent --
        String t = "test";
        System.out.println(t);
        // NOTE: indent() always add a new line terminator
        System.out.print("[" + t.indent(4) + "]");
        System.out.print("[" + t.indent(8) + "]");
        System.out.println(t.lines().toList().size());


        // -- transform --
        String name = "Kevin Murphy";
        String result = name.transform(x -> x.toUpperCase()).transform(y -> y.replace(" ", ""));
        System.out.println(result);
        result = name.transform(String::toUpperCase).transform(s -> new StringBuilder(s).reverse().toString());
        System.out.println(result);
    }
}
