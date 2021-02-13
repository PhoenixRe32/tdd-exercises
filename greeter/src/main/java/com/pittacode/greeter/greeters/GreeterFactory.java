package com.pittacode.greeter.greeters;

public final class GreeterFactory {

    public static Greeter aGenericGreeter() {
        return new GenericGreeter();
    }

    public static Greeter aNormalGreeter(String[] names) {
        return new NormalGreeter(names);
    }

    public static Greeter aShoutingGreeter(String[] names) {
        return new ShoutingGreeter(names);
    }

    private GreeterFactory() {
    }
}
