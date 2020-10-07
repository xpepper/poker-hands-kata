package com.kata.poker;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GameRunnerTest {

    private final GameRunner gameRunner = new GameRunner();

    @Test
    public void white_wins_with_high_card() {
        assertEquals("White wins. - with high card: 5", gameRunner.run("Black: 2H 4D  White: 2C 5H"));
    }

    @Test
    public void black_wins_with_high_card() {
        assertTrue(gameRunner.run("Black: 2C 5H  White: 2H 4D").startsWith("Black wins. - with high card"));
    }

    @Test
    public void when_no_player_has_a_winning_hand_the_game_is_tie() {
        assertEquals("Tie.", gameRunner.run("Black: 2H 5D  White: 2C 5H"));
    }
}
