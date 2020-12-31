package com.pittacode;

public class GreeterJoiner {

    private final NormalGreeter normalGreeter;
    private final ShoutingGreeter shoutingGreeter;

    public GreeterJoiner(NormalGreeter normalGreeter, ShoutingGreeter shoutingGreeter) {
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
