package com.kata.poker;

public class Player {
    static final int FIRST_PLAYER = 1;
    static final int SECOND_PLAYER = -1;
    static final int TIE = 0;

    public final String name;
    public final PokerHand hand;

    public Player(String name, PokerHand hand) {
        this.name = name;
        this.hand = hand;
    }

    GameResult playAgainst(Player anotherPlayer) {
        int winningPlayer = hand.compareTo(anotherPlayer.hand);
        switch (winningPlayer) {
            case FIRST_PLAYER:
                return new Winner(name);
            case SECOND_PLAYER:
                return new Winner(anotherPlayer.name);
            case TIE:
            default:
                return GameResult.tie;
        }
    }
}
