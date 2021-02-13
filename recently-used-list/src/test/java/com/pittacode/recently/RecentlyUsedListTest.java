package com.pittacode.recently;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        var underTest = new RecentlyUsedList();

        underTest.add("element-0");
        underTest.add("element-1");

        assertThat(underTest.size()).isEqualTo(2);
    }

    @Test
    void shouldStoreElementsInLIFO() {
        var underTest = new RecentlyUsedList();

        underTest.add("element-0");
        underTest.add("element-1");

        assertThat(underTest.get(0)).isEqualTo("element-1");
        assertThat(underTest.get(1)).isEqualTo("element-0");
    }
}
