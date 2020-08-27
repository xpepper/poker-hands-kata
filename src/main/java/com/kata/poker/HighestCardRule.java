package com.kata.poker;

public class HighestCardRule {
    boolean canApply(Hand hand) {
        return true;
    }

    Rank apply(Hand hand) {
        return Rank.highCard(hand.highestCard());
    }
}