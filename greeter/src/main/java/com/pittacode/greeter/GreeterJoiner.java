package com.pittacode.greeter;

class GreeterJoiner {

    private final Greeter normalGreeter;
    private final Greeter shoutingGreeter;

    GreeterJoiner(Greeter normalGreeter, Greeter shoutingGreeter) {
        this.normalGreeter = normalGreeter;
        this.shoutingGreeter = shoutingGreeter;
    }

    String joinGreetings() {
        var greeting = new StringBuilder(normalGreeter.buildGreeting());
        if (areWeGreetingBothNormallAndShouting()) {
            greeting.append(" AND ");
        }
        greeting.append(shoutingGreeter.buildGreeting());

        return greeting.toString();
    }

    private boolean areWeGreetingBothNormallAndShouting() {
        return !normalGreeter.isEmpty() && !shoutingGreeter.isEmpty();
    }
}
