package com.kata.poker;

import com.kata.poker.Card.Value;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PokerHandTest {

    private static final int IS_LOWER = -1;
    private static final int IS_GREATER = 1;
    private static final int IS_TIE = 0;

    @Test
    public void an_hand_with_a_four_is_lower_than_an_hand_with_a_five() {
        PokerHand hand = new PokerHand(new Card(Value.Four));
        PokerHand otherHand = new PokerHand(new Card(Value.Five));

        assertEquals(IS_LOWER, hand.compareTo(otherHand));
    }

    @Test
    public void an_hand_with_a_five_is_greater_than_an_hand_with_a_four() {
        PokerHand hand = new PokerHand(new Card(Value.Five));
        PokerHand otherHand = new PokerHand(new Card(Value.Four));

        assertEquals(IS_GREATER, hand.compareTo(otherHand));
    }

    @Test
    public void two_hands_with_the_same_card_are_tie() {
        PokerHand hand = new PokerHand(new Card(Value.Five));
        PokerHand otherHand = new PokerHand(new Card(Value.Five));

        assertEquals(IS_TIE, hand.compareTo(otherHand));
    }

    @Test
    public void compare_hands_by_highest_card() {
        PokerHand hand = new PokerHand(new Card(Value.Four), new Card(Value.Three));
        PokerHand otherHand = new PokerHand(new Card(Value.Four), new Card(Value.Five));

        assertEquals(IS_LOWER, hand.compareTo(otherHand));
    }
}


