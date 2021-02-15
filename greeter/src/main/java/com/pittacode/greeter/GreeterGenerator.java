package com.pittacode.greeter;

public class GreeterGenerator {

    private static final String NO_NAME_GREETING = "Hello, my friend.";

    private final NameProcessor nameProcessor;
    private final NameFilter nameFilter;
    private final GreeterJoiner greeterJoiner;

    public GreeterGenerator(NameProcessor nameProcessor,
                            NameFilter nameFilter,
                            GreeterJoiner greeterJoiner) {
        this.nameProcessor = nameProcessor;
        this.nameFilter = nameFilter;
        this.greeterJoiner = greeterJoiner;
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
        String[] processedNames = nameProcessor.splitAnyCommaSeparatedEntriesToSingleNames(names);

        var filteredNames = nameFilter.filterNames(processedNames);

        return greeterJoiner.joinGreetings(filteredNames);
    }
}
