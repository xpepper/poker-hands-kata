package com.kata.poker;

import java.util.*;

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
        return selectGroupWithAtLeastTwoCards(groupCardsByValue())
                .map(cards -> cards.subList(0, 2))
                .orElse(emptyList());
    }

    List<Card> selectThreeCardsWithTheSameValue() {
        return selectGroupWithAtLeastThreeCards(groupCardsByValue())
                .map(cards -> cards.subList(0, 3))
                .orElse(emptyList());
    }

    Optional<List<Card>> selectGroupWithAtLeastTwoCards(Collection<List<Card>> groups) {
        return groups.stream()
                .filter(cards -> cards.size() >= 2)
                .findFirst();
    }

    Optional<List<Card>> selectGroupWithAtLeastThreeCards(Collection<List<Card>> groups) {
        return groups.stream()
                .filter(cards -> cards.size() >= 3)
                .findFirst();
    }

    Collection<List<Card>> groupCardsByValue() {
        return cards.stream()
                .collect(groupingBy(c -> c.value))
                .values();
    }

    Card selectHighestRankingCard() {
        return cards.stream().max(Card::compareTo).get();
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

    Cards allExcept(Cards cardsToExclude) {
        List<Card> remainingCards = this.cards.stream()
                .filter(card -> !cardsToExclude.cards.contains(card))
                .collect(toList());
        return new Cards(remainingCards);
    }
}
