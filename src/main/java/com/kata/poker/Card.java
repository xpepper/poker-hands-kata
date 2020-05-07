package com.kata.poker;

public class Card implements Comparable<Card> {

    private final Value value;
    private final Suit suit;

    public Card(Value value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    public int compareTo(Card otherCard) {
        return value.numericValue.compareTo(otherCard.value.numericValue);
    }

    public boolean comesBefore(Card card) {
        return value.comesBefore(card.value);
    }

    public boolean hasSameValueOf(Card otherCard) {
        return value.equals(otherCard.value);
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
