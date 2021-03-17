package com.kata.poker.rank;

import com.kata.poker.Card;
import com.kata.poker.RankDisplay;

import java.util.Objects;

import static java.lang.String.format;

public class Straight extends Rank {

    private final Card highestCard;

    Straight(int priority, Card highestCard) {
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
        if (!(o instanceof com.kata.poker.rank.Straight)) return false;
        com.kata.poker.rank.Straight straight = (com.kata.poker.rank.Straight) o;
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
}
