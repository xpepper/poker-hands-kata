package com.kata.poker;

public class FourOfKindRule implements Rule {
    @Override
    public boolean canApply(Hand hand) {
        return hand.selectFourCardsWithTheSameValue().isPresent();
    }

    @Override
    public Rank apply(Hand hand) {
        FourCards fourCards = hand.selectFourCardsWithTheSameValue().get();

        return Rank.fourOfKind(fourCards.first().value);
    }

}
