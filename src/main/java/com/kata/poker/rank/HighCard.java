package com.kata.poker.rank;

import com.kata.poker.Card;
import com.kata.poker.RankDisplay;

import java.util.Objects;

import static java.lang.String.format;

public class HighCard extends Rank {

    private final Card highestCard;

    HighCard(int priority, Card highestCard) {
        super(priority, highestCard);
        this.highestCard = highestCard;
    }

    public Card.Value value() {
        return highestCard.value;
    }

    @Override
    public <T> T displayUsing(RankDisplay<T> rankDisplay) {
        return rankDisplay.display(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof com.kata.poker.rank.HighCard)) return false;
        com.kata.poker.rank.HighCard highCard = (com.kata.poker.rank.HighCard) o;
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

}
