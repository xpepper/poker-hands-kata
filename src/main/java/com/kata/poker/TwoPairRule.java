package com.kata.poker;

import java.util.List;

public class TwoPairRule implements Rule {
    @Override
    public boolean canApply(Hand hand) {
        return hand.selectCoupleOfTwoCardsWithTheSameValue().isPresent();
    }

    @Override
    public Rank apply(Hand hand) {
        List<TwoCards> twoPair = hand.selectCoupleOfTwoCardsWithTheSameValue().get();

        return Rank.twoPair(twoPair.get(0).first().value, twoPair.get(1).first().value);
    }

}
