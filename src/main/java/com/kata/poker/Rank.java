package com.kata.poker;

import java.util.Objects;

import static com.kata.poker.Card.Value;
import static java.lang.String.format;

public class Rank {
    public static final Rank StraightFlush = new Rank(5);

    private final int priority;

    private Rank(int priority) {
        this.priority = priority;
    }

    public static Rank highCard(Card highestCard) {
        return new HighCard(highestCard);
    }

    public static Rank pair(Card first, Card second) {
        return new Pair(first, second);
    }

    public static Rank straight(Card highestCard) {
        return new Straight(highestCard);
    }

    public static Rank flush(Card highestCard) {
        return new Flush(highestCard);
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
            return format("HighCard'{'highestCard=%s'}'", highestCard);
        }

        public Value value() {
            return highestCard.value;
        }
    }

    public static class Pair extends Rank {
        private final Card first;
        private final Card second;

        public Pair(Card first, Card second) {
            super(2);
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

        private Straight(Card highestCard) {
            super(3);
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

    private static class Flush extends Rank {
        private Card highestCard;

        public Flush(Card highestCard) {
            super(4);
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
    }
}
