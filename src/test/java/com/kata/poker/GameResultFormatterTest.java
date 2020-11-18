package com.kata.poker;

import org.junit.Test;

import static com.kata.poker.Card.Suit.*;
import static com.kata.poker.CardBuilder.*;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class GameResultFormatterTest {

    private final GameResultFormatter formatter = new GameResultFormatter();

    @Test
    public void format_the_winner_name_with_its_rank_and_point() {
        Winner winner = new Winner(new Player("Peter", new Hand(threeOf(Clubs), fiveOf(Diamonds), sevenOf(Hearts))));

        assertEquals("Peter wins. - with high card: 7", formatter.format(winner));
    }

    @Test
    public void format_the_winner_player_name() {
        Winner winner = new Winner(new Player("Peter", new Hand(threeOf(Clubs), fiveOf(Diamonds), sevenOf(Hearts))));

        assertThat(formatter.format(winner), containsString("Peter wins."));
    }

    @Test
    public void format_the_high_card_rank() {
        Winner winner = aWinnerWith(threeOf(Clubs), fiveOf(Diamonds), sevenOf(Hearts));

        assertThat(formatter.format(winner), containsString("high card: 7"));
    }

    @Test
    public void format_a_rank_with_a_figure() {
        Winner winner = aWinnerWith(threeOf(Clubs), queenOf(Diamonds), aceOf(Hearts));

        assertThat(formatter.format(winner), containsString("high card: Ace"));
    }

    @Test
    public void format_the_pair_rank() {
        Winner winner = aWinnerWith(fiveOf(Hearts), fiveOf(Diamonds), threeOf(Clubs));

        assertThat(formatter.format(winner), containsString("pair: 5s"));
    }

    @Test
    public void format_the_three_of_a_kind_rank() {
        Winner winner = aWinnerWith(fiveOf(Hearts), fiveOf(Diamonds), fiveOf(Clubs));

        assertThat(formatter.format(winner), containsString("three of a kind: 5s"));
    }

    @Test
    public void format_the_straight_rank() {
        Winner winner = aWinnerWith(fiveOf(Hearts), fourOf(Diamonds), threeOf(Clubs));

        assertThat(formatter.format(winner), containsString("straight: 5-high"));
    }

    @Test
    public void format_the_flush_rank() {
        Winner winner = aWinnerWith(fiveOf(Hearts), sevenOf(Hearts), threeOf(Hearts));

        assertThat(formatter.format(winner), containsString("flush: 7-high"));
    }

    @Test
    public void format_the_straight_flush_rank() {
        Winner winner = aWinnerWith(fiveOf(Hearts), fourOf(Hearts), threeOf(Hearts));

        assertThat(formatter.format(winner), containsString("straight flush: 5-high"));
    }

    @Test
    public void format_tie_result() {
        assertEquals("Tie.", formatter.format(GameResult.tie));
    }

    private Winner aWinnerWith(Card... cards) {
        return new Winner(new Player("anyName", new Hand(cards)));
    }
}
