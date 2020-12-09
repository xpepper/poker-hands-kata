package com.kata.poker;

public class PairRule implements Rule {
    @Override
    public boolean canApply(Hand hand) {
        return hand.hasTwoCardsWithTheSameValue();
    }

    @Override
    public Rank apply(Hand hand) {
        TwoCards twoCards = hand.selectTwoCardsWithTheSameValue().get();
        Cards kickers = hand.allCardsExcept(twoCards.first(), twoCards.second());
        return Rank.pair(twoCards.first(), twoCards.second(), kickers.highestCard());
    }

}
