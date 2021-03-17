package com.kata.poker.rank;

import com.kata.poker.Card;
import com.kata.poker.RankDisplay;

import static com.kata.poker.Card.Value;

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

    Rank(int priority, Card highestCard) {
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

}
