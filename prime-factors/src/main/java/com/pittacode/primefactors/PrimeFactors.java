package com.pittacode.primefactors;

import java.util.LinkedList;
import java.util.List;

public class PrimeFactors {

    public List<Integer> calculateFor(int number) {
        if (number < 2)
            return List.of();

        return calculateForValid(number);
    }

    private List<Integer> calculateForValid(int number) {
        var result = new LinkedList<Integer>();
        var intermediateDivisionResult = number;
        for (int primeDivider = 2; primeDivider <= number && intermediateDivisionResult != 1; primeDivider++) {
            while (isPerfectlyDivided(intermediateDivisionResult, primeDivider)) {
                intermediateDivisionResult /= primeDivider;
                result.add(primeDivider);
            }
        }
        return result;
    }


    private boolean isPerfectlyDivided(int number, int primeDivider) {
        return number % primeDivider == 0;
    }

}
