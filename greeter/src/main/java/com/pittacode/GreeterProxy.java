package com.pittacode;

import static com.pittacode.NameUtils.isEmptyName;
import static com.pittacode.NameUtils.isShoutedName;
import static com.pittacode.NameUtils.splitAnyCommaSeparatedEntriesToSingleNames;

public class GreeterProxy {

    public String buildGreeting(String[] names) {
        String[] splitNames = splitAnyCommaSeparatedEntriesToSingleNames(names);

        var greeterFactory = new GreeterFactory(splitNames);

        var normalGreeter = greeterFactory.getNormalGreeter();
        var shoutingGreeter = greeterFactory.getShoutingGreeter();

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
