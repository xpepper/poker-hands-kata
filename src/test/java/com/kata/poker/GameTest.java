package com.kata.poker;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {
    @Test
    public void white_wins_with_high_card() {
        Game game = new Game("Black: 2H 4D  White: 2C 5H");

        assertEquals("White wins. - with high card", game.play());
    }
}
