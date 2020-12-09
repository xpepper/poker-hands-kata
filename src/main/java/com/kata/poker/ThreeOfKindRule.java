package com.kata.poker;

import java.util.List;

public class ThreeOfKindRule implements Rule {
    @Override
    public boolean canApply(Hand hand) {
        return hand.hasThreeCardsWithTheSameValue();
    }

    @Override
    public Rank apply(Hand hand) {
        ThreeCards threeCards = selectThreeCardsWithTheSameValue(hand);
        return Rank.threeOfKind(takeOneOf(threeCards).value);
    }

    private Card takeOneOf(ThreeCards threeCards) {
        return threeCards.first();
    }

    private ThreeCards selectThreeCardsWithTheSameValue(Hand hand) {
        List<Card> cards = hand.selectThreeCardsWithTheSameValue();
        return new ThreeCards(cards.get(0), cards.get(1), cards.get(2));
    }

}
