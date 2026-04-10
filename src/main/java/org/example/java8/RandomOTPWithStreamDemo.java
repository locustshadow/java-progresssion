package org.example.java8;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomOTPWithStreamDemo {
    public static void main(String[] args) {
        Stream.generate(() -> (new Random()).nextInt(10)).limit(6).forEach(System.out::print);

        System.out.println();

        /*
            Tricky one... building a base-10 number 1 digit at a time using `reduce` and an `accumulator`
         */
        Random r = new Random();
        int x = Stream.generate(() -> r.nextInt(10))
                .limit(6)
                .reduce(0, (acc, d) -> acc * 10 + d); // identity = 0 → starting value of acc
        //  acc = value so far    |     d = new value
        //  accumulator = function (acc, d) -> ...
        System.out.println(x);
        /*
            Behind the scenes... java does this:

            acc = identity;
            for (Integer d: streamElements) {
                acc = accumulator.apply(acc, d);
            }
         */

        // easier if a string
        String y = Stream.generate(() -> String.valueOf(r.nextInt(10)))
                .limit(6)
                .collect(Collectors.joining()); //<--= concatenate the strings
        System.out.println(y);
    }
}