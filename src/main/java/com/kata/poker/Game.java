package com.kata.poker;

public class Game {

    GameResult play(Player firstPlayer, Player secondPlayer) {
        GameRules gameRules = new GameRules();
        Rank rank = gameRules.evaluate(firstPlayer.hand);
        Rank otherRank = gameRules.evaluate(secondPlayer.hand);

        if (rank.higherThan(otherRank)) {
            return new Winner(firstPlayer);
        }

        if (rank.lowerThan(otherRank)) {
            return new Winner(secondPlayer);
        }

        return GameResult.tie;
    }
}