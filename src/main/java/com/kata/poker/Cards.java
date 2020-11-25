package com.kata.poker;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

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

    Collection<List<Card>> groupCardsByValue() {
        return cards.stream()
                .collect(groupingBy(c -> c.value))
                .values();
    }

    Optional<List<Card>> selectGroupWithAtLeastThreeCards(Collection<List<Card>> groups) {
        return groups.stream()
                .filter(cards -> cards.size() >= 3)
                .findFirst();
    }
}
