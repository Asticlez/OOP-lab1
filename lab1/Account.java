public class Account
{
    private String name;
    private double balance;

    public Account(String name, double balance)
    {
        this.name = name;
        deposit(balance);
    }

    public void deposit(double depositAmount)
    {
        if (depositAmount > 0) {
            balance += depositAmount;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }
}
