package com.pittacode;

public class Runner {
    public static void main(String[] args) {
        var fizzBuzzTranslator = new FizzBuzzTranslator();
        var application = new Application(fizzBuzzTranslator);

        application.run();
    }
}
