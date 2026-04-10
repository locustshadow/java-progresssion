package org.example.java16;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class DayPeriodDemo {
    public static void main(String[] args) {
        var oldWay = "EEEE, MMMM d, yyyy, h:mm a";
        var newWay = "EEEE, MMMM d, yyyy, h:mm B";

        var x = DateTimeFormatter.ofPattern(oldWay, Locale.US).format(LocalDateTime.now());
        System.out.println(x);
        var y = DateTimeFormatter.ofPattern(newWay, Locale.US).format(LocalDateTime.now());
        System.out.println(y);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("B");
        System.out.println(LocalTime.of(6, 0).format(fmt));   // in the morning
        System.out.println(LocalTime.of(13, 0).format(fmt));  // in the afternoon
        System.out.println(LocalTime.of(20, 0).format(fmt));  // in the evening
        System.out.println(LocalTime.of(23, 0).format(fmt));  // at night
    }
}
