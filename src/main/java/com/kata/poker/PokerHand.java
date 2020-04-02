package com.kata.poker;

public class PokerHand implements Comparable<PokerHand> {

    private Card card;
    private Card secondCard;

    public PokerHand(Card card) {
        this.card = card;
    }

    public PokerHand(Card first, Card second) {
        card = first;
        secondCard = second;
    }

    @Override
    public int compareTo(PokerHand other) {
        return highestCard().compareTo(other.highestCard());
    }

    private Card highestCard() {
        if (secondCard == null) return card;

        return card.compareTo(secondCard) == 1 ? card : secondCard;
    }
}
