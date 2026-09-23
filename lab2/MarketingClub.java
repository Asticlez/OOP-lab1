package lab2;

public class MarketingClub extends Club {
    private int budget;

    public MarketingClub(String c, int m, int budget) {
        super(c, m);
        this.budget = budget;
    }

    public boolean useBudget(int amount) {
        if (budget - amount < 0) {
            return false;
        }
        budget -= amount;
        return true;
    }

    @Override
    public int determineBudget() {
        if (budget > 1000) {
            return 0;
        }
        return super.determineBudget();
    }
}
