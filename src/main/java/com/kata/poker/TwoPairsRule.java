package com.kata.poker;

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
        TwoCards firstPair = hand.selectTwoCardsWithTheSameValue().get();
        Card.Value firstPairValue = firstPair.first().value;
        Cards otherCards = hand.allCardsExcept(firstPair.first(), firstPair.second());
        Card.Value secondPairValue = otherCards.highestCard().value;
        return Rank.twoPairs(firstPairValue, secondPairValue);
    }
}
