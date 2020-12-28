package com.pittacode;

import java.util.stream.IntStream;

public class Application {

    private static final int START_INCLUSIVE = 1;
    private static final int END_EXCLUSIVE = 101;

    private final FizzBuzzTranslator fizzBuzzTranslator;

    public Application(FizzBuzzTranslator fizzBuzzTranslator) {
        this.fizzBuzzTranslator = fizzBuzzTranslator;
    }

    public void run() {
        IntStream.range(START_INCLUSIVE, END_EXCLUSIVE)
                 .mapToObj(fizzBuzzTranslator::translate)
                 .forEach(System.out::println);
    }
}
