package org.example.java9;

public class ProcessApiDemo {
    public static void main(String[] args) {
        ProcessHandle ph = ProcessHandle.current();
        System.out.println(ph); // pid
        ProcessHandle.Info info = ph.info();
        System.out.println(info); // [user: Optional[ASIMOV\hexC0DE], cmd: C:\Program Files\Java\jdk-25\bin\java.exe, startTime: Optional[2026-03-27T19:29:23.915Z], totalTime: Optional[PT0.140625S]]
        System.out.println(info.user().get());
    }
}
