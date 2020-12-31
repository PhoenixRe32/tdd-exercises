package com.pittacode.greeters;

public interface Greeter {

    String buildGreeting();

    default boolean isEmpty() {
        return true;
    }
}
