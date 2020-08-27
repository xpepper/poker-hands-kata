package com.kata.poker;

public class StraightRule {
    boolean canApply(Hand hand) {
        return hand.firstCard().comesBefore(hand.secondCard());
    }

    Rank apply(Hand hand) {
        return Rank.straight(hand.highestCard());
    }
}