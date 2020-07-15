package com.kata.poker;

public class PlayerParser {
    private final PokerHandParser pokerHandParser = new PokerHandParser();

    Player parse(String rawPlayer) {
        String name = rawPlayer.split(":")[0];
        String rawPokerHand = rawPlayer.split(": ")[1];
        PokerHand pokerHand = pokerHandParser.parse(rawPokerHand);
        return new Player(name, pokerHand);
    }
}