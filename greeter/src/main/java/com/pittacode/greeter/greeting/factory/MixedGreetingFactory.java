package com.pittacode.greeter.greeting.factory;

import com.pittacode.greeter.greeting.factory.NameFilter.Names;

class MixedGreetingFactory implements GreetingFactory {

    private final Greeter normalGreeter;
    private final Greeter shoutingGreeter;
    private final NameFilter nameFilter;

    MixedGreetingFactory(Greeter normalGreeter, Greeter shoutingGreeter, NameFilter nameFilter) {
        this.normalGreeter = normalGreeter;
        this.shoutingGreeter = shoutingGreeter;
        this.nameFilter = nameFilter;
    }

    @Override
    public String generateGreeting(String[] names) {
        var filteredNames = nameFilter.filterNames(names);

        var greeting = new StringBuilder(normalGreeter.buildGreeting(filteredNames.normalNames));
        if (areWeGreetingBothNormallAndShouting(filteredNames)) {
            greeting.append(" AND ");
        }
        greeting.append(shoutingGreeter.buildGreeting(filteredNames.shoutedNames));

        return greeting.toString();
    }

    private boolean areWeGreetingBothNormallAndShouting(Names names) {
        return names.normalNames.length != 0 && names.shoutedNames.length != 0;
    }
}
