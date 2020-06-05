package com.kata.poker;

import org.junit.Ignore;
import org.junit.Test;

import static com.kata.poker.Card.Suit.*;
import static com.kata.poker.PokerHandTest.*;
import static org.junit.Assert.assertEquals;

public class PlayerAgainstAnotherPlayerTest {

    @Test
    public void returns_the_winner() {
        PokerHand higherHand = new PokerHand(sevenOf(Diamonds), fiveOf(Hearts));
        PokerHand hand = new PokerHand(fiveOf(Diamonds), threeOf(Hearts));

        Player winningPlayer = new Player("aPlayer", higherHand);
        Player losingPlayer = new Player("anotherPlayer", hand);

        assertEquals(new Winner(winningPlayer), winningPlayer.playAgainst(losingPlayer));
        assertEquals(new Winner(winningPlayer), losingPlayer.playAgainst(winningPlayer));
    }

    @Test
    public void returns_a_tie_when_no_player_has_a_winning_hand() {
        PokerHand hand = new PokerHand(fiveOf(Diamonds), threeOf(Hearts));
        PokerHand otherHand = new PokerHand(fiveOf(Clubs), threeOf(Spades));

        Player aPlayer = new Player("aPlayer", hand);
        Player anotherPlayer = new Player("anotherPlayer", otherHand);

        assertEquals(GameResult.tie, aPlayer.playAgainst(anotherPlayer));
        assertEquals(GameResult.tie, anotherPlayer.playAgainst(aPlayer));
    }

}
