package org.example.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicatesDemo {
    public static void main(String[] args) {
        // ------------------------PREDICATES-----------------------------
        // Predicates (functional method == test(T)
        // type must be an object, not a primitive
        Predicate<Integer> p = (n) -> n > 2021; // specify type
        System.out.println(p.test(2020));
        System.out.println(p.test(2022));

        Predicate<String> p1 = (s) -> s.length() > 5;
        System.out.println(p1.test("test test"));
        System.out.println(p1.test("test"));

        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(5);
        list.add(30);
        list.add(51);
        list.add(65);
        Predicate<Integer> p2 = (n) -> n > 10;
        for (Integer x : list) {
            if (p2.test(x)) {
                System.out.println(x);
            }
        }

        List<Country> list2 = new ArrayList<>();
        list2.add(new Country("abc country", 10));
        list2.add(new Country("iabc country", 20));
        list2.add(new Country("ixyz country", 30));
        list2.add(new Country("xyz country", 40));
        Predicate<Country> p3 = (c) -> (c.getName().startsWith("i") && c.getPopulation() > 20);
        for (Country x : list2) {
            if (p3.test(x)) {
                System.out.println(x.getName() + ":" + x.getPopulation());
            }
        }
    }
}

//-------------
class Country {
    private String name;
    private int population;

    public Country(String name, int population) {
        this.name = name;
        this.population = population;
    }

    public String getName() {
        return this.name;
    }

    public int getPopulation() {
        return this.population;
    }
}