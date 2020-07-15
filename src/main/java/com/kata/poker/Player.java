package com.kata.poker;

public class Player {

    public final String name;
    public final Hand hand;

    public Player(String name, Hand hand) {
        this.name = name;
        this.hand = hand;
    }

    GameResult playAgainst(Player other) {
        switch (hand.playAgainst(other.hand)) {
            case Win:
                return new Winner(this);
            case Lose:
                return new Winner(other);
            case Tie:
            default:
                return GameResult.tie;
        }
    }
}
