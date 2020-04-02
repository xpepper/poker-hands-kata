package com.kata.poker;

public class PokerHand implements Comparable<PokerHand> {

    private Card firstCard;
    private Card secondCard;

    public PokerHand(Card first, Card second) {
        firstCard = first;
        secondCard = second;
    }

    @Override
    public int compareTo(PokerHand other) {
        return highestCard().compareTo(other.highestCard());
    }

    private Card highestCard() {
        return firstCard.compareTo(secondCard) == 1 ? firstCard : secondCard;
    }
}
