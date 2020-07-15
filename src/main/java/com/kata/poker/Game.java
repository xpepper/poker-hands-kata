package com.kata.poker;

import static com.kata.poker.Card.Suit.Clubs;
import static com.kata.poker.Card.Suit.Diamonds;
import static com.kata.poker.Card.Value.Four;
import static com.kata.poker.Card.Value.Two;

public class Game {

    private final CardParser cardParser = new CardParser();

    private String input;

    public Game(String input) {
        this.input = input;
    }

    public String play() {
        String secondPlayerInput = input.split("  ")[1];
        String playerName = secondPlayerInput.split(":")[0];

        String[] rawPlayerHand = secondPlayerInput.split(": ")[1].split(" ");
        Card firstCard = cardParser.parse(rawPlayerHand[0]);
        Card secondCard = cardParser.parse(rawPlayerHand[1]);
        PokerHand hand = new PokerHand(firstCard, secondCard);

        Player winnerPlayer = new Player(playerName, hand);
        Player alwaysLoosingPlayer = new Player("Foo", new PokerHand(new Card(Two, Clubs), new Card(Four, Diamonds)));
        Winner winner = (Winner) winnerPlayer.playAgainst(alwaysLoosingPlayer);

        return new GameResultPrinter().print(winner);
    }

}
