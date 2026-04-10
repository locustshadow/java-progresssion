package org.example.java21;

public class CharIsEmojiDemo {
    public static void main(String[] args) {
        // A code point is a number that represents a character in Unicode.
        int cp1 = "😀".codePointAt(0);
        System.out.println(Character.isEmoji(cp1)); // true
        //-----------
        String s = "Hi 😀🔥!";
        s.codePoints().forEach(cp -> {
            if (Character.isEmoji(cp)) {
                System.out.println("Emoji: " + new String(Character.toChars(cp)));
            }
        });
    }
}
