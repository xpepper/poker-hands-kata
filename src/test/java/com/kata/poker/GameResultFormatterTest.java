package com.kata.poker;

import org.junit.Test;

import static com.kata.poker.Card.Suit.*;
import static com.kata.poker.HandTest.*;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class GameResultFormatterTest {

    @Test
    public void format_the_winner_name_with_its_rank_and_point() {
        Winner winner = new Winner(new Player("Peter", new Hand(threeOf(Clubs), sevenOf(Hearts))));

        assertEquals("Peter wins. - with high card: 7", new GameResultFormatter().format(winner));
    }

    @Test
    public void format_the_straight_rank() {
        Winner winner = new Winner(new Player("anyName", new Hand(fiveOf(Hearts), fourOf(Diamonds))));

        assertThat(new GameResultFormatter().format(winner), containsString("straight: 5-high"));
    }

    @Test
    public void format_tie_result() {
        assertEquals("Tie.", new GameResultFormatter().format(GameResult.tie));
    }
}
