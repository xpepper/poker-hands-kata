package com.kata.poker;

import java.util.List;

public class TwoPairsRule implements Rule {
    @Override
    public boolean canApply(Hand hand) {
        if (!hand.hasTwoCardsWithTheSameValue()) {
            return false;
        }

        return hand.selectCoupleOfTwoCardsWithTheSameValue().isPresent();
    }

    @Override
    public Rank apply(Hand hand) {
        List<TwoCards> twoPairs = hand.selectCoupleOfTwoCardsWithTheSameValue().get();

        return Rank.twoPairs(twoPairs.get(0).first().value, twoPairs.get(1).first().value);
    }

}
