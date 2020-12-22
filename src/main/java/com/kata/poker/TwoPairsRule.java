package com.kata.poker;

public class TwoPairsRule implements Rule {
    @Override
    public boolean canApply(Hand hand) {
        return false;
    }

    @Override
    public Rank apply(Hand hand) {
        TwoCards firstPair = hand.selectTwoCardsWithTheSameValue().get();
        Card.Value firstPairValue = firstPair.first().value;
        Cards otherCards = hand.allCardsExcept(firstPair.first(), firstPair.second());
        Card.Value secondPairValue = otherCards.highestCard().value;
        return Rank.twoPairs(firstPairValue, secondPairValue);
    }
}
