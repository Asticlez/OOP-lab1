package lab2;

public final class CardUtil {
    // Static members belong to the class; final prevents reassignment.
    public static final Rank HIGHEST_RANK = Rank.ACE;
    public static final Suite HIGHEST_SUITE = Suite.SPADES;

    private CardUtil() {
        // A utility class does not need objects.
    }

    public static boolean isHighestCard(Card card) {
        return card != null && card.getRank() == HIGHEST_RANK
                && card.getSuit() == HIGHEST_SUITE;
    }
}
