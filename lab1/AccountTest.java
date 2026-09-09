public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account("Oak", 100);
        assert account.getName().equals("Oak");
        assert account.getBalance() == 100;
        System.out.printf("%s: initial balance %.2f%n", account.getName(), account.getBalance());

        account.setName("Two");
        assert account.getName().equals("Two");
        account.deposit(50);
        assert account.getBalance() == 150;
        account.deposit(0);
        assert account.getBalance() == 150;
        account.deposit(-20);
        assert account.getBalance() == 150;
        System.out.printf("%s: balance after deposits %.2f%n", account.getName(), account.getBalance());

        Account zero = new Account("Zero", 0);
        Account negative = new Account("Negative", -100);
        assert zero.getBalance() == 0;
        assert negative.getBalance() == 0;
        negative.deposit(25);
        assert negative.getBalance() == 25;
        System.out.println("Account tests completed.");
    }
}
