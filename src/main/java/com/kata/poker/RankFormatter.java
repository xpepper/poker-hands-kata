package com.kata.poker;

public interface RankFormatter {
    String format(Rank.TwoPair twoPair);

    String format(Rank.StraightFlush flush);

    String format(Rank.Flush flush);

    String format(Rank.Straight straight);

    String format(Rank.ThreeOfKind threeOfKind);

    String format(Rank.Pair pair);

    String format(Rank.HighCard highCard);
}
