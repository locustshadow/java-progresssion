package org.example.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsDemo {
    public static void main(String[] args) {
        // FILTER ---------------------------------
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            list.add(i);
        }
        System.out.println(list);
        Collection<Integer> result = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        System.out.println(result);

        // MAP ------------------------------------
        List<String> list_s = new ArrayList<>();
        list_s.add("kevin");
        list_s.add("j");
        list_s.add("murphy");
        Collection<String> result_s = list_s.stream().map(s -> s.toUpperCase() /*or String::toUpperCase()*/).collect(Collectors.toList());
        System.out.println(result_s);

        List<Integer> addedTen = list.stream().map((i) -> i + 10).collect(Collectors.toList());
        System.out.println(addedTen);

        // SORT
        /*
          @FunctionalInterface
          public interface Comparator<T> {
            int compare(T o1, T o2);
        */
        // `sorted(...)` can take a Comparator, which is a functional interface, and so you can pass the 2 values to sort.
        // if x.compareTo(y), then Ascending
        // if y.compareTo(x), then Descending
        List<String> result_3 = list_s.stream().sorted((x, y) -> y.compareTo(x)).collect(Collectors.toList());
        System.out.println(result_3);

        // Comparator.comparing(
        List<Employee> eList = new ArrayList<>();
        eList.add(new Employee("kevin", 10.0));
        eList.add(new Employee("j", 30.0));
        eList.add(new Employee("murphy", 20.0));
        // ...natural order
        List<Employee> result_3a = eList.stream().sorted(Comparator.comparing(Employee::getSalary)).collect(Collectors.toList());
        System.out.println(result_3a);
        // ...reversed
        List<Employee> result_3b = eList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).collect(Collectors.toList());
        System.out.println(result_3b);

        // MIN / MAX
        System.out.println(list.stream().min((x, y) -> y.compareTo(x)).get()); // use "get()" to get the value out of the "Optional" object
        // ^-- Makes no sense here since we have Integers. Min could return the Max... depends on the comparator you use.
        // for strings/integers... better to use Comparator.naturalOrder())
        System.out.println(list.stream().min(Comparator.naturalOrder()).get());

        // COUNT
        long count = list.stream().filter(x -> x % 2 == 0).count();
        System.out.println(count);

        // CONVERSION
        Integer[] arr = {12, 45, 78, 32, 65, 98};
        Stream<Integer> numbers = Stream.of(arr);
        numbers.forEach(n -> System.out.println(n));
        //numbers.forEach(System.out::println); //  error : stream has already been operated upon or closed

        // ALL MATCH
        boolean test = list_s.stream().allMatch(s -> s.startsWith("k"));
        System.out.println(test); // false

        // ANY MATCH
        boolean test2 = list_s.stream().anyMatch(s -> s.startsWith("k"));
        System.out.println(test2); // true

        // NONE MATCH
        boolean test3 = list_s.stream().anyMatch(s -> s.startsWith("x"));
        System.out.println(test3); // false

        // STREAM CREATION
        String[] strArr = new String[]{"kevin", "j", "murphy"};
        Stream<String> s = Arrays.stream(strArr);
        List<String> xyz = s.sorted().collect(Collectors.toList()); // sorted with no arg uses object's comparable interface
        System.out.println(xyz);
        //List<String> newResult = s.filter(r->r.startsWith("k")).collect(Collectors.toList()); // CAN'T DO, because `collect` is a terminal command.
        /* Once you run a terminal operation (collect, forEach, min, etc.), it’s consumed and closed. You can’t use it again. */

        // DISTINCT
        List<String> someList = new ArrayList<>();
        someList.add("kevin");
        someList.add("kevin");
        someList.add("kevin");
        someList.add("j");
        someList.add("murphy");
        List<String> distList = someList.stream().distinct().collect(Collectors.toList());
        System.out.println(distList);

        // for a hashmap, you use the entrySet to use a stream. Then get the key or value using Map.Entry.
        Map<String, Integer> someMap = new HashMap<>();
        // ... build map values ...
        someMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);

        // SERIES
        Stream.iterate(1, x -> x + 1).filter(x -> x % 2 == 0).limit(10).forEach(System.out::println);
    }
}

class Employee {
    private String name;
    private Double salary;

    Employee(String name, Double salary) {
        this.name = name;
        this.salary = salary;
    }

    String getName() {
        return this.name;
    }

    Double getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        return this.name + ":" + this.salary;
    }
}