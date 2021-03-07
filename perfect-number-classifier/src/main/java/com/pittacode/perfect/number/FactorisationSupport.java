package com.pittacode.perfect.number;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.LongStream;

import static java.lang.Math.ceil;
import static java.lang.Math.sqrt;
import static java.util.stream.Collectors.toUnmodifiableSet;

public final class FactorisationSupport {

    public static Set<Long> calculateFactors(long number) {
        return LongStream.rangeClosed(1, roundUpsquareRoot(number))
                         .filter(l -> isFactor(number, l))
                         .mapToObj(l -> getTheFactorPair(number, l))
                         .flatMap(Collection::stream)
                         .collect(toUnmodifiableSet());
    }

    private static long roundUpsquareRoot(long number) {
        return Double.valueOf(ceil(sqrt(number))).longValue();
    }

    private static boolean isFactor(long number, long i) {
        return number % i == 0;
    }

    private static Set<Long> getTheFactorPair(long number, long l) {
        var factorPair = new HashSet<Long>(2);
        factorPair.add(l);
        factorPair.add(number / l);
        return factorPair;
    }

    private FactorisationSupport() {
    }
}