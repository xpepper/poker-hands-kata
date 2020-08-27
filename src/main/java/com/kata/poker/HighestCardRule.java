package com.kata.poker;

public class HighestCardRule implements Rule {
    @Override
    public boolean canApply(Hand hand) {
        return true;
    }

    @Override
    public Rank apply(Hand hand) {
        return Rank.highCard(hand.highestCard());
    }
}