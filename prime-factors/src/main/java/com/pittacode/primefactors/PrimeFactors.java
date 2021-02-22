package com.pittacode.primefactors;

import java.util.LinkedList;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

import static java.util.Comparator.naturalOrder;

public class PrimeFactors {

    private static final List<Integer> PRIMES = new LinkedList<>(List.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31));
    private final int number;

    public PrimeFactors(int number) {
        this.number = number;
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
        for (int prime : PRIMES) {
            if (intermediateNumber % prime == 0) {
                return prime;
            }
        }
        if (isIntermediateNumberAPrime(intermediateNumber)) {
            PRIMES.add(intermediateNumber);
            PRIMES.sort(naturalOrder());
            System.out.println("Added new prime: " + intermediateNumber);
            return intermediateNumber;
        }

        throw new UnsupportedOperationException(
                "Class doesn't support further factoring " + intermediateNumber + "\n"
                        + "Only knows the following primes: " + PRIMES);
    }

    private boolean isIntermediateNumberAPrime(int number) {
        return IntStream.range(2, number / 2)
                        .noneMatch(isDividerOf(number));
    }

    private IntPredicate isDividerOf(int number) {
        return i -> number / i == 0;
    }

}
