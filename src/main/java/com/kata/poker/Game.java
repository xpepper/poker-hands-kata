package com.kata.poker;

import java.util.HashMap;
import java.util.Map;

public class Game {
    private static final Map<Character, Card.Value> CHAR_TO_VALUE = new HashMap<Character, Card.Value>() {{
        put('2', Card.Value.Two);
        put('5', Card.Value.Five);
    }};

    private String input;

    public Game(String input) {
        this.input = input;
    }

    public String play() {
        String secondPlayerInput = input.split("  ")[1];
        String playerName = secondPlayerInput.split(":")[0];
        String[] rawPlayerHand = secondPlayerInput.split(": ")[1].split(" ");

        String rawFirstCard = rawPlayerHand[0];
        char rawFirstCardValue = rawFirstCard.charAt(0);
        Card.Value firstCardValue = CHAR_TO_VALUE.get(rawFirstCardValue);
        Card firstCard = new Card(firstCardValue, Card.Suit.Spades);

        String rawSecondCard = rawPlayerHand[1];
        char rawSecondCardValue = rawSecondCard.charAt(0);
        Card.Value secondCardValue = CHAR_TO_VALUE.get(rawSecondCardValue);
        Card secondCard = new Card(secondCardValue, Card.Suit.Hearts);

        Winner winner = new Winner(new Player(playerName, new PokerHand(firstCard, secondCard)));
        return new GameResultPrinter().print(winner);
    }
}
