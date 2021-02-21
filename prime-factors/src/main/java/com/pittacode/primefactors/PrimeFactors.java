package com.pittacode.primefactors;

import java.util.List;

public class PrimeFactors {

    private final int number;

    public PrimeFactors(int number) {
        this.number = number;
    }

    public List<Integer> calculate() {
        if (number < 2)
            return List.of();
        return List.of();
    }
}
