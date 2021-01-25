package com.pittacode.greeter.greeters;

public interface Greeter {

    String buildGreeting();

    default boolean isEmpty() {
        return true;
    }
}
