package com.kata.poker;

import java.util.Objects;

import static java.text.MessageFormat.format;

public class Rank {
    private static final Rank STRAIGHT = new Straight();
    public static final Rank Flush = new Rank(4);
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
        return STRAIGHT;
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
            return format("HighCard'{'highestCard={0}'}'", highestCard);
        }

        public Card.Value value() {
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
            return format("Pair'{'first={0}, second={1}'}'", first, second);
        }
    }

    private static class Straight extends Rank {
        private static final Straight instance = new Straight();

        private Straight() {
            super(3);
        }
    }
}
