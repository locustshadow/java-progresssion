package org.example.java17;

public class SealedClassesDemo {
    public static void main(String[] args) {
        
    }

    // ---- inner classes ----

    sealed interface Fruit permits Apple, Orange {
        // sealed - can only be extended by permitted subclasses
    }

    sealed class Apple implements Fruit permits GrannySmith {
        // sealed - can only be extended by permitted subclasses
    }

    non-sealed class GrannySmith extends Apple {
        // non-sealed - can be extended by unknown subclassees
    }

    final class RipeGrannySmith extends GrannySmith {
        // final - cannot be extended further
    }

    non-sealed class Orange implements Fruit {
    }
}
