package com.pittacode;

import static com.pittacode.NameUtils.isEmptyName;
import static com.pittacode.NameUtils.isShoutedName;
import static com.pittacode.NameUtils.splitAnyCommaSeparatedEntriesToSingleNames;

public class GreeterProxy {

    public String buildGreeting(String[] names) {
        String[] splitNames = splitAnyCommaSeparatedEntriesToSingleNames(names);

        var nameDifferentiator = new NameDifferentiator(splitNames);

        var shoutedNames = nameDifferentiator.getNormalNames();
        var normalNames = nameDifferentiator.getShoutedNames();

        var normalGreeter = new NormalGreeter(normalNames);
        var shoutingGreeter = new ShoutingGreeter(shoutedNames);

        return new GreeterJoiner(normalGreeter, shoutingGreeter).joinGreetings();
    }


    public String buildGreeting(String name) {
        if (isEmptyName(name)) {
            return new GenericGreeter().buildGreeting();
        }

        return isShoutedName(name)
                ? new ShoutingGreeter(name).buildGreeting()
                : new NormalGreeter(name).buildGreeting();
    }
}
