package org.example.java8;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class AverageWithStreamDemo {
    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("kevin", "a123", 200.00));
        accounts.add(new Account("j", "b456", 400.00));
        accounts.add(new Account("murphy", "c789", 300.00));
        accounts.add(new Account("bubba", "d001", 900.00));
        accounts.add(new Account("murphy", "e002", 700.00));

        Double ave = accounts.stream().collect(Collectors.averagingDouble(acc -> acc.balance));
        System.out.println(ave);
        // 300.0

        DoubleSummaryStatistics stats = accounts.stream().collect(Collectors.summarizingDouble(acc -> acc.balance));
        System.out.println(stats);
        // {count=3, sum=900.000000, min=200.000000, average=300.000000, max=400.000000}
        System.out.println(stats.getAverage());
        // 300.0

        // combine a bunch
        List<String> result = accounts.stream()
                .filter(a -> a.balance > 200)
                .map(a -> a.name.toUpperCase())
                .distinct()
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(result);

        /*
            .map(a -> a.name.toUpperCase())         <-- can do in 1 line

        ... is equivalent to ...

            .map(Account::getName)
            .map(String::toUpperCase)
         */
    }
}

class Account {
    String name;
    String accountNumber;
    Double balance;

    Account(String name, String accountNumber, Double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
}
