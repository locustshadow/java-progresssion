package org.example.java21;

import java.util.ArrayList;

public class SwitchPatternMatchingDemo {
    /*
      Before Java 21, switch was mostly limited to primitives, enums, and strings.
      If you wanted to handle different object types, you had to use a messy chain of if-else and instanceof.

      With Pattern Matching, the switch statement can now test the type of an object and bind it to a variable automatically.
        - Key Upgrade: No more manual casting like String s = (String) obj;.
        - Guarded Clauses: You can add a when condition to a case for finer logic.
        - Null Handling: You can now handle null directly inside the switch.
     */
    public static void main(String[] args) {
        Object obj1 = "Hello World";
        Object obj2 = "Hi";
        Object obj3 = new Integer(100);
        Object obj4 = new ArrayList();
        Object obj5 = null;
        tryIt(obj1);
        tryIt(obj2);
        tryIt(obj3);
        tryIt(obj4);
        tryIt(obj5);
    }

    private static void tryIt(Object obj) {
        String result = switch (obj) {
            case Integer i -> "It's an integer: " + i;
            case String s when s.length() > 5 -> "Long string: " + s;
            case String s -> "Short string: " + s;
            case null -> "It's null!";
            default -> "Unknown type";
        };

        System.out.println(result);
    }
}
