package com.kata.poker;

import org.junit.Test;

import static com.kata.poker.Card.Suit.Diamonds;
import static com.kata.poker.Card.Suit.Hearts;
import static com.kata.poker.HandTest.*;
import static org.junit.Assert.assertEquals;

public class GameRulesTest {

    private final GameRules gameRules = new GameRules();

    @Test
    public void tell_when_an_hand_has_an_high_card_rank() {
        Hand hand = new Hand(sevenOf(Hearts), fourOf(Diamonds));

        assertEquals(Rank.highCard(sevenOf(Hearts)), gameRules.evaluate(hand));
    }

    @Test
    public void tell_when_an_hand_has_a_pair_rank() {
        Hand hand = new Hand(sevenOf(Hearts), sevenOf(Diamonds));

        assertEquals(Rank.pair(sevenOf(Hearts), sevenOf(Diamonds)), gameRules.evaluate(hand));
    }

    @Test
    public void tell_when_an_hand_has_a_straight() {
        Hand hand = new Hand(fiveOf(Hearts), fourOf(Diamonds));

        assertEquals(Rank.straight(fiveOf(Hearts)), gameRules.evaluate(hand));
    }

    @Test
    public void tell_when_an_hand_has_a_flush() {
        Hand hand = new Hand(fiveOf(Hearts), sevenOf(Hearts));

        assertEquals(Rank.flush(sevenOf(Hearts)), gameRules.evaluate(hand));
    }

    @Test
    public void tell_when_an_hand_has_a_straight_flush() {
        Hand hand = new Hand(fiveOf(Hearts), fourOf(Hearts));

        assertEquals(Rank.straightFlush(fiveOf(Hearts)), gameRules.evaluate(hand));
    }

}