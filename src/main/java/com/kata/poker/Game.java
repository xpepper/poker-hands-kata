package com.kata.poker;

public class Game {

    private final GameRules rules;

    public Game(GameRules rules) {
        this.rules = rules;
    }

    GameResult play(Player firstPlayer, Player secondPlayer) {
        Rank rank = rules.evaluate(firstPlayer.hand);
        Rank otherRank = rules.evaluate(secondPlayer.hand);

        if (rank.higherThan(otherRank)) {
            return new Winner(firstPlayer);
        }

        if (otherRank.higherThan(rank)) {
            return new Winner(secondPlayer);
        }

        return GameResult.tie;
    }
}
