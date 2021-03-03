package com.kata.poker;

import java.util.List;
import java.util.Optional;

public class FourOfKindRule implements Rule {
    @Override
    public boolean canApply(Hand hand) {
        Optional<List<TwoCards>> twoCards = hand.selectCoupleOfTwoCardsWithTheSameValue();
        if (twoCards.isEmpty())
            return false;
        return twoCards.get().get(0).first().value == twoCards.get().get(1).first().value;
    }

    @Override
    public Rank apply(Hand hand) {
        List<TwoCards> twoPair = hand.selectCoupleOfTwoCardsWithTheSameValue().get();

        return Rank.fourOfKind(twoPair.get(0).first().value);
    }

}
