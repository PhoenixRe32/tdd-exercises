package com.pittacode;

import java.util.Arrays;

import static java.lang.String.format;

public class Greeter {

    public String buildGreeting(String[] names) {
        String[] splitNames = splitAnyCommaSeparatedEntriesToSingleNames(names);

        var nameDifferentiator = new NameDifferentiator(splitNames);

        var shoutedNames = nameDifferentiator.getNormalNames();
        var normalNames = nameDifferentiator.getShoutedNames();

        var normalGreeter = new NormalGreeter(normalNames);
        var shoutingGreeter = new ShoutingGreeter(shoutedNames);

        return new GreeterJoiner(normalGreeter, shoutingGreeter).joinGreetings();
    }

    private String[] splitAnyCommaSeparatedEntriesToSingleNames(String[] names) {
        return Arrays.stream(names)
                     .map(this::splitNames)
                     .flatMap(name -> Arrays.stream(name.clone()).map(String::trim))
                     .toArray(String[]::new);
    }

    private String[] splitNames(String name) {
        return isNameSurrounedWithQuotes(name)
                ? new String[]{removeQuotes(name)}
                : name.split(",");
    }

    private boolean isNameSurrounedWithQuotes(String name) {
        return name.startsWith("\"") && name.endsWith("\"");
    }

    private String removeQuotes(String name) {
        return name.substring(1, name.length() - 1);
    }

    public String buildGreeting(String name) {
        if (isEmpty(name)) {
            return new GenericGreeter().buildGreeting();
        }

        return NameUtils.isShoutedName(name)
                ? new ShoutingGreeter(name).buildGreeting()
                : new NormalGreeter(name).buildGreeting();
    }

    private boolean isEmpty(String name) {
        return name == null || name.isEmpty();
    }


}
