[PokerHands Kata](http://codingdojo.org/kata/PokerHands/)
[List of Poker hands](https://en.wikipedia.org/wiki/List_of_poker_hands)

### TODO

* [R] `GameResultFormatter` has too many responsibilities (format the player name, format the rank and combine them together)
    - This is making tests dependent each other (e.g. if we change the formatting of the high card we have two tests that fail)

* [F] Poker hand with three cards... ("3 cards" world)
    * rewrite the logic to find the highest card in a hand using sorting
    * three of a kind ranking
    * Add the missing ranks in `Rank`

* [R] Idea to avoid having many boilerplate equals / hashcode / ... : have a list of cards on the `Rank` superclass?

* [F] `CardParserTest` add support to more values and suites?

* [F] Should we add a validation when 
    - creating a `Card` (null values and suites should not be allowed) ?
    - creating a kind of `Rank` (e.g. I should not be able to create a `Pair` with two cards with different values, or a `Pair` with two cards with the same suit)

* [F] Make sure you cannot create invalid Cards.

* Write an AT (end-to-end!) that accepts an input like `Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C AH`
  and prints the outcome of the match as a string like `White wins. - with high card: Ace`

* [R] Improve the Player tests: maybe using a builder would help in improving the readability of the test
    * like `aPlayer().with(highestHand())`...
    * add helper assertions to "hide" the pair of symmetric assertions

* [R] Smells like a rule engine is yelling to be implemented to evaluate the poker hands...
    
* Add all the possible values for the poker `Cards`
    * [F] add the formatting of all the remaining figures (K, Q, J)

* From a single-card poker hand to a 5-cards poker hand
    * two pairs ("4 cards" world)
    * four of a kind (poker) ranking ("4 cards" world)
    * full house ranking ("5 cards" world)
    * Add the missing ranks in `Rank` enumeration

* Are we sure we are testing all the possible combinations of hands?
    * parametrize test?

* Building a Card is not easy (new Card(Value.Three, suit) vs some of builder / factory).
    * Waiting to have an application code that needs to create many cards in order to play a game

* New "Texas Hold'em" rule: 2 cards in your hand + 5 common cards on the table
    - hand1: (2, 4), hand2: (8, 5), table: (3, 5, 6, 8, 8) 
     
* What changes if we had to expose as an HTTP service?
* EXTRA: What would you need to change if a new game input should be supported?

* What would happen if we try to write unit tests for `PlayerParser` and the other two parsers? 
    * What feedback would we get from those tests?

* [F] Evaluate a straight with the [`high rules`](https://www.briggsoft.com/docs/pmavens/PMHoldem.htm):
    - an ace can rank either high (as in A K Q J 10, an ace-high straight) or low (as in 5 4 3 2 A, a five-high straight)
    
### Notes

Deck of 52 cards

Each `Card` has:

* one of 4 suits (clubs, ....) => (C,D,H,S)
* a value in (2-10, Jack, Queen, King, Ace) => (2-9,T,J,Q,K,A)

each **Poker Hand** has 5 cards taken from DECK

* *High Card*: lowest ranking - 

es:  (2C, 3D, 6H, 9S, 5H) => rank: *9*

* *Pair*: 2 of the 5 cards in the hand have the same value. 

es: (*2C, 2D*, 6H, 9S, 5H) 

es:  

* (2C, 2D, 6H, 9S, 5H) => 2
* (3C, 3D, 6H, 9S, 5H) => 3

es:  

* (3S, 3H, 5H, 6H, 9S) => 3  |=> WIN! 
* (3C, 3D, 4S, 6S, 7C) => 3  

* *Two Pairs*: 

es: (*2C, 2D*, *6H, 6S*, 5H) 

es

* (*2C, 2D*, *6H, 6S*, 5H) 
* (*3C, 3D*, *7H, 7S*, 5H)  => WIN

es

* (*2C, 2D*, *3H, 3S*, 7H)  => WIN 
* (*3C, 3D*, *2S, 2S*, 5H)

* *Three of a Kind*

* *Straight*

es: (*2C, 3D, 4H, 5S, 6H*) 

* *Flush*

es: (*2C, 8C, 4C, 5C, 6C*) 

* *Full House* = Three + Pair

es: (*2C, 2D*, *6H, 6S, 6D*) 

* *Four of a kind*

es: (*2C, 2D, 2H, 2S*, 6C) 

* *Straight flush*:

es: (*TS, JS, QS, KS, AS*) 

