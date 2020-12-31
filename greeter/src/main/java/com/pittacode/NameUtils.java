package com.pittacode;

import java.util.Arrays;

public final class NameUtils {

    public static boolean isEmptyName(String name) {
        return name == null || name.isEmpty();
    }

    public static boolean isShoutedName(String name) {
        return name.codePoints()
                   .mapToObj(i -> (char) i)
                   .allMatch(ch -> !Character.isLetter(ch) || Character.isUpperCase(ch));
    }

    public static String[] splitAnyCommaSeparatedEntriesToSingleNames(String[] names) {
        return Arrays.stream(names)
                     .map(NameUtils::splitNames)
                     .map(NameUtils::trimNames)
                     .flatMap(arr -> Arrays.stream(arr.clone()))
                     .toArray(String[]::new);
    }

    private static String[] trimNames(String[] names) {
        return Arrays.stream(names)
                     .map(String::trim)
                     .toArray(String[]::new);
    }

    private static String[] splitNames(String name) {
        return isNameSurrounedWithQuotes(name)
                ? new String[]{removeQuotes(name)}
                : name.split(",");
    }

    private static boolean isNameSurrounedWithQuotes(String name) {
        return name.startsWith("\"") && name.endsWith("\"");
    }

    private static String removeQuotes(String name) {
        return name.substring(1, name.length() - 1);
    }

    private NameUtils(){}
}
