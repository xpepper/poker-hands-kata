package com.kata.poker;

import java.util.List;

import static java.util.Arrays.asList;

public class TwoPairsRule implements Rule {
    @Override
    public boolean canApply(Hand hand) {
        if (!hand.hasTwoCardsWithTheSameValue()) {
            return false;
        }

        TwoCards firstPair = hand.selectTwoCardsWithTheSameValue().get();
        Cards otherCards = hand.allCardsExcept(firstPair.first(), firstPair.second());
        Card remainingHighestCard = otherCards.highestCard();
        Cards cards = hand.allCardsExcept(firstPair.first(), firstPair.second(), remainingHighestCard);
        return cards.highestCard().value == remainingHighestCard.value;
    }

    @Override
    public Rank apply(Hand hand) {
        List<TwoCards> twoPairs = getTwoPairs(hand);

        return Rank.twoPairs(twoPairs.get(0).first().value, twoPairs.get(1).first().value);
    }

    private List<TwoCards> getTwoPairs(Hand hand) {
        TwoCards firstPair = hand.selectTwoCardsWithTheSameValue().get();
        Cards otherCards = hand.allCardsExcept(firstPair.first(), firstPair.second());
        List<Card> otherPairCards = otherCards.selectCardsWithTheSameValue(2).get();
        TwoCards secondPair = new TwoCards(otherPairCards.get(0), otherPairCards.get(1));
        List<TwoCards> twoPairs = asList(firstPair, secondPair);
        return twoPairs;
    }
}
