package org.example.java18;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class InternetAddressResolutionDemo {
    public static void main(String[] args) {
        String[] hosts = {"google.com", "localhost"};
        Arrays.stream(hosts).toList().forEach(InternetAddressResolutionDemo::printThem);
    }

    private static void printThem(String host) {
        System.out.println("Resolving: " + host + " <--------=");
        try {
            InetAddress[] addresses = InetAddress.getAllByName(host);
            System.out.printf("found [%d] addresses\n", addresses.length);

            for (InetAddress addr : addresses) {
                System.out.println("-------------------");
                System.out.println("Host Name: " + addr.getHostName());
                System.out.println("Host Address: " + addr.getHostAddress());
                System.out.println("Canonical Host Name: " + addr.getCanonicalHostName());
                System.out.println(addr.getAddress()); // binary value
                System.out.println(addr.getAddress().length); // length of binary value
                //127.0.0.1 === 01111111 00000000 00000000 00000001 === 4 bytes
                System.out.println("Is IPv4: " + (addr.getAddress().length == 4));
                System.out.println("Is IPv6: " + (addr.getAddress().length == 16));
                // should be just addr.isIp4v() or addr.isIp6v()
                if (addr instanceof Inet4Address) {
                    System.out.println("IPv4");
                } else if (addr instanceof Inet6Address) {
                    System.out.println("IPv6");
                }
            }
        } catch (UnknownHostException e) {
            System.out.println("Failed to resolve host: " + host);
            e.printStackTrace();
        }
    }
}