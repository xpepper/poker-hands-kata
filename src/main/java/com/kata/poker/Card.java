package com.kata.poker;

import java.util.Objects;

import static com.kata.poker.Outcome.*;
import static java.text.MessageFormat.format;

public class Card {

    public final Value value;
    private final Suit suit;

    public Card(Value value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    public Outcome playAgainst(Card otherCard) {
        switch (value.numericValue.compareTo(otherCard.value.numericValue)) {
            case 1:
                return Win;
            case -1:
                return Lose;
            default:
                return Tie;
        }
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

    public boolean hasSameValueOf(Card otherCard) {
        return value.equals(otherCard.value);
    }

    public boolean hasSameSuitOf(Card otherCard) {
        return suit.equals(otherCard.suit);
    }

    public enum Value {
        Two(2),
        Three(3),
        Four(4),
        Five(5),
        Seven(7),
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
