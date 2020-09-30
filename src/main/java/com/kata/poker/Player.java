package com.kata.poker;

public class Player {

    public final String name;
    public final Hand hand;

    public Player(String name, Hand hand) {
        this.name = name;
        this.hand = hand;
    }

    GameResult playAgainst(Player other) {
        GameRules gameRules = new GameRules();
        Rank rank = gameRules.evaluate(hand);
        Rank otherRank = gameRules.evaluate(other.hand);

        if (rank.higherThan(otherRank)) {
            return new Winner(this);
        }

        if (rank.lowerThan(otherRank)) {
            return new Winner(other);
        }

        return GameResult.tie;
    }
}
