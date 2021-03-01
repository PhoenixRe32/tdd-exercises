package com.pittacode.primefactors;

import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.StringJoiner;
import java.util.function.Function;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;

public class PrimeFactorDecompositionPrinter {

    private final PrimeFactors primeFactors;

    public PrimeFactorDecompositionPrinter(PrimeFactors primeFactors) {
        this.primeFactors = primeFactors;
    }

    public String print(int number) {
        return primeFactors.calculateFor(number)
                           .stream()
                           .collect(groupingBy(identity(), LinkedHashMap::new, counting()))
                           .entrySet()
                           .stream()
                           .map(this::toString)
                           .collect(joining());
    }

    private String toString(Entry<Integer, Long> entry) {
        return new StringJoiner("", "(", ")")
                .add(entry.getKey().toString())
                .add(entry.getValue() == 1L ? "" : "**" + entry.getValue())
                .toString();
//        return format("(%d%s)",
//                      entry.getKey(),
//                      entry.getValue() == 1L ? "" : "**" + entry.getValue());
    }
}
