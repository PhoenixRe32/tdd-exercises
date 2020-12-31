package com.pittacode;

import com.pittacode.greeters.Greeter;

class GreeterJoiner {

    private final Greeter normalGreeter;
    private final Greeter shoutingGreeter;

    GreeterJoiner(Greeter normalGreeter, Greeter shoutingGreeter) {
        this.normalGreeter = normalGreeter;
        this.shoutingGreeter = shoutingGreeter;
    }

    String joinGreetings() {
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
