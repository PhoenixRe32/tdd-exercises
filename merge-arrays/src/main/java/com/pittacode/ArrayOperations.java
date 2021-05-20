package com.pittacode;

public class ArrayOperations {

    public static int[] merge(int[] a1, int[] a2) {
        var result = new int[a1.length + a2.length];
        int i1 = 0;
        int i2 = 0;
        int resultIndex = 0;

        while (resultIndex < result.length) {
            if (isArrayConsumed(a1, i1)) {
                var copiedElements = copyRemainingArray(a2, i2, result, resultIndex);
                i2 = moveIndex(i2, copiedElements);
                resultIndex = moveIndex(resultIndex, copiedElements);
            } else if (isArrayConsumed(a2, i2)) {
                var copiedElements = copyRemainingArray(a1, i1, result, resultIndex);
                i1 = moveIndex(i1, copiedElements);
                resultIndex = moveIndex(resultIndex, copiedElements);
            } else if (a1[i1] < a2[i2]) {
                result[resultIndex] = a1[i1];
                i1 = moveIndex(i1, 1);
                resultIndex = moveIndex(resultIndex, 1);
            } else {
                result[resultIndex] = a2[i2];
                i2 = moveIndex(i2, 1);
                resultIndex = moveIndex(resultIndex, 1);
            }
        }

        return result;
    }

    private static boolean isArrayConsumed(int[] a, int i) {
        return i == a.length;
    }

    private static int copyRemainingArray(int[] source, int sourceIndex, int[] target, int targetIndex) {
        var copiedElements = 0;
        while (sourceIndex < source.length) {
            target[targetIndex] = source[sourceIndex];
            targetIndex++;
            sourceIndex++;
            copiedElements++;
        }
        return copiedElements;
    }

    private static int moveIndex(int i, int copiedElements) {
        i += copiedElements;
        return i;
    }
}
