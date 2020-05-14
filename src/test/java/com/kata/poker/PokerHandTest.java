package com.kata.poker;

import com.kata.poker.Card.Value;
import org.junit.Test;

import static com.kata.poker.Card.Suit.*;
import static org.junit.Assert.assertEquals;

public class PokerHandTest {

    private static final int IS_LOWER = -1;
    private static final int IS_HIGHER = 1;
    private static final int IS_TIE = 0;

    @Test
    public void highest_card_wins_when_both_hands_do_not_fit_any_higher_ranking() {
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
    public void highest_card_wins_when_both_hands_have_a_pair() {
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
    public void highest_card_wins_when_both_hands_have_a_straight() {
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
        assertEquals(IS_LOWER, highestCard.compareTo(flush));
    }

    @Test
    public void a_flush_always_wins_against_a_pair() {
        PokerHand flush = new PokerHand(threeOf(Diamonds), fiveOf(Diamonds));
        PokerHand pair = new PokerHand(threeOf(Hearts), threeOf(Diamonds));

        assertEquals(IS_HIGHER, flush.compareTo(pair));
        assertEquals(IS_LOWER, pair.compareTo(flush));
    }

    @Test
    public void two_hands_with_the_same_flush_are_tie() {
        PokerHand hand = new PokerHand(fourOf(Spades), sevenOf(Spades));
        PokerHand otherHand = new PokerHand(fourOf(Diamonds), sevenOf(Diamonds));

        assertEquals(IS_TIE, hand.compareTo(otherHand));
        assertEquals(IS_TIE, otherHand.compareTo(hand));
    }

    @Test
    public void a_flush_always_wins_against_a_straight() {
        PokerHand flush = new PokerHand(threeOf(Diamonds), fiveOf(Diamonds));
        PokerHand straight = new PokerHand(threeOf(Hearts), fourOf(Diamonds));

        assertEquals(IS_HIGHER, flush.compareTo(straight));
        assertEquals(IS_LOWER, straight.compareTo(flush));
    }

    @Test
    public void highest_card_wins_when_both_hands_have_a_flush() {
        PokerHand lowerFlush = new PokerHand(threeOf(Diamonds), fiveOf(Diamonds));
        PokerHand higherFlush = new PokerHand(fourOf(Spades), sevenOf(Spades));

        assertEquals(IS_LOWER, lowerFlush.compareTo(higherFlush));
        assertEquals(IS_HIGHER, higherFlush.compareTo(lowerFlush));
    }

    @Test
    public void a_straight_flush_always_wins_against_a_flush() {
        PokerHand straightFlush = new PokerHand(threeOf(Diamonds), fourOf(Diamonds));
        PokerHand flush = new PokerHand(threeOf(Clubs), fiveOf(Clubs));

        assertEquals(IS_HIGHER, straightFlush.compareTo(flush));
        assertEquals(IS_LOWER, flush.compareTo(straightFlush));
    }

    @Test
    public void a_straight_flush_always_wins_against_a_straight() {
        PokerHand straightFlush = new PokerHand(threeOf(Diamonds), fourOf(Diamonds));
        PokerHand straight = new PokerHand(fourOf(Clubs), fiveOf(Diamonds));

        assertEquals(IS_HIGHER, straightFlush.compareTo(straight));
        assertEquals(IS_LOWER, straight.compareTo(straightFlush));
    }

    @Test
    public void a_straight_flush_always_wins_against_a_pair() {
        PokerHand straightFlush = new PokerHand(threeOf(Diamonds), fourOf(Diamonds));
        PokerHand pair = new PokerHand(fourOf(Clubs), fourOf(Hearts));

        assertEquals(IS_HIGHER, straightFlush.compareTo(pair));
        assertEquals(IS_LOWER, pair.compareTo(straightFlush));
    }

    @Test
    public void a_straight_flush_always_wins_against_a_highest_card() {
        PokerHand straightFlush = new PokerHand(threeOf(Diamonds), fourOf(Diamonds));
        PokerHand highestCard = new PokerHand(fourOf(Clubs), sevenOf(Hearts));

        assertEquals(IS_HIGHER, straightFlush.compareTo(highestCard));
        assertEquals(IS_LOWER, highestCard.compareTo(straightFlush));
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
