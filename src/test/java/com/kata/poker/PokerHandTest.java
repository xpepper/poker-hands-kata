package com.kata.poker;

import com.kata.poker.Card.Value;
import org.junit.Ignore;
import org.junit.Test;

import static com.kata.poker.Card.Suit.*;
import static org.junit.Assert.assertEquals;

public class PokerHandTest {

    private static final int IS_LOWER = -1;
    private static final int IS_HIGHER = 1;
    private static final int IS_TIE = 0;

    @Test
    public void compare_hands_by_highest_card() {
        PokerHand lowerHighestCard = new PokerHand(fiveOf(Diamonds), threeOf(Hearts));
        PokerHand higherHighestCard = new PokerHand(sevenOf(Diamonds), fiveOf(Hearts));

        assertEquals(IS_LOWER, lowerHighestCard.compareTo(higherHighestCard));
        assertEquals(IS_HIGHER, higherHighestCard.compareTo(lowerHighestCard));
    }

    @Test
    public void two_hands_with_the_same_highest_card_are_tie() {
        PokerHand hand = new PokerHand(sevenOf(Hearts), fourOf(Diamonds));
        PokerHand otherHand = new PokerHand(threeOf(Hearts), sevenOf(Diamonds));

        assertEquals(IS_TIE, hand.compareTo(otherHand));
        assertEquals(IS_TIE, otherHand.compareTo(hand));
    }

    @Test
    public void compare_hands_having_both_a_pair() {
        PokerHand lowerPair = new PokerHand(fourOf(Diamonds), fourOf(Hearts));
        PokerHand higherPair = new PokerHand(fiveOf(Spades), fiveOf(Spades));

        assertEquals(IS_LOWER, lowerPair.compareTo(higherPair));
        assertEquals(IS_HIGHER, higherPair.compareTo(lowerPair));
    }

    @Test
    public void two_hands_with_the_same_pair_are_tie() {
        PokerHand hand = new PokerHand(fiveOf(Spades), fiveOf(Diamonds));
        PokerHand otherHand = new PokerHand(fiveOf(Clubs), fiveOf(Spades));

        assertEquals(IS_TIE, hand.compareTo(otherHand));
        assertEquals(IS_TIE, otherHand.compareTo(hand));
    }

    @Test
    public void a_pair_always_wins_against_a_highest_card() {
        PokerHand handWithPair = new PokerHand(threeOf(Diamonds), threeOf(Diamonds));
        PokerHand handWithHighestCard = new PokerHand(fiveOf(Spades), threeOf(Diamonds));

        assertEquals(IS_HIGHER, handWithPair.compareTo(handWithHighestCard));
        assertEquals(IS_LOWER, handWithHighestCard.compareTo(handWithPair));
    }

    @Test
    public void a_straight_always_wins_against_a_highest_card() {
        PokerHand handWithStraight = new PokerHand(fourOf(Hearts), threeOf(Diamonds));
        PokerHand handWithHighestCard = new PokerHand(threeOf(Diamonds), fiveOf(Spades));

        assertEquals(IS_HIGHER, handWithStraight.compareTo(handWithHighestCard));
        assertEquals(IS_LOWER, handWithHighestCard.compareTo(handWithStraight));
    }

    @Test
    public void a_straight_always_wins_against_a_pair() {
        PokerHand handWithStraight = new PokerHand(fourOf(Hearts), threeOf(Diamonds));
        PokerHand handWithPair = new PokerHand(sevenOf(Clubs), sevenOf(Spades));

        assertEquals(IS_HIGHER, handWithStraight.compareTo(handWithPair));
        assertEquals(IS_LOWER, handWithPair.compareTo(handWithStraight));
    }

    @Test
    public void two_hands_with_the_same_straight_are_tie() {
        PokerHand hand = new PokerHand(fiveOf(Spades), fourOf(Hearts));
        PokerHand otherHand = new PokerHand(fourOf(Hearts), fiveOf(Spades));

        assertEquals(IS_TIE, hand.compareTo(otherHand));
        assertEquals(IS_TIE, otherHand.compareTo(hand));
    }

    @Test
    public void compare_hands_having_both_a_straight() {
        PokerHand lowerStraight = new PokerHand(threeOf(Diamonds), fourOf(Hearts));
        PokerHand higherStraight = new PokerHand(fourOf(Hearts), fiveOf(Spades));

        assertEquals(IS_LOWER, lowerStraight.compareTo(higherStraight));
        assertEquals(IS_HIGHER, higherStraight.compareTo(lowerStraight));
    }

    @Test
    public void a_flush_always_wins_against_a_highest_card() {
        PokerHand flush = new PokerHand(threeOf(Diamonds), fiveOf(Diamonds));
        PokerHand highestCard = new PokerHand(threeOf(Hearts), sevenOf(Diamonds));

        assertEquals(IS_HIGHER, flush.compareTo(highestCard));
//        assertEquals(IS_LOWER, highestCard.compareTo(flush));
    }

    private Card threeOf(Card.Suit suit) {
        return new Card(Value.Three, suit);
    }

    private Card fourOf(Card.Suit suit) {
        return new Card(Value.Four, suit);
    }

    private Card fiveOf(Card.Suit suit) {
        return new Card(Value.Five, suit);
    }

    private Card sevenOf(Card.Suit suit) {
        return new Card(Value.Seven, suit);
    }

}
