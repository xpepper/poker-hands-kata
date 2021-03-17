package com.kata.poker.rank;

import com.kata.poker.Card;
import com.kata.poker.RankDisplay;

import java.util.Objects;

public class StraightFlush extends Rank {

    private final Card highestCard;

    public StraightFlush(int priority, Card highestCard) {
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
        if (!(o instanceof com.kata.poker.rank.StraightFlush)) return false;
        com.kata.poker.rank.StraightFlush that = (com.kata.poker.rank.StraightFlush) o;
        return Objects.equals(highestCard, that.highestCard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(highestCard);
    }
}
