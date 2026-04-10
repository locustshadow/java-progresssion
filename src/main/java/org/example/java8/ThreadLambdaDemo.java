package org.example.java8;

public class ThreadLambdaDemo {
    public static void main(String[] args) {
        // old way
        Runnable r = new Runnable() {
            public void run() {
                System.out.println("r");
            }
        };
        Thread t = new Thread(r);
        t.start();

        // new way (lambda)
        Runnable r1 = () -> System.out.println("r1"); // Lambda implementation of Runnable (functional interface) functional method ("run")
        Thread t1 = new Thread(r1);
        t1.start();

    }
}

//--------------- can extend a functional interface, but cannot add a new functional method
@FunctionalInterface
interface Test1 {
    void m1();
}

@FunctionalInterface
interface Test2 extends Test1 {
    //void m2(); // not allowed if extending a functional interface
}


