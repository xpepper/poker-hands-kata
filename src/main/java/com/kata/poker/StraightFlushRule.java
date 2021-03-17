package com.kata.poker;

import com.kata.poker.rank.Rank;

public class StraightFlushRule implements Rule {
    @Override
    public boolean canApply(Hand hand) {
        Rule straightRule = new StraightRule();
        Rule flushRule = new FlushRule();

        return straightRule.canApply(hand) && flushRule.canApply(hand);
    }

    @Override
    public Rank apply(Hand hand) {
        return Rank.straightFlush(hand.highestCard());
    }
}
