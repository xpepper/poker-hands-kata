package com.kata.poker;

public class PairRule {
    boolean canApply(Hand hand) {
        return hand.firstCard().hasSameValueOf(hand.secondCard());
    }

    Rank apply(Hand hand) {
        return Rank.pair(hand.firstCard(), hand.secondCard());
    }
}