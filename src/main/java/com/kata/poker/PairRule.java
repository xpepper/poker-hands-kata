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

    private static class TwoCards {
        private final List<Card> cards;

        public TwoCards(List<Card> cards) {
            this.cards = cards;
        }

        public Card first() {
            return cards.get(0);
        }

        public Card second() {
            return cards.get(1);
        }
    }
}
