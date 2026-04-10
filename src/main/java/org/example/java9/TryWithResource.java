package org.example.java9;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TryWithResource {
    public static void main(String[] args) throws IOException {
        // JAVA 8 APPROACH-------------------
        try (FileOutputStream fos = new FileOutputStream("test.txt")) {
            fos.write("testing".getBytes());
            System.out.println("file is written");
        } catch (Exception e) {
            System.out.println("something unexpected happened");
        } // no finally. auto-closes resource.

        // JAVA 9 APPROACH-------------------
        FileOutputStream fos2 = new FileOutputStream("test.txt");
        try (fos2) {                                                     // <-------- can now reference resource here
            fos2.write("testing".getBytes());
            System.out.println("file is written");
        } catch (Exception e) {
            System.out.println("something unexpected happened");
        } // no finally. auto-closes resource.

        // --multiple resources--
        FileInputStream fis = new FileInputStream("in.txt");
        BufferedInputStream bis = new BufferedInputStream(fis);
        try (fis; bis) {
            // use them
        } // auto-closes in reverse order (bis then fis)
        // NOTE: Exceptions during close are suppressed, not lost. can use e.getSuppressed() to view.
    }


}
