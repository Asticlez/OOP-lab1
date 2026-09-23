package lab2;

public class Card {
    // Private fields and validated setters provide encapsulation.
    private Rank rank;
    private Suite suit;

    public Card(Rank rank, Suite suit) {
        setRank(rank);
        setSuit(suit);
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        if (rank == null) {
            throw new IllegalArgumentException("Rank must not be null.");
        }
        this.rank = rank;
    }

    public Suite getSuit() {
        return suit;
    }

    public void setSuit(Suite suit) {
        if (suit == null) {
            throw new IllegalArgumentException("Suit must not be null.");
        }
        this.suit = suit;
    }
}
