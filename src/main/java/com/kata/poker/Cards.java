package com.kata.poker;

import java.util.*;

import static java.util.Arrays.asList;
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

    public Optional<List<Card>> selectCardsWithTheSameValue(int groupSize) {
        return groupWithAtLeastSize(groupSize)
                .map(cards -> cards.subList(0, groupSize));
    }

    private Optional<List<Card>> groupWithAtLeastSize(int groupSize) {
        return groupByValue().stream()
                .filter(cards -> cards.size() >= groupSize)
                .findFirst();
    }

    private Collection<List<Card>> groupByValue() {
        return cards.stream()
                .collect(groupingBy(c -> c.value))
                .values();
    }

    Card highestCard() {
        return cards.stream().max(Card::compareTo).get();
    }

    Cards allExcept(Card... cardsToExclude) {
        List<Card> remainingCards = cards.stream()
                .filter(card -> !asList(cardsToExclude).contains(card))
                .collect(toList());
        return new Cards(remainingCards);
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

    public int size() {
        return cards.size();
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

    @Override
    public String toString() {
        return cards.toString();
    }
}
