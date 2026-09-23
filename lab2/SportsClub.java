package lab2;

public class SportsClub extends Club {
    public SportsClub(String c, int m) {
        super(c, m);
    }

    @Override
    public int determineBudget() {
        return super.determineBudget() + (numMember - minNumMember) * 100;
    }

    @Override
    public void changeName(String newName) {
        // This club keeps its original name.
    }
}
