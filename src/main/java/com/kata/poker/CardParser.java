package com.kata.poker;

import java.util.HashMap;
import java.util.Map;

public class CardParser {
    private static final Map<Character, Card.Value> CHAR_TO_VALUE = new HashMap<Character, Card.Value>() {{
        put('2', Card.Value.Two);
        put('4', Card.Value.Four);
        put('5', Card.Value.Five);
        put('6', Card.Value.Six);
        put('7', Card.Value.Seven);
    }};

    private static final Map<Character, Card.Suit> CHAR_TO_SUIT = new HashMap<Character, Card.Suit>() {{
        put('C', Card.Suit.Clubs);
        put('H', Card.Suit.Hearts);
        put('D', Card.Suit.Diamonds);
    }};

    Card parse(String rawCard) {
        Character rawCardValue = rawCard.charAt(0);
        Card.Value value = CHAR_TO_VALUE.get(rawCardValue);

        Character rawCardSuit = rawCard.charAt(1);
        Card.Suit suit = CHAR_TO_SUIT.get(rawCardSuit);

        return new Card(value, suit);
    }
}