package com.kata.poker;

import java.util.List;

import static java.util.Arrays.asList;

public class RankEngine {

    private final List<Rule> rules = asList(
            new StraightFlushRule(),
            new FlushRule(),
            new StraightRule(),
            new PairRule(),
            new HighestCardRule()
    );

    Rank evaluate(Hand hand) {
        return rules.stream()
                .filter(rule -> rule.canApply(hand))
                .map(rule -> rule.apply(hand))
                .max(Rank::compareTo)
                .orElse(null);
    }
}