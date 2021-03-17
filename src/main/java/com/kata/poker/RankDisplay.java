package com.kata.poker;

import com.kata.poker.rank.*;

public interface RankDisplay<T> {
    T display(TwoPair twoPair);

    T display(StraightFlush flush);

    T display(Flush flush);

    T display(Straight straight);

    T display(ThreeOfKind threeOfKind);

    T display(Pair pair);

    T display(HighCard highCard);

    T display(FourOfKind fourOfKind);
}
