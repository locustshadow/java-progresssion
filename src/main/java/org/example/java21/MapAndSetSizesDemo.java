package org.example.java21;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/*
    Advantages of Specifying Initial Capacity:

    1. Avoids Rehashing (Performance)
    When a HashMap or HashSet exceeds its load factor threshold (default 0.75),
    it must rehash all entries into a larger array. This is an expensive O(n) operation that:

    * Creates a new array (typically 2x larger)
    * Recomputes all hash codes
    * Reinserts every entry

    By setting initial capacity appropriately, you prevent multiple rehash cycles during population.

    2. Single Memory Allocation
    Instead of incremental growth (e.g., 16 → 32 → 64 → 128), you allocate once with the exact capacity needed, reducing:

    * Memory fragmentation
    * Garbage collection pressure from discarded arrays

    3. Predictable Performance
    No sudden pauses from rehashing when the collection crosses threshold boundaries during critical operations.
 */
public class MapAndSetSizesDemo {
    public static void main(String[] args) {
        var map = HashMap.newHashMap(100);
        var set = HashSet.newHashSet(100);
        var linkedMap = LinkedHashMap.newLinkedHashMap(100);
        var linkedSet = LinkedHashSet.newLinkedHashSet(100);
    }
}
