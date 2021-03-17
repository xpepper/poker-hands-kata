package com.kata.poker.rank;

import com.kata.poker.Card;
import com.kata.poker.RankDisplay;

import java.util.Objects;

public class FourOfKind extends Rank {

    private final Card.Value value;

    public FourOfKind(int priority, Card.Value value) {
        super(priority, new Card(value, Card.Suit.Clubs));
        this.value = value;
    }

    public Card.Value value() {
        return value;
    }

    @Override
    public <T> T displayUsing(RankDisplay<T> rankDisplay) {
        return rankDisplay.display(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com.kata.poker.rank.FourOfKind fourOfKind = (com.kata.poker.rank.FourOfKind) o;
        return Objects.equals(value, fourOfKind.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Four of a kind";
    }
}
