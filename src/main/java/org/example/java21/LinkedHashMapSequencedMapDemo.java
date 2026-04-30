package org.example.java21;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SequencedMap;

public class LinkedHashMapSequencedMapDemo {
    public static void main(String[] args) {
        // LinkedHashMap now implements SequencedMap (Java 21+)
        // This provides putFirst() and putLast() methods

        System.out.println("=== LinkedHashMap SequencedMap Demo ===");

        // Create a LinkedHashMap with insertion-order
        SequencedMap<String, Integer> map = new LinkedHashMap<>();
        map.put("apple", 1);
        map.put("banana", 2);
        map.put("orange", 3);

        System.out.println("Initial map: " + map);
        System.out.println();

        // putFirst: Insert a new entry at the beginning
        map.putFirst("grape", 4);
        System.out.println("After putFirst(\"grape\", 4): " + map);
        System.out.println();

        // putLast: Insert a new entry at the end
        map.putLast("mango", 5);
        System.out.println("After putLast(\"mango\", 5): " + map);
        System.out.println();

        // Regular put adds at the end (same as putLast for LinkedHashMap)
        map.put("pear", 6);
        System.out.println("After regular put(\"pear\", 6): " + map);
        System.out.println();

        // Demonstrate iteration order follows insertion order
        System.out.println("Iterating entries in order:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println();

        // putFirst with existing key - moves it to first position
        map.putFirst("banana", 20);  // Update value and move to first
        System.out.println("After putFirst(\"banana\", 20) (updates and moves to first): " + map);
        System.out.println();

        // putLast with existing key - moves it to last position
        map.putLast("apple", 10);  // Update value and move to last
        System.out.println("After putLast(\"apple\", 10) (updates and moves to last): " + map);
        System.out.println();

        // Demonstrate first() and last() methods from SequencedMap
        System.out.println("First entry: " + map.firstEntry());
        System.out.println("Last entry: " + map.lastEntry());
        System.out.println();

        // pollFirst() and pollLast() remove and return entries
        Map.Entry<String, Integer> removedFirst = map.pollFirstEntry();
        System.out.println("pollFirstEntry() removed: " + removedFirst);
        System.out.println("Map after pollFirst: " + map);
        System.out.println();

        Map.Entry<String, Integer> removedLast = map.pollLastEntry();
        System.out.println("pollLastEntry() removed: " + removedLast);
        System.out.println("Map after pollLast: " + map);
        System.out.println();

        // reversed() - get a reversed view of the map
        System.out.println("=== reversed() demo ===");
        SequencedMap<String, Integer> reversed = map.reversed();
        System.out.println("Original map: " + map);
        System.out.println("Reversed view: " + reversed);
        System.out.println();

        // Modifications to reversed view affect original
        reversed.putFirst("kiwi", 7);
        System.out.println("After putFirst(\"kiwi\", 7) on reversed view:");
        System.out.println("  Reversed view: " + reversed);
        System.out.println("  Original map: " + map);
        System.out.println();

        // reversed() can be chained
        SequencedMap<String, Integer> doubleReversed = map.reversed().reversed();
        System.out.println("Double reversed (back to original order): " + doubleReversed);
    }
}
