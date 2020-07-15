package com.kata.poker;

public class PokerHandParser {
    private final CardParser cardParser = new CardParser();

    PokerHand parse(String rawPokerHand) {
        String[] rawCards = rawPokerHand.split(" ");
        Card firstCard = cardParser.parse(rawCards[0]);
        Card secondCard = cardParser.parse(rawCards[1]);
        return new PokerHand(firstCard, secondCard);
    }
}