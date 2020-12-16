package com.kata.poker;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GameRunnerTest {

    private final GameRunner gameRunner = new GameRunner();

    @Test
    public void white_wins_with_high_card() {
        String gameResult = gameRunner.run("Black: 2H 4D 6C 3H  White: 2C 5H 7D 6H");

        assertEquals("White wins. - with high card: 7", gameResult);
    }

    @Test
    public void black_wins_with_high_card() {
        String gameResult = gameRunner.run("Black: 2C 5H 7D 6H  White: 2H 4D 6C 3H");

        assertTrue(gameResult.startsWith("Black wins. - with high card"));
    }

    @Test
    public void when_no_player_has_a_winning_hand_the_game_is_tie() {
        String gameResult = gameRunner.run("Black: 2H 5D 7C 6H  White: 2C 5H 7H 3H");

        assertEquals("Tie.", gameResult);
    }
}
