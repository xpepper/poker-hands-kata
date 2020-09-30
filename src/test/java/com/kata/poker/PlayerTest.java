package com.kata.poker;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;
import org.junit.Test;

import static com.kata.poker.Card.Suit.*;
import static com.kata.poker.GameResult.tie;
import static com.kata.poker.HandTest.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class PlayerTest {

    @Test
    public void highest_card_wins_when_both_hands_have_a_high_card() {
        Player winningPlayer = aPlayerWithHand(sevenOf(Diamonds), fiveOf(Hearts));
        Player otherPlayer = aPlayerWithHand(fiveOf(Diamonds), threeOf(Hearts));

        assertThat(winningPlayer, winsAgainst(otherPlayer));
    }

    @Test
    public void two_hands_with_the_same_high_card_are_tie() {
        Player player = aPlayerWithHand(sevenOf(Hearts), fourOf(Diamonds));
        Player otherPlayer = aPlayerWithHand(threeOf(Hearts), sevenOf(Diamonds));

        assertEquals(tie, player.playAgainst(otherPlayer));
        assertEquals(tie, otherPlayer.playAgainst(player));
    }

    @Test
    public void highest_card_wins_when_both_hands_have_a_pair() {
        Player winningPlayer = aPlayerWithHand(fiveOf(Spades), fiveOf(Spades));
        Player otherPlayer = aPlayerWithHand(fourOf(Diamonds), fourOf(Hearts));

        assertThat(winningPlayer, winsAgainst(otherPlayer));
    }

    @Test
    public void two_hands_with_the_same_pair_are_tie() {
        Player player = aPlayerWithHand(fiveOf(Spades), fiveOf(Diamonds));
        Player otherPlayer = aPlayerWithHand(fiveOf(Clubs), fiveOf(Spades));

        assertEquals(tie, player.playAgainst(otherPlayer));
        assertEquals(tie, otherPlayer.playAgainst(player));
    }

    @Test
    public void a_pair_always_wins_against_a_high_card() {
        Player playerWithPair = aPlayerWithHand(threeOf(Diamonds), threeOf(Diamonds));
        Player playerWithHighCard = aPlayerWithHand(fiveOf(Spades), threeOf(Diamonds));

        assertThat(playerWithPair, winsAgainst(playerWithHighCard));
    }

    @Test
    public void a_straight_always_wins_against_a_high_card() {
        Player playerWithStraight = aPlayerWithHand(fourOf(Hearts), threeOf(Diamonds));
        Player playerWithHighCard = aPlayerWithHand(threeOf(Diamonds), fiveOf(Spades));

        assertThat(playerWithStraight, winsAgainst(playerWithHighCard));
    }

    @Test
    public void a_straight_always_wins_against_a_pair() {
        Player playerWithStraight = aPlayerWithHand(fourOf(Hearts), threeOf(Diamonds));
        Player playerWithPair = aPlayerWithHand(sevenOf(Clubs), sevenOf(Spades));

        assertThat(playerWithStraight, winsAgainst(playerWithPair));
    }

    @Test
    public void two_hands_with_the_same_straight_are_tie() {
        Player player = aPlayerWithHand(fiveOf(Spades), fourOf(Hearts));
        Player otherPlayer = aPlayerWithHand(fourOf(Hearts), fiveOf(Spades));

        assertEquals(tie, player.playAgainst(otherPlayer));
        assertEquals(tie, otherPlayer.playAgainst(player));
    }

    @Test
    public void highest_card_wins_when_both_hands_have_a_straight() {
        Player winningPlayer = aPlayerWithHand(fourOf(Hearts), fiveOf(Spades));
        Player otherPlayer = aPlayerWithHand(threeOf(Diamonds), fourOf(Hearts));

        assertThat(winningPlayer, winsAgainst(otherPlayer));
    }

    @Test
    public void a_flush_always_wins_against_a_high_card() {
        Player playerWithFlush = aPlayerWithHand(threeOf(Diamonds), fiveOf(Diamonds));
        Player playerWithHighCard = aPlayerWithHand(threeOf(Hearts), sevenOf(Diamonds));

        assertThat(playerWithFlush, winsAgainst(playerWithHighCard));
    }

    @Test
    public void a_flush_always_wins_against_a_pair() {
        Player playerWithFlush = aPlayerWithHand(threeOf(Diamonds), fiveOf(Diamonds));
        Player playerWithPair = aPlayerWithHand(threeOf(Hearts), threeOf(Diamonds));

        assertThat(playerWithFlush, winsAgainst(playerWithPair));
    }

    @Test
    public void two_hands_with_the_same_flush_are_tie() {
        Player player = aPlayerWithHand(fourOf(Spades), sevenOf(Spades));
        Player otherPlayer = aPlayerWithHand(fourOf(Diamonds), sevenOf(Diamonds));

        assertEquals(tie, player.playAgainst(otherPlayer));
        assertEquals(tie, otherPlayer.playAgainst(player));
    }

    @Test
    public void a_flush_always_wins_against_a_straight() {
        Player playerWithFlush = aPlayerWithHand(threeOf(Diamonds), fiveOf(Diamonds));
        Player playerWithStraight = aPlayerWithHand(threeOf(Hearts), fourOf(Diamonds));

        assertThat(playerWithFlush, winsAgainst(playerWithStraight));
    }

    @Test
    public void highest_card_wins_when_both_hands_have_a_flush() {
        Player winningPlayer = aPlayerWithHand(fourOf(Spades), sevenOf(Spades));
        Player otherPlayer = aPlayerWithHand(threeOf(Diamonds), fiveOf(Diamonds));

        assertThat(winningPlayer, winsAgainst(otherPlayer));
    }

    @Test
    public void a_straight_flush_always_wins_against_a_flush() {
        Player playerWithStraightFlush = aPlayerWithHand(threeOf(Diamonds), fourOf(Diamonds));
        Player playerWithFlush = aPlayerWithHand(threeOf(Clubs), fiveOf(Clubs));

        assertThat(playerWithStraightFlush, winsAgainst(playerWithFlush));
    }

    @Test
    public void a_straight_flush_always_wins_against_a_straight() {
        Player playerWithStraightFlush = aPlayerWithHand(threeOf(Diamonds), fourOf(Diamonds));
        Player playerWithStraight = aPlayerWithHand(fourOf(Clubs), fiveOf(Diamonds));

        assertThat(playerWithStraightFlush, winsAgainst(playerWithStraight));
    }

    @Test
    public void a_straight_flush_always_wins_against_a_pair() {
        Player playerWithStraightFlush = aPlayerWithHand(threeOf(Diamonds), fourOf(Diamonds));
        Player playerWithPair = aPlayerWithHand(fourOf(Clubs), fourOf(Hearts));

        assertThat(playerWithStraightFlush, winsAgainst(playerWithPair));
    }

    @Test
    public void a_straight_flush_always_wins_against_a_high_card() {
        Player playerWithStraightFlush = aPlayerWithHand(threeOf(Diamonds), fourOf(Diamonds));
        Player playerWithHighCard = aPlayerWithHand(fourOf(Clubs), sevenOf(Hearts));

        assertThat(playerWithStraightFlush, winsAgainst(playerWithHighCard));
    }

    @Test
    public void two_hands_with_the_same_straight_flush_are_tie() {
        Player player = aPlayerWithHand(threeOf(Diamonds), fourOf(Diamonds));
        Player otherPlayer = aPlayerWithHand(threeOf(Spades), fourOf(Spades));

        assertEquals(tie, player.playAgainst(otherPlayer));
        assertEquals(tie, otherPlayer.playAgainst(player));
    }

    @Test
    public void highest_card_wins_when_both_hands_have_a_straight_flush() {
        Player winningPlayer = aPlayerWithHand(fourOf(Spades), fiveOf(Spades));
        Player otherPlayer = aPlayerWithHand(threeOf(Diamonds), fourOf(Diamonds));

        assertThat(winningPlayer, winsAgainst(otherPlayer));
    }

    private Player aPlayerWithHand(Card firstCard, Card secondCard) {
        return new Player("a name", new Hand(firstCard, secondCard));
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

}