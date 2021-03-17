package com.kata.poker.rank;

import com.kata.poker.Card;
import com.kata.poker.RankDisplay;

import java.util.Objects;

import static java.util.Arrays.asList;

public class TwoPair extends Rank {
    private final Card.Value firstPairValue;
    private final Card.Value secondPairValue;

    public TwoPair(int priority, Card.Value firstPairValue, Card.Value secondPairValue) {
        super(priority, new Card(Card.Value.max(firstPairValue, secondPairValue), null));
        this.firstPairValue = firstPairValue;
        this.secondPairValue = secondPairValue;
    }

    public Card.Value lowestRankingPairValue() {
        return Card.Value.min(firstPairValue, secondPairValue);
    }

    public Card.Value highestRankingPairValue() {
        return Card.Value.max(firstPairValue, secondPairValue);
    }

    @Override
    public <T> T displayUsing(RankDisplay<T> rankDisplay) {
        return rankDisplay.display(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com.kata.poker.rank.TwoPair otherTwoPair = (com.kata.poker.rank.TwoPair) o;
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
}
