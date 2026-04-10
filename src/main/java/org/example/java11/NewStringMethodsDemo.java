package org.example.java11;

public class NewStringMethodsDemo {
    public static void main(String[] args) {
        String name = "\t   kevin  \t\n";
        String nameWithUnicodeChars = "\u2003  murphy  \u00A0\u2003";

        // -- repeat --
        System.out.println("[" + name.repeat(3) + "]");

        // -- OLD: trim() --
        System.out.println("[" + name.trim() + "]");
        System.out.println("[" + nameWithUnicodeChars.trim() + "]"); // doesn't remove unicode chars

        // -- strip --
        System.out.println("[" + nameWithUnicodeChars.strip() + "]"); // removes leading and trailing WHITE SPACE

        /*
            how is this different from `trim()`???
                `trim()` removes any character with a value ≤ ' ' (U+0020)
                    That includes:
                    ' ' (space)
                    \t (tab, U+0009)
                    \n (newline, U+000A)
                    \r (carriage return, U+000D)
                    a few other control chars

                `strip()` removes non-breaking space, unicode spaces, etc. also
         */

        // -- stripLeading --
        System.out.println("[" + nameWithUnicodeChars.stripLeading() + "]");

        // -- stripLeading --
        System.out.println("[" + nameWithUnicodeChars.stripTrailing() + "]");

        // -- lines --
        // NOTE: `lines()` creates a stream where each line is an element in the stream
        var testText = "kevin\nj\nmurphy";
        System.out.println(testText.lines().toList());

        // -- isBlank() --
        var blankString = "";
        System.out.println(blankString.isBlank());
        System.out.println(name.isBlank());
    }
}
