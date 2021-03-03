package com.kata.poker;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;
import org.junit.Test;

import static com.kata.poker.Card.Suit.*;
import static com.kata.poker.CardBuilder.*;
import static com.kata.poker.GameResult.tie;
import static org.junit.Assert.assertThat;

public class GameTest {

    @Test
    public void highest_card_wins_when_both_hands_have_a_high_card() {
        Player winningPlayer = aPlayerWithHand(sevenOf(Diamonds), fiveOf(Hearts), threeOf(Diamonds), twoOf(Hearts));
        Player otherPlayer = aPlayerWithHand(fiveOf(Diamonds), fourOf(Hearts), twoOf(Clubs), sixOf(Hearts));

        assertThat(winningPlayer, winsAgainst(otherPlayer));
    }

    @Test
    public void two_hands_with_the_same_high_card_are_tie() {
        Player player = aPlayerWithHand(sevenOf(Hearts), fourOf(Diamonds), twoOf(Clubs), threeOf(Clubs));
        Player otherPlayer = aPlayerWithHand(threeOf(Hearts), sevenOf(Diamonds), fiveOf(Clubs), sixOf(Hearts));

        assertThat(player, isTieWith(otherPlayer));
    }

    @Test
    public void a_pair_always_wins_against_a_high_card() {
        Player playerWithPair = aPlayerWithHand(threeOf(Diamonds), threeOf(Hearts), twoOf(Clubs), sixOf(Hearts));
        Player playerWithHighCard = aPlayerWithHand(fiveOf(Spades), threeOf(Clubs), twoOf(Spades), sevenOf(Clubs));

        assertThat(playerWithPair, winsAgainst(playerWithHighCard));
    }

    @Test
    public void a_pair_with_highest_cards_wins_against_another_pair() {
        Player winningPlayer = aPlayerWithHand(fiveOf(Spades), fiveOf(Spades), twoOf(Clubs), threeOf(Hearts));
        Player otherPlayer = aPlayerWithHand(fourOf(Diamonds), fourOf(Hearts), twoOf(Spades), threeOf(Clubs));

        assertThat(winningPlayer, winsAgainst(otherPlayer));
    }

    @Test
    public void two_hands_with_the_same_pair_are_tie_when_they_have_the_same_kicker() {
        Player player = aPlayerWithHand(fiveOf(Spades), fiveOf(Diamonds), twoOf(Clubs), threeOf(Hearts));
        Player otherPlayer = aPlayerWithHand(fiveOf(Clubs), fiveOf(Hearts), twoOf(Spades), threeOf(Clubs));

        assertThat(player, isTieWith(otherPlayer));
    }

    @Test
    public void when_two_hands_have_the_same_pair_then_the_hand_with_the_highest_kicker_wins() {
        Player winningPlayer = aPlayerWithHand(twoOf(Spades), twoOf(Hearts), sevenOf(Diamonds), fiveOf(Clubs));
        Player otherPlayer = aPlayerWithHand(twoOf(Diamonds), twoOf(Clubs), sixOf(Diamonds), fiveOf(Diamonds));

        assertThat(winningPlayer, winsAgainst(otherPlayer));
    }

    @Test
    public void two_pair_always_wins_against_a_high_card() {
        Player playerWithTwoPair = aPlayerWithHand(threeOf(Diamonds), threeOf(Hearts), twoOf(Clubs), twoOf(Hearts));
        Player playerWithHighCard = aPlayerWithHand(fiveOf(Spades), threeOf(Clubs), twoOf(Spades), sevenOf(Clubs));

        assertThat(playerWithTwoPair, winsAgainst(playerWithHighCard));
    }

    @Test
    public void two_pair_always_wins_against_a_pair() {
        Player playerWithTwoPair = aPlayerWithHand(threeOf(Diamonds), threeOf(Hearts), twoOf(Clubs), twoOf(Hearts));
        Player playerWithPair = aPlayerWithHand(fiveOf(Spades), threeOf(Clubs), sevenOf(Spades), sevenOf(Clubs));

        assertThat(playerWithTwoPair, winsAgainst(playerWithPair));
    }

    @Test
    public void two_pair_with_highest_cards_wins_against_another_two_pair() {
        Player winningPlayer = aPlayerWithHand(fourOf(Hearts), fourOf(Diamonds), threeOf(Hearts), threeOf(Diamonds));
        Player otherPlayer = aPlayerWithHand(twoOf(Clubs), twoOf(Spades), threeOf(Clubs), threeOf(Spades));

        assertThat(winningPlayer, winsAgainst(otherPlayer));
    }

    @Test
    public void two_hands_with_the_same_two_pair_are_tie() {
        Player player = aPlayerWithHand(twoOf(Hearts), twoOf(Diamonds), threeOf(Hearts), threeOf(Diamonds));
        Player otherPlayer = aPlayerWithHand(twoOf(Clubs), twoOf(Spades), threeOf(Clubs), threeOf(Spades));

        assertThat(player, isTieWith(otherPlayer));
    }

    @Test
    public void a_three_of_a_kind_wins_against_a_high_card() {
        Player playerWithThreeOfKind = aPlayerWithHand(fourOf(Hearts), fourOf(Diamonds), fourOf(Clubs), threeOf(Hearts));
        Player playerWithHighCard = aPlayerWithHand(threeOf(Diamonds), fiveOf(Spades), aceOf(Clubs), fourOf(Spades));

        assertThat(playerWithThreeOfKind, winsAgainst(playerWithHighCard));
    }

    @Test
    public void a_three_of_a_kind_wins_against_a_pair() {
        Player playerWithThreeOfKind = aPlayerWithHand(fourOf(Hearts), fourOf(Diamonds), fourOf(Clubs), threeOf(Hearts));
        Player playerWithPair = aPlayerWithHand(sevenOf(Clubs), sevenOf(Spades), fiveOf(Clubs), fourOf(Spades));

        assertThat(playerWithThreeOfKind, winsAgainst(playerWithPair));
    }

    @Test
    public void a_three_of_a_kind_wins_against_a_two_pair() {
        Player playerWithThreeOfKind = aPlayerWithHand(fourOf(Hearts), fourOf(Diamonds), fourOf(Clubs), threeOf(Hearts));
        Player playerWithTwoPair = aPlayerWithHand(fiveOf(Clubs), fiveOf(Spades), threeOf(Clubs), threeOf(Spades));

        assertThat(playerWithThreeOfKind, winsAgainst(playerWithTwoPair));
    }

    @Test
    public void a_three_of_a_kind_with_highest_cards_wins_against_another_three_of_a_kind() {
        Player winningPlayer = aPlayerWithHand(fourOf(Hearts), fourOf(Diamonds), fourOf(Clubs), threeOf(Hearts));
        Player otherPlayer = aPlayerWithHand(twoOf(Hearts), twoOf(Spades), twoOf(Clubs), threeOf(Spades));

        assertThat(winningPlayer, winsAgainst(otherPlayer));
    }

    @Test
    public void a_straight_always_wins_against_a_high_card() {
        Player playerWithStraight = aPlayerWithHand(fourOf(Hearts), threeOf(Diamonds), twoOf(Clubs), fiveOf(Hearts));
        Player playerWithHighCard = aPlayerWithHand(threeOf(Diamonds), fiveOf(Spades), aceOf(Clubs), fourOf(Diamonds));

        assertThat(playerWithStraight, winsAgainst(playerWithHighCard));
    }

    @Test
    public void a_straight_always_wins_against_a_pair() {
        Player playerWithStraight = aPlayerWithHand(fourOf(Hearts), threeOf(Diamonds), twoOf(Diamonds), fiveOf(Hearts));
        Player playerWithPair = aPlayerWithHand(sevenOf(Clubs), sevenOf(Spades), fiveOf(Clubs), twoOf(Spades));

        assertThat(playerWithStraight, winsAgainst(playerWithPair));
    }

    @Test
    public void a_straight_always_wins_against_a_two_pair() {
        Player playerWithStraight = aPlayerWithHand(fourOf(Hearts), threeOf(Diamonds), twoOf(Diamonds), fiveOf(Hearts));
        Player playerWithTwoPair = aPlayerWithHand(fiveOf(Clubs), fiveOf(Spades), threeOf(Clubs), threeOf(Spades));

        assertThat(playerWithStraight, winsAgainst(playerWithTwoPair));
    }

    @Test
    public void a_straight_always_wins_against_a_three_of_kind() {
        Player playerWithStraight = aPlayerWithHand(fourOf(Hearts), threeOf(Diamonds), twoOf(Diamonds), fiveOf(Hearts));
        Player playerWithThreeOfKind = aPlayerWithHand(sevenOf(Clubs), sevenOf(Spades), sevenOf(Diamonds), twoOf(Spades));

        assertThat(playerWithStraight, winsAgainst(playerWithThreeOfKind));
    }

    @Test
    public void two_hands_with_the_same_straight_are_tie() {
        Player player = aPlayerWithHand(fiveOf(Spades), fourOf(Hearts), threeOf(Clubs), twoOf(Hearts));
        Player otherPlayer = aPlayerWithHand(fourOf(Hearts), fiveOf(Clubs), threeOf(Spades), twoOf(Spades));

        assertThat(player, isTieWith(otherPlayer));
    }

    @Test
    public void highest_card_wins_when_both_hands_have_a_straight() {
        Player winningPlayer = aPlayerWithHand(fourOf(Hearts), fiveOf(Spades), sixOf(Diamonds), threeOf(Hearts));
        Player otherPlayer = aPlayerWithHand(threeOf(Diamonds), fourOf(Clubs), fiveOf(Diamonds), twoOf(Diamonds));

        assertThat(winningPlayer, winsAgainst(otherPlayer));
    }

    @Test
    public void a_flush_always_wins_against_a_high_card() {
        Player playerWithFlush = aPlayerWithHand(threeOf(Diamonds), fiveOf(Diamonds), sevenOf(Diamonds), twoOf(Diamonds));
        Player playerWithHighCard = aPlayerWithHand(threeOf(Hearts), sevenOf(Clubs), aceOf(Clubs), twoOf(Spades));

        assertThat(playerWithFlush, winsAgainst(playerWithHighCard));
    }

    @Test
    public void a_flush_always_wins_against_a_pair() {
        Player playerWithFlush = aPlayerWithHand(threeOf(Diamonds), fiveOf(Diamonds), sevenOf(Diamonds), twoOf(Diamonds));
        Player playerWithPair = aPlayerWithHand(threeOf(Hearts), threeOf(Spades), aceOf(Clubs), twoOf(Spades));

        assertThat(playerWithFlush, winsAgainst(playerWithPair));
    }

    @Test
    public void a_flush_always_wins_against_a_two_pair() {
        Player playerWithFlush = aPlayerWithHand(threeOf(Diamonds), fiveOf(Diamonds), sevenOf(Diamonds), twoOf(Diamonds));
        Player playerWithTwoPair = aPlayerWithHand(fiveOf(Clubs), fiveOf(Spades), threeOf(Clubs), threeOf(Spades));

        assertThat(playerWithFlush, winsAgainst(playerWithTwoPair));
    }

    @Test
    public void a_flush_always_wins_against_a_three_of_a_kind() {
        Player playerWithFlush = aPlayerWithHand(threeOf(Diamonds), fiveOf(Diamonds), sevenOf(Diamonds), twoOf(Diamonds));
        Player playerWithThreeOfKind = aPlayerWithHand(threeOf(Hearts), threeOf(Spades), threeOf(Clubs), twoOf(Spades));

        assertThat(playerWithFlush, winsAgainst(playerWithThreeOfKind));
    }

    @Test
    public void a_flush_always_wins_against_a_straight() {
        Player playerWithFlush = aPlayerWithHand(twoOf(Diamonds), threeOf(Diamonds), fiveOf(Diamonds), twoOf(Diamonds));
        Player playerWithStraight = aPlayerWithHand(threeOf(Hearts), fourOf(Spades), fiveOf(Clubs), twoOf(Spades));

        assertThat(playerWithFlush, winsAgainst(playerWithStraight));
    }

    @Test
    public void two_hands_with_the_same_flush_are_tie() {
        Player player = aPlayerWithHand(fourOf(Spades), sevenOf(Spades), aceOf(Spades), twoOf(Spades));
        Player otherPlayer = aPlayerWithHand(fourOf(Diamonds), sevenOf(Diamonds), aceOf(Diamonds), twoOf(Diamonds));

        assertThat(player, isTieWith(otherPlayer));
    }

    @Test
    public void highest_card_wins_when_both_hands_have_a_flush() {
        Player winningPlayer = aPlayerWithHand(fourOf(Spades), sevenOf(Spades), aceOf(Spades), twoOf(Spades));
        Player otherPlayer = aPlayerWithHand(threeOf(Diamonds), fiveOf(Diamonds), sevenOf(Diamonds), twoOf(Diamonds));

        assertThat(winningPlayer, winsAgainst(otherPlayer));
    }

    @Test
    public void a_four_of_a_kind_wins_against_a_high_card() {
        Player playerWithFourOfKind = aPlayerWithHand(fourOf(Hearts), fourOf(Diamonds), fourOf(Clubs), fourOf(Spades));
        Player playerWithHighCard = aPlayerWithHand(threeOf(Diamonds), fiveOf(Spades), aceOf(Clubs), twoOf(Hearts));

        assertThat(playerWithFourOfKind, winsAgainst(playerWithHighCard));
    }

    @Test
    public void a_four_of_a_kind_wins_against_a_pair() {
        Player playerWithFourOfKind = aPlayerWithHand(fourOf(Hearts), fourOf(Diamonds), fourOf(Clubs), fourOf(Spades));
        Player playerWithPair = aPlayerWithHand(threeOf(Diamonds), threeOf(Hearts), fiveOf(Spades), aceOf(Clubs));

        assertThat(playerWithFourOfKind, winsAgainst(playerWithPair));
    }

    @Test
    public void a_four_of_a_kind_wins_against_a_two_pair() {
        Player playerWithFourOfKind = aPlayerWithHand(fourOf(Hearts), fourOf(Diamonds), fourOf(Clubs), fourOf(Spades));
        Player playerWithTwoPair = aPlayerWithHand(threeOf(Diamonds), threeOf(Hearts), fiveOf(Spades), fiveOf(Clubs));

        assertThat(playerWithFourOfKind, winsAgainst(playerWithTwoPair));
    }

    @Test
    public void a_four_of_a_kind_wins_against_a_three_of_a_kind() {
        Player playerWithFourOfKind = aPlayerWithHand(fourOf(Hearts), fourOf(Diamonds), fourOf(Clubs), fourOf(Spades));
        Player playerWithThreeOfKind = aPlayerWithHand(threeOf(Diamonds), fiveOf(Hearts), fiveOf(Spades), fiveOf(Clubs));

        assertThat(playerWithFourOfKind, winsAgainst(playerWithThreeOfKind));
    }

    @Test
    public void a_straight_flush_always_wins_against_a_high_card() {
        Player playerWithStraightFlush = aPlayerWithHand(threeOf(Diamonds), fourOf(Diamonds), twoOf(Diamonds), fiveOf(Diamonds));
        Player playerWithHighCard = aPlayerWithHand(fourOf(Clubs), sevenOf(Hearts), aceOf(Diamonds), twoOf(Spades));

        assertThat(playerWithStraightFlush, winsAgainst(playerWithHighCard));
    }

    @Test
    public void a_straight_flush_always_wins_against_a_pair() {
        Player playerWithStraightFlush = aPlayerWithHand(twoOf(Diamonds), threeOf(Diamonds), fourOf(Diamonds), fiveOf(Diamonds));
        Player playerWithPair = aPlayerWithHand(fourOf(Clubs), fourOf(Hearts), sevenOf(Hearts), fiveOf(Spades));

        assertThat(playerWithStraightFlush, winsAgainst(playerWithPair));
    }

    @Test
    public void a_straight_flush_always_wins_against_a_two_pair() {
        Player playerWithStraightFlush = aPlayerWithHand(twoOf(Diamonds), threeOf(Diamonds), fourOf(Diamonds), fiveOf(Diamonds));
        Player playerWithTwoPair = aPlayerWithHand(fiveOf(Clubs), fiveOf(Spades), threeOf(Clubs), threeOf(Spades));

        assertThat(playerWithStraightFlush, winsAgainst(playerWithTwoPair));
    }

    @Test
    public void a_straight_flush_always_wins_against_a_three_of_kind() {
        Player playerWithStraightFlush = aPlayerWithHand(twoOf(Diamonds), threeOf(Diamonds), fourOf(Diamonds), fiveOf(Diamonds));
        Player playerWithThreeOfKind = aPlayerWithHand(fourOf(Clubs), fourOf(Hearts), fourOf(Spades), fiveOf(Spades));

        assertThat(playerWithStraightFlush, winsAgainst(playerWithThreeOfKind));
    }

    @Test
    public void a_straight_flush_always_wins_against_a_straight() {
        Player playerWithStraightFlush = aPlayerWithHand(twoOf(Diamonds), threeOf(Diamonds), fourOf(Diamonds), fiveOf(Diamonds));
        Player playerWithStraight = aPlayerWithHand(fourOf(Clubs), fiveOf(Diamonds), sixOf(Hearts), threeOf(Hearts));

        assertThat(playerWithStraightFlush, winsAgainst(playerWithStraight));
    }

    @Test
    public void a_straight_flush_always_wins_against_a_flush() {
        Player playerWithStraightFlush = aPlayerWithHand(twoOf(Diamonds), threeOf(Diamonds), fourOf(Diamonds), fiveOf(Diamonds));
        Player playerWithFlush = aPlayerWithHand(threeOf(Clubs), fiveOf(Clubs), sevenOf(Clubs), twoOf(Clubs));

        assertThat(playerWithStraightFlush, winsAgainst(playerWithFlush));
    }

    @Test
    public void two_hands_with_the_same_straight_flush_are_tie() {
        Player player = aPlayerWithHand(threeOf(Diamonds), fourOf(Diamonds), twoOf(Diamonds), fiveOf(Diamonds));
        Player otherPlayer = aPlayerWithHand(threeOf(Spades), fourOf(Spades), twoOf(Spades), fiveOf(Spades));

        assertThat(player, isTieWith(otherPlayer));
    }

    @Test
    public void highest_card_wins_when_both_hands_have_a_straight_flush() {
        Player winningPlayer = aPlayerWithHand(fourOf(Spades), fiveOf(Spades), threeOf(Spades), sixOf(Spades));
        Player otherPlayer = aPlayerWithHand(threeOf(Diamonds), fourOf(Diamonds), twoOf(Diamonds), fiveOf(Diamonds));

        assertThat(winningPlayer, winsAgainst(otherPlayer));
    }

    private Player aPlayerWithHand(Card... cards) {
        return new Player("a name", new Hand(cards[0], cards[1], cards[2], cards[3]));
    }

    private Matcher<Player> winsAgainst(Player player) {
        return new TypeSafeDiagnosingMatcher<Player>() {
            private final Game game = new Game(new GameRules());
            private Winner winner;

            @Override
            public void describeTo(Description description) {
                description.appendText("winner to be " + winner);
            }

            @Override
            protected boolean matchesSafely(Player winningPlayer, Description mismatchDescription) {
                winner = new Winner(winningPlayer);
                GameResult firstResult = game.play(winningPlayer, player);
                GameResult secondResult = game.play(player, winningPlayer);

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

    private Matcher<Player> isTieWith(Player otherPlayer) {
        return new TypeSafeDiagnosingMatcher<Player>() {
            private final Game game = new Game(new GameRules());

            @Override
            public void describeTo(Description description) {
                description.appendText("result to be a tie");
            }

            @Override
            protected boolean matchesSafely(Player player, Description mismatchDescription) {
                GameResult result = game.play(player, otherPlayer);

                if (!result.equals(tie)) {
                    mismatchDescription.appendText("was " + result);
                    return false;
                }

                return true;
            }
        };
    }

}
