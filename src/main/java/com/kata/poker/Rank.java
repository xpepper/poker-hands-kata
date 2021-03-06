package com.kata.poker;

import java.util.Objects;

import static com.kata.poker.Card.Value;
import static java.lang.String.format;
import static java.util.Arrays.asList;

public abstract class Rank implements Comparable<Rank> {

    public static Rank highCard(Card highestCard) {
        return new HighCard(1, highestCard);
    }

    public static Rank pair(Card first, Card second, Card highestRankingKicker) {
        return new Pair(2, first, second, highestRankingKicker);
    }

    public static Rank twoPair(Value firstPairValue, Value secondPairValue) {
        return new TwoPair(3, firstPairValue, secondPairValue);
    }

    public static Rank threeOfKind(Value value) {
        return new ThreeOfKind(4, value);
    }

    public static Rank straight(Card highestCard) {
        return new Straight(5, highestCard);
    }

    public static Rank flush(Card highestCard) {
        return new Flush(6, highestCard);
    }

    public static Rank fourOfKind(Value value) {
        return new FourOfKind(7, value);
    }
    public static Rank straightFlush(Card highestCard) {
        return new StraightFlush(8, highestCard);
    }

    private final int priority;

    private final Card highestCard;

    private Rank(int priority, Card highestCard) {
        this.priority = priority;
        this.highestCard = highestCard;
    }

    public boolean higherThan(Rank other) {
        if (priority == other.priority) {
            return highestCard.higherThan(other.highestCard);
        }

        return priority > other.priority;
    }

    @Override
    public int compareTo(Rank other) {
        return Integer.compare(priority, other.priority);
    }

    public abstract <T> T displayUsing(RankDisplay<T> rankDisplay);

    public static class HighCard extends Rank {

        private final Card highestCard;

        private HighCard(int priority, Card highestCard) {
            super(priority, highestCard);
            this.highestCard = highestCard;
        }

        @Override
        public <T> T displayUsing(RankDisplay<T> rankDisplay) {
            return rankDisplay.display(this);
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
        private final Card highestRankingKicker;

        public Pair(int priority, Card first, Card second, Card highestRankingKicker) {
            super(priority, first);
            this.first = first;
            this.second = second;
            this.highestRankingKicker = highestRankingKicker;
        }

        @Override
        public boolean higherThan(Rank other) {
            if (super.higherThan(other)) {
                return true;
            }

            return isPair(other) && hasHighestKickerThan(other);
        }

        private boolean isPair(Rank other) {
            return other instanceof Pair;
        }

        private boolean hasHighestKickerThan(Rank other) {
            Pair otherPair = (Pair) other;
            return highestRankingKicker.higherThan(otherPair.highestRankingKicker);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return Objects.equals(first, pair.first) &&
                    Objects.equals(second, pair.second) &&
                    Objects.equals(highestRankingKicker, pair.highestRankingKicker);
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }

        @Override
        public String toString() {
            return format("Pair'{'first=%s, second=%s, highestRankingKicker=%s'}'", first, second, highestRankingKicker);
        }

        public Card.Value value() {
            return first.value;
        }

        @Override
        public <T> T displayUsing(RankDisplay<T> rankDisplay) {
            return rankDisplay.display(this);
        }
    }

    public static class TwoPair extends Rank {
        private final Value firstPairValue;
        private final Value secondPairValue;

        public TwoPair(int priority, Value firstPairValue, Value secondPairValue) {
            super(priority, new Card(Value.max(firstPairValue, secondPairValue), null));
            this.firstPairValue = firstPairValue;
            this.secondPairValue = secondPairValue;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TwoPair otherTwoPair = (TwoPair) o;
            return asList(firstPairValue, secondPairValue).containsAll(asList(otherTwoPair.firstPairValue, otherTwoPair.secondPairValue));
        }

        @Override
        public int hashCode() {
            return Objects.hash(firstPairValue, secondPairValue);
        }

        @Override
        public String toString() {
            return String.format("TwoPair{first=%s, second=%s}", firstPairValue, secondPairValue);
        }

        public Value lowestRankingPairValue() {
            return Value.min(firstPairValue, secondPairValue);
        }

        public Value highestRankingPairValue() {
            return Value.max(firstPairValue, secondPairValue);
        }

        @Override
        public <T> T displayUsing(RankDisplay<T> rankDisplay) {
            return rankDisplay.display(this);
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

        @Override
        public <T> T displayUsing(RankDisplay<T> rankDisplay) {
            return rankDisplay.display(this);
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

        @Override
        public <T> T displayUsing(RankDisplay<T> rankDisplay) {
            return rankDisplay.display(this);
        }
    }

    public static class FourOfKind extends Rank {

        private final Value value;

        public FourOfKind(int priority, Value value) {
            super(priority, new Card(value, Card.Suit.Clubs));
            this.value = value;
        }

        @Override
        public String toString() {
            return "Four of a kind";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            FourOfKind fourOfKind = (FourOfKind) o;
            return Objects.equals(value, fourOfKind.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }

        public Value value() {
            return value;
        }

        @Override
        public <T> T displayUsing(RankDisplay<T> rankDisplay) {
            throw new RuntimeException("TODO");
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

        @Override
        public <T> T displayUsing(RankDisplay<T> rankDisplay) {
            return rankDisplay.display(this);
        }
    }

    public static class ThreeOfKind extends Rank {

        private final Value value;

        public ThreeOfKind(int priority, Value value) {
            super(priority, new Card(value, Card.Suit.Clubs));
            this.value = value;
        }

        @Override
        public String toString() {
            return "Three of a kind";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ThreeOfKind threeOfKind = (ThreeOfKind) o;
            return Objects.equals(value, threeOfKind.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }

        public Value value() {
            return value;
        }

        @Override
        public <T> T displayUsing(RankDisplay<T> rankDisplay) {
            return rankDisplay.display(this);
        }
    }
}
