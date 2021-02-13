package com.pittacode.recently;

public interface RecentlyUsedList {

    static RecentlyUsedList aRecentlyUsedList() {
        return new RecentlyUsedListImpl();
    }

    static RecentlyUsedList aRecentlyUsedList(int initialSize) {
        return new RecentlyUsedListImpl(initialSize);
    }

    static RecentlyUsedList aBoundedRecentlyUsedList(int size) {
        return new BoundedRecentlyUsedList(size);
    }

    int size();

    String get(int index);

    void add(String element);
}
