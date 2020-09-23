package com.kata.poker;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;
import org.junit.Test;

import static com.kata.poker.Card.Suit.Diamonds;
import static com.kata.poker.Card.Suit.Hearts;
import static com.kata.poker.GameResult.tie;
import static com.kata.poker.HandTest.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class PlayerTest {

    @Test
    public void a_player_with_the_highest_card_wins_when_they_both_have_hands_with_the_same_rank() {
        Player winningPlayer = aPlayerWithHand(sevenOf(Diamonds), fiveOf(Hearts));
        Player otherPlayer = aPlayerWithHand(fiveOf(Diamonds), threeOf(Hearts));

        assertThat(winningPlayer, winsAgainst(otherPlayer));
    }

    private Matcher<Player> winsAgainst(Player player) {
        return new TypeSafeDiagnosingMatcher<Player>() {
            private Winner winner;

            @Override
            public void describeTo(Description description) {
                description.appendText("winner to be " + winner);
            }

            @Override
            protected boolean matchesSafely(Player winningPlayer, Description mismatchDescription) {
                winner = new Winner(winningPlayer);
                GameResult firstResult = winningPlayer.playAgainst(player);
                GameResult secondResult = player.playAgainst(winningPlayer);

                if (!firstResult.equals(winner)) {
                    mismatchDescription.appendText("was " + firstResult);
                    return false;
                }
                if (!secondResult.equals(winner)) {
                    mismatchDescription.appendText("was " + secondResult);
                    return false;
                }
                return true;
            }

        };
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
