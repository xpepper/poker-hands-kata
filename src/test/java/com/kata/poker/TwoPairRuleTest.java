package com.kata.poker;

import org.junit.Test;

import static com.kata.poker.Card.Suit.*;
import static com.kata.poker.Card.Suit.Hearts;
import static com.kata.poker.Card.Value.Three;
import static com.kata.poker.Card.Value.Two;
import static com.kata.poker.CardBuilder.threeOf;
import static com.kata.poker.CardBuilder.twoOf;
import static org.junit.Assert.*;

public class TwoPairRuleTest {

    @Test
    public void extract_two_pair_rank_from_a_hand() {
        Hand hand = new Hand(threeOf(Diamonds), threeOf(Hearts), twoOf(Clubs), twoOf(Hearts));

        TwoPairRule rule = new TwoPairRule();

        assertEquals(Rank.twoPair(Two, Three), rule.apply(hand));
    }

    @Test
    public void detects_when_an_hand_has_two_pair() {
        Hand hand = new Hand(threeOf(Diamonds), threeOf(Hearts), twoOf(Clubs), twoOf(Hearts));

        TwoPairRule rule = new TwoPairRule();

        assertTrue(rule.canApply(hand));
    }
}