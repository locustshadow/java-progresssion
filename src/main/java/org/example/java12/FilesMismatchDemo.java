package org.example.java12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilesMismatchDemo {
    public static void main(String[] args) throws IOException {
        var f1 = Paths.get("test.txt");
        var f2 = Paths.get("test2.txt");
        long mismatch = Files.mismatch(f1, f2);
        if (mismatch == -1) {
            System.out.println("files are the same");
        } else {
            System.out.println("files are different @ " + mismatch);
        }
    }
}
