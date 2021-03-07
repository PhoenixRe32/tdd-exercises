package com.pittacode.perfect.number;

import java.util.stream.LongStream;

import static com.pittacode.perfect.number.FactorisationSupport.calculateFactors;

public class PerfectNumberClassifier {

    public boolean isPerfect(long number) {
        return getFactorsStream(number).sum() - number == number;

    }

    private LongStream getFactorsStream(long number) {
        return (calculateFactors(number).stream().mapToLong(Long::longValue));
    }
}
