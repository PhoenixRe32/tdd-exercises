package com.pittacode.array.comparators;

public class Intersection {
    public int calculate(int[] arr1, int[] arr2) {
        var commonElements = 0;
        for (int i = 0, length = arr1.length; i < length; i++) {
            if (arr1[i] == arr2[i]) {
                commonElements++;
            }
        }
        return commonElements;
    }
}
