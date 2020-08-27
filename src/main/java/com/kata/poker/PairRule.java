package com.kata.poker;

public class PairRule implements Rule {
    @Override
    public boolean canApply(Hand hand) {
        return hand.firstCard().hasSameValueOf(hand.secondCard());
    }

    @Override
    public Rank apply(Hand hand) {
        return Rank.pair(hand.firstCard(), hand.secondCard());
    }
}