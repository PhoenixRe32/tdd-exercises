package com.pittacode.array.comparators;

import java.util.Arrays;

public class UniqueElementArrayIntersection {

    public int calculate(int[] arr1, int[] arr2) {
        if (isAtLeastOneEmpty(arr1, arr2)) {
            return 0;
        }

        sortArrays(arr1, arr2);
        return countCommonElementsInSortedArrays(arr1, arr2);
    }

    private boolean isAtLeastOneEmpty(int[] arr1, int[] arr2) {
        return arr1.length == 0 || arr2.length == 0;
    }

    private void sortArrays(int[] shorterArray, int[] longerArray) {
        Arrays.sort(shorterArray);
        Arrays.sort(longerArray);
    }

    private int countCommonElementsInSortedArrays(int[] arr1, int[] arr2) {
        var count = 0;

        int iter1 = 0;
        int arr1Length = arr1.length;
        int iter2 = 0;
        int arr2Length = arr2.length;

        while (iter1 < arr1Length && iter2 < arr2Length) {
            if (arr1[iter1] == arr2[iter2]) {
                count++;
                iter1++;
                iter2++;
            } else if (arr1[iter1] < arr2[iter2]) {
                iter1++;
            } else {
                iter2++;
            }
        }

        return count;
    }
}
