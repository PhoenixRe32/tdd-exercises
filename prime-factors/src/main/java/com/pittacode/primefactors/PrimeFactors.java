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

        return calculate(number);
    }

    private List<Integer> calculate(int number) {
        var result = new LinkedList<Integer>();
        do {
            var primeDivider = findSmallestPrimeDivider(number);
            number /= primeDivider;
            result.add(primeDivider);
        } while (number != 1);

        return result;
    }

    private int findSmallestPrimeDivider(int intermediateNumber) {
        for (int prime : primes) {
            if (intermediateNumber % prime == 0) {
                return prime;
            }
        }
        throw new UnsupportedOperationException(
                "Class doesn't support further factoring " + intermediateNumber + "\n"
                        + "Only knows the following primes: " + primes);
    }
}
