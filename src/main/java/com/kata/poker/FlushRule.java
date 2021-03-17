package com.kata.poker;

import com.kata.poker.rank.Rank;

public class FlushRule implements Rule {
    @Override
    public boolean canApply(Hand hand) {
        return hand.hasAllCardsWithTheSameSuit();
    }

    @Override
    public Rank apply(Hand hand) {
        return Rank.flush(hand.highestCard());
    }
}
