package com.kata.poker;

import org.junit.Test;

import static com.kata.poker.Card.Suit.*;
import static com.kata.poker.CardBuilder.*;
import static org.junit.Assert.assertTrue;

public class RankTest {

    @Test
    public void the_pair_with_the_highest_kicker_wins_when_the_pairs_have_the_same_value() {
        Rank winningPair = Rank.pair(fiveOf(Diamonds), fiveOf(Hearts), kingOf(Clubs));
        Rank anotherPair = Rank.pair(fiveOf(Clubs), fiveOf(Spades), sevenOf(Clubs));

        assertTrue(winningPair.higherThan(anotherPair));
    }
}
