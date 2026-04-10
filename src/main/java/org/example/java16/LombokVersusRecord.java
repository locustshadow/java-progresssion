package org.example.java16;

import lombok.Value;

public class LombokVersusRecord {
    public static void main(String[] args) {

    }

    // ----------OLD WAY------------
    class Person {
        private final String name;
        private final int age;

        public Person(String name, int age) {
            if (age < 0) throw new IllegalArgumentException();
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public boolean equals(Object o) {
            return true;/* verbose */
        }

        @Override
        public int hashCode() {
            return 0;/* verbose */
        }

        @Override
        public String toString() {
            return ""; /* verbose */
        }
    }

    // -----------LOMBOK------------
    @Value
    class Person2 {
        String name;
        int age;

        public Person2(String name, int age) {
            if (age < 0) throw new IllegalArgumentException();
            this.name = name;
            this.age = age;
        }
    }
    /*
        Lombok generates:
            getters
            equals/hashCode
            toString
            constructor
     */

    // -----------RECORD-----------
    record Person3(String name, int age) {
        public Person3 {
            if (age < 0) throw new IllegalArgumentException();
        }
    }
    /*
        Java generates:
            fields
            constructor
            getters (name(), age())
            equals/hashCode
            toString
     */

    // NOTE: Records replace ~90% of Lombok @Value use cases — with zero magic and cleaner code.
}
