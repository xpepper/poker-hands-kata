package com.kata.poker;

import org.junit.Test;

import static com.kata.poker.Card.Suit.Diamonds;
import static com.kata.poker.Card.Suit.Hearts;
import static com.kata.poker.PokerHandTest.*;
import static org.junit.Assert.assertEquals;

public class GameTest {

    @Test
    public void returns_the_name_of_the_winning_hand() {
        PokerHand hand = new PokerHand(fiveOf(Diamonds), threeOf(Hearts));
        PokerHand otherHand = new PokerHand(sevenOf(Diamonds), fiveOf(Hearts));

        String winningHand = new Game(hand, otherHand).play();

        assertEquals("second hand wins.", winningHand);
    }
}
