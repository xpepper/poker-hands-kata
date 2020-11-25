package com.kata.poker;

import java.util.List;

public class PairRule implements Rule {
    @Override
    public boolean canApply(Hand hand) {
        return hand.hasTwoCardsWithTheSameValue();
    }

    @Override
    public Rank apply(Hand hand) {
        List<Card> cards = hand.selectTwoCardsWithTheSameValue();
        Cards kickers = hand.allCardsExcept(new Cards(cards));
        return Rank.pair(cards.get(0), cards.get(1), kickers.selectHighestRankingCard());
    }

}
