package com.kata.poker;

public class Player {

    public final String name;
    public final PokerHand hand;

    public Player(String name, PokerHand hand) {
        this.name = name;
        this.hand = hand;
    }

    GameResult playAgainst(Player other) {
        switch (hand.compareToXXX(other.hand)) {
            case Winner:
                return new Winner(this);
            case Loser:
                return new Winner(other);
            case Tie:
            default:
                return GameResult.tie;
        }
    }
}
