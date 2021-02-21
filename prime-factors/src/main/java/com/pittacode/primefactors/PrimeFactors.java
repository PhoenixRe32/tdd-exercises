package com.pittacode.primefactors;

import java.util.LinkedList;
import java.util.List;

public class PrimeFactors {

    private final int number;

    public PrimeFactors(int number) {
        this.number = number;
    }

    public List<Integer> calculate() {
        if (number < 2)
            return List.of();

        var result = new LinkedList<Integer>();
        var intermediateNumber = number;
        do {
            if (intermediateNumber % 2 == 0) {
                intermediateNumber /= 2;
                result.add(2);
            } else if (intermediateNumber % 3 == 0) {
                intermediateNumber /= 3;
                result.add(3);
            } else if (intermediateNumber % 5 == 0) {
                intermediateNumber /= 5;
                result.add(5);
            } else if (intermediateNumber % 7 == 0) {
                intermediateNumber /= 7;
                result.add(7);
            } else {
                var message = number + " couldn't be calculated.\n"
                        + "Factors calculated: " + result + "\n"
                        + "Remainder: " + intermediateNumber;
                throw new UnsupportedOperationException(message);
            }
        } while (intermediateNumber != 1);

        return result;
    }
}
