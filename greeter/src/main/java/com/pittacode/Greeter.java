package com.pittacode;

public interface Greeter {

    String buildGreeting();

    default boolean isEmpty() {
        return true;
    }
}
