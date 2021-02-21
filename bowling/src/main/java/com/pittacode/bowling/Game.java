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
        roll += isStrike(roll) ? 2 : 1;
    }

    private boolean isStrike(int roll) {
        return rolls[roll] == MAX_PINS && isFirstRollOfAFrame(roll);
    }

    private boolean isFirstRollOfAFrame(int roll) {
        return roll % 2 == 0;
    }

    public int score() {
        var totalScore = 0;
        for (int frame = 0; frame < FRAMES; frame++) {
            var frameFirstRoll = frame << 1;
            var frameScore = rolls[frameFirstRoll] + rolls[frameFirstRoll + 1];

            if (frameScore < MAX_PINS) {
                totalScore += frameScore;
            } else if (rolls[frameFirstRoll] != MAX_PINS) {
                var spareBonus = rolls[frameFirstRoll + 2];
                totalScore += frameScore + spareBonus;
            } else if (rolls[frameFirstRoll] == MAX_PINS) {
                var strikeBonus = rolls[frameFirstRoll + 2] + rolls[frameFirstRoll + 3];
                totalScore += frameScore + strikeBonus;
            }
        }
        return totalScore;
    }
}
