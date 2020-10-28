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
        List<Card> kickers = hand.allExcept(cards);
        return Rank.pair(cards.get(0), cards.get(1), highestRankingOf(kickers));
    }

    private Card highestRankingOf(List<Card> cards) {
        return cards.stream().max(Card::compareTo).get();
    }

}
