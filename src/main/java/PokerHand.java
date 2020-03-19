public class PokerHand implements Comparable<PokerHand> {

    private Card card;

    public PokerHand(Card card) {
        this.card = card;
    }

    @Override
    public int compareTo(PokerHand other) {
        if (card().value() == Value.Five) return 1;
        return -1;
    }

    private Card card() {
        return card;
    }
}
