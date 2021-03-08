package com.pittacode.romannumerals;

import java.util.Arrays;
import java.util.Collection;

import static java.util.function.Predicate.not;
import static java.util.stream.Collectors.toList;

public enum RomanSymbol {

    // NOTE: I actually depend on the order of this to do some stuff... Not optimum but too late to change
    I(1, true),
    V(5, false),
    X(10, true),
    L(50, false),
    C(100, true),
    D(500, false),
    M(1000, true);

    private final int value;
    private final boolean isSubtractable;

    RomanSymbol(int value, boolean isSubtractable) {
        this.value = value;
        this.isSubtractable = isSubtractable;
    }

    public int getValue() {
        return value;
    }

    public boolean isSubtractable() {
        return isSubtractable;
    }

    public static RomanSymbol from(Character c) {
        return Arrays.stream(values())
                     .filter(symbol -> symbol.name().equalsIgnoreCase(c.toString()))
                     .findFirst()
                     .orElseThrow(() -> new IllegalArgumentException(c + " is not a roman numeral symbol."));
    }

    public static Collection<RomanSymbol> getNonSubtractable() {
        return Arrays.stream(values())
                     .filter(not(RomanSymbol::isSubtractable))
                     .collect(toList());
    }
}
