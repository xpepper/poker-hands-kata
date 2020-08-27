package com.kata.poker;

public class PairRule {
    Rank apply(Hand hand) {
        return Rank.pair(hand.firstCard(), hand.secondCard());
    }

    boolean canApply(Hand hand) {
        return hand.firstCard().hasSameValueOf(hand.secondCard());
    }
}