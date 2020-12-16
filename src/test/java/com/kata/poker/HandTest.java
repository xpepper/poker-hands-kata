package com.kata.poker;

import com.kata.poker.Hand.FourCardsExpectedException;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static com.kata.poker.Card.Suit.*;
import static com.kata.poker.CardBuilder.*;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HandTest {

    @Test(expected = FourCardsExpectedException.class)
    public void cannot_build_an_hand_with_no_cards() {
        new Hand();
    }

    @Test
    public void select_no_cards_when_all_cards_has_different_value() {
        Hand hand = new Hand(threeOf(Hearts), fiveOf(Hearts), aceOf(Hearts), twoOf(Hearts));
        assertTrue(hand.selectTwoCardsWithTheSameValue().isEmpty());
    }

    @Test
    public void select_the_cards_with_the_same_value_when_at_least_two_cards_have_the_same_value() {
        Hand hand = new Hand(threeOf(Hearts), fiveOf(Hearts), threeOf(Clubs), twoOf(Hearts));
        assertEquals(new TwoCards(threeOf(Hearts), threeOf(Clubs)), hand.selectTwoCardsWithTheSameValue().get());
    }

    @Test
    public void select_two_cards_out_of_three_cards_with_the_same_value() {
        Hand hand = new Hand(fourOf(Hearts), fourOf(Diamonds), fourOf(Clubs), twoOf(Hearts));
        assertTrue(hand.selectTwoCardsWithTheSameValue().isPresent());
    }

    @Test
    public void returns_all_cards_except_the_provided_ones() {
        Hand hand = new Hand(fourOf(Hearts), fourOf(Diamonds), fourOf(Clubs), twoOf(Hearts));

        Cards cards = hand.allCardsExcept(fourOf(Hearts));

        assertEquals(new Cards(asList(fourOf(Diamonds), fourOf(Clubs), twoOf(Hearts))), cards);
    }
}
