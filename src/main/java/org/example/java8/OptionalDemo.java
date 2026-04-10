package org.example.java8;

import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        // -- old way --
        var student = getStudentName("kevinx");
        if (student != null) {
            System.out.println("student found: [" + student.getFirstName() + "]");
        } else {
            System.out.println("some error");
        }

        // -- new way with Optional --
        var student2 = Optional.ofNullable(getStudentName("kevin"));
        if (student2.isPresent()) {
            System.out.println("student found: [" + student2.get().getFirstName() + "]");
        } else {
            System.out.println("some error");
        }

        // -- newer way with Optional --
        var student3 = Optional.ofNullable(getStudentName("kevinx")).orElseThrow(); //NoSuchElementException
        // OR ...
        // var student3 = Optional.ofNullable(getStudentName("kevinx")).orElseThrow(() -> new RuntimeException("some error"));
        System.out.println(student3.getFirstName());
    }

    // simulate some db call
    public static Student getStudentName(String name) {
        if (name.equals("kevin") || name.equals("murphy")) {
            return new Student(111, name, "whatever");
        } else {
            return null;
        }
    }

    // inner class
    public static class Student {
        private Integer id;
        private String firstName;
        private String lastName;

        public Student(Integer id, String firstName, String lastName) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }
}


