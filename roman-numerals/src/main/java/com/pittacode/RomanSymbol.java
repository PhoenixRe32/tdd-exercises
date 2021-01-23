package com.pittacode;

import java.util.Arrays;

public enum RomanSymbol {
    I(1),
    V(5),
    X(10),
    L(50),
    C(100),
    D(500),
    M(1000);

    private final int value;

    RomanSymbol(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static RomanSymbol from(Character c) {
        return Arrays.stream(values())
                     .filter(symbol -> symbol.name().equalsIgnoreCase(c.toString()))
                     .findFirst()
                     .orElseThrow(() -> new IllegalArgumentException(c + " is not a roman numeral symbol."));
    }
}
