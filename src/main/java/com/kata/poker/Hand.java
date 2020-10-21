package com.kata.poker;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;

public class Hand {

    private final List<Card> cards;

    public Hand(Card... cards) {
        this.cards = sortedListOf(asList(cards));
    }

    public Card firstCard() {
        return cards.get(0);
    }

    public Card secondCard() {
        return cards.get(1);
    }

    public Card highestCard() {
        return cards.get(cards.size() - 1);
    }

    boolean hasTwoCardsWithTheSameValue() {
        return !selectTwoCardsWithTheSameValue().isEmpty();
    }

    List<Card> selectTwoCardsWithTheSameValue() {
        Card first;
        Card second;

        if (firstCard().hasSameValueOf(secondCard())) {
            first = firstCard();
            second = secondCard();
        } else if (firstCard().hasSameValueOf(highestCard())) {
            first = firstCard();
            second = highestCard();
        } else if (secondCard().hasSameValueOf(highestCard())) {
            first = secondCard();
            second = highestCard();
        } else {
            return emptyList();
        }
        return asList(first, second);
    }

    private List<Card> sortedListOf(List<Card> cards) {
        cards.sort(Card::compareTo);
        return cards;
    }
}
