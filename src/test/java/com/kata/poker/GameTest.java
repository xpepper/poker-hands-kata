package com.kata.poker;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GameTest {
    @Test
    public void white_wins_with_high_card() {
        Game game = new Game("Black: 2H 4D  White: 2C 5H");

        assertTrue(game.play().startsWith("White wins. - with high card"));
    }

    @Test
    public void black_wins_with_high_card() {
        Game game = new Game("Black: 2C 5H  White: 2H 4D");

        assertTrue(game.play().startsWith("Black wins. - with high card"));
    }

    @Test
    public void when_no_player_has_a_winning_hand_the_game_is_tie() {
        Game game = new Game("Black: 2H 5D  White: 2C 5H");

        assertEquals("Tie.", game.play());
    }
}
