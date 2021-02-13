package com.pittacode.recently;

import java.util.Arrays;

public class BoundedRecentlyUsedList extends RecentlyUsedListImpl {

    public BoundedRecentlyUsedList(int boundedSize) {
        super(boundedSize);
    }

    @Override
    protected void resize() {
        elements = Arrays.copyOfRange(elements, 1, elements.length + 1);
        size -= 1;
    }
}
