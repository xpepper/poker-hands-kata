import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PokerHandsTest {

    public static final int IS_LOWER = -1;
    private static final int IS_GREATER = 1;

    @Test
    public void an_hand_with_a_four_is_lower_than_an_hand_with_a_five() {
        PokerHand hand = new PokerHand(new Card(Value.Four));
        PokerHand otherHand = new PokerHand(new Card(Value.Five));

        assertEquals(IS_LOWER, hand.compareTo(otherHand));
    }

    @Test
    public void an_hand_with_a_five_is_greater_than_an_hand_with_a_four() {
        PokerHand hand = new PokerHand(new Card(Value.Five));
        PokerHand otherHand = new PokerHand(new Card(Value.Four));

        assertEquals(IS_GREATER, hand.compareTo(otherHand));
    }
}


