package com.kata.poker;

public class Player {
    static final int ME = 1;
    static final int OTHER = -1;
    static final int TIE = 0;

    public final String name;
    public final PokerHand hand;

    public Player(String name, PokerHand hand) {
        this.name = name;
        this.hand = hand;
    }

    GameResult playAgainst(Player other) {
        int winningPlayer = hand.compareTo(other.hand);
        switch (winningPlayer) {
            case ME:
                return new Winner(this);
            case OTHER:
                return new Winner(other);
            case TIE:
            default:
                return GameResult.tie;
        }
    }
}
