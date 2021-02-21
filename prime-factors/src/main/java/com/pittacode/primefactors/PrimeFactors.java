package com.pittacode.primefactors;

import java.util.LinkedList;
import java.util.List;

public class PrimeFactors {


    private final List<Integer> primes;
    private final int number;

    public PrimeFactors(int number) {
        this.number = number;
        primes = new LinkedList<>(List.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31));
    }

    public List<Integer> calculate() {
        if (number < 2)
            return List.of();

        var result = new LinkedList<Integer>();
        var intermediateNumber = number;
        do {
            var primeDivider = findSmallestPrimeDivider(intermediateNumber);
            intermediateNumber /= primeDivider;
            result.add(primeDivider);
        } while (intermediateNumber != 1);

        return result;
    }

    private int findSmallestPrimeDivider(int intermediateNumber) {
        for (int prime : primes) {
            if (intermediateNumber % prime == 0) {
                return prime;
            }
        }
        throw new RuntimeException("Could not find prime that perfectly divides " + intermediateNumber);
    }
}
