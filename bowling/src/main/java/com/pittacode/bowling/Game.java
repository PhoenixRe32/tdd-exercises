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
        var roll = 0;
        for (int frame = 0; frame < FRAMES; frame++) {
            if (isStrike(roll)) {
                totalScore += MAX_PINS + strikeBonus(roll);
                roll += 1;
            } else if (isSpare(roll)) {
                totalScore += MAX_PINS + spareBonus(roll);
                roll += 2;
            } else {
                totalScore += frameScore(roll);
                roll += 2;
            }
        }
        return totalScore;
    }

    private boolean isStrike(int roll) {
        return rolls[roll] == MAX_PINS;
    }

    private int strikeBonus(int roll) {
        return rolls[roll + 1] + rolls[roll + 2];
    }

    private boolean isSpare(int roll) {
        return rolls[roll] + rolls[roll + 1] == MAX_PINS;
    }

    private int spareBonus(int roll) {
        return rolls[roll + 2];
    }

    private int frameScore(int roll) {
        return rolls[roll] + rolls[roll + 1];
    }
}
