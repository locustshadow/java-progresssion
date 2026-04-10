package org.example.java12;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class CompactNumberFormatDemo {
    public static void main(String[] args) throws ParseException {
        var shortForm = NumberFormat.getCompactNumberInstance(new Locale("en", "US"), NumberFormat.Style.SHORT);
        System.out.println(shortForm.format(100000)); // 100K
        System.out.println(shortForm.format(1_000_000)); // 1M
        var longForm = NumberFormat.getCompactNumberInstance(new Locale("en", "US"), NumberFormat.Style.LONG);
        System.out.println(longForm.format(100000)); // 100 thousand
        System.out.println(longForm.format(1_000_000)); // 1 million
        //---
        System.out.println(longForm.parse("1 million")); //1000000
        System.out.println(shortForm.parse("1K")); // 1000
    }
}
