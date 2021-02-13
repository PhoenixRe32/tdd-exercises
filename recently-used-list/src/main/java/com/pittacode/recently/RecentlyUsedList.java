package com.pittacode.recently;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class RecentlyUsedList {

    private static final int DEFAULT_SIZE = 5;

    private String[] elements = new String[DEFAULT_SIZE];
    private int size;

    public int size() {
        return size;
    }

    public void add(String element) {
        remove(element);
        resizeArray();
        elements[size] = element;
        size++;
    }

    private void remove(String element) {
        var elementIndex = findIndexOf(element);
        if (elementIndex.isPresent()) {
            var duplicateEntryIndex = elementIndex.getAsInt();
            remove(duplicateEntryIndex);
        }
    }

    private OptionalInt findIndexOf(String element) {
        return IntStream.range(0, size)
                        .filter(i -> isElementAtIndexADuplicate(i, element))
                        .findFirst();
    }

    private boolean isElementAtIndexADuplicate(int index, String element) {
        return element.equals(elements[index]);
    }

    private void remove(int duplicateEntryIndex) {
        var newArray = new String[elements.length];
        System.arraycopy(elements, 0,
                         newArray, 0,
                         duplicateEntryIndex);
        System.arraycopy(elements, duplicateEntryIndex + 1,
                         newArray, duplicateEntryIndex,
                         size - (duplicateEntryIndex + 1));
        elements = newArray;
        size -= 1;
    }

    private void resizeArray() {
        if (isArrayFull()) {
            elements = Arrays.copyOf(elements, size + DEFAULT_SIZE);
        }
    }

    private boolean isArrayFull() {
        return size == elements.length;
    }

    public String get(int index) {
        return elements[size - 1 - index];
    }
}
