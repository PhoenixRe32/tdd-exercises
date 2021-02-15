package com.pittacode.greeter;

public class GreeterGenerator {

    private static final Greeter NO_NAME_GREETER = () -> "Hello, my friend.";

    private final NameProcessor nameProcessor;
    private final NameFilter nameFilter;

    public GreeterGenerator(NameProcessor nameProcessor, NameFilter nameFilter) {
        this.nameProcessor = nameProcessor;
        this.nameFilter = nameFilter;
    }

    public String buildGreeting(String name) {
        return isEmpty(name)
                ? NO_NAME_GREETER.buildGreeting()
                : buildGreeting(new String[]{name});

    }

    private boolean isEmpty(String name) {
        return name == null || name.isEmpty();
    }

    public String buildGreeting(String[] names) {
        String[] processedNames = nameProcessor.splitAnyCommaSeparatedEntriesToSingleNames(names);

        var filteredNames = nameFilter.filterNames(processedNames);

        var normalGreeter = new NormalGreeter(filteredNames.normalNames);
        var shoutingGreeter = new ShoutingGreeter(filteredNames.shoutedNames);

        return new GreeterJoiner(normalGreeter, shoutingGreeter).joinGreetings();
    }
}
