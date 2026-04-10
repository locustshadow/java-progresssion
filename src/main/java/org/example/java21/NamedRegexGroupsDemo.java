package org.example.java21;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NamedRegexGroupsDemo {
    public static void main(String[] args) {
        String line = "1;New York;8336817";
        Pattern pattern = Pattern.compile("""
                (?<index>\\d+);\
                (?<city>[ a-zA-Z]+);\
                (?<population>[ \\d]+)$""");
        Matcher matcher = pattern.matcher(line);
        if (matcher.matches()) {
            var index = matcher.group("index");
            var city = matcher.group("city");
            var population = matcher.group("population");
        }
    }
}
