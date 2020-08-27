package com.kata.poker;

public interface Rule {
    boolean canApply(Hand hand);

    Rank apply(Hand hand);
}
