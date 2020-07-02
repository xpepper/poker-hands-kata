package com.kata.poker;

public enum Rank {
    HighCard,
    Pair,
    Straight,
    Flush,
    StraightFlush;

    public boolean higherThan(Rank other) {
        return compareTo(other) > 0;
    }

    public boolean lowerThan(Rank other) {
        return compareTo(other) < 0;
    }
}
