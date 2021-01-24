package com.pittacode;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RomanNumeralTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "DD", "CDD", "MDD",
            "LL", "XLL", "CLL", "DLL",
            "VV", "IVV", "XVV", "CVV", "DVV"
    })
    void whenParsingRomanNumeral_WithConsequitiveNonSubtractableSymbols_throwsException(String input) {
        assertThatThrownBy(() -> new RomanNumeral(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "DM",
            "LC", "LD", "LM",
            "VX", "VL", "VC", "VD", "VM"
    })
    void whenParsingRomanNumeral_NonSubtractableSymbolsFollowedByBiggerRomanSymbols_throwsException(String input) {
        assertThatThrownBy(() -> new RomanNumeral(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"IL", "IC", "ID", "IM", "XD", "XM"})
    void whenParsingRomanNumeral_SymbolsFollowedBySymbolsInDifferentMagnitude_throwsException(String input) {
        assertThatThrownBy(() -> new RomanNumeral(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Disabled
    @ParameterizedTest
    @ValueSource(strings = {"IIV", "IIX", "IXL", "IXC", "XXC", "XCD", "CCM",})
    void whenPassingInvalidRomanNumeral_throwException(String input) {
        assertThatThrownBy(() -> new RomanNumeral(input)).isInstanceOf(IllegalArgumentException.class);
    }
}