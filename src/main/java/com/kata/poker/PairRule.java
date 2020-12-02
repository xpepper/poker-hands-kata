package com.kata.poker;

import java.util.List;

public class PairRule implements Rule {
    @Override
    public boolean canApply(Hand hand) {
        return hand.hasTwoCardsWithTheSameValue();
    }

    @Override
    public Rank apply(Hand hand) {
        TwoCards twoCards = selectTwoCardsWithTheSameValue(hand);
        Cards kickers = hand.allCardsExcept(twoCards.first(), twoCards.second());
        return Rank.pair(twoCards.first(), twoCards.second(), kickers.selectHighestRankingCard());
    }

    private TwoCards selectTwoCardsWithTheSameValue(Hand hand) {
        List<Card> cards = hand.selectTwoCardsWithTheSameValue();
        return new TwoCards(cards);
    }

}
