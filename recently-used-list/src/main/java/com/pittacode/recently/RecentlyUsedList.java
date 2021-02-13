package com.pittacode.recently;

import java.util.Arrays;

public class RecentlyUsedList {

    private static final int DEFAULT_SIZE = 5;

    private String[] elements = new String[DEFAULT_SIZE];
    private int size;

    public int size() {
        return size;
    }

    public void add(String element) {
        if (isArrayFull()) {
            elements = Arrays.copyOf(elements, size + DEFAULT_SIZE);
        }
        elements[size] = element;
        size++;
    }

    private boolean isArrayFull() {
        return size == elements.length;
    }

    public String get(int index) {
        return elements[size-1-index];
    }
}
