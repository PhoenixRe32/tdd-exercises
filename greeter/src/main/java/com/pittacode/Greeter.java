package com.pittacode;

import static java.lang.String.format;

public class Greeter {

    public String greet(String name) {
        if (name == null || name.isEmpty()) {
            return "Hello, my friend.";
        }
        return format("Hello, %s.", name);
    }
}
