package com.kata.poker;

import java.util.HashMap;
import java.util.Map;

public class Game {
    private static final Map<Character, Card.Value> CHAR_TO_VALUE = new HashMap<Character, Card.Value>() {{
        put('2', Card.Value.Two);
        put('5', Card.Value.Five);
    }};

    private static final Map<Character, Card.Suit> CHAR_TO_SUIT = new HashMap<Character, Card.Suit>() {{
        put('C', Card.Suit.Clubs);
    }};

    private String input;

    public Game(String input) {
        this.input = input;
    }

    public String play() {
        String secondPlayerInput = input.split("  ")[1];
        String playerName = secondPlayerInput.split(":")[0];
        String[] rawPlayerHand = secondPlayerInput.split(": ")[1].split(" ");

        Card firstCard = parseCard(rawPlayerHand[0]);
        Card secondCard = parseCard(rawPlayerHand[1]);

        Winner winner = new Winner(new Player(playerName, new PokerHand(firstCard, secondCard)));
        return new GameResultPrinter().print(winner);
    }

    private Card parseCard(String rawCard) {
        char rawCardValue = rawCard.charAt(0);
        Card.Value value = CHAR_TO_VALUE.get(rawCardValue);

        Character rawCardSuit = rawCard.charAt(1);
        Card.Suit suit = CHAR_TO_SUIT.get(rawCardSuit);

        return new Card(value, suit);
    }
}
