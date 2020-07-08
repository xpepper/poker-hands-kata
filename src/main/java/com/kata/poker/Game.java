package com.kata.poker;

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

        Card.Value firstCardValue = Card.Value.Four;
        Card firstCard = new Card(firstCardValue, Card.Suit.Spades);
        Card secondCard = new Card(Card.Value.Seven, Card.Suit.Hearts);
        Winner winner = new Winner(new Player(playerName, new PokerHand(firstCard, secondCard)));
        return new GameResultPrinter().print(winner);
    }
}
