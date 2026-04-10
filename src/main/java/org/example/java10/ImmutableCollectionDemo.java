package org.example.java10;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ImmutableCollectionDemo {
    public static void main(String[] args) {
        var listA = new ArrayList<>();
        listA.add("kevin");
        listA.add("j");
        listA.add("murphy");
        var listB = listA.stream().collect(Collectors.toUnmodifiableList());
        //listB.add("test"); //UnsupportedOperationException
        var listC = listA.stream().collect(Collectors.toList());
        // SAME AS:  var listC = new ArrayList<>(listA);
        listC.add("test");
        System.out.println(listC);
    }
}
