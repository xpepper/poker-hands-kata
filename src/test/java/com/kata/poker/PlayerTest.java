package com.kata.poker;

import org.junit.Test;

import static com.kata.poker.Card.Suit.Diamonds;
import static com.kata.poker.Card.Suit.Hearts;
import static com.kata.poker.HandTest.*;
import static org.junit.Assert.assertEquals;

public class PlayerTest {

    @Test
    public void a_player_with_the_highest_card_wins_when_they_both_have_hands_with_the_same_rank() {
        Hand lowerHighCardHand = new Hand(fiveOf(Diamonds), threeOf(Hearts));
        Hand higherHighCardHand = new Hand(sevenOf(Diamonds), fiveOf(Hearts));

        Player playerWithLowerHand = new Player("lowerHandPlayer", lowerHighCardHand);
        Player playerWithHigherHand = new Player("higherHandPlayer", higherHighCardHand);

        assertEquals(new Winner(playerWithHigherHand), playerWithHigherHand.playAgainst(playerWithLowerHand));
        assertEquals(new Winner(playerWithHigherHand), playerWithLowerHand.playAgainst(playerWithHigherHand));
    }

}
