package com.kata.poker;

public class Game {
    private static final int SECOND_HAND = -1;
    private static final int FIRST_HAND = 1;
    private static final int TIE = 0;

    private final PokerHand firstHand;
    private final PokerHand secondHand;

    public Game(PokerHand firstHand, PokerHand secondHand) {
        this.firstHand = firstHand;
        this.secondHand = secondHand;
    }

    public String play() {
        int winningHand = firstHand.compareTo(secondHand);
        switch (winningHand) {
            case FIRST_HAND:
                return "first hand wins.";
            case SECOND_HAND:
                return "second hand wins.";
            case TIE:
            default:
                return "Tie.";
        }
    }
}
