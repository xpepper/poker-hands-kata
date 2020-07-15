package com.kata.poker;

public class HandParser {
    private final CardParser cardParser = new CardParser();

    Hand parse(String rawPokerHand) {
        String[] rawCards = rawPokerHand.split(" ");
        Card firstCard = cardParser.parse(rawCards[0]);
        Card secondCard = cardParser.parse(rawCards[1]);
        return new Hand(firstCard, secondCard);
    }
}