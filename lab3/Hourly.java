package lab3;

public class Hourly extends Employee {
    private double rate;
    private int hour;

    public Hourly(String n, double r, int h) {
        name = n;
        rate = r;
        hour = h;
    }

    @Override
    public double computePay() {
        return hour * rate;
    }
}
