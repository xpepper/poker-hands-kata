package com.kata.poker;

import static com.kata.poker.Outcome.*;

public class Player {

    public final String name;
    public final Hand hand;

    public Player(String name, Hand hand) {
        this.name = name;
        this.hand = hand;
    }

    GameResult playAgainst(Player other) {
        Outcome outcome = Tie;
        GameRules gameRules = new GameRules();
        Rank rank = gameRules.evaluate(hand);
        Rank otherRank = gameRules.evaluate(other.hand);
        if (rank.higherThan(otherRank)) {
            outcome = Win;
        } else if (rank.lowerThan(otherRank)) {
            outcome = Lose;
        } else {
            outcome = Tie;
        }
        switch (outcome) {
            case Win:
                return new Winner(this);
            case Lose:
                return new Winner(other);
            case Tie:
            default:
                return GameResult.tie;
        }
    }
}
