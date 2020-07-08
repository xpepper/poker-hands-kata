package com.kata.poker;

import java.util.HashMap;

public class Game {
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
        String rawSecondCard = rawPlayerHand[1];
        char rawSecondCardValue = rawSecondCard.charAt(0);

        HashMap<Character, Card.Value> charToValue = new HashMap<>();
        charToValue.put('2', Card.Value.Two);
        charToValue.put('5', Card.Value.Five);

        Card.Value firstCardValue = charToValue.get(rawFirstCardValue);
        Card firstCard = new Card(firstCardValue, Card.Suit.Spades);
        Card.Value secondCardValue = charToValue.get(rawSecondCardValue);
        Card secondCard = new Card(secondCardValue, Card.Suit.Hearts);
        Winner winner = new Winner(new Player(playerName, new PokerHand(firstCard, secondCard)));
        return new GameResultPrinter().print(winner);
    }
}
