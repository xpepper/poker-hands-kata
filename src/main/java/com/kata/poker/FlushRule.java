package com.kata.poker;

public class FlushRule implements Rule {
    @Override
    public boolean canApply(Hand hand) {
        return hand.firstCard().hasSameSuitOf(hand.secondCard()) && hand.firstCard().hasSameSuitOf(hand.highestCard());
    }

    @Override
    public Rank apply(Hand hand) {
        return Rank.flush(hand.highestCard());
    }
}
