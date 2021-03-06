package com.pittacode.greeter.greeting.factory;

import static java.lang.String.format;

class NormalGreeter implements Greeter {

    @Override
    public String buildGreeting(String[] names) {
        if (names.length == 0) {
            return "";
        }

        if (names.length == 1) {
            return buildGreeting(names[0]);
        }

        if (names.length == 2) {
            return buildGreeting(names[0], names[1]);
        }

        return buildGreetingFor3OrMore(names);
    }

    private String buildGreeting(String name) {
        return "Hello, " + name + ".";
    }

    private String buildGreeting(String name1, String name2) {
        return format("Hello, %s and %s.", name1, name2);
    }

    private String buildGreetingFor3OrMore(String[] names) {
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
