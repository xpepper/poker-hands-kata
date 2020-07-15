[PokerHands Kata](http://codingdojo.org/kata/PokerHands/)

### TODO

* Write an AT that accept an input like `Black: 2H 4D  White: 2C 5H`
  and prints the outcome of the match as a string like `White wins. - with high card`

  * Print the GameResult
  * CardParserTest
    - add support to more values and suites?
  * Should we add a validation when creating a Card (null values and suites should not be allowed) ?
  * Make sure you cannot create invalid Cards.

* Rename `PokerHand` in `Hand`.

* Improve the Player tests: maybe using a builder would help in improving the readability of the test
    * like `aPlayer().with(highestHand())`...
    * add helper assertions to "hide" the pair of symmetric assertions

* Write an AT that accept an input like `Black: 2H 5D  White: 2C 5H`
  and prints the outcome of the match as a string like `Tie.`
    * GameResultPrint should print a GameResult

* From simply telling which hand is higher than another to showing the actual winning rank
    * explore how to tell which is the winning rank and **its point**
        * White wins. - with high card: Ace
        * Black wins. - with full house: 4 over 2
        * Tie.

* Write an AT that accept an input like `Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C AH`
  and prints the outcome of the match as a string like `White wins. - with high card: Ace`

* Smells like a rule engine is yelling to be implemented to evaluate the poker hands...

* `GameResultPrinter` print a `Winner`... is it ok? What happens with a `Tie`?
* Add the missing conversions from rank to string in `GameResultPrinter`

* Poker hand with three cards... ("3 cards" world)
    * rewrite the logic to find the highest card in a hand using sorting
    * three of a kind ranking
    * Add the missing ranks in `Rank` enumeration
    
* Add all the possible values for the poker `Cards`

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

