package com.pittacode.recently;

public class RecentlyUsedList {

    private static final int DEFAULT_SIZE = 5;

    private String[] elements = new String[DEFAULT_SIZE];
    private int size;

    public int size() {
        return size;
    }

    public void add(String element) {
        elements[size] = element;
        size++;
    }

    public String get(int index) {
        return elements[size-1-index];
    }
}
