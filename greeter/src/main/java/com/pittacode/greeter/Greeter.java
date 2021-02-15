package com.pittacode.greeter;

@FunctionalInterface
public interface Greeter {

    String buildGreeting();

    default boolean hasNoNames() {
        return true;
    }
}
