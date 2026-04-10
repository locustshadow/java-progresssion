package org.example.java21;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;


public class VirtualThreadDemo {
    public static void main(String[] args) throws Exception {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 5; i++) {
                int id = i;
                executor.submit(() -> {
                    Thread.sleep(1000); // cheap blocking
                    System.out.println("Task " + id);
                    return null;
                });
            }
        }

        // COMPLETABLE FUTURES
        var f1 = CompletableFuture.supplyAsync(() -> fakeFetchUser());
        var f2 = CompletableFuture.supplyAsync(() -> fakeFetchOrders());
        var result = f1.thenCombine(f2, (user, orders) ->
                process(user, orders)
        ).join();

        // VIRTUAL THREADS
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            // also.. .could do `Thread.startVirtualThread(() -> doWork());`
            var f3 = executor.submit(() -> fakeFetchUser());
            var f4 = executor.submit(() -> fakeFetchOrders());
            var result2 = process(f1.get(), f2.get());
        }
    }

    
    // --- fake methods ---
    private static Object process(Object user, Object orders) {
        sleep();
        return null;
    }

    static Object fakeFetchUser() {
        sleep();
        return null;
    }

    static Object fakeFetchOrders() {
        sleep();
        return null;
    }

    static void sleep() {
        try {
            Thread.sleep(1000); // cheap blocking
        } catch (InterruptedException e) {
            System.out.println("error");
        }
    }
}

