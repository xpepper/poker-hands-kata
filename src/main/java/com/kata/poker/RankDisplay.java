package com.kata.poker;

public interface RankDisplay<T> {
    T display(Rank.TwoPair twoPair);

    T display(Rank.StraightFlush flush);

    T display(Rank.Flush flush);

    T display(Rank.Straight straight);

    T display(Rank.ThreeOfKind threeOfKind);

    T display(Rank.Pair pair);

    T display(Rank.HighCard highCard);
}
