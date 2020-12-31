package com.pittacode;

import static com.pittacode.NameUtils.isShoutedName;

public class GreeterProxy {

    public String buildGreeting(String[] names) {
        String[] processedNames = new NameInputProcessor().process(names);

        var greeterFactory = new GreeterFactory(processedNames);

        var normalGreeter = greeterFactory.getNormalGreeter();
        var shoutingGreeter = greeterFactory.getShoutingGreeter();

        return new GreeterJoiner(normalGreeter, shoutingGreeter).joinGreetings();
    }


    public String buildGreeting(String name) {
        if (isEmpty(name)) {
            return new GenericGreeter().buildGreeting();
        }

        return isShoutedName(name)
                ? new ShoutingGreeter(name).buildGreeting()
                : new NormalGreeter(name).buildGreeting();
    }

    private boolean isEmpty(String name) {
        return name == null || name.isEmpty();
    }
}
