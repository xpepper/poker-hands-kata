package com.kata.poker;

public class Player {
    public final String name;
    public final PokerHand hand;

    public Player(String name, PokerHand hand) {
        this.name = name;
        this.hand = hand;
    }
}
