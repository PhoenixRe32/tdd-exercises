package com.pittacode.greeter;

import static com.pittacode.greeter.greeters.GreeterFactory.aGenericGreeter;
import static com.pittacode.greeter.greeters.GreeterFactory.aNormalGreeter;
import static com.pittacode.greeter.greeters.GreeterFactory.aShoutingGreeter;

public class GreeterGenerator {

    private final NameInputProcessor nameInputProcessor;

    public GreeterGenerator(NameInputProcessor nameInputProcessor) {
        this.nameInputProcessor = nameInputProcessor;
    }

    public String buildGreeting(String[] names) {
        String[] processedNames = nameInputProcessor.splitAnyCommaSeparatedEntriesToSingleNames(names);

        var nameDifferentiator = new NameDifferentiator(processedNames);

        var normalGreeter = aNormalGreeter(nameDifferentiator.getNormalNames());
        var shoutingGreeter = aShoutingGreeter(nameDifferentiator.getShoutedNames());

        return new GreeterJoiner(normalGreeter, shoutingGreeter).joinGreetings();
    }


    public String buildGreeting(String name) {
        if (isEmpty(name)) {
            return aGenericGreeter().buildGreeting();
        }

        return buildGreeting(new String[]{name});
    }

    private boolean isEmpty(String name) {
        return name == null || name.isEmpty();
    }
}
