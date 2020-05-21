package com.kata.poker;

import org.junit.Test;

import static com.kata.poker.Card.Suit.*;
import static com.kata.poker.PokerHandTest.*;
import static org.junit.Assert.assertEquals;

public class GameTest {

    @Test
    public void returns_the_name_of_the_winning_hand() {
        PokerHand hand = new PokerHand(fiveOf(Diamonds), threeOf(Hearts));
        PokerHand higherHand = new PokerHand(sevenOf(Diamonds), fiveOf(Hearts));

        assertEquals("first hand wins.", new Game(higherHand, hand).play());
        assertEquals("second hand wins.", new Game(hand, higherHand).play());
    }

    @Test
    public void returns_a_tie_when_there_is_no_winning_hand() {
        PokerHand hand = new PokerHand(fiveOf(Diamonds), threeOf(Hearts));
        PokerHand otherHand = new PokerHand(fiveOf(Clubs), threeOf(Spades));

        assertEquals("Tie.", new Game(hand, otherHand).play());
    }

}
