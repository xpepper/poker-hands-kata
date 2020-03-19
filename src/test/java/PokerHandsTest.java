import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PokerHandsTest {

    public static final int IS_LOWER = -1;
    private static final int IS_GREATER = 1;

    @Test
    public void compare_hands_by_highest_card() {
        PokerHand hand = new PokerHand(new Card(Value.Four));
        PokerHand otherHand = new PokerHand(new Card(Value.Five));

        assertEquals(IS_LOWER, hand.compareTo(otherHand));
    }

    @Test
    public void compare_to_is_1_when_the_hand_is_higher() {
        PokerHand hand = new PokerHand(new Card(Value.Five));
        PokerHand otherHand = new PokerHand(new Card(Value.Four));

        assertEquals(IS_GREATER, hand.compareTo(otherHand));
    }
}


