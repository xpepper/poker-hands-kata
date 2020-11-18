package com.kata.poker;

import java.util.List;

public class ThreeOfKindRule implements Rule {
    @Override
    public boolean canApply(Hand hand) {
        return hand.hasThreeCardsWithTheSameValue();
    }

    @Override
    public Rank apply(Hand hand) {
        List<Card> cards = hand.selectThreeCardsWithTheSameValue();
        return Rank.threeOfKind(takeOne(cards).value);
    }

    private Card takeOne(List<Card> cards) {
        return cards.get(0);
    }

}
