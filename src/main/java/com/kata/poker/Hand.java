package com.kata.poker;

import java.util.List;
import java.util.Optional;

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
        return selectTwoCardsWithTheSameValue().isPresent();
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

    Optional<TwoCards> selectTwoCardsWithTheSameValue() {
        List<Card> twoCards = cards.selectTwoCardsWithTheSameValue();
        if (twoCards.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(new TwoCards(twoCards.get(0), twoCards.get(1)));
    }
}
