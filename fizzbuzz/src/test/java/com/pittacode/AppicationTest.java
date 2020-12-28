package com.pittacode;

import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class AppicationTest {

    @Test
    void callFizzBuzzTranslator() {
        var fizzBuzzTranslator = mock(FizzBuzzTranslator.class);
        var underTest = new Application(fizzBuzzTranslator);

        underTest.run();

        verify(fizzBuzzTranslator).translate(any());
    }
}
