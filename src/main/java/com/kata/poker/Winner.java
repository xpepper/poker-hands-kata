package com.kata.poker;

import java.util.Objects;

public class Winner implements GameResult {
    private final String playerName;

    public Winner(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Winner that = (Winner) o;
        return Objects.equals(playerName, that.playerName);
    }
}
