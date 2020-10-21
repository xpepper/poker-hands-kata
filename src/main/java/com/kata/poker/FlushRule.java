package com.kata.poker;

public class FlushRule implements Rule {
    @Override
    public boolean canApply(Hand hand) {
        return hand.hasAllCardsWithTheSameSuit();
    }

    @Override
    public Rank apply(Hand hand) {
        return Rank.flush(hand.highestCard());
    }
}
