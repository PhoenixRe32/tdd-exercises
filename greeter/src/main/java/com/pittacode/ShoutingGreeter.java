package com.pittacode;

import static java.lang.String.format;

public class ShoutingGreeter implements Greeter {

    private final String[] names;

    public ShoutingGreeter(String[] names) {
        this.names = names;
    }

    public ShoutingGreeter(String name) {
        this(new String[]{name});
    }

    @Override
    public String buildGreeting() {
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
        return "HELLO " + name + "!";
    }

    private String buildGreeting(String name1, String name2) {
        return format("HELLO %s AND %s.", name1, name2);
    }

    private String buildGreetingFor3OrMore(String[] names) {
        var greetingBuilder = new StringBuilder("HELLO ");
        for (int i = 0; i < names.length - 1; i++) {
            greetingBuilder.append(names[i]);
            greetingBuilder.append(" AND ");
        }
        greetingBuilder.append(" AND ");
        greetingBuilder.append(names[names.length - 1]);
        greetingBuilder.append(".");

        return greetingBuilder.toString();
    }

    public boolean isEmpty() {
        return names.length == 0;
    }
}
