package com.kata.poker;

public class PokerHand implements Comparable<PokerHand> {

    private Card card;

    public PokerHand(Card card) {
        this.card = card;
    }

    @Override
    public int compareTo(PokerHand other) {
        return card.compareTo(other.card);
    }
}
