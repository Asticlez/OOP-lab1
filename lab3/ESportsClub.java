package lab3;

public final class ESportsClub extends SportsClub {
    public ESportsClub(String c, int m) {
        super(c, 1);
    }

    @Override
    public final void advertise() {
        System.out.println("No need to advertise");
    }
}
