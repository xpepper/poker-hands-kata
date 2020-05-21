package com.kata.poker;

public class Game {
    private final PokerHand firstHand;
    private final PokerHand secondHand;

    public Game(PokerHand firstHand, PokerHand secondHand) {
        this.firstHand = firstHand;
        this.secondHand = secondHand;
    }

    public String play() {
        if (firstHand.compareTo(secondHand) == -1) {
            return "second hand wins.";
        }

        return null;
    }
}
