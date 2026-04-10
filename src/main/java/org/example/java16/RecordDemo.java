package org.example.java16;

public class RecordDemo {
    public static void main(String[] args) {
        var cust = new Customer(1, "kevin");
        System.out.println(cust);
        //var cust2 = new Customer(0, "admin");
        System.out.println(cust.name()); // NOTE: Does not use "get" for getters
    }

    public record Customer(int acctNo, String name) {
        /*
           implicitly generated are
           * canonical constructor
           * toString()
           * equals()
           * hashcode()
           * public accessor (getter) methods [ NO SETTERS ]
         */

        // can add validations also, like so:
        public Customer {
            if (acctNo < 1) {
                throw new IllegalArgumentException("account number must be greater than 0");
            }
        }

        @Override
        public String name() {
            return this.name.toUpperCase();  // NOTE: Can override. Does not use "get" for getters
        }

        // Can't add setters:  "Cannot assign a value to final variable 'name'"
        //public void setName(String name) {
        //    this.name = name;
        //}
    }

    // Normal way
    public class Employee {
        private int acctNo;
        private String name;

        public Employee(int acctNo, String name) {
            this.acctNo = acctNo;
            this.name = name;
        }

        public int getAcctNo() {
            return acctNo;
        }

        public String getName() {
            return name;
        }
    }
}
