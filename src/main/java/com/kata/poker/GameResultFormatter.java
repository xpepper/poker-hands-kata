package com.kata.poker;

import com.kata.poker.GameResult.Tie;
import com.kata.poker.Rank.*;

import static com.kata.poker.Card.Value.Ace;

public class GameResultFormatter implements RankVisitor<String> {

    public String visit(GameResult result) {
        if (result instanceof Tie) {
            return tieMessage();
        }

        return winnerMessage((Winner) result);
    }

    private String tieMessage() {
        return "Tie.";
    }

    private String winnerMessage(Winner winner) {
        return String.format("%s wins. - with %s", winner.playerName(), rankMessage(winner.rank()));
    }

    private String rankMessage(Rank rank) {
        return rank.accept(this);
    }

    @Override public String visit(TwoPair twoPair) {
        return String.format(
                "two pair: %ss and %ss",
                formatCardValue(twoPair.highestRankingPairValue()),
                formatCardValue(twoPair.lowestRankingPairValue()));
    }

    @Override public String visit(StraightFlush flush) {
        return String.format("straight flush: %s-high", formatCardValue(flush.highestCardValue()));
    }

    @Override public String visit(Flush flush) {
        return String.format("flush: %s-high", formatCardValue(flush.highestCardValue()));
    }

    @Override public String visit(Straight straight) {
        return String.format("straight: %s-high", formatCardValue(straight.highestCardValue()));
    }

    @Override public String visit(ThreeOfKind threeOfKind) {
        return String.format("three of a kind: %ss", formatCardValue(threeOfKind.value()));
    }

    @Override public String visit(Pair pair) {
        return String.format("pair: %ss", formatCardValue(pair.value()));
    }

    @Override
    public String visit(HighCard highCard) {
        return String.format("high card: %s", formatCardValue(highCard.value()));
    }

    private String formatCardValue(Card.Value cardValue) {
        if (Ace.equals(cardValue)) {
            return "Ace";
        }
        if (cardValue.numericValue > 10) {
            throw new IllegalStateException("Unexpected card value: " + cardValue);
        }
        return cardValue.numericValue.toString();
    }
}
