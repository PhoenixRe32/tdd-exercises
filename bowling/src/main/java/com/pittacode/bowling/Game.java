package com.pittacode.bowling;

public class Game {

    private static final int MAX_PINS = 10;
    private static final int FRAMES = 10;
    private static final int ROLLS_PER_FRAME = 2;

    private final int[] rolls;
    private int roll;

    public Game() {
        rolls = new int[FRAMES * ROLLS_PER_FRAME + 1];
        roll = 0;
    }

    public void roll(int pins) {
        rolls[roll] = pins;
        roll++;
    }

    public int score() {
        var totalScore = 0;
        for (int frame = 0; frame < FRAMES; frame++) {
            var frameFirstRoll = frame << 1;
            var frameScore = rolls[frameFirstRoll] + rolls[frameFirstRoll + 1];

            totalScore += frameScore == MAX_PINS
                    ? frameScore + rolls[frame + 2]
                    : frameScore;
        }
        return totalScore;
    }
}
