package org.example.java16;

import java.util.Arrays;
import java.util.List;

public class MapMultiDemo {
    public static void main(String[] args) {
        List<String> data = List.of(
                "apple,banana",
                "carrot",
                "dog,elephant,fox"
        );

        // with flatMap
        List<String> result = data.stream().flatMap(line -> Arrays.stream(line.split(","))).toList();
        System.out.println(result);

        // with mapMulti
        List<String> result2 = data.stream()
                .<String>mapMulti((line, consumer) -> {   //<----= added "type witness" on mapMulti method
                    for (String part : line.split(",")) {
                        consumer.accept(part);
                    }
                }).toList();
        System.out.println(result2);
    }
}
