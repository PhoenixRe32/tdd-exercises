package com.pittacode.application;

import com.pittacode.recently.RecentlyUsedList;

import java.security.SecureRandom;

public class App {
    public static void main(String[] args) {
        var recentlyUsedList = RecentlyUsedList.aRecentlyUsedList();
        var boundedRecentlyUsedList = RecentlyUsedList.aBoundedRecentlyUsedList(9);
        var random = new SecureRandom();

        for (int i = 0; i < 999; i++) {
            var s = String.valueOf(random.nextInt(20));
            boundedRecentlyUsedList.add(s);
            recentlyUsedList.add(s);
        }
        System.out.println(boundedRecentlyUsedList);
    }
}
