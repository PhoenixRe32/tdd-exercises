package com.pittacode.recently;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class RecentlyUsedListImplTest {

    private RecentlyUsedList underTest;

    @BeforeEach
    void setUp() {
        underTest = new RecentlyUsedListImpl();
    }

    @Test
    void initialSizeIs0() {
        assertThat(underTest.size()).isEqualTo(0);
    }

    @Test
    void shouldHaveSizeOf1_afterAddingOneItem() {
        underTest.add("element-0");

        assertThat(underTest.size()).isEqualTo(1);
    }

    @Test
    void shouldHaveSizeOf2_afterAddingTwoItems() {
        underTest.add("element-0");
        underTest.add("element-1");

        assertThat(underTest.size()).isEqualTo(2);
    }

    @Test
    void shouldStoreElementsInLIFO() {
        underTest.add("element-0");
        underTest.add("element-1");

        assertThat(underTest.get(0)).isEqualTo("element-1");
        assertThat(underTest.get(1)).isEqualTo("element-0");
    }

    @Test // implementation detail -> array starts with 5 spaces
    void shouldResizeArray_whenStoringMoreThan5Elements() {
        IntStream.range(0, 6)
                 .forEach(i -> underTest.add("element-" + i));

        assertThat(underTest.size()).isEqualTo(6);
        assertThat(underTest.get(0)).isEqualTo("element-5");
    }

    @Test // implementation detail -> in every resize, 5 spaces are added
    void shouldResizeArrayAgain_whenStoringMoreThan10Elements() {
        IntStream.range(0, 11)
                 .forEach(i -> underTest.add("element-" + i));

        assertThat(underTest.size()).isEqualTo(11);
        assertThat(underTest.get(0)).isEqualTo("element-10");
    }

    @Test
    void shouldMoveDuplicatedEntryToTop() {
        underTest.add("element-0");
        underTest.add("element-1");
        underTest.add("element-0");

        assertThat(underTest.size()).isEqualTo(2);
        assertThat(underTest.get(0)).isEqualTo("element-0");
    }

    @Test
    void shouldStoreElementsInLIFOAndWithoutDuplicates() {
        underTest.add("element-0");
        underTest.add("element-1");
        underTest.add("element-2");
        underTest.add("element-3");
        underTest.add("element-0");
        underTest.add("element-4");
        underTest.add("element-5");
        underTest.add("element-6");
        underTest.add("element-1");
        underTest.add("element-3");

        assertThat(underTest.size()).isEqualTo(7);
        assertThat(underTest.get(0)).isEqualTo("element-3");
        assertThat(underTest.get(1)).isEqualTo("element-1");
        assertThat(underTest.get(2)).isEqualTo("element-6");
        assertThat(underTest.get(3)).isEqualTo("element-5");
        assertThat(underTest.get(4)).isEqualTo("element-4");
        assertThat(underTest.get(5)).isEqualTo("element-0");
        assertThat(underTest.get(6)).isEqualTo("element-2");
    }

    @ParameterizedTest
    @NullAndEmptySource
    void shouldNotInsertEmptyOrNullStrings(String element) {
        underTest.add(element);

        assertThat(underTest.size()).isEqualTo(0);
    }
}
