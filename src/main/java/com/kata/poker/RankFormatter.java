package com.kata.poker;

import static com.kata.poker.Card.Value.Ace;

class RankFormatter implements RankDisplay<String> {
    @Override
    public String display(Rank.TwoPair twoPair) {
        return String.format(
                "two pair: %ss and %ss",
                formatCardValue(twoPair.highestRankingPairValue()),
                formatCardValue(twoPair.lowestRankingPairValue()));
    }

    @Override
    public String display(Rank.StraightFlush flush) {
        return String.format("straight flush: %s-high", formatCardValue(flush.highestCardValue()));
    }

    @Override
    public String display(Rank.Flush flush) {
        return String.format("flush: %s-high", formatCardValue(flush.highestCardValue()));
    }

    @Override
    public String display(Rank.Straight straight) {
        return String.format("straight: %s-high", formatCardValue(straight.highestCardValue()));
    }

    @Override
    public String display(Rank.ThreeOfKind threeOfKind) {
        return String.format("three of a kind: %ss", formatCardValue(threeOfKind.value()));
    }

    @Override
    public String display(Rank.Pair pair) {
        return String.format("pair: %ss", formatCardValue(pair.value()));
    }

    @Override
    public String display(Rank.HighCard highCard) {
        return String.format("high card: %s", formatCardValue(highCard.value()));
    }

    private String formatCardValue(Card.Value cardValue) {
        if (Ace.equals(cardValue)) {
            return "Ace";
        }
        if (cardValue.numericValue > 10) {
            throw new IllegalStateException("Unexpected card value: " + cardValue);
        }
        return cardValue.numericValue.toString();
    }

}
