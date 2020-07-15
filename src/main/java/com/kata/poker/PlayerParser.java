package com.kata.poker;

public class PlayerParser {
    private final HandParser handParser = new HandParser();

    Player parse(String rawPlayer) {
        String name = rawPlayer.split(":")[0];
        String rawPokerHand = rawPlayer.split(": ")[1];
        Hand hand = handParser.parse(rawPokerHand);
        return new Player(name, hand);
    }
}