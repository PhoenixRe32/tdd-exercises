package com.pittacode.greeter;

import com.pittacode.greeter.greeting.factory.GreetingFactory;

public class GreeterGenerator {

    private static final String NO_NAME_GREETING = "Hello, my friend.";

    private final NameProcessor nameProcessor;
    private final GreetingFactory greetingFactory;

    public GreeterGenerator(NameProcessor nameProcessor,
                            GreetingFactory greetingFactory) {
        this.nameProcessor = nameProcessor;
        this.greetingFactory = greetingFactory;
    }

    public String buildGreeting(String name) {
        return isEmpty(name)
                ? NO_NAME_GREETING
                : buildGreeting(new String[]{name});
    }

    private boolean isEmpty(String name) {
        return name == null || name.isEmpty();
    }

    public String buildGreeting(String[] names) {
        String[] distinctNames = nameProcessor.splitAnyCommaSeparatedEntriesToSingleNames(names);

        return greetingFactory.generateGreeting(distinctNames);
    }
}
