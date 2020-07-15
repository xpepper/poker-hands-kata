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

        String rawSecondPlayerHand = secondPlayerInput.split(": ")[1];

        PokerHand hand = parsePokerHand(rawSecondPlayerHand);

        Player winnerPlayer = new Player(playerName, hand);
        Player alwaysLoosingPlayer = new Player("Foo", new PokerHand(new Card(Two, Clubs), new Card(Four, Diamonds)));
        Winner winner = (Winner) winnerPlayer.playAgainst(alwaysLoosingPlayer);

        return new GameResultPrinter().print(winner);
    }

    private PokerHand parsePokerHand(String rawPokerHand) {
        String[] rawCards = rawPokerHand.split(" ");
        Card firstCard = cardParser.parse(rawCards[0]);
        Card secondCard = cardParser.parse(rawCards[1]);
        return new PokerHand(firstCard, secondCard);
    }

}
