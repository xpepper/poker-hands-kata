package com.kata.poker;

import org.junit.Test;

import static com.kata.poker.Card.Suit.Clubs;
import static com.kata.poker.Card.Suit.Hearts;
import static com.kata.poker.CardBuilder.*;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HandTest {
    @Test
    public void select_no_cards_when_all_cards_has_different_value() {
        Hand hand = new Hand(threeOf(Hearts), fiveOf(Hearts), aceOf(Hearts));
        assertTrue(hand.selectTwoCardsWithTheSameValue().isEmpty());
    }

    @Test
    public void select_the_cards_with_the_same_value_when_at_least_two_cards_has_the_same_value() {
        Hand hand = new Hand(threeOf(Hearts), fiveOf(Hearts), threeOf(Clubs));
        assertEquals(asList(threeOf(Hearts), threeOf(Clubs)), hand.selectTwoCardsWithTheSameValue());
    }
}