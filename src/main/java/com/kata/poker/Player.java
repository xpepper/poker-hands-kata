package com.kata.poker;

public class Player {

    public final String name;
    public final Hand hand;
    private final Game game = new Game();

    public Player(String name, Hand hand) {
        this.name = name;
        this.hand = hand;
    }

    GameResult playAgainst(Player other) {
        return game.play(this, other);
    }

}
