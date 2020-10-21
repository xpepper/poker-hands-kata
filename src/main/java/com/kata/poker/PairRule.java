package com.kata.poker;

public class PairRule implements Rule {
    @Override
    public boolean canApply(Hand hand) {
        return hand.hasTwoCardsWithTheSameValue();
    }

    @Override
    public Rank apply(Hand hand) {
        Card first;
        Card second;

        if (hand.firstCard().hasSameValueOf(hand.secondCard())) {
            first = hand.firstCard();
            second = hand.secondCard();
        } else if (hand.firstCard().hasSameValueOf(hand.highestCard())) {
            first = hand.firstCard();
            second = hand.highestCard();
        } else {
            first = hand.secondCard();
            second = hand.highestCard();
        }

        return Rank.pair(first, second);
    }
}
