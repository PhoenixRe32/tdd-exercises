package com.pittacode.array.comparators;

public class Intersection {

    public int calculate(int[] arr1, int[] arr2) {
        var commonElements = 0;
        for (int i = 0, length1 = arr1.length; i < length1; i++) {
            for (int j = 0, length2 = arr2.length; j < length2; j++) {
                if (arr1[i] == arr2[j]) {
                    commonElements++;
                }
            }
        }
        return commonElements;
    }
}
