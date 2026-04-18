package org.example.java21;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

/**
 * Demonstrates the new DateTimeFormatter localization APIs introduced in Java 21.
 * 
 * <p><strong>What's new in Java 21?</strong><br>
 * Java 21 introduces two new methods for creating localized date-time formatters:
 * 
 * <ul>
 *   <li>{@code DateTimeFormatter.ofLocalizedPattern(String skeleton)} - Creates a formatter 
 *       from a <em>skeleton pattern</em> (a string of pattern letters without literals) 
 *       that is automatically localized using the default locale (or a specified locale). 
 *       The skeleton specifies which fields to include (e.g., year, month, day, hour); 
 *       the actual pattern (order, separators) is determined by the locale's conventions.</li>
 *   <li>{@code DateTimeFormatterBuilder.appendLocalized(String skeleton)} - 
 *       Appends a localized date-time pattern to the builder based on a skeleton string. 
 *       This allows constructing formatters by adding a localized pattern within a 
 *       builder chain, useful for combining with other formatter components.</li>
 * </ul>
 * 
 * <p><strong>Benefits:</strong>
 * <ul>
 *   <li><strong>Locale-conformant formats:</strong> Automatically use the correct order, 
 *       separators, and text for each locale (e.g., MM/dd/yyyy vs dd/MM/yyyy).</li>
 *   <li><strong>Simplified code:</strong> No need to manually craft different patterns 
 *       for each locale; provide a skeleton once and let the API handle the rest.</li>
 *   <li><strong>Flexibility:</strong> Use skeletons directly or within builders for 
 *       complex formatters, and apply explicit locale as needed.</li>
 * </ul>
 * 
 * <p><strong>Note:</strong> Skeleton patterns contain only pattern letters (e.g., "yMMdHm") 
 * and no literal characters (spaces, commas, quotes). The locale's formatting conventions 
 * (separators, order, text) are applied automatically.
 */
public class LocalizationOfDateTimeFormatterDemo {
    public static void main(String[] args) {
        System.out.println("=== Java 21 DateTimeFormatter Localization APIs ===\n");
        
        LocalDateTime now = LocalDateTime.now();
        ZonedDateTime zonedNow = ZonedDateTime.now(ZoneId.of("America/New_York"));
        
        // Example 1: DateTimeFormatter.ofLocalizedPattern with a skeleton (new in Java 21)
        System.out.println("--- Example 1: ofLocalizedPattern ---");
        // Skeleton: year, month (numeric), day, hour (0-23), minute
        // This produces locale-specific date-time formats (e.g., US: MM/dd/yyyy HH:mm)
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedPattern("yMMdHm");
        System.out.println("Skeleton: \"yMMdHm\"");
        System.out.println("US: " + now.format(formatter1.withLocale(Locale.US)));
        System.out.println("France: " + now.format(formatter1.withLocale(Locale.FRANCE)));
        System.out.println("Japan: " + now.format(formatter1.withLocale(Locale.JAPAN)));
        System.out.println();
        
        // Example 2: DateTimeFormatterBuilder.appendLocalized with a skeleton (new in Java 21)
        System.out.println("--- Example 2: appendLocalized(String) ---");
        // Same skeleton via builder
        DateTimeFormatter formatter2 = new DateTimeFormatterBuilder()
            .appendLocalized("yMMdHm")
            .toFormatter(Locale.GERMAN);
        System.out.println("Skeleton: \"yMMdHm\"");
        System.out.println("German: " + zonedNow.format(formatter2));
        
        DateTimeFormatter formatter2French = new DateTimeFormatterBuilder()
            .appendLocalized("yMMdHm")
            .toFormatter(Locale.FRENCH);
        System.out.println("French: " + zonedNow.format(formatter2French));
    }
}
