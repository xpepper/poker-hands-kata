package com.kata.poker;

public class Game {
    private String input;

    public Game(String input) {
        this.input = input;
    }

    public String play() {
        String secondPlayerInput = input.split("  ")[1];
        String playerName = secondPlayerInput.split(":")[0];

        return playerName + " wins. - with high card";
    }
}
