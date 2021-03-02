package com.pittacode.greeter.greeting.factory;

public final class GreetingFactoryProvider {

    public static GreetingFactory aMixedGreetingFactory() {
        return new MixedGreetingFactory(new NormalGreeter(), new ShoutingGreeter(), new NameFilter());
    }
}
