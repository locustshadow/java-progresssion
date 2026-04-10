package org.example.java8;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class JavaTime {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now(); // 2026-03-27
        System.out.println(date);

        LocalTime time = LocalTime.now();
        System.out.println(time); // 11:03:01.113682900

        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime); // 2026-03-27T11:03:31.402175500

        System.out.println(dateTime.getYear());
        System.out.println(dateTime.getMonth());
        System.out.println(dateTime.getDayOfMonth());
        System.out.println(dateTime.getDayOfWeek());
        System.out.println(dateTime.getDayOfYear());

        ZoneId z = ZoneId.systemDefault();
        System.out.println(z); // America/Denver

        Instant timestamp = Instant.now();
        System.out.println(timestamp); // 2026-03-27T17:17:33.671729600Z

        Period p = Period.between(date, date.plusDays(60));
        System.out.println(p.getMonths()); // 1 month
        System.out.println(p.getDays()); // 29 days (1 month, 29 days)

        String dateText = "Fri, 27 March 2026";
        String longForm = "EEE, d MMMM yyyy";
        String longerForm = "EEE, d MMMM yyyy HH:mm:ss";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(longForm, Locale.ENGLISH);
        System.out.println(LocalDate.parse(dateText, dtf));
        System.out.println(dateTime.format(DateTimeFormatter.ofPattern(longForm)));
        System.out.println(dateTime.format(DateTimeFormatter.ofPattern(longerForm)));
    }
}
