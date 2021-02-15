package com.pittacode.greeter;

import com.pittacode.greeter.NameFilter.Names;

class GreeterJoiner {

    private final Greeter normalGreeter;
    private final Greeter shoutingGreeter;

    GreeterJoiner(Greeter normalGreeter, Greeter shoutingGreeter) {
        this.normalGreeter = normalGreeter;
        this.shoutingGreeter = shoutingGreeter;
    }

    String joinGreetings(Names names) {
        var greeting = new StringBuilder(normalGreeter.buildGreeting(names.normalNames));
        if (areWeGreetingBothNormallAndShouting(names)) {
            greeting.append(" AND ");
        }
        greeting.append(shoutingGreeter.buildGreeting(names.shoutedNames));

        return greeting.toString();
    }

    private boolean areWeGreetingBothNormallAndShouting(Names names) {
        return names.normalNames.length != 0 && names.shoutedNames.length != 0;
    }
}
