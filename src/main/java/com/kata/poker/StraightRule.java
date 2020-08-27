package com.kata.poker;

public class StraightRule implements Rule {
    @Override
    public boolean canApply(Hand hand) {
        return hand.firstCard().comesBefore(hand.secondCard());
    }

    @Override
    public Rank apply(Hand hand) {
        return Rank.straight(hand.highestCard());
    }
}