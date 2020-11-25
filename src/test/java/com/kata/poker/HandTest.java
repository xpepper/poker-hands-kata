package com.kata.poker;

import org.junit.Test;

import static com.kata.poker.Card.Suit.*;
import static com.kata.poker.CardBuilder.*;
import static java.util.Arrays.asList;
import static org.junit.Assert.*;

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

    @Test
    public void select_two_cards_out_of_three_cards_with_the_same_value() {
        Hand hand = new Hand(fourOf(Hearts), fourOf(Diamonds), fourOf(Clubs));

        assertEquals(2, hand.selectTwoCardsWithTheSameValue().size());
    }

    @Test
    public void returns_all_cards_except_the_provided_ones() {
        Hand hand = new Hand(fourOf(Hearts), fourOf(Diamonds), fourOf(Clubs));

        Cards cards = hand.allCardsExcept(new Cards(asList(fourOf(Hearts))));

        assertEquals(new Cards(asList(fourOf(Diamonds), fourOf(Clubs))), cards);
    }
}
