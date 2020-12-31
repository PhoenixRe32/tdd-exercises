package com.pittacode;

public final class NameUtils {

    public static boolean isShoutedName(String name) {
        return name.codePoints()
                   .mapToObj(i -> (char) i)
                   .allMatch(ch -> !Character.isLetter(ch) || Character.isUpperCase(ch));
    }

    private NameUtils(){}
}
