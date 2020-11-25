package com.kata.poker;

import java.util.*;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.*;

public class Hand {

    private final List<Card> cards;

    public Hand(Card... cards) {
        this.cards = asList(cards);
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
        return selectAllSuits().size() == 1;
    }

    boolean hasTwoCardsWithTheSameValue() {
        return !selectTwoCardsWithTheSameValue().isEmpty();
    }

    List<Card> selectTwoCardsWithTheSameValue() {
        return selectGroupWithAtLeastTwoCards(groupCardsByValue())
                .map(cards -> cards.subList(0, 2))
                .orElse(emptyList());
    }

    private Set<Card.Suit> selectAllSuits() {
        return new Cards(this.cards).allSuits();
    }

    private Optional<List<Card>> selectGroupWithAtLeastTwoCards(Collection<List<Card>> groups) {
        return groups.stream()
                .filter(cards -> cards.size() >= 2)
                .findFirst();
    }

    private Collection<List<Card>> groupCardsByValue() {
        return cards.stream()
                .collect(groupingBy(c -> c.value))
                .values();
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
        return selectGroupWithAtLeastThreeCards(groupCardsByValue())
                .map(cards -> cards.subList(0, 3))
                .orElse(emptyList());
    }

    private Optional<List<Card>> selectGroupWithAtLeastThreeCards(Collection<List<Card>> groups) {
        return groups.stream()
                .filter(cards -> cards.size() >= 3)
                .findFirst();
    }

}
