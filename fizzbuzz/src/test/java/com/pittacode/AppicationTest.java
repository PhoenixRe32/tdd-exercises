package com.pittacode;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class AppicationTest {

    @Test
    void callFizzBuzzTranslator100times() {
        var fizzBuzzTranslator = mock(FizzBuzzTranslator.class);
        var underTest = new Application(fizzBuzzTranslator);

        underTest.run();

        verify(fizzBuzzTranslator, times(100))
                .translate(anyInt());
    }
}
