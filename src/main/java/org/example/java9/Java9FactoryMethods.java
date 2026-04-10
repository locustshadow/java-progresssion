package org.example.java9;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Map.entry;

public class Java9FactoryMethods {
    public static void main(String[] args) {
        // Java 8
        List<String> list = new ArrayList<>();
        list.add("kevin");
        list.add("j");
        list.add("murphy");
        System.out.println(list);

        // Java 9
        //-- list --
        List<String> list2 = List.of("kevin", "j", "murphy"); // uses ImmutableCollections to create
        //list2.add("test"); // UnsupportedOperationException: CANNOT modify
        System.out.println(list2);

        //-- set --
        //Set<String> set = Set.of("kevin", "kevin"); // IllegalArgumentException: set does not allow duplicates

        //-- map --
        Map<Integer, String> map = Map.of(1, "kevin", 2, "murphy");
        System.out.println(map);

        Map<Integer, String> map2 = Map.ofEntries(entry(1, "kevin"), entry(2, "murphy"));
        System.out.println(map2); // using static method "entry" from Map interface
    }
}
