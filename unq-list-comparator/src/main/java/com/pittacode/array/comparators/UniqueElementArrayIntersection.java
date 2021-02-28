package com.pittacode.array.comparators;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class UniqueElementArrayIntersection {

    public <T extends Comparable<T>> int calculate(T[] arr1, T[] arr2) {
        if (isAtLeastOneEmpty(arr1, arr2)) {
            return 0;
        }

        sortArrays(arr1, arr2);
        return countCommonElementsInSortedArrays(arr1, arr2);
    }

    private <T extends Comparable<T>> boolean isAtLeastOneEmpty(T[] arr1, T[] arr2) {
        return arr1.length == 0 || arr2.length == 0;
    }

    private <T extends Comparable<T>> void sortArrays(T[] shorterArray, T[] longerArray) {
        Arrays.sort(shorterArray);
        Arrays.sort(longerArray);
    }

    private <T extends Comparable<T>> int countCommonElementsInSortedArrays(T[] arr1, T[] arr2) {
        var count = 0;

        int iter1 = 0;
        int arr1Length = arr1.length;
        int iter2 = 0;
        int arr2Length = arr2.length;

        while (iter1 < arr1Length && iter2 < arr2Length) {
            if (Objects.equals(arr1[iter1], arr2[iter2])) {
                count++;
                iter1++;
                iter2++;
            } else if (Objects.compare(arr1[iter1], arr2[iter2], Comparator.naturalOrder()) < 0) {
                iter1++;
            } else {
                iter2++;
            }
        }

        return count;
    }
}
