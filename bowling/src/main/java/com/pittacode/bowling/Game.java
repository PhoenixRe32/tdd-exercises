package com.pittacode.bowling;

import java.util.Arrays;

public class Game {

    private final int[] rolls;
    private int roll;

    public Game() {
        rolls = new int[21];
        roll = 0;
    }

    public void roll(int pins) {
        rolls[roll] = pins;
        roll++;
    }

    public int score() {
        return Arrays.stream(rolls).sum();
    }
}
