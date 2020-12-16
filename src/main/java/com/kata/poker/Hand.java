package com.kata.poker;

import java.util.Optional;

import static java.util.Arrays.asList;

public class Hand {

    public class FourCardsExpectedException extends RuntimeException {
    }

    private final Cards cards;

    public Hand(Card... cards) {
        if (cards.length != 4) {
            throw new FourCardsExpectedException();
        }
        this.cards = new Cards(asList(cards));
    }

    public Card highestCard() {
        return cards.highestCard();
    }

    public boolean hasAllCardsWithConsecutiveValues() {
        return cards.hasAllConsecutiveValues();
    }

    public boolean hasAllCardsWithTheSameSuit() {
        return cards.allSuits().size() == 1;
    }

    public boolean hasTwoCardsWithTheSameValue() {
        return selectTwoCardsWithTheSameValue().isPresent();
    }

    public boolean hasThreeCardsWithTheSameValue() {
        return selectThreeCardsWithTheSameValue().isPresent();
    }

    public Cards allCardsExcept(Card... cardsToExclude) {
        return cards.allExcept(cardsToExclude);
    }

    public Optional<TwoCards> selectTwoCardsWithTheSameValue() {
        return cards.selectCardsWithTheSameValue(2)
                .map(cards -> new TwoCards(cards.get(0), cards.get(1)));
    }

    public Optional<ThreeCards> selectThreeCardsWithTheSameValue() {
        return cards.selectCardsWithTheSameValue(3)
                .map(cards -> new ThreeCards(cards.get(0), cards.get(1), cards.get(2)));
    }
}
