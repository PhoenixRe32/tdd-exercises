package com.pittacode;

public class GreeterGenerator {

    private final NameInputProcessor nameInputProcessor;

    public GreeterGenerator(NameInputProcessor nameInputProcessor) {
        this.nameInputProcessor = nameInputProcessor;
    }

    public String buildGreeting(String[] names) {
        String[] processedNames = nameInputProcessor.process(names);

        var nameDifferentiator = new NameDifferentiator(processedNames);

        var normalGreeter = new NormalGreeter(nameDifferentiator.getNormalNames());
        var shoutingGreeter = new ShoutingGreeter(nameDifferentiator.getShoutedNames());

        return new GreeterJoiner(normalGreeter, shoutingGreeter).joinGreetings();
    }


    public String buildGreeting(String name) {
        if (isEmpty(name)) {
            return new GenericGreeter().buildGreeting();
        }

        return buildGreeting(new String[]{name});
    }

    private boolean isEmpty(String name) {
        return name == null || name.isEmpty();
    }
}
