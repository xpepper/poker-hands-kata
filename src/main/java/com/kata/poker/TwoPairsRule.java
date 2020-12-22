package com.kata.poker;

public class TwoPairsRule implements Rule {
    @Override
    public boolean canApply(Hand hand) {
        return false;
    }

    @Override
    public Rank apply(Hand hand) {
        throw new RuntimeException("Not yet implemented");
    }
}
