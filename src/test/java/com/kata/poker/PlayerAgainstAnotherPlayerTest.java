package com.kata.poker;

import org.junit.Test;

import static com.kata.poker.Card.Suit.*;
import static com.kata.poker.HandTest.*;
import static org.junit.Assert.assertEquals;

public class PlayerAgainstAnotherPlayerTest {

    @Test
    public void returns_the_winner() {
        Hand higherHand = new Hand(sevenOf(Diamonds), fiveOf(Hearts));
        Hand hand = new Hand(fiveOf(Diamonds), threeOf(Hearts));

        Player winningPlayer = new Player("aPlayer", higherHand);
        Player losingPlayer = new Player("anotherPlayer", hand);

        assertEquals(new Winner(winningPlayer), winningPlayer.playAgainst(losingPlayer));
        assertEquals(new Winner(winningPlayer), losingPlayer.playAgainst(winningPlayer));
    }

    @Test
    public void returns_a_tie_when_no_player_has_a_winning_hand() {
        Hand hand = new Hand(fiveOf(Diamonds), threeOf(Hearts));
        Hand otherHand = new Hand(fiveOf(Clubs), threeOf(Spades));

        Player aPlayer = new Player("aPlayer", hand);
        Player anotherPlayer = new Player("anotherPlayer", otherHand);

        assertEquals(GameResult.tie, aPlayer.playAgainst(anotherPlayer));
        assertEquals(GameResult.tie, anotherPlayer.playAgainst(aPlayer));
    }

}
