package com.kata.poker;

import static com.kata.poker.HandOutcome.*;

public class Card implements Comparable<Card> {

    private final Value value;
    private final Suit suit;

    public Card(Value value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    public HandOutcome playAgainst(Card otherCard) {
        int outcome = value.numericValue.compareTo(otherCard.value.numericValue);
        switch (outcome) {
            case 1: return Win;
            case -1: return Lose;
            default: return Tie;
        }
    }

    @Override
    public int compareTo(Card otherCard) {
        HandOutcome outcome = playAgainst(otherCard);
        switch (outcome) {
            case Win: return 1;
            case Lose: return -1;
            default: return 0;
        }
    }

    public boolean comesBefore(Card card) {
        return value.comesBefore(card.value);
    }

    public boolean hasSameValueOf(Card otherCard) {
        return value.equals(otherCard.value);
    }

    public boolean hasSameSuitOf(Card otherCard) {
        return suit.equals(otherCard.suit);
    }

    public enum Value {
        Three(3),
        Four(4),
        Five(5),
        Seven(7);

        public final Integer numericValue;

        Value(Integer numericValue) {
            this.numericValue = numericValue;
        }

        public boolean comesBefore(Value otherValue) {
            return numericValue + 1 == otherValue.numericValue;
        }
    }

    public enum Suit {Hearts, Spades, Clubs, Diamonds}
}
