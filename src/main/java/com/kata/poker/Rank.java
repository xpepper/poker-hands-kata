package com.kata.poker;

import java.util.Objects;

import static com.kata.poker.Card.Value;
import static java.lang.String.format;

public class Rank implements Comparable<Rank> {

    public static Rank highCard(Card highestCard) {
        return new HighCard(1, highestCard);
    }

    public static Rank pair(Card first, Card second) {
        return new Pair(2, first, second);
    }

    public static Rank straight(Card highestCard) {
        return new Straight(3, highestCard);
    }

    public static Rank flush(Card highestCard) {
        return new Flush(4, highestCard);
    }

    public static Rank straightFlush(Card highestCard) {
        return new StraightFlush(5, highestCard);
    }

    private final int priority;

    private Rank(int priority, Card highestCard) {
        this.priority = priority;
    }

    public boolean higherThan(Rank other) {
        return priority > other.priority;
    }

    public boolean lowerThan(Rank other) {
        return priority < other.priority;
    }

    @Override
    public int compareTo(Rank other) {
        return Integer.compare(priority, other.priority);
    }

    public static class HighCard extends Rank {

        private final Card highestCard;

        private HighCard(int priority, Card highestCard) {
            super(priority, highestCard);
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
            return format("HighCard'{'highestCard=%s'}'", highestCard);
        }

        public Value value() {
            return highestCard.value;
        }
    }

    public static class Pair extends Rank {
        private final Card first;
        private final Card second;

        public Pair(int priority, Card first, Card second) {
            super(priority, first);
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return Objects.equals(first, pair.first) &&
                    Objects.equals(second, pair.second);
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }

        @Override
        public String toString() {
            return format("Pair'{'first=%s, second=%s'}'", first, second);
        }

        public Card.Value value() {
            return first.value;
        }
    }

    public static class Straight extends Rank {
        private final Card highestCard;

        private Straight(int priority, Card highestCard) {
            super(priority, highestCard);
            this.highestCard = highestCard;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Straight)) return false;
            Straight straight = (Straight) o;
            return Objects.equals(highestCard, straight.highestCard);
        }

        @Override
        public int hashCode() {
            return Objects.hash(highestCard);
        }

        @Override
        public String toString() {
            return format("Straight{highestCard=%s}", highestCard);
        }

        public Value highestCardValue() {
            return highestCard.value;
        }
    }

    public static class Flush extends Rank {
        private Card highestCard;

        public Flush(int priority, Card highestCard) {
            super(priority, highestCard);
            this.highestCard = highestCard;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Flush flush = (Flush) o;
            return Objects.equals(highestCard, flush.highestCard);
        }

        @Override
        public int hashCode() {
            return Objects.hash(highestCard);
        }

        public Value highestCardValue() {
            return highestCard.value;
        }
    }

    public static class StraightFlush extends Rank {
        private final Card highestCard;

        public StraightFlush(int priority, Card highestCard) {
            super(priority, highestCard);
            this.highestCard = highestCard;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof StraightFlush)) return false;
            StraightFlush that = (StraightFlush) o;
            return Objects.equals(highestCard, that.highestCard);
        }

        @Override
        public int hashCode() {
            return Objects.hash(highestCard);
        }

        public Value highestCardValue() {
            return highestCard.value;
        }
    }
}
