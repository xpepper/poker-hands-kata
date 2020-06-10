package com.kata.poker;

import com.kata.poker.Card.Value;
import org.junit.Test;

import static com.kata.poker.Card.Suit.*;
import static com.kata.poker.HandOutcome.*;
import static org.junit.Assert.assertEquals;

public class PokerHandTest {

    @Test
    public void highest_card_wins_when_both_hands_do_not_fit_any_higher_ranking() {
        PokerHand lowerHand = new PokerHand(fiveOf(Diamonds), threeOf(Hearts));
        PokerHand higherHand = new PokerHand(sevenOf(Diamonds), fiveOf(Hearts));

        assertEquals(Loser, lowerHand.compareToXXX(higherHand));
        assertEquals(Winner, higherHand.compareToXXX(lowerHand));
    }

    @Test
    public void two_hands_with_the_same_highest_card_are_tie() {
        PokerHand hand = new PokerHand(sevenOf(Hearts), fourOf(Diamonds));
        PokerHand otherHand = new PokerHand(threeOf(Hearts), sevenOf(Diamonds));

        assertEquals(Tie, hand.compareToXXX(otherHand));
        assertEquals(Tie, otherHand.compareToXXX(hand));
    }

    @Test
    public void highest_card_wins_when_both_hands_have_a_pair() {
        PokerHand lowerHand = new PokerHand(fourOf(Diamonds), fourOf(Hearts));
        PokerHand higherHand = new PokerHand(fiveOf(Spades), fiveOf(Spades));

        assertEquals(Loser, lowerHand.compareToXXX(higherHand));
        assertEquals(Winner, higherHand.compareToXXX(lowerHand));
    }

    @Test
    public void two_hands_with_the_same_pair_are_tie() {
        PokerHand hand = new PokerHand(fiveOf(Spades), fiveOf(Diamonds));
        PokerHand otherHand = new PokerHand(fiveOf(Clubs), fiveOf(Spades));

        assertEquals(Tie, hand.compareToXXX(otherHand));
        assertEquals(Tie, otherHand.compareToXXX(hand));
    }

    @Test
    public void a_pair_always_wins_against_a_highest_card() {
        PokerHand handWithPair = new PokerHand(threeOf(Diamonds), threeOf(Diamonds));
        PokerHand handWithHighestCard = new PokerHand(fiveOf(Spades), threeOf(Diamonds));

        assertEquals(Winner, handWithPair.compareToXXX(handWithHighestCard));
        assertEquals(Loser, handWithHighestCard.compareToXXX(handWithPair));
    }

    @Test
    public void a_straight_always_wins_against_a_highest_card() {
        PokerHand handWithStraight = new PokerHand(fourOf(Hearts), threeOf(Diamonds));
        PokerHand handWithHighestCard = new PokerHand(threeOf(Diamonds), fiveOf(Spades));

        assertEquals(Winner, handWithStraight.compareToXXX(handWithHighestCard));
        assertEquals(Loser, handWithHighestCard.compareToXXX(handWithStraight));
    }

    @Test
    public void a_straight_always_wins_against_a_pair() {
        PokerHand handWithStraight = new PokerHand(fourOf(Hearts), threeOf(Diamonds));
        PokerHand handWithPair = new PokerHand(sevenOf(Clubs), sevenOf(Spades));

        assertEquals(Winner, handWithStraight.compareToXXX(handWithPair));
        assertEquals(Loser, handWithPair.compareToXXX(handWithStraight));
    }

    @Test
    public void two_hands_with_the_same_straight_are_tie() {
        PokerHand hand = new PokerHand(fiveOf(Spades), fourOf(Hearts));
        PokerHand otherHand = new PokerHand(fourOf(Hearts), fiveOf(Spades));

        assertEquals(Tie, hand.compareToXXX(otherHand));
        assertEquals(Tie, otherHand.compareToXXX(hand));
    }

    @Test
    public void highest_card_wins_when_both_hands_have_a_straight() {
        PokerHand lowerHand = new PokerHand(threeOf(Diamonds), fourOf(Hearts));
        PokerHand higherHand = new PokerHand(fourOf(Hearts), fiveOf(Spades));

        assertEquals(Loser, lowerHand.compareToXXX(higherHand));
        assertEquals(Winner, higherHand.compareToXXX(lowerHand));
    }

    @Test
    public void a_flush_always_wins_against_a_highest_card() {
        PokerHand flush = new PokerHand(threeOf(Diamonds), fiveOf(Diamonds));
        PokerHand highestCard = new PokerHand(threeOf(Hearts), sevenOf(Diamonds));

        assertEquals(Winner, flush.compareToXXX(highestCard));
        assertEquals(Loser, highestCard.compareToXXX(flush));
    }

    @Test
    public void a_flush_always_wins_against_a_pair() {
        PokerHand flush = new PokerHand(threeOf(Diamonds), fiveOf(Diamonds));
        PokerHand pair = new PokerHand(threeOf(Hearts), threeOf(Diamonds));

        assertEquals(Winner, flush.compareToXXX(pair));
        assertEquals(Loser, pair.compareToXXX(flush));
    }

    @Test
    public void two_hands_with_the_same_flush_are_tie() {
        PokerHand hand = new PokerHand(fourOf(Spades), sevenOf(Spades));
        PokerHand otherHand = new PokerHand(fourOf(Diamonds), sevenOf(Diamonds));

        assertEquals(Tie, hand.compareToXXX(otherHand));
        assertEquals(Tie, otherHand.compareToXXX(hand));
    }

    @Test
    public void a_flush_always_wins_against_a_straight() {
        PokerHand flush = new PokerHand(threeOf(Diamonds), fiveOf(Diamonds));
        PokerHand straight = new PokerHand(threeOf(Hearts), fourOf(Diamonds));

        assertEquals(Winner, flush.compareToXXX(straight));
        assertEquals(Loser, straight.compareToXXX(flush));
    }

    @Test
    public void highest_card_wins_when_both_hands_have_a_flush() {
        PokerHand lowerHand = new PokerHand(threeOf(Diamonds), fiveOf(Diamonds));
        PokerHand higherHand = new PokerHand(fourOf(Spades), sevenOf(Spades));

        assertEquals(Loser, lowerHand.compareToXXX(higherHand));
        assertEquals(Winner, higherHand.compareToXXX(lowerHand));
    }

    @Test
    public void a_straight_flush_always_wins_against_a_flush() {
        PokerHand straightFlush = new PokerHand(threeOf(Diamonds), fourOf(Diamonds));
        PokerHand flush = new PokerHand(threeOf(Clubs), fiveOf(Clubs));

        assertEquals(Winner, straightFlush.compareToXXX(flush));
        assertEquals(Loser, flush.compareToXXX(straightFlush));
    }

    @Test
    public void a_straight_flush_always_wins_against_a_straight() {
        PokerHand straightFlush = new PokerHand(threeOf(Diamonds), fourOf(Diamonds));
        PokerHand straight = new PokerHand(fourOf(Clubs), fiveOf(Diamonds));

        assertEquals(Winner, straightFlush.compareToXXX(straight));
        assertEquals(Loser, straight.compareToXXX(straightFlush));
    }

    @Test
    public void a_straight_flush_always_wins_against_a_pair() {
        PokerHand straightFlush = new PokerHand(threeOf(Diamonds), fourOf(Diamonds));
        PokerHand pair = new PokerHand(fourOf(Clubs), fourOf(Hearts));

        assertEquals(Winner, straightFlush.compareToXXX(pair));
        assertEquals(Loser, pair.compareToXXX(straightFlush));
    }

    @Test
    public void a_straight_flush_always_wins_against_a_highest_card() {
        PokerHand straightFlush = new PokerHand(threeOf(Diamonds), fourOf(Diamonds));
        PokerHand highestCard = new PokerHand(fourOf(Clubs), sevenOf(Hearts));

        assertEquals(Winner, straightFlush.compareToXXX(highestCard));
        assertEquals(Loser, highestCard.compareToXXX(straightFlush));
    }

    @Test
    public void two_hands_with_the_same_straight_flush_are_tie() {
        PokerHand hand = new PokerHand(threeOf(Diamonds), fourOf(Diamonds));
        PokerHand otherHand = new PokerHand(threeOf(Spades), fourOf(Spades));

        assertEquals(Tie, hand.compareToXXX(otherHand));
        assertEquals(Tie, otherHand.compareToXXX(hand));
    }

    @Test
    public void highest_card_wins_when_both_hands_have_a_straight_flush() {
        PokerHand lowerHand = new PokerHand(threeOf(Diamonds), fourOf(Diamonds));
        PokerHand higherHand = new PokerHand(fourOf(Spades), fiveOf(Spades));

        assertEquals(Loser, lowerHand.compareToXXX(higherHand));
        assertEquals(Winner, higherHand.compareToXXX(lowerHand));
    }

    public static Card threeOf(Card.Suit suit) {
        return new Card(Value.Three, suit);
    }

    public static Card fourOf(Card.Suit suit) {
        return new Card(Value.Four, suit);
    }

    public static Card fiveOf(Card.Suit suit) {
        return new Card(Value.Five, suit);
    }

    public static Card sevenOf(Card.Suit suit) {
        return new Card(Value.Seven, suit);
    }

}
