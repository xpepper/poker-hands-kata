package com.kata.poker;

import java.util.Objects;

public class GameResult {
    private String playerName;

    public GameResult(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameResult that = (GameResult) o;
        return Objects.equals(playerName, that.playerName);
    }
}
