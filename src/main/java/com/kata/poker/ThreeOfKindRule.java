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

    private class ThreeCards {
        private final Card first;
        private final Card second;
        private final Card third;

        public ThreeCards(Card first, Card second, Card third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }

        public Card first() {
            return first;
        }

        public Card second() {
            return second;
        }

        public Card third() {
            return third;
        }
    }
}
