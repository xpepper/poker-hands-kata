package com.kata.poker;

import java.util.List;

import static java.util.Arrays.asList;

public class GameRules {

    private final List<Rule> rules = asList(
            new StraightFlushRule(),
            new FlushRule(),
            new StraightRule(),
            new ThreeOfKindRule(),
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