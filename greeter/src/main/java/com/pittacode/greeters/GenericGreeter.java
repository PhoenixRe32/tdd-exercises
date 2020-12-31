package com.pittacode.greeters;

public class GenericGreeter implements Greeter {

    @Override
    public String buildGreeting() {
        return "Hello, my friend.";
    }
}
