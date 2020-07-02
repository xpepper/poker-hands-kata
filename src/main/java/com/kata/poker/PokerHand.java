package com.kata.poker;

import java.util.List;

import static com.kata.poker.Outcome.Lose;
import static com.kata.poker.Outcome.Win;
import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;

public class PokerHand {

    private final List<Card> cards;

    public PokerHand(Card first, Card second) {
        this.cards = sortedListOf(first, second);
    }

    public Outcome playAgainst(PokerHand other) {
        int i = rank().compareTo(other.rank());
        if (i > 0)
            return Win;
        else if (i < 0)
            return Lose;
        else
            return compareHighestCard(other);
    }

    public Rank rank() {
        if (hasStraightFlush()) {
            return Rank.StraightFlush;
        }
        if (hasFlush()) {
            return Rank.Flush;
        }
        if (hasStraight()) {
            return Rank.Straight;
        }
        if (hasPair()) {
            return Rank.Pair;
        }
        return Rank.HighCard;
    }

    private Outcome compareHighestCard(PokerHand other) {
        return highestCard().playAgainst(other.highestCard());
    }

    private boolean hasStraightFlush() {
        return hasStraight() && hasFlush();
    }

    private boolean hasFlush() {
        return cards.get(0).hasSameSuitOf(cards.get(1));
    }

    private boolean hasStraight() {
        return cards.get(0).comesBefore(cards.get(1));
    }

    private boolean hasPair() {
        return cards.get(0).hasSameValueOf(cards.get(1));
    }

    private Card highestCard() {
        return cards.get(1);
    }

    private List<Card> sortedListOf(Card first, Card second) {
        List<Card> cards = asList(first, second);
        cards.sort(this::compareCards);
        return unmodifiableList(cards);
    }

    private int compareCards(Card card, Card otherCard) {
        switch (card.playAgainst(otherCard)) {
            case Win:
                return 1;
            case Lose:
                return -1;
            default:
                return 0;
        }
    }
}
