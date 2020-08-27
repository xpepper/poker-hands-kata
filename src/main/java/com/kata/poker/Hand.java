package com.kata.poker;

import java.util.List;

import static com.kata.poker.Outcome.Lose;
import static com.kata.poker.Outcome.Win;
import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;

public class Hand {

    private final List<Card> cards;
    private final PairRule pairRule = new PairRule();

    public Hand(Card first, Card second) {
        this.cards = sortedListOf(first, second);
    }

    public Outcome playAgainst(Hand other) {
        if (rank().higherThan(other.rank())) {
            return Win;
        }
        if (rank().lowerThan(other.rank())) {
            return Lose;
        }
        return highestCard().playAgainst(other.highestCard());
    }

    public Rank rank() {
        if (hasStraightFlush()) {
            return Rank.straightFlush(highestCard());
        }
        if (hasFlush()) {
            return Rank.flush(highestCard());
        }
        if (hasStraight()) {
            return Rank.straight(highestCard());
        }
        if (pairRule.canApply(this)) return pairRule.apply(this);
        return Rank.highCard(highestCard());
    }

    public Card firstCard() {
        return cards.get(0);
    }

    public Card secondCard() {
        return cards.get(1);
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
