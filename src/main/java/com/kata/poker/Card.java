package com.kata.poker;

import java.util.Objects;

import static java.text.MessageFormat.format;

public class Card implements Comparable<Card> {

    public final Value value;
    public final Suit suit;

    public Card(Value value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    @Override
    public int compareTo(Card otherCard) {
        return value.numericValue.compareTo(otherCard.value.numericValue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        Card card = (Card) o;
        return value == card.value &&
                suit == card.suit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, suit);
    }

    @Override
    public String toString() {
        return format("Card'{'value={0}, suit={1}'}'", value, suit);
    }

    public boolean comesBefore(Card card) {
        return value.comesBefore(card.value);
    }

    boolean higherThan(Card otherCard) {
        return value.numericValue > otherCard.value.numericValue;
    }

    public enum Value {
        Two(2),
        Three(3),
        Four(4),
        Five(5),
        Six(6),
        Seven(7),
        Queen(12),
        King(13),
        Ace(14);

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
