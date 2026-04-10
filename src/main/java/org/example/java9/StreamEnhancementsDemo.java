package org.example.java9;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEnhancementsDemo {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(2, 4, 6, 8, 1, 10, 5);
        // old filter way
        List<Integer> result = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println(result);

        // takeWhile (default)
        // - processes like a filter, but only for elements where predicate is true
        // -- takeWhile --
        List<Integer> result2 = numbers.stream().takeWhile(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println(result2);

        // -- dropWhile --
        List<Integer> result3 = numbers.stream().dropWhile(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println(result3);

        // Iterate (static)
        // -- java 8 --
        //Stream.iterate(1, x -> x + 1).forEach(System.out::println); // infinite
        Stream.iterate(1, x -> x + 1).limit(10).forEach(System.out::println); // limited
        // -- java 9 --
        Stream.iterate(1, x -> x < 10, x -> x + 1).forEach(System.out::println); // limit expression argument in iterator

        // ofNullable (static)
        Stream<String> stream1 = Stream.ofNullable(null);
        stream1.forEach(x -> System.out.println("nothing:" + x)); // nothing prints, because there is nothing in the stream

        Stream<String> stream2 = Stream.ofNullable("kevin");
        stream2.forEach(System.out::println);
    }
}
