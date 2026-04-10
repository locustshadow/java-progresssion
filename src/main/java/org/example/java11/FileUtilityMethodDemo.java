package org.example.java11;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
    File Utility methods
        - readString
        - writeString
 */
public class FileUtilityMethodDemo {
    public static void main(String[] args) throws IOException {
        File f = new File("test.txt");
        System.out.println(f.canRead());
        // ----readString----
        Path filePath = Paths.get("test.txt");
        String result = Files.readString(filePath); //<---= quick read from file
        System.out.println(result);
        // ----writeString----
        Path filePath2 = Paths.get("test2.txt");
        Files.writeString(filePath2, "testing writeString");
    }
}
