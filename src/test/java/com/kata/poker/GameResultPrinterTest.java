package com.kata.poker;

import org.junit.Test;

import static com.kata.poker.Card.Suit.Clubs;
import static com.kata.poker.Card.Suit.Hearts;
import static com.kata.poker.PokerHandTest.*;
import static org.junit.Assert.assertEquals;

public class GameResultPrinterTest {

    @Test
    public void print_the_winner_name_and_its_rank() {
        Winner winner = new Winner(new Player("Peter", new PokerHand(threeOf(Clubs), sevenOf(Hearts))));

        assertEquals("Peter wins. - with high card", new GameResultPrinter().print(winner));
    }
}
