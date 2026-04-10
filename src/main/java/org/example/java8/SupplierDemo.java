package org.example.java8;

import java.util.Random;
import java.util.function.Supplier;

public class SupplierDemo {
    public static void main(String[] args) {
        Supplier<String> s = () -> "kevin";
        System.out.println(s.get());

        Supplier<Double> s1 = Math::random;
        Double y = s1.get();
        System.out.println(y);

        Supplier<Integer> s2 = () -> new Random().nextInt(1000);
        System.out.println(s2.get());

        Supplier<String> otpGenerator = () -> {
            // some code here
            String otp = "";
            for (int i = 0; i < 6; i++) {
                otp += new Random().nextInt(10);
            }
            return otp;
        };
        System.out.println(otpGenerator.get());
    }
}
