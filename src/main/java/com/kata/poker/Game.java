package com.kata.poker;

public class Game {
    private static final int SECOND_HAND = -1;
    private static final int FIRST_HAND = 1;
    private static final int TIE = 0;

    private final Player firstPlayer;
    private final Player secondPlayer;

    public Game(PokerHand firstHand, PokerHand secondHand) {
        this(new Player("first hand", firstHand), new Player("second hand", secondHand));
    }

    public Game(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    public String play() {
        int winningHand = firstPlayer.hand.compareTo(secondPlayer.hand);
        switch (winningHand) {
            case FIRST_HAND:
                return firstPlayer.name + " wins.";
            case SECOND_HAND:
                return secondPlayer.name + " wins.";
            case TIE:
            default:
                return "Tie.";
        }
    }
}
