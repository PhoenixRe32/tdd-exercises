package com.pittacode.bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    public static final int FRAMES = 10;
    private Game underTest;

    @BeforeEach
    void setUp() {
        underTest = new Game();
    }

    @Test
    void shouldReturn0_whenRollAll0() {
        rollAll(0);

        assertThat(underTest.score()).isEqualTo(0);
    }

    @Test
    void shouldReturn20_whenRollAll1() {
        rollAll(1);

        assertThat(underTest.score()).isEqualTo(20);
    }

    @Test
    void shouldReturnCorrectScore_whenRollingASpare() {
        rollASpare();
        underTest.roll(3);
        underTest.roll(1);

        assertThat(underTest.score()).isEqualTo(17);
    }

    @Test
    void shouldReturnCorrectScore_whenRollingAStrike() {
        rollAStrike();
        underTest.roll(3);
        underTest.roll(1);

        assertThat(underTest.score()).isEqualTo(18);
    }

    @Test
    void shouldReturnCorrectScore_whenRollingPerfectGame() {
        for (int i = 0; i < FRAMES; i++) {
            rollAStrike();
        }
        rollAStrike();
        rollAStrike();

        assertThat(underTest.score()).isEqualTo(300);
    }

    @Test
    void shouldReturnCorrectScore_whenRollingAllGutterSpares() {
        for (int i = 0; i < FRAMES; i++) {
            underTest.roll(0);
            underTest.roll(10);
        }

        assertThat(underTest.score()).isEqualTo(100);
    }

    @Test
    void shouldReturnCorrectScore_whenRollingAllGutterSparesAndAfinal9() {
        for (int i = 0; i < FRAMES; i++) {
            underTest.roll(0);
            underTest.roll(10);
        }
        underTest.roll(9);

        assertThat(underTest.score()).isEqualTo(109);
    }

    private void rollAStrike() {
        underTest.roll(10);
    }

    private void rollASpare() {
        underTest.roll(5);
        underTest.roll(5);
    }

    private void rollAll(int pins) {
        for (int i = 0; i < FRAMES; i++) {
            underTest.roll(pins);
            underTest.roll(pins);
        }
    }
}
