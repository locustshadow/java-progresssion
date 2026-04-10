package org.example.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;


public class FunctionsDemo {
    public static void main(String[] args) {
        // ------------------------FUNCTIONS-----------------------------
        // functions have the Functional Method of "apply"
        // Function<T, R> -- type has 2 parts... input and output

        Function<String, Integer> f = s -> s.length(); // OR String::length
        System.out.println(f.apply("kevin"));

        Function<String, Integer> f1 = String::length;
        System.out.println(f.apply("murphy"));

        List<Bank> banks = new ArrayList<>();
        banks.add(null);
        banks.add(new Bank(null, 0));
        banks.add(new Bank("kevin", 123));
        banks.add(new Bank("murphy", 234));
        Function<Bank, String> f2 = b -> b.getName();

        for (Bank b : banks) {
            if (b != null) {
                System.out.println(f2.apply(b));
            }
        }
    }
}

class Bank {
    private String name;
    private Integer accountNumber;

    public Bank(String name, Integer accountNumber) {
        this.name = name;
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }
}