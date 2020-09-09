package com.kata.poker;

import java.util.List;

import static com.kata.poker.Outcome.*;
import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;

public class Hand {

    private final List<Card> cards;

    public Hand(Card first, Card second) {
        this.cards = sortedListOf(first, second);
    }

    public Outcome playAgainst(Hand other) {
        GameRules gameRules = new GameRules();
        Rank rank = gameRules.evaluate(this);
        Rank otherRank = gameRules.evaluate(other);
        if (rank.higherThan(otherRank)) {
            return Win;
        }
        if (rank.lowerThan(otherRank)) {
            return Lose;
        }
        return Tie;
    }

    public Card firstCard() {
        return cards.get(0);
    }

    public Card secondCard() {
        return cards.get(1);
    }

    public Card highestCard() {
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
