package com.kata.poker;

import com.kata.poker.Card.Value;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PokerHandTest {

    private static final int IS_LOWER = -1;
    private static final int IS_HIGHER = 1;
    private static final int IS_TIE = 0;

    @Test
    public void compare_hands_by_highest_card() {
        PokerHand lowerHighestCard = new PokerHand(five(), three());
        PokerHand higherHighestCard = new PokerHand(seven(), five());

        assertEquals(IS_LOWER, lowerHighestCard.compareTo(higherHighestCard));
        assertEquals(IS_HIGHER, higherHighestCard.compareTo(lowerHighestCard));
    }

    @Test
    public void two_hands_with_the_same_highest_card_are_tie() {
        PokerHand hand = new PokerHand(seven(), four());
        PokerHand otherHand = new PokerHand(three(), seven());

        assertEquals(IS_TIE, hand.compareTo(otherHand));
        assertEquals(IS_TIE, otherHand.compareTo(hand));
    }

    @Test
    public void compare_hands_having_both_a_pair() {
        PokerHand lowerPair = new PokerHand(four(), four());
        PokerHand higherPair = new PokerHand(five(), five());

        assertEquals(IS_LOWER, lowerPair.compareTo(higherPair));
        assertEquals(IS_HIGHER, higherPair.compareTo(lowerPair));
    }

    @Test
    public void two_hands_with_the_same_pair_are_tie() {
        PokerHand hand = new PokerHand(five(), five());
        PokerHand otherHand = new PokerHand(five(), five());

        assertEquals(IS_TIE, hand.compareTo(otherHand));
        assertEquals(IS_TIE, otherHand.compareTo(hand));
    }

    @Test
    public void a_pair_always_wins_against_a_highest_card() {
        PokerHand handWithPair = new PokerHand(three(), three());
        PokerHand handWithHighestCard = new PokerHand(five(), three());

        assertEquals(IS_HIGHER, handWithPair.compareTo(handWithHighestCard));
        assertEquals(IS_LOWER, handWithHighestCard.compareTo(handWithPair));
    }

    @Test
    public void a_straight_always_wins_against_a_highest_card() {
        PokerHand handWithStraight = new PokerHand(four(), three());
        PokerHand handWithHighestCard = new PokerHand(three(), five());

        assertEquals(IS_HIGHER, handWithStraight.compareTo(handWithHighestCard));
        assertEquals(IS_LOWER, handWithHighestCard.compareTo(handWithStraight));
    }

    @Test
    public void a_straight_always_wins_against_a_pair() {
        PokerHand handWithStraight = new PokerHand(four(), three());
        PokerHand handWithPair = new PokerHand(seven(), seven());

        assertEquals(IS_HIGHER, handWithStraight.compareTo(handWithPair));
        assertEquals(IS_LOWER, handWithPair.compareTo(handWithStraight));
    }

    @Test
    public void two_hands_with_the_same_straight_are_tie() {
        PokerHand hand = new PokerHand(five(), four());
        PokerHand otherHand = new PokerHand(four(), five());

        assertEquals(IS_TIE, hand.compareTo(otherHand));
        assertEquals(IS_TIE, otherHand.compareTo(hand));
    }

    @Test
    public void compare_hands_having_both_a_straight() {
        PokerHand lowerStraight = new PokerHand(three(), four());
        PokerHand higherStraight = new PokerHand(four(), five());

        assertEquals(IS_LOWER, lowerStraight.compareTo(higherStraight));
        assertEquals(IS_HIGHER, higherStraight.compareTo(lowerStraight));
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

    private Card seven() {
        return new Card(Value.Seven);
    }
}
