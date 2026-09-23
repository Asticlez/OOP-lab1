package lab2;

public class CardUtilTest {
    public static void main(String[] args) {
        TestSupport.check(CardUtil.HIGHEST_RANK == Rank.ACE, "Highest rank");
        TestSupport.check(CardUtil.HIGHEST_SUITE == Suite.SPADES, "Highest suite");
        // Check every combination, including cards with only one matching attribute.
        for (Rank rank : Rank.values()) {
            for (Suite suit : Suite.values()) {
                Card card = new Card(rank, suit);
                boolean expected = rank == Rank.ACE && suit == Suite.SPADES;
                TestSupport.check(CardUtil.isHighestCard(card) == expected,
                        "Wrong result for " + rank + " of " + suit);
            }
        }
        TestSupport.check(!CardUtil.isHighestCard(null), "Null is not a highest card");
        expectInvalid(() -> new Card(null, Suite.SPADES));
        expectInvalid(() -> new Card(Rank.ACE, null));
        // Invalid enum names are rejected before a Card can be constructed.
        expectInvalid(() -> Rank.valueOf("ONE"));
        expectInvalid(() -> Suite.valueOf("STARS"));

        Card card = new Card(Rank.TWO, Suite.CLUBS);
        expectInvalid(() -> card.setRank(null));
        expectInvalid(() -> card.setSuit(null));
        TestSupport.check(card.getRank() == Rank.TWO && card.getSuit() == Suite.CLUBS,
                "Rejected setters must preserve the card");
        card.setRank(Rank.ACE);
        card.setSuit(Suite.SPADES);
        TestSupport.check(CardUtil.isHighestCard(card), "Setters should update the card");
        System.out.println("CardUtilTest passed (all 52 cards and invalid attributes).");
    }

    private static void expectInvalid(Runnable action) {
        try {
            action.run();
        } catch (IllegalArgumentException expected) {
            return;
        }
        throw new AssertionError("Expected an invalid attribute to be rejected");
    }
}
