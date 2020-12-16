package com.kata.poker;

import static java.util.Arrays.stream;

public class HandParser {
    private static final String CARD_SEPARATOR = " ";

    private final CardParser cardParser = new CardParser();

    Hand parse(String rawPokerHand) {
        Card[] cards = cardsFrom(rawPokerHand);
        return new Hand(cards[0], cards[1], cards[2]);
    }

    private Card[] cardsFrom(String rawPokerHand) {
        return stream(rawPokerHand.split(CARD_SEPARATOR))
                .map(cardParser::parse)
                .toArray(Card[]::new);
    }
}