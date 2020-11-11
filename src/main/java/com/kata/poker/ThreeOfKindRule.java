package com.kata.poker;

import static java.util.Collections.emptyList;

public class ThreeOfKindRule implements Rule {
    @Override
    public boolean canApply(Hand hand) {
        return hand.hasThreeCardsWithTheSameValue();
    }

    @Override
    public Rank apply(Hand hand) {
        return Rank.threeOfKind(hand.allExcept(emptyList()).get(0).value);
    }
}
