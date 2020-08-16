package com.kata.poker;

import com.kata.poker.Card.Value;
import org.junit.Test;

import static com.kata.poker.Card.Suit.*;
import static com.kata.poker.Outcome.*;
import static org.junit.Assert.assertEquals;

public class HandTest {

    @Test
    public void tell_when_an_hand_has_an_high_card_rank() {
        Hand hand = new Hand(sevenOf(Hearts), fourOf(Diamonds));

        assertEquals(Rank.highCard(sevenOf(Hearts)), hand.rank());
    }

    @Test
    public void tell_when_an_hand_has_a_pair_rank() {
        Hand hand = new Hand(sevenOf(Hearts), sevenOf(Diamonds));

        assertEquals(Rank.pair(sevenOf(Hearts), sevenOf(Diamonds)), hand.rank());
    }

    @Test
    public void tell_when_an_hand_has_a_straight() {
        Hand hand = new Hand(fiveOf(Hearts), fourOf(Diamonds));

        assertEquals(Rank.straight(fiveOf(Hearts)), hand.rank());
    }

    @Test
    public void tell_when_an_hand_has_a_flush() {
        Hand hand = new Hand(fiveOf(Hearts), sevenOf(Hearts));

        assertEquals(Rank.flush(sevenOf(Hearts)), hand.rank());
    }

    @Test
    public void tell_when_an_hand_has_a_straight_flush() {
        Hand hand = new Hand(fiveOf(Hearts), fourOf(Hearts));

        assertEquals(Rank.straightFlush(fiveOf(Hearts)), hand.rank());
    }

    @Test
    public void highest_card_wins_when_both_hands_do_not_fit_any_higher_ranking() {
        Hand lowerHand = new Hand(fiveOf(Diamonds), threeOf(Hearts));
        Hand higherHand = new Hand(sevenOf(Diamonds), fiveOf(Hearts));

        assertEquals(Lose, lowerHand.playAgainst(higherHand));
        assertEquals(Win, higherHand.playAgainst(lowerHand));
    }

    @Test
    public void two_hands_with_the_same_highest_card_are_tie() {
        Hand hand = new Hand(sevenOf(Hearts), fourOf(Diamonds));
        Hand otherHand = new Hand(threeOf(Hearts), sevenOf(Diamonds));

        assertEquals(Tie, hand.playAgainst(otherHand));
        assertEquals(Tie, otherHand.playAgainst(hand));
    }

    @Test
    public void highest_card_wins_when_both_hands_have_a_pair() {
        Hand lowerHand = new Hand(fourOf(Diamonds), fourOf(Hearts));
        Hand higherHand = new Hand(fiveOf(Spades), fiveOf(Spades));

        assertEquals(Lose, lowerHand.playAgainst(higherHand));
        assertEquals(Win, higherHand.playAgainst(lowerHand));
    }

    @Test
    public void two_hands_with_the_same_pair_are_tie() {
        Hand hand = new Hand(fiveOf(Spades), fiveOf(Diamonds));
        Hand otherHand = new Hand(fiveOf(Clubs), fiveOf(Spades));

        assertEquals(Tie, hand.playAgainst(otherHand));
        assertEquals(Tie, otherHand.playAgainst(hand));
    }

    @Test
    public void a_pair_always_wins_against_a_highest_card() {
        Hand handWithPair = new Hand(threeOf(Diamonds), threeOf(Diamonds));
        Hand handWithHighestCard = new Hand(fiveOf(Spades), threeOf(Diamonds));

        assertEquals(Win, handWithPair.playAgainst(handWithHighestCard));
        assertEquals(Lose, handWithHighestCard.playAgainst(handWithPair));
    }

    @Test
    public void a_straight_always_wins_against_a_highest_card() {
        Hand handWithStraight = new Hand(fourOf(Hearts), threeOf(Diamonds));
        Hand handWithHighestCard = new Hand(threeOf(Diamonds), fiveOf(Spades));

        assertEquals(Win, handWithStraight.playAgainst(handWithHighestCard));
        assertEquals(Lose, handWithHighestCard.playAgainst(handWithStraight));
    }

    @Test
    public void a_straight_always_wins_against_a_pair() {
        Hand handWithStraight = new Hand(fourOf(Hearts), threeOf(Diamonds));
        Hand handWithPair = new Hand(sevenOf(Clubs), sevenOf(Spades));

        assertEquals(Win, handWithStraight.playAgainst(handWithPair));
        assertEquals(Lose, handWithPair.playAgainst(handWithStraight));
    }

    @Test
    public void two_hands_with_the_same_straight_are_tie() {
        Hand hand = new Hand(fiveOf(Spades), fourOf(Hearts));
        Hand otherHand = new Hand(fourOf(Hearts), fiveOf(Spades));

        assertEquals(Tie, hand.playAgainst(otherHand));
        assertEquals(Tie, otherHand.playAgainst(hand));
    }

    @Test
    public void highest_card_wins_when_both_hands_have_a_straight() {
        Hand lowerHand = new Hand(threeOf(Diamonds), fourOf(Hearts));
        Hand higherHand = new Hand(fourOf(Hearts), fiveOf(Spades));

        assertEquals(Lose, lowerHand.playAgainst(higherHand));
        assertEquals(Win, higherHand.playAgainst(lowerHand));
    }

    @Test
    public void a_flush_always_wins_against_a_highest_card() {
        Hand flush = new Hand(threeOf(Diamonds), fiveOf(Diamonds));
        Hand highestCard = new Hand(threeOf(Hearts), sevenOf(Diamonds));

        assertEquals(Win, flush.playAgainst(highestCard));
        assertEquals(Lose, highestCard.playAgainst(flush));
    }

    @Test
    public void a_flush_always_wins_against_a_pair() {
        Hand flush = new Hand(threeOf(Diamonds), fiveOf(Diamonds));
        Hand pair = new Hand(threeOf(Hearts), threeOf(Diamonds));

        assertEquals(Win, flush.playAgainst(pair));
        assertEquals(Lose, pair.playAgainst(flush));
    }

    @Test
    public void two_hands_with_the_same_flush_are_tie() {
        Hand hand = new Hand(fourOf(Spades), sevenOf(Spades));
        Hand otherHand = new Hand(fourOf(Diamonds), sevenOf(Diamonds));

        assertEquals(Tie, hand.playAgainst(otherHand));
        assertEquals(Tie, otherHand.playAgainst(hand));
    }

    @Test
    public void a_flush_always_wins_against_a_straight() {
        Hand flush = new Hand(threeOf(Diamonds), fiveOf(Diamonds));
        Hand straight = new Hand(threeOf(Hearts), fourOf(Diamonds));

        assertEquals(Win, flush.playAgainst(straight));
        assertEquals(Lose, straight.playAgainst(flush));
    }

    @Test
    public void highest_card_wins_when_both_hands_have_a_flush() {
        Hand lowerHand = new Hand(threeOf(Diamonds), fiveOf(Diamonds));
        Hand higherHand = new Hand(fourOf(Spades), sevenOf(Spades));

        assertEquals(Lose, lowerHand.playAgainst(higherHand));
        assertEquals(Win, higherHand.playAgainst(lowerHand));
    }

    @Test
    public void a_straight_flush_always_wins_against_a_flush() {
        Hand straightFlush = new Hand(threeOf(Diamonds), fourOf(Diamonds));
        Hand flush = new Hand(threeOf(Clubs), fiveOf(Clubs));

        assertEquals(Win, straightFlush.playAgainst(flush));
        assertEquals(Lose, flush.playAgainst(straightFlush));
    }

    @Test
    public void a_straight_flush_always_wins_against_a_straight() {
        Hand straightFlush = new Hand(threeOf(Diamonds), fourOf(Diamonds));
        Hand straight = new Hand(fourOf(Clubs), fiveOf(Diamonds));

        assertEquals(Win, straightFlush.playAgainst(straight));
        assertEquals(Lose, straight.playAgainst(straightFlush));
    }

    @Test
    public void a_straight_flush_always_wins_against_a_pair() {
        Hand straightFlush = new Hand(threeOf(Diamonds), fourOf(Diamonds));
        Hand pair = new Hand(fourOf(Clubs), fourOf(Hearts));

        assertEquals(Win, straightFlush.playAgainst(pair));
        assertEquals(Lose, pair.playAgainst(straightFlush));
    }

    @Test
    public void a_straight_flush_always_wins_against_a_highest_card() {
        Hand straightFlush = new Hand(threeOf(Diamonds), fourOf(Diamonds));
        Hand highestCard = new Hand(fourOf(Clubs), sevenOf(Hearts));

        assertEquals(Win, straightFlush.playAgainst(highestCard));
        assertEquals(Lose, highestCard.playAgainst(straightFlush));
    }

    @Test
    public void two_hands_with_the_same_straight_flush_are_tie() {
        Hand hand = new Hand(threeOf(Diamonds), fourOf(Diamonds));
        Hand otherHand = new Hand(threeOf(Spades), fourOf(Spades));

        assertEquals(Tie, hand.playAgainst(otherHand));
        assertEquals(Tie, otherHand.playAgainst(hand));
    }

    @Test
    public void highest_card_wins_when_both_hands_have_a_straight_flush() {
        Hand lowerHand = new Hand(threeOf(Diamonds), fourOf(Diamonds));
        Hand higherHand = new Hand(fourOf(Spades), fiveOf(Spades));

        assertEquals(Lose, lowerHand.playAgainst(higherHand));
        assertEquals(Win, higherHand.playAgainst(lowerHand));
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

    public static Card aceOf(Card.Suit suit) {
        return new Card(Value.Ace, suit);
    }

}
