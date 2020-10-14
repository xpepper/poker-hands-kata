package com.kata.poker;

import org.junit.Test;

import static com.kata.poker.Card.Suit.*;
import static com.kata.poker.CardBuilder.*;
import static org.junit.Assert.assertEquals;

public class GameRulesTest {

    private final GameRules gameRules = new GameRules();

    @Test
    public void tell_when_an_hand_has_an_high_card_rank() {
        Hand hand = new Hand(sevenOf(Hearts), fourOf(Diamonds), twoOf(Clubs));

        assertEquals(Rank.highCard(sevenOf(Hearts)), gameRules.evaluate(hand));
    }

    @Test
    public void tell_when_an_hand_has_a_pair_rank() {
        Hand hand = new Hand(sevenOf(Hearts), sevenOf(Diamonds));

        assertEquals(Rank.pair(sevenOf(Hearts), sevenOf(Diamonds)), gameRules.evaluate(hand));
    }

    @Test
    public void tell_when_an_hand_has_a_straight() {
        Hand hand = new Hand(fiveOf(Hearts), fourOf(Diamonds), threeOf(Clubs));

        assertEquals(Rank.straight(fiveOf(Hearts)), gameRules.evaluate(hand));
    }

    @Test
    public void tell_when_an_hand_has_a_flush() {
        Hand hand = new Hand(fiveOf(Hearts), sevenOf(Hearts));

        assertEquals(Rank.flush(sevenOf(Hearts)), gameRules.evaluate(hand));
    }

    @Test
    public void tell_when_an_hand_has_a_straight_flush() {
        Hand hand = new Hand(fiveOf(Hearts), fourOf(Hearts), sixOf(Hearts));

        assertEquals(Rank.straightFlush(sixOf(Hearts)), gameRules.evaluate(hand));
    }

}