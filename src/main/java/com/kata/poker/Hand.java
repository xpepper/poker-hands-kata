package com.kata.poker;

import java.util.*;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.*;

public class Hand {

    private final List<Card> cards;
    private final Cards cards1;

    public Hand(Card... cards) {
        this.cards = asList(cards);
        cards1 = new Cards(asList(cards));
    }

    public Card highestCard() {
        return cards.stream().max(Card::compareTo).get();
    }

    boolean hasAllCardsWithConsecutiveValues() {
        List<Card> sortedCards = sortedListOf(cards);

        for (int cardIndex = 1; cardIndex < sortedCards.size(); cardIndex++) {
            if (!sortedCards.get(cardIndex - 1).comesBefore(sortedCards.get(cardIndex))) {
                return false;
            }
        }

        return true;
    }

    boolean hasAllCardsWithTheSameSuit() {
        return cards1.allSuits().size() == 1;
    }

    boolean hasTwoCardsWithTheSameValue() {
        return !selectTwoCardsWithTheSameValue().isEmpty();
    }

    List<Card> selectTwoCardsWithTheSameValue() {
        return cards1.selectGroupWithAtLeastTwoCards(cards1.groupCardsByValue())
                .map(cards -> cards.subList(0, 2))
                .orElse(emptyList());
    }

    private List<Card> sortedListOf(List<Card> cards) {
        List<Card> sortedList = new ArrayList<>(cards);
        sortedList.sort(Card::compareTo);
        return sortedList;
    }

    public List<Card> allExcept(List<Card> cardsToExclude) {
        return cards.stream()
                .filter(card -> !cardsToExclude.contains(card))
                .collect(toList());
    }

    public boolean hasThreeCardsWithTheSameValue() {
        return !selectThreeCardsWithTheSameValue().isEmpty();
    }

    public List<Card> selectThreeCardsWithTheSameValue() {
        return cards1.selectGroupWithAtLeastThreeCards(cards1.groupCardsByValue())
                .map(cards -> cards.subList(0, 3))
                .orElse(emptyList());
    }

}
