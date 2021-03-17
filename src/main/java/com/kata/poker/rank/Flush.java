package com.kata.poker.rank;

import com.kata.poker.Card;
import com.kata.poker.RankDisplay;

import java.util.Objects;

public class Flush extends Rank {

    private final Card highestCard;

    public Flush(int priority, Card highestCard) {
        super(priority, highestCard);
        this.highestCard = highestCard;
    }

    public Card.Value highestCardValue() {
        return highestCard.value;
    }

    @Override
    public <T> T displayUsing(RankDisplay<T> rankDisplay) {
        return rankDisplay.display(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com.kata.poker.rank.Flush flush = (com.kata.poker.rank.Flush) o;
        return Objects.equals(highestCard, flush.highestCard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(highestCard);
    }
}
