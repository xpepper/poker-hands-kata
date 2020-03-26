class Card {

    private Value value;

    public Card(Value value) {
        this.value = value;
    }

    public int compareTo(Card otherCard) {
        if (value.numericValue > otherCard.value.numericValue) return 1;
        if (value.numericValue == otherCard.value.numericValue) return 0;
        return -1;
    }
}
