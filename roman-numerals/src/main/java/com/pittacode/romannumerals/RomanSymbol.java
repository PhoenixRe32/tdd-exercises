package com.pittacode.romannumerals;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import static java.util.function.Predicate.not;
import static java.util.stream.Collectors.toList;

public enum RomanSymbol {

    // NOTE: I actually depend on the order of this to do some stuff... Not optimum but too late to change
    I(1, true, 1),
    V(5, false, 2),
    X(10, true, 3),
    L(50, false, 4),
    C(100, true, 5),
    D(500, false, 6),
    M(1000, true, 7);

    public static RomanSymbol from(Character c) {
        return Arrays.stream(values())
                     .filter(symbol -> symbol.name().equalsIgnoreCase(c.toString()))
                     .findFirst()
                     .orElseThrow(() -> new IllegalArgumentException(c + " is not a roman numeral symbol."));
    }

    public static Optional<RomanSymbol> fromOrdinal(int i) {
        return Arrays.stream(values())
                     .filter(symbol -> symbol.ordinal == i)
                     .findFirst();
    }

    public static Collection<RomanSymbol> getNonSubtractableSymbols() {
        return Arrays.stream(values())
                     .filter(not(RomanSymbol::isSubtractable))
                     .collect(toList());
    }

    private final int value;
    private final boolean isSubtractable;
    private final int ordinal;

    RomanSymbol(int value, boolean isSubtractable, int ordinal) {
        this.value = value;
        this.isSubtractable = isSubtractable;
        this.ordinal = ordinal;
    }

    public int getValue() {
        return value;
    }

    public boolean isSubtractable() {
        return isSubtractable;
    }

    public RomanSymbol getNextMagnitude() {
        return fromOrdinal(this.ordinal + 2)
                .orElseThrow(() -> new NumberFormatException("Can't go higher than " + this));
    }

    public RomanSymbol getHalfwayMagnitude() {
        return fromOrdinal(this.ordinal + 1)
                .orElseThrow(() -> new NumberFormatException("Can't go higher than " + this));
    }
}
