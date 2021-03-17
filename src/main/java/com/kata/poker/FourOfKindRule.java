package com.kata.poker;

import java.util.List;
import java.util.Optional;

public class FourOfKindRule implements Rule {
    @Override
    public boolean canApply(Hand hand) {
        return hand.selectFourCardsWithTheSameValue().isPresent();
    }

    @Override
    public Rank apply(Hand hand) {
        List<TwoCards> twoPair = hand.selectCoupleOfTwoCardsWithTheSameValue().get();

        return Rank.fourOfKind(twoPair.get(0).first().value);
    }

}
