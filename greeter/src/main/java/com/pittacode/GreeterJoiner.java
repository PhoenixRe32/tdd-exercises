package com.pittacode;

public class GreeterJoiner {

    private final Greeter normalGreeter;
    private final Greeter shoutingGreeter;

    public GreeterJoiner(Greeter normalGreeter, Greeter shoutingGreeter) {
        this.normalGreeter = normalGreeter;
        this.shoutingGreeter = shoutingGreeter;
    }

    public String joinGreetings() {
        var normalGreeting = normalGreeter.buildGreeting();
        var shoutedGreeting = shoutingGreeter.buildGreeting();

        var greetingBuilder = new StringBuilder(normalGreeting);
        if (areWeGreetingBothNormallAndShouting()) {
            greetingBuilder.append(" AND ");
        }
        greetingBuilder.append(shoutedGreeting);

        return greetingBuilder.toString();
    }

    private boolean areWeGreetingBothNormallAndShouting() {
        return !normalGreeter.isEmpty() && !shoutingGreeter.isEmpty();
    }
}
