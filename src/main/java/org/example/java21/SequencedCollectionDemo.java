package org.example.java21;

import java.util.ArrayList;
import java.util.List;
import java.util.SequencedCollection;

public class SequencedCollectionDemo {
    public static void main(String[] args) {
        // SequencedCollection<E>, SequencedSet<E>, SequencedMap<K, V>

        // -- old way --
        List<String> oldWayFruits = new ArrayList<>(List.of("apple", "banana", "orange"));
        String oldWayFirstFruit = oldWayFruits.get(0);
        String oldWayLastFruit = oldWayFruits.get(oldWayFruits.size() - 1);

        System.out.println("Old way fruits: " + oldWayFruits);
        System.out.println("Old way first fruit: " + oldWayFirstFruit);
        System.out.println("Old way last fruit: " + oldWayLastFruit);

        // -- new way --
        SequencedCollection<String> newWayFruits = new ArrayList<>(List.of("apple", "banana", "orange"));
        String newWayFirstFruit = newWayFruits.getFirst();
        String newWayLastFruit = newWayFruits.getLast();

        System.out.println("New way fruits: " + newWayFruits);
        System.out.println("New way first fruit: " + newWayFirstFruit);
        System.out.println("New way last fruit: " + newWayLastFruit);
    }
}
