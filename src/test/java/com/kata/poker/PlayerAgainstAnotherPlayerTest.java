package com.kata.poker;

import org.junit.Ignore;
import org.junit.Test;

import static com.kata.poker.Card.Suit.*;
import static com.kata.poker.PokerHandTest.*;
import static org.junit.Assert.assertEquals;

public class PlayerAgainstAnotherPlayerTest {

    @Test
    public void returns_the_winner() {
        PokerHand hand = new PokerHand(fiveOf(Diamonds), threeOf(Hearts));
        PokerHand higherHand = new PokerHand(sevenOf(Diamonds), fiveOf(Hearts));

        assertEquals(new Winner("White"), new Player("White", higherHand).playAgainst(new Player("Black", hand)));
        assertEquals(new Winner("Black"), new Player("White", hand).playAgainst(new Player("Black", higherHand)));
    }

    @Test
    public void returns_a_tie_when_no_player_has_a_winning_hand() {
        PokerHand hand = new PokerHand(fiveOf(Diamonds), threeOf(Hearts));
        PokerHand otherHand = new PokerHand(fiveOf(Clubs), threeOf(Spades));

        Player aPlayer = new Player("aPlayer", hand);
        Player anotherPlayer = new Player("anotherPlayer", otherHand);

        assertEquals(GameResult.tie, aPlayer.playAgainst(anotherPlayer));
    }

    @Test
    @Ignore
    public void returns_the_rank_of_the_winning_hand() {
        PokerHand hand = new PokerHand(fiveOf(Diamonds), threeOf(Hearts));
        PokerHand higherHand = new PokerHand(sevenOf(Diamonds), fiveOf(Hearts));

        assertEquals(null, new Player("White", higherHand).playAgainst(new Player("Black", hand)));
    }

}
