package com.kata.poker;

import static com.kata.poker.Card.Value.Four;
import static com.kata.poker.Card.Value.Three;

public class Card {

    private Value value;

    public Card(Value value) {
        this.value = value;
    }

    public int compareTo(Card otherCard) {
        return value.numericValue.compareTo(otherCard.value.numericValue);
    }

    public boolean isConsecutiveTo(Card card) {
        return card.hasValue(Three) && hasValue(Four);
    }

    private boolean hasValue(Value value) {
        return compareTo(new Card(value)) == 0;
    }

    public enum Value {
        Three(3),
        Four(4),
        Five(5);

        public final Integer numericValue;

        Value(Integer numericValue) {
            this.numericValue = numericValue;
        }

    }
}
