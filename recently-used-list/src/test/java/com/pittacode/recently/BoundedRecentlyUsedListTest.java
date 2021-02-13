package com.pittacode.recently;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BoundedRecentlyUsedListTest {

    private RecentlyUsedList underTest;

    @Test
    void shouldBoundArray_whenConstructedWithSizeArgument() {
        underTest = new BoundedRecentlyUsedList(3);

        underTest.add("element-0");
        underTest.add("element-1");
        underTest.add("element-2");
        underTest.add("element-3");
        underTest.add("element-2");
        underTest.add("element-1");

        assertThat(underTest.size()).isEqualTo(3);
        assertThat(underTest.get(0)).isEqualTo("element-1");
        assertThat(underTest.get(1)).isEqualTo("element-2");
        assertThat(underTest.get(2)).isEqualTo("element-3");
    }
}