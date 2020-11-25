package com.kata.poker;

import java.util.List;
import java.util.Set;

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
}
