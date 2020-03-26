package com.kata.poker;

public class Card {

    private Value value;

    public Card(Value value) {
        this.value = value;
    }

    public int compareTo(Card otherCard) {
        return value.numericValue.compareTo(otherCard.value.numericValue);
    }

    public enum Value {
        Four(4),
        Five(5);

        public final Integer numericValue;

        Value(Integer numericValue) {
            this.numericValue = numericValue;
        }
    }

}
