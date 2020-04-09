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
        if (hasPair() && other.hasPair()) {
            return highestCard().compareTo(other.highestCard());
        }

        if (hasPair()) {
            return 1;
        }

        if (other.hasPair()) {
            return -1;
        }

        return highestCard().compareTo(other.highestCard());
    }

    private boolean hasPair() {
        return firstCard.compareTo(secondCard) == 0;
    }

    private Card highestCard() {
        return firstCard.compareTo(secondCard) == 1 ? firstCard : secondCard;
    }
}
