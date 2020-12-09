package com.kata.poker;

import java.util.*;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.*;

public class Cards {
    private final List<Card> cards;

    public Cards(List<Card> cards) {
        this.cards = cards;
    }

    public Set<Card.Suit> allSuits() {
        return cards.stream()
                .map(c -> c.suit)
                .collect(toSet());
    }

    List<Card> selectTwoCardsWithTheSameValue() {
        return groupWithAtLeastSize(2)
                .map(cards -> cards.subList(0, 2))
                .orElse(emptyList());
    }

    List<Card> selectThreeCardsWithTheSameValue() {
        return groupWithAtLeastSize(3)
                .map(cards -> cards.subList(0, 3))
                .orElse(emptyList());
    }

    private Optional<List<Card>> groupWithAtLeastSize(int groupSize) {
        return groups().stream()
                .filter(cards -> cards.size() >= groupSize)
                .findFirst();
    }

    private Collection<List<Card>> groups() {
        return cards.stream()
                .collect(groupingBy(c -> c.value))
                .values();
    }

    Card selectHighestRankingCard() {
        return cards.stream().max(Card::compareTo).get();
    }

    Cards allExcept(Card... cardsToExclude) {
        List<Card> remainingCards = cards.stream()
                .filter(card -> !asList(cardsToExclude).contains(card))
                .collect(toList());
        return new Cards(remainingCards);
    }

    Card highestCard() {
        return cards.stream().max(Card::compareTo).get();
    }

    boolean hasAllConsecutiveValues() {
        List<Card> sortedList = new ArrayList<>(cards);
        sortedList.sort(Card::compareTo);

        for (int cardIndex = 1; cardIndex < sortedList.size(); cardIndex++) {
            if (!sortedList.get(cardIndex - 1).comesBefore(sortedList.get(cardIndex))) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cards otherCards = (Cards) o;
        return Objects.equals(cards, otherCards.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cards);
    }
}
