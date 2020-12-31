package com.pittacode;

public class GreeterFactory {

    private final String[] names;
    private final NameDifferentiator nameDifferentiator;

    public GreeterFactory(String[] names) {
        this.names = names;
        nameDifferentiator = new NameDifferentiator(names);
    }

    public Greeter getNormalGreeter() {
        var normalNames = nameDifferentiator.getNormalNames();
        return new NormalGreeter(normalNames);
    }

    public Greeter getShoutingGreeter() {
        var shoutedNames = nameDifferentiator.getShoutedNames();
        return new ShoutingGreeter(shoutedNames);
    }
}
