package com.kata.poker;

public class ThreeOfKindRule implements Rule {
    @Override
    public boolean canApply(Hand hand) {
        return hand.hasThreeCardsWithTheSameValue();
    }

    @Override
    public Rank apply(Hand hand) {
        return Rank.threeOfKind();
    }
}
