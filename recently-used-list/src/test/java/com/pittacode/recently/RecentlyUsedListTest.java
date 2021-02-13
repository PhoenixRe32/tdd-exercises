package com.pittacode.recently;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class RecentlyUsedListTest {

    private RecentlyUsedList underTest;

    @BeforeEach
    void setUp() {
        underTest = new RecentlyUsedList();
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

    @Test
    void shouldResizeArray_whenStoringMoreThan5Elements() {
        IntStream.range(0, 6)
                 .forEach(i -> underTest.add("element-" + i));

        assertThat(underTest.size()).isEqualTo(6);
        assertThat(underTest.get(0)).isEqualTo("element-5");
    }

    @Test
    void shouldResizeArrayAgain_whenStoringMoreThan10Elements() {
        IntStream.range(0, 11)
                 .forEach(i -> underTest.add("element-" + i));

        assertThat(underTest.size()).isEqualTo(11);
        assertThat(underTest.get(0)).isEqualTo("element-10");
    }
}
