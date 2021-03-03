package com.kata.poker;

import org.junit.Test;

import static com.kata.poker.Card.Suit.*;
import static com.kata.poker.Card.Value.*;
import static com.kata.poker.CardBuilder.*;
import static org.junit.Assert.assertEquals;

public class GameRulesTest {

    private final GameRules gameRules = new GameRules();

    @Test
    public void tell_when_an_hand_has_an_high_card_rank() {
        Hand hand = new Hand(sevenOf(Hearts), fourOf(Diamonds), twoOf(Clubs), threeOf(Hearts));

        assertEquals(Rank.highCard(sevenOf(Hearts)), gameRules.evaluate(hand));
    }

    @Test
    public void tell_when_an_hand_has_a_pair_rank() {
        Hand hand = new Hand(sevenOf(Hearts), sevenOf(Diamonds), fourOf(Clubs), threeOf(Hearts));

        assertEquals(Rank.pair(sevenOf(Hearts), sevenOf(Diamonds), fourOf(Clubs)), gameRules.evaluate(hand));
    }

    @Test
    public void tell_when_an_hand_has_two_pair_rank() {
        Hand hand = new Hand(threeOf(Diamonds), threeOf(Hearts), twoOf(Clubs), twoOf(Hearts));

        assertEquals(Rank.twoPair(Two, Three), gameRules.evaluate(hand));
    }

    @Test
    public void tell_when_an_hand_has_a_three_of_a_kind_rank() {
        Hand hand = new Hand(fourOf(Hearts), fourOf(Diamonds), fourOf(Clubs), twoOf(Hearts));

        assertEquals(Rank.threeOfKind(Four), gameRules.evaluate(hand));
    }

    @Test
    public void tell_when_an_hand_has_a_straight() {
        Hand hand = new Hand(fiveOf(Hearts), fourOf(Diamonds), threeOf(Clubs), twoOf(Hearts));

        assertEquals(Rank.straight(fiveOf(Hearts)), gameRules.evaluate(hand));
    }

    @Test
    public void tell_when_an_hand_has_a_flush() {
        Hand hand = new Hand(fiveOf(Hearts), sevenOf(Hearts), aceOf(Hearts), twoOf(Hearts));

        assertEquals(Rank.flush(aceOf(Hearts)), gameRules.evaluate(hand));
    }

    @Test
    public void tell_when_an_hand_has_a_four_of_a_kind_rank() {
        Hand hand = new Hand(fourOf(Hearts), fourOf(Diamonds), fourOf(Clubs), fourOf(Spades));

        assertEquals(Rank.fourOfKind(Four), gameRules.evaluate(hand));
    }

    @Test
    public void tell_when_an_hand_has_a_straight_flush() {
        Hand hand = new Hand(fiveOf(Hearts), fourOf(Hearts), sixOf(Hearts), threeOf(Hearts));

        assertEquals(Rank.straightFlush(sixOf(Hearts)), gameRules.evaluate(hand));
    }

}
