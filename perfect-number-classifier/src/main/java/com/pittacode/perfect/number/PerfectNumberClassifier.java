package com.pittacode.perfect.number;

import java.util.List;
import java.util.stream.LongStream;

import static com.pittacode.perfect.number.FactorisationSupport.*;

public class PerfectNumberClassifier {

    public boolean isPerfect(long number) {
        return getFactorsStream(number).sum() - number == 0;

    }

    private LongStream getFactorsStream(long number) {
        return (calculateFactors(number).stream().mapToLong(Long::longValue));
    }
}
