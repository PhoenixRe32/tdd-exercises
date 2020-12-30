package com.pittacode;

import static java.lang.String.format;

public class Greeter {

    public String greet(String name) {
        if (name == null || name.isEmpty()) {
            return "Hello, my friend.";
        }

        var greeting = format("Hello, %s.", name);

        return isUpperCase(name)
                ? greeting.toUpperCase()
                : greeting;
    }

    private boolean isUpperCase(String name) {
        return name.chars()
                   .mapToObj(i -> (char) i)
                   .allMatch(Character::isUpperCase);
    }
}
