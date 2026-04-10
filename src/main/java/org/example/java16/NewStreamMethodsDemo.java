package org.example.java16;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NewStreamMethodsDemo {
    public static void main(String[] args) {

        // --- OLD WAY ---
        var result1 = Stream.of("kevin", "j", "murphy").collect(Collectors.toList());
        result1.add("test");

        // --- NEW WAY ---
        var result2 = Stream.of("kevin", "j", "murphy").toList();  // This is how I would have done it in the first place.
        //result2.add("test"); // UnsupportedOperationException ! it creates an immutable list by default.

        /*
            default List<T> toList() {
                return (List<T>) Collections.unmodifiableList(new ArrayList<>(Arrays.asList(this.toArray())));
            }
         */


    }
}
