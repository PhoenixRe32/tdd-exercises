package com.pittacode;

public class GreeterGenerator {

    private final NameInputProcessor nameInputProcessor;

    public GreeterGenerator(NameInputProcessor nameInputProcessor) {
        this.nameInputProcessor = nameInputProcessor;
    }

    public String buildGreeting(String[] names) {
        String[] processedNames = nameInputProcessor.process(names);

        var greeterFactory = new GreeterFactory(processedNames);

        var normalGreeter = greeterFactory.getNormalGreeter();
        var shoutingGreeter = greeterFactory.getShoutingGreeter();

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
