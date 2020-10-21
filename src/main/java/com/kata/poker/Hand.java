package com.kata.poker;

import java.util.Collection;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.groupingBy;

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
        return selectGroupWithTwoCards(groupCardsByValue());
    }

    private List<Card> selectGroupWithTwoCards(Collection<List<Card>> groups) {
        return groups.stream()
                .filter(cards -> cards.size() == 2)
                .findFirst()
                .orElse(emptyList());
    }

    private Collection<List<Card>> groupCardsByValue() {
        return cards.stream()
                .collect(groupingBy(c -> c.value))
                .values();
    }

    private List<Card> sortedListOf(List<Card> cards) {
        cards.sort(Card::compareTo);
        return cards;
    }
}
