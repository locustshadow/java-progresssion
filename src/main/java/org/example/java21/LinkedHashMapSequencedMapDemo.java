package org.example.java21;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SequencedMap;

public class LinkedHashMapSequencedMapDemo {
    public static void main(String[] args) {
        // SequencedMap<K, V> - Java 21+ feature
        // LinkedHashMap implements SequencedMap, providing positional operations

        System.out.println("=== LinkedHashMap SequencedMap Demo ===");
        System.out.println();

        // -- basic putFirst / putLast demo --
        SequencedMap<String, Integer> map = new LinkedHashMap<>();
        map.put("apple", 1);
        map.put("banana", 2);
        map.put("orange", 3);

        System.out.println("Initial map: " + map);
        System.out.println();

        map.putFirst("grape", 4);
        System.out.println("putFirst(\"grape\", 4): " + map);
        System.out.println();

        map.putLast("mango", 5);
        System.out.println("putLast(\"mango\", 5): " + map);
        System.out.println();

        map.put("pear", 6);
        System.out.println("regular put(\"pear\", 6): " + map);
        System.out.println();

        // -- updating existing keys moves them --
        map.putFirst("banana", 20);
        System.out.println("putFirst(\"banana\", 20) moves to front: " + map);
        System.out.println();

        map.putLast("apple", 10);
        System.out.println("putLast(\"apple\", 10) moves to back: " + map);
        System.out.println();

        /* NOTES:
            "Poll" vs "remove" - The term "poll" comes from queue/stack terminology:

                poll() - retrieves AND removes the head/first element, returns null if empty (non-throwing)
                remove() - retrieves AND removes the head/first element, throws exception if empty

            The "poll" naming convention exists in Queue interface (poll(), peek()) and now in SequencedMap/SequencedCollection:

                pollFirstEntry() / pollLastEntry() - remove and return, or return null if empty
                firstEntry() / lastEntry() - peek (return but don't remove), or null if empty
         */

        // -- peek at ends --
        System.out.println("firstEntry(): " + map.firstEntry());
        System.out.println("lastEntry(): " + map.lastEntry());
        System.out.println();

        // -- poll (remove) from ends --
        System.out.println("pollFirstEntry(): " + map.pollFirstEntry());
        System.out.println("Map after pollFirst: " + map);
        System.out.println();

        System.out.println("pollLastEntry(): " + map.pollLastEntry());
        System.out.println("Map after pollLast: " + map);
        System.out.println();

        // -- reversed() view --
        System.out.println("-- reversed() demo --");
        SequencedMap<String, Integer> reversed = map.reversed();
        System.out.println("Original: " + map);
        System.out.println("Reversed: " + reversed);
        System.out.println();

        reversed.putFirst("kiwi", 7);
        System.out.println("putFirst(\"kiwi\", 7) on reversed view:");
        System.out.println("  reversed: " + reversed);
        System.out.println("  original: " + map + " (live view!)");
        System.out.println();

        SequencedMap<String, Integer> doubleReversed = map.reversed().reversed();
        System.out.println("reversed().reversed(): " + doubleReversed);
    }
}
