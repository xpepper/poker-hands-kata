package com.kata.poker;

import org.junit.Test;

import static com.kata.poker.Card.Suit.*;
import static com.kata.poker.PokerHandTest.*;
import static org.junit.Assert.assertEquals;

public class GameTest {

    @Test
    public void returns_the_name_of_the_player_with_the_winning_hand() {
        PokerHand hand = new PokerHand(fiveOf(Diamonds), threeOf(Hearts));
        PokerHand higherHand = new PokerHand(sevenOf(Diamonds), fiveOf(Hearts));

        assertEquals("White wins.", new Game(new Player("White", higherHand), new Player("Black", hand)).play());
        assertEquals("Black wins.", new Game(new Player("White", hand), new Player("Black", higherHand)).play());
    }

    @Test
    public void returns_a_tie_when_no_player_has_a_winning_hand() {
        PokerHand hand = new PokerHand(fiveOf(Diamonds), threeOf(Hearts));
        PokerHand otherHand = new PokerHand(fiveOf(Clubs), threeOf(Spades));

        Player aPlayer = new Player("aPlayer", hand);
        Player anotherPlayer = new Player("anotherPlayer", otherHand);

        assertEquals("Tie.", new Game(aPlayer, anotherPlayer).play());
    }

}
