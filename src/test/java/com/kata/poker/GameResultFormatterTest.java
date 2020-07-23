package com.kata.poker;

import org.junit.Test;

import static com.kata.poker.Card.Suit.Clubs;
import static com.kata.poker.Card.Suit.Hearts;
import static com.kata.poker.HandTest.*;
import static org.junit.Assert.assertEquals;

public class GameResultFormatterTest {

    @Test
    public void format_the_winner_name_and_its_rank() {
        Winner winner = new Winner(new Player("Peter", new Hand(threeOf(Clubs), sevenOf(Hearts))));

        assertEquals("Peter wins. - with high card", new GameResultFormatter().format(winner));
    }

    @Test
    public void format_tie_result() {
        assertEquals("Tie.", new GameResultFormatter().format(GameResult.tie));
    }
}
