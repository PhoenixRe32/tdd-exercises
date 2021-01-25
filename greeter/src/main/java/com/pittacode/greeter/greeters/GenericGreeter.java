package com.pittacode.greeter.greeters;

public class GenericGreeter implements Greeter {

    @Override
    public String buildGreeting() {
        return "Hello, my friend.";
    }
}
