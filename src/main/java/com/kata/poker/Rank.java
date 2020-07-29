package com.kata.poker;

import java.util.Objects;

public class Rank {
    public static final Rank HighCard = new HighCard(null);
    public static final Rank Pair = new Rank(2);
    public static final Rank Straight = new Rank(3);
    public static final Rank Flush = new Rank(4);
    public static final Rank StraightFlush = new Rank(5);
    private final int priority;

    private Rank(int priority) {
        this.priority = priority;
    }

    public static Rank highCard(Card highestCard) {
        return new HighCard(highestCard);
    }

    public boolean higherThan(Rank other) {
        return priority > other.priority;
    }

    public boolean lowerThan(Rank other) {
        return priority < other.priority;
    }

    public static class HighCard extends Rank {

        private final Card highestCard;

        private HighCard(Card highestCard) {
            super(1);
            this.highestCard = highestCard;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof HighCard)) return false;
            HighCard highCard = (HighCard) o;
            return Objects.equals(highestCard, highCard.highestCard);
        }

        @Override
        public int hashCode() {
            return Objects.hash(highestCard);
        }

        @Override
        public String toString() {
            return "HighCard{" +
                    "highestCard=" + highestCard +
                    '}';
        }
    }
}
