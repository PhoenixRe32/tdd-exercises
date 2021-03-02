package com.pittacode.greeter.greeting.factory;

@FunctionalInterface
public interface Greeter {

    String buildGreeting(String[] names);
}
