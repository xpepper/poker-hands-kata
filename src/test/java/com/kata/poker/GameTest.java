package com.kata.poker;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {
    @Test
    public void play_a_game_between_black_and_white() {
        Game game = new Game("Black: 2H 3D  White: 2C 5H");

        assertEquals("White wins. - with high card", game.play());
    }
}
