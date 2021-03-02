package com.pittacode.greeter.greeting.factory;

class ShoutingGreeter implements Greeter {

    @Override
    public String buildGreeting(String[] names) {
        if (names.length == 0) {
            return "";
        }

        if (names.length == 1) {
            return buildGreeting(names[0]);
        }

        return buildGreetingForMultiplePeople(names);
    }

    private String buildGreeting(String name) {
        return "HELLO " + name + "!";
    }

    private String buildGreetingForMultiplePeople(String[] names) {
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
}
