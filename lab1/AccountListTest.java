public class AccountListTest {
    public static void main(String[] args) {
        AccountList al = new AccountList(3);
        Account first = new Account("Oak", 1.0);
        boolean success = al.appendAccount(first);
        assert success;
        success = al.appendAccount(new Account("Two", 0.1));
        assert success;
        assert al.getAccount(0) == first;

        Account account = al.getAccount(2);
        assert account == null;
        System.out.println(account);

        account = al.getAccount(1);
        assert account.getBalance() == 0.1;
        System.out.println(account.getBalance());

        success = al.appendAccount(new Account("tmp", 0));
        assert success;
        success = al.appendAccount(new Account("tmp2", 0));
        assert !success;
        System.out.println(success);
        assert al.getAccount(2).getName().equals("tmp");

        // Additional boundary cases beyond the PDF's example.
        account = al.getAccount(-1);
        assert account == null;
        account = al.getAccount(3);
        assert account == null;
        AccountList empty = new AccountList(0);
        success = empty.appendAccount(first);
        assert !success;
        account = empty.getAccount(0);
        assert account == null;
        System.out.println("AccountList tests completed.");
    }
}
