package com.pittacode.greeter;

@FunctionalInterface
public interface Greeter {

    String buildGreeting(String[] names);
}
