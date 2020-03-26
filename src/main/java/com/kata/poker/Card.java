package com.kata.poker;

public class Card {

    private Value value;

    public Card(Value value) {
        this.value = value;
    }

    public int compareTo(Card otherCard) {
        if (value.numericValue > otherCard.value.numericValue) return 1;
        if (value.numericValue == otherCard.value.numericValue) return 0;
        return -1;
    }

    public enum Value {
        Four(4),
        Five(5);

        public int numericValue;

        Value(int numericValue) {
            this.numericValue = numericValue;
        }
    }

}
