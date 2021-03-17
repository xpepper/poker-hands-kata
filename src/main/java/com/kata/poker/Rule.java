package com.kata.poker;

import com.kata.poker.rank.Rank;

public interface Rule {
    boolean canApply(Hand hand);

    Rank apply(Hand hand);
}
