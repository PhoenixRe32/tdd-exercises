package com.pittacode.array.comparators;

public class UniqueElementArrayIntersection {

    public int calculate(int[] arr1, int[] arr2) {
        if (isAtLeastOneEmpty(arr1, arr2)) {
            return 0;
        }

        return countCommonElements(arr1, arr2);
    }

    private int countCommonElements(int[] arr1, int[] arr2) {
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

    private boolean isAtLeastOneEmpty(int[] arr1, int[] arr2) {
        return arr1.length == 0 || arr2.length == 0;
    }
}
