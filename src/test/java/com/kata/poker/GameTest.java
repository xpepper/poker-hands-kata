package com.kata.poker;

import org.junit.Ignore;
import org.junit.Test;

import static com.kata.poker.Card.Suit.*;
import static com.kata.poker.PokerHandTest.*;
import static org.junit.Assert.assertEquals;

public class GameTest {

    @Test
    public void playing_a_game_returns_the_name_of_the_winning_player() {
        PokerHand hand = new PokerHand(fiveOf(Diamonds), threeOf(Hearts));
        PokerHand higherHand = new PokerHand(sevenOf(Diamonds), fiveOf(Hearts));

        assertEquals(new Winner("White"), new Game(new Player("White", higherHand), new Player("Black", hand)).play());
        assertEquals(new Winner("Black"), new Game(new Player("White", hand), new Player("Black", higherHand)).play());
    }

    @Test
    public void playing_a_game_returns_a_tie_when_no_player_has_a_winning_hand() {
        PokerHand hand = new PokerHand(fiveOf(Diamonds), threeOf(Hearts));
        PokerHand otherHand = new PokerHand(fiveOf(Clubs), threeOf(Spades));

        Player aPlayer = new Player("aPlayer", hand);
        Player anotherPlayer = new Player("anotherPlayer", otherHand);

        assertEquals(GameResult.tie, new Game(aPlayer, anotherPlayer).play());
    }

    @Test @Ignore
    public void returns_the_rank_of_the_winning_hand() {
        PokerHand hand = new PokerHand(fiveOf(Diamonds), threeOf(Hearts));
        PokerHand higherHand = new PokerHand(sevenOf(Diamonds), fiveOf(Hearts));

        assertEquals(null, new Game(new Player("White", higherHand), new Player("Black", hand)).play());
    }

}
