package com.pittacode.magnet.particulars;

import java.util.stream.IntStream;

import static java.lang.StrictMath.pow;

public class Magents {

    public double doubles(int maxK, int maxN) {
        return forceExertedByBox(maxK, maxN);
    }

    private double forceExertedByBox(int maxK, int maxN) {
        return IntStream.rangeClosed(1, maxK)
                        .mapToDouble(k -> forceExertedByRow(k, maxN))
                        .sum();
    }

    private double forceExertedByRow(int k, int maxN) {
        return IntStream.rangeClosed(1, maxN)
                        .mapToDouble(n -> forceExertedByPoint(k, n))
                        .sum();
    }

    private double forceExertedByPoint(int k, int n) {
        return invertOf(k * pow(n + 1, 2 * k));
    }

    private double invertOf(double denominator) {
        return 1 / denominator;
    }
}
