package lab3;

public class Fulltimer extends Employee {
    private double salary;

    public Fulltimer(String n, double s) {
        name = n;
        salary = s;
    }

    @Override
    public double computePay() {
        return salary;
    }
}
