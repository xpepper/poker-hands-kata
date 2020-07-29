package com.kata.poker;

public class Rank {
    public static final Rank HighCard = new Rank(1);
    public static final Rank Pair = new Rank(2);
    public static final Rank Straight = new Rank(3);
    public static final Rank Flush = new Rank(4);
    public static final Rank StraightFlush = new Rank(5);
    private final int priority;

    private Rank(int priority) {
        this.priority = priority;
    }

    public boolean higherThan(Rank other) {
        return priority > other.priority;
    }

    public boolean lowerThan(Rank other) {
        return priority < other.priority;
    }
}
