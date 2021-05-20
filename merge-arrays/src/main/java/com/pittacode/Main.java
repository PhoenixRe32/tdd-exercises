package com.pittacode;

import static com.pittacode.ArrayOperations.*;

public class Main {

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7, 9, 11, 13, 15};
        int[] arr2 = {-1, 0, 1, 2, 3, 4, 5, 6, 21, 23};

        System.out.println(merge(arr1, arr2));
    }
}
