package com.kata.poker;

import com.kata.poker.Card.Value;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PokerHandTest {

    private static final int IS_LOWER = -1;
    private static final int IS_GREATER = 1;
    private static final int IS_TIE = 0;

    @Test
    public void compare_hands_by_highest_card() {
        PokerHand hand = new PokerHand(four(), three());
        PokerHand otherHand = new PokerHand(four(), five());

        assertEquals(IS_LOWER, hand.compareTo(otherHand));
        assertEquals(IS_GREATER, otherHand.compareTo(hand));

        assertEquals(IS_TIE, hand.compareTo(hand));
        assertEquals(IS_TIE, otherHand.compareTo(otherHand));
    }

    @Test
    public void two_hands_with_the_same_highest_card_are_tie() {
        PokerHand hand = new PokerHand(five(), four());
        PokerHand otherHand = new PokerHand(three(), five());

        assertEquals(IS_TIE, hand.compareTo(otherHand));
    }

    @Test @Ignore
    public void compare_hands_having_both_a_pair() {
        PokerHand hand = new PokerHand(four(), four());
        PokerHand otherHand = new PokerHand(five(), five());

        assertEquals(IS_LOWER, hand.compareTo(otherHand));
        assertEquals(IS_GREATER, otherHand.compareTo(hand));

        assertEquals(IS_TIE, hand.compareTo(hand));
        assertEquals(IS_TIE, otherHand.compareTo(otherHand));
    }

    @Test @Ignore
    public void two_hands_with_the_same_pair_are_tie() {
        PokerHand hand = new PokerHand(five(), five());
        PokerHand otherHand = new PokerHand(five(), five());

        assertEquals(IS_TIE, hand.compareTo(otherHand));
    }

    @Test
    public void a_pair_always_wins_against_a_highest_card() {
        PokerHand handWithPair = new PokerHand(three(), three());
        PokerHand handWithHighestCard = new PokerHand(five(), four());

        assertEquals(IS_GREATER, handWithPair.compareTo(handWithHighestCard));
    }

    private Card three() {
        return new Card(Value.Three);
    }

    private Card four() {
        return new Card(Value.Four);
    }

    private Card five() {
        return new Card(Value.Five);
    }
}
