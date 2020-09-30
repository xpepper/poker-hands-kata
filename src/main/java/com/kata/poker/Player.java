package com.kata.poker;

public class Player {
    public final String name;
    public final Hand hand;

    public Player(String name, Hand hand) {
        this.name = name;
        this.hand = hand;
    }
}
