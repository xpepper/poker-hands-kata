package com.kata.poker;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;

public class TwoPairsRule implements Rule {
    @Override
    public boolean canApply(Hand hand) {
        if (!hand.hasTwoCardsWithTheSameValue()) {
            return false;
        }

        return getTwoPairs(hand).isPresent();
    }

    @Override
    public Rank apply(Hand hand) {
        List<TwoCards> twoPairs = getTwoPairs(hand).get();

        return Rank.twoPairs(twoPairs.get(0).first().value, twoPairs.get(1).first().value);
    }

    private Optional<List<TwoCards>> getTwoPairs(Hand hand) {
        if (hand.selectTwoCardsWithTheSameValue().isEmpty()) {
            return Optional.empty();
        }

        TwoCards firstPair = hand.selectTwoCardsWithTheSameValue().get();
        Cards otherCards = hand.allCardsExcept(firstPair.first(), firstPair.second());
        if (otherCards.selectCardsWithTheSameValue(2).isEmpty()) {
            return Optional.empty();
        }

        List<Card> otherPairCards = otherCards.selectCardsWithTheSameValue(2).get();
        TwoCards secondPair = new TwoCards(otherPairCards.get(0), otherPairCards.get(1));
        List<TwoCards> twoPairs = asList(firstPair, secondPair);
        return Optional.of(twoPairs);
    }
}
