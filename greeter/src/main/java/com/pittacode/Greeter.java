package com.pittacode;

import static java.lang.String.format;

public class Greeter {

    public String greet() {
        return "Hello, my friend.";
    }

    public String greet(String name) {
        if (isEmpty(name)) {
            return greet();
        }

        var greetingBuilder = new StringBuilder("Hello, ");


        return isUpperCase(name)
                ? greetingBuilder.append(name).append("!").toString().toUpperCase()
                : greetingBuilder.append(name).append(".").toString();
    }

    private boolean isEmpty(String name) {
        return name == null || name.isEmpty();
    }

    private boolean isUpperCase(String name) {
        return name.codePoints()
                   .mapToObj(i -> (char) i)
                   .allMatch(ch -> !Character.isLetter(ch) || Character.isUpperCase(ch));
    }

    public String greet(String[] names) {
        if (names.length == 2) {
            return format("Hello, %s and %s.", names[0], names[1]);
        }

        var greetingBuilder = new StringBuilder("Hello, ");
        for (int i = 0; i < names.length - 1; i++) {
            greetingBuilder.append(names[i]);
            greetingBuilder.append(", ");
        }
        greetingBuilder.append("and ");
        greetingBuilder.append(names[names.length - 1]);
        greetingBuilder.append(".");

        return greetingBuilder.toString();
    }
}
