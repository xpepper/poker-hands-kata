[PokerHands Kata](http://codingdojo.org/kata/PokerHands/)

### TODO
 
* From simply telling which hand is higher than another to showing the actual winning rank
    * we need to have someone telling the Game which is the rank of the winning hand (not just which hand is the winner...)
    * it's weird we have to have a double assertion around the winning rank (is it because of our design in the play method?)
    * find a way to have a shorter statement than `assertEquals("White wins.", new Game(new Player("White", higherHand), new Player("Black", hand)).play());`
    * explore how to tell which is the winning rank of the player
        * White wins. - with high card
        * Black wins. - with full house
        * Tie.
    * explore how to tell which is the winning rank and its point
        * White wins. - with high card: Ace
        * Black wins. - with full house: 4 over 2
        * Tie.
    * write the hand comparison in terms of the domain language (avoid -1, 0, 1...)

* We want to print a GameResult into something like _"White wins. - with high card: Ace"_
    * game result + game result printer? 

* Smells like a rule engine is yelling to be implemented to evaluate the poker hands...

* Poker hand with three cards... ("3 cards" world)
    * rewrite the logic to find the highest card in a hand using sorting
    * three of a kind ranking
    
* Add all the possible values for the poker `Cards`

* From a single-card poker hand to a 5-cards poker hand
    * two pairs ("4 cards" world)
    * four of a kind (poker) ranking ("4 cards" world)
    * full house ranking ("5 cards" world)

* Are we sure we are testing all the possible combinations of hands?
    * parametrize test?

* Play a poker game between two players starting from a text input

* Building a Card is not easy (new Card(Value.Three, suit) vs some of builder / factory).
    * Waiting to have an application code that needs to create many cards in order to play a game

* New "Texas Hold'em" rule: 2 cards in your hand + 5 common cards on the table
    - hand1: (2, 4), hand2: (8, 5), table: (3, 5, 6, 8, 8) 
     
    
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

