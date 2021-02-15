package com.pittacode.greeter;

public interface Greeter {

    String buildGreeting();

    default boolean isEmpty() {
        return true;
    }
}
