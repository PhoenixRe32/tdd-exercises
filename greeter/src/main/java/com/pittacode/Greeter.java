package com.pittacode;

import java.util.Arrays;

import static java.lang.String.format;
import static java.util.function.Predicate.not;

public class Greeter {

    public String buildGreeting(String[] names) {
        var shoutedNames = Arrays.stream(names)
                                 .filter(this::isUpperCase)
                                 .toArray(String[]::new);
        var normalNames = Arrays.stream(names)
                                .filter(not(this::isUpperCase))
                                .toArray(String[]::new);

        var normalGreeting = buildNormalGreeting(normalNames);
        var shoutedGreeting = buildShoutedGreeting(shoutedNames);

        return joinGreetings(normalGreeting, shoutedGreeting);
    }

    private String joinGreetings(String normalGreeting, String shoutedGreeting) {
        var greetingBuilder = new StringBuilder(normalGreeting);
        if (areWeGreetingBothNormallAndShouting(normalGreeting, shoutedGreeting)) {
            greetingBuilder.append(" AND ");
        }
        greetingBuilder.append(shoutedGreeting);

        return greetingBuilder.toString();
    }

    private boolean areWeGreetingBothNormallAndShouting(String normalGreeting, String shoutedGreeting) {
        return !normalGreeting.isEmpty() && !shoutedGreeting.isEmpty();
    }

    private String buildNormalGreeting(String[] names) {
        if (names.length == 0) {
            return "";
        }

        if (names.length == 1) {
            return buildNormalGreeting(names[0]);
        }

        if (names.length == 2) {
            return buildNormalGreeting(names[0], names[1]);
        }

        return buildNormalGreetingFor3OrMore(names);
    }

    private String buildNormalGreeting(String name) {
        return "Hello, " + name + ".";
    }

    private String buildNormalGreeting(String name1, String name2) {
        return format("Hello, %s and %s.", name1, name2);
    }

    private String buildNormalGreetingFor3OrMore(String[] names) {
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

    public String buildGreeting(String name) {
        if (isEmpty(name)) {
            return buildGenericGreeting();
        }


        return isUpperCase(name)
                ? buildShoutedGreeting(name)
                : buildNormalGreeting(name);
    }

    private String buildGenericGreeting() {
        return "Hello, my friend.";
    }

    private String buildShoutedGreeting(String[] names) {
        if (names.length == 0) {
            return "";
        }

        if (names.length == 1) {
            return buildShoutedGreeting(names[0]);
        }

        if (names.length == 2) {
            return buildShoutedGreeting(names[0], names[1]);
        }

        return buildShoutedGreetingFor3OrMore(names);
    }

    private String buildShoutedGreeting(String name) {
        return "HELLO " + name + "!";
    }

    private String buildShoutedGreeting(String name1, String name2) {
        return format("HELLO %s AND %s.", name1, name2);
    }

    private String buildShoutedGreetingFor3OrMore(String[] names) {
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

    private boolean isEmpty(String name) {
        return name == null || name.isEmpty();
    }

    private boolean isUpperCase(String name) {
        return name.codePoints()
                   .mapToObj(i -> (char) i)
                   .allMatch(ch -> !Character.isLetter(ch) || Character.isUpperCase(ch));
    }
}
