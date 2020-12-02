package com.kata.poker;

import java.util.*;

import static java.util.Arrays.asList;

public class Hand {

    private final Cards cards;

    public Hand(Card... cards) {
        this.cards = new Cards(asList(cards));
    }

    public Card highestCard() {
        return cards.highestCard();
    }

    boolean hasAllCardsWithConsecutiveValues() {
        return cards.hasAllConsecutiveValues();
    }

    boolean hasAllCardsWithTheSameSuit() {
        return cards.allSuits().size() == 1;
    }

    boolean hasTwoCardsWithTheSameValue() {
        return !selectTwoCardsWithTheSameValue2().isEmpty();
    }

    List<Card> selectTwoCardsWithTheSameValue2() {
        return cards.selectTwoCardsWithTheSameValue();
    }

    public boolean hasThreeCardsWithTheSameValue() {
        return !selectThreeCardsWithTheSameValue().isEmpty();
    }

    public List<Card> selectThreeCardsWithTheSameValue() {
        return cards.selectThreeCardsWithTheSameValue();
    }

    public Cards allCardsExcept(Card... cardsToExclude) {
        return cards.allExcept(cardsToExclude);
    }

    TwoCards selectTwoCardsWithTheSameValue() {
        List<Card> cards = selectTwoCardsWithTheSameValue2();
        return new TwoCards(cards);
    }
}
