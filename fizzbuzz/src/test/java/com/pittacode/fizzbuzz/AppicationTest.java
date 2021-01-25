package com.pittacode.fizzbuzz;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class AppicationTest {

    @Test
    void whenRunning_callFizzBuzzTranslator100times() {
        var fizzBuzzTranslator = mock(FizzBuzzTranslator.class);
        var underTest = new Application(fizzBuzzTranslator);

        underTest.run();

        verify(fizzBuzzTranslator, times(100)).translate(anyInt());
    }


    @Test
    void whenRunning_callTranslatorWithSeriesOfInts() {
        var fizzBuzzTranslator = mock(FizzBuzzTranslator.class);
        var captor = ArgumentCaptor.forClass(Integer.class);
        var underTest = new Application(fizzBuzzTranslator);

        underTest.run();

        verify(fizzBuzzTranslator, times(100)).translate(captor.capture());
        var arguments = captor.getAllValues();
        var expected = IntStream.range(1, 101)
                                .boxed()
                                .toArray(Integer[]::new);
        assertThat(arguments).containsExactly(expected);
    }
}
