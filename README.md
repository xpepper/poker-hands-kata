[PokerHands Kata](http://codingdojo.org/kata/PokerHands/)

### TODO

* Poker hand with two cards
    - flush (=> suit!) (D,H,C,S)
        - (3D, 5D) WINS over (3H, 7D) **DONE**
        - (3D, 5D) WINS over (3H, 3C) **DONE**
        - (3D, 5D) WINS over (3H, 4C)
        - (3D, 7D) WINS over (3S, 5S)
        - (3D, 7D) vs (3S, 7S) is a TIE
    - straight flush

* Building a Card is not easy. Also, comparing a Card against another is NOT straightforward.
 
* From simply telling which hand is higher than another to showing the actual winning rank (e.g. _"White wins. - with high card: Ace"_)
    * write the hand comparison in terms of the domain language (avoid -1, 0, 1...)

* Smells like a rule engine is yelling to be implemented to evaluate the poker hands...

* Poker hand with three cards...
    * rewrite the logic to find the highest card in a hand using sorting

* Add all the possible values for the poker `Cards`

* From a single-card poker hand to a 5-cards poker hand
    * introducing the "suit" of each card

* Are we sure we are testing all the possible combinations of hands?

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

