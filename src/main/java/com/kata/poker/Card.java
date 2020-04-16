package com.kata.poker;

import static com.kata.poker.Card.Value.Four;

public class Card {

    private Value value;

    public Card(Value value) {
        this.value = value;
    }

    public int compareTo(Card otherCard) {
        return value.numericValue.compareTo(otherCard.value.numericValue);
    }

    public boolean hasValueConsecutiveTo(Card card) {
        return value.isConsecutiveTo(card.value);
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

        public boolean isConsecutiveTo(Value value) {
            return numericValue == value.numericValue + 1;
        }
    }
}
