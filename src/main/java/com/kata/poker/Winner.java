package com.kata.poker;

import java.util.Objects;

public class Winner implements GameResult {
    private final Player player;

    public Winner(Player player) {
        this.player = player;
    }

    public Rank rank() {
        return player.hand.rank();
    }

    public String playerName() {
        return player.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Winner that = (Winner) o;
        return Objects.equals(player, that.player);
    }

}
