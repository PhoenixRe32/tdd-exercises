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
        var frame = 0;
        var roll = 0;
        while (frame < FRAMES) {
            if (rolls[roll] == MAX_PINS) { // strike
                totalScore += rolls[roll] + rolls[roll + 1] + rolls[roll + 2];
                roll += 1;
            } else if (rolls[roll] + rolls[roll + 1] == MAX_PINS) { // spare
                totalScore += rolls[roll] + rolls[roll + 1] + rolls[roll + 2];
                roll += 2;
            } else { // normal
                totalScore += rolls[roll] + rolls[roll + 1];
                roll += 2;
            }
            frame++;
        }
        return totalScore;
    }
}
