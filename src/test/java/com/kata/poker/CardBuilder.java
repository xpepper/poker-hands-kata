package com.kata.poker;

import com.kata.poker.Card.Value;

public class CardBuilder {

    public static Card threeOf(Card.Suit suit) {
        return new Card(Value.Three, suit);
    }

    public static Card fourOf(Card.Suit suit) {
        return new Card(Value.Four, suit);
    }

    public static Card fiveOf(Card.Suit suit) {
        return new Card(Value.Five, suit);
    }

    public static Card sevenOf(Card.Suit suit) {
        return new Card(Value.Seven, suit);
    }

    public static Card kingOf(Card.Suit suit) {
        return new Card(Value.King, suit);
    }

    public static Card aceOf(Card.Suit suit) {
        return new Card(Value.Ace, suit);
    }

}
