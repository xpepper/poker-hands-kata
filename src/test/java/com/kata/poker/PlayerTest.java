package com.kata.poker;

import org.junit.Test;

import static com.kata.poker.Card.Suit.Diamonds;
import static com.kata.poker.Card.Suit.Hearts;
import static com.kata.poker.GameResult.tie;
import static com.kata.poker.HandTest.*;
import static org.junit.Assert.assertEquals;

public class PlayerTest {

    @Test
    public void a_player_with_the_highest_card_wins_when_they_both_have_hands_with_the_same_rank() {
        Player winningPlayer = aPlayerWithHand(sevenOf(Diamonds), fiveOf(Hearts));
        Player otherPlayer = aPlayerWithHand(fiveOf(Diamonds), threeOf(Hearts));

        assertEquals(new Winner(winningPlayer), winningPlayer.playAgainst(otherPlayer));
        assertEquals(new Winner(winningPlayer), otherPlayer.playAgainst(winningPlayer));
    }

    @Test
    public void players_with_the_same_rank_and_highest_card_are_tie() {
        Player player = aPlayerWithHand(sevenOf(Hearts), fourOf(Diamonds));
        Player otherPlayer = aPlayerWithHand(threeOf(Hearts), sevenOf(Diamonds));

        assertEquals(tie, player.playAgainst(otherPlayer));
        assertEquals(tie, otherPlayer.playAgainst(player));
    }

    private Player aPlayerWithHand(Card firstCard, Card secondCard) {
        return new Player("a name", new Hand(firstCard, secondCard));
    }

}
