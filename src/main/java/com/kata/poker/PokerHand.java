package com.kata.poker;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.sort;

public class PokerHand implements Comparable<PokerHand> {

    private Card firstCard;
    private Card secondCard;

    public PokerHand(Card first, Card second) {
        firstCard = first;
        secondCard = second;
    }

    @Override
    public int compareTo(PokerHand other) {
        if (hasStraight()) {
            return 1;
        }

        if (other.hasStraight()) {
            return -1;
        }

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

    private boolean hasStraight() {
        List<Card> cards = asList(firstCard, secondCard);
        sort(cards);
        return cards.get(0).comesBefore(cards.get(1));
    }

    private boolean hasPair() {
        return firstCard.compareTo(secondCard) == 0;
    }

    private Card highestCard() {
        return firstCard.compareTo(secondCard) == 1 ? firstCard : secondCard;
    }
}
