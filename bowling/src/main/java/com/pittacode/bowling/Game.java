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
        for (int i = 0, rollsLength = rolls.length; i < rollsLength - 2; i += 2) {
            var frameScore = rolls[i] + rolls[i + 1];
            totalScore += frameScore == MAX_PINS
                    ? frameScore + rolls[i + 2]
                    : frameScore;

        }
        return totalScore;
    }
}
