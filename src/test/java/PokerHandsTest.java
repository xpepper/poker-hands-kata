import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PokerHandsTest {

    public static final int IS_LOWER = -1;

    @Test
    public void compare_hands_by_highest_card() {
        PokerHand hand = new PokerHand(new Card(Value.Four));
        PokerHand otherHand = new PokerHand(new Card(Value.Five));

        assertEquals(IS_LOWER, hand.compareTo(otherHand));
    }

}


