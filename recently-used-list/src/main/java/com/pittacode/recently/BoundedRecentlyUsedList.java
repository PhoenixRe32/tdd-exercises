package com.pittacode.recently;

import java.util.Arrays;

final class BoundedRecentlyUsedList extends RecentlyUsedListImpl {

    BoundedRecentlyUsedList(int size) {
        super(size);
    }

    @Override
    protected void resize() {
        elements = Arrays.copyOfRange(elements, 1, elements.length + 1);
        size -= 1;
    }
}
