package com.kata.poker;

public interface RankVisitor<T> {
    T visit(Rank.TwoPair twoPair);

    T visit(Rank.StraightFlush flush);

    T visit(Rank.Flush flush);

    T visit(Rank.Straight straight);

    T visit(Rank.ThreeOfKind threeOfKind);

    T visit(Rank.Pair pair);

    T visit(Rank.HighCard highCard);
}
