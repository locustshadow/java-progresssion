package org.example.java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {
        Consumer<String> c = (x) -> System.out.println(x.toUpperCase());
        c.accept("kevin");
        // ---
        List<String> list = new ArrayList<>();
        list.add("kevin");
        list.add("j");
        list.add("murphy");
        list.forEach(x -> System.out.println(x.toUpperCase())); // Collection.forEach
        // Collection extends Iterable.  Iterable has a default method (forEach) that takes a Consumer

        // ALSO ... (since consumer defined as c above)
        list.forEach(c); // Collection.forEach

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "kevin");
        map.put(2, "j");
        map.put(3, "murphy");
        map.forEach((x, y) -> System.out.println(x + ":" + y));
    }
}
