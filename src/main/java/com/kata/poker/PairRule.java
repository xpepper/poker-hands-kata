package com.kata.poker;

public class PairRule implements Rule {
    @Override
    public boolean canApply(Hand hand) {
        return hand.firstCard().hasSameValueOf(hand.secondCard()) ||
                hand.firstCard().hasSameValueOf(hand.highestCard()) ||
                hand.secondCard().hasSameValueOf(hand.highestCard());
    }

    @Override
    public Rank apply(Hand hand) {
        if (hand.firstCard().hasSameValueOf(hand.secondCard())) {
            return Rank.pair(hand.firstCard(), hand.secondCard());
        }
        if (hand.firstCard().hasSameValueOf(hand.highestCard())) {
            return Rank.pair(hand.firstCard(), hand.highestCard());
        }

        return Rank.pair(hand.secondCard(), hand.highestCard());
    }
}